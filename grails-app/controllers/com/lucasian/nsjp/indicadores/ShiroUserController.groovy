package com.lucasian.nsjp.indicadores

import static org.springframework.http.HttpStatus.*
import java.text.*
import java.util.Locale
import grails.transaction.Transactional
import com.lucasian.nsjp.indicadores.ArchivosCargados
import com.lucasian.nsjp.indicadores.*

import org.apache.shiro.crypto.hash.Sha256Hash

@Transactional(readOnly = true)
class ShiroUserController {
    def grailsApplication
    def rolesService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {                
        params.max = Math.min(max ?: 10, 100)
        def usuarios         
        if(rolesService.asignableRole){
            def rol = ShiroRole.findByName(rolesService.asignableRole.name)
            usuarios = rol.users            
        }else{
            usuarios = ShiroUser.list(params)
        }                
        model:[shiroUserInstanceList:usuarios, shiroUserInstanceCount: usuarios.size()]
    }

    def show(ShiroUser shiroUserInstance) {
        respond shiroUserInstance
    }

    def create() {        
        [shiroUserInstance:new UsuarioCommand(), permission:rolesService.asignablePermissions]
    }

    @Transactional
    def save(UsuarioCommand shiroUserInstance) {        
        if (shiroUserInstance == null) {
            notFound()
            return
        }

        if (shiroUserInstance.hasErrors()) {
            respond shiroUserInstance.errors, view:'create'
            return
        }
        
        def permisos = shiroUserInstance.permisos.tokenize(',')
        if(shiroUserInstance.password == shiroUserInstance.passwordConfirm){
            def newUser = new ShiroUser(
                username: shiroUserInstance.username,
                passwordHash: new Sha256Hash(shiroUserInstance.password).toHex(),            
            )
            newUser.save()
            
            permisos.each(){
                newUser.addToPermissions(it)
            }
            newUser.save()
            def rol = rolesService.asignableRole
            rol.addToUsers(newUser)
            rol.save(failOnError:true)
            redirect(action:'index')
        }else{
            flash.message = 'La confirmacion de contraseña no es correcta'
            render(view:"create", model:[asignedPermission:permisos, shiroUserInstance:shiroUserInstance,permission:rolesService.asignablePermissions])
        }           

        
    }

    def edit(ShiroUser shiroUserInstance) {
        def command = new UsuarioCommand()
        command.username = shiroUserInstance.username        
        [shiroUserInstance: command, permission:rolesService.asignablePermissions, asignedPermission:shiroUserInstance.permissions.toString(), userId: shiroUserInstance.id ]
    }

    @Transactional
    def update(UsuarioCommand shiroUserInstance) {
        if (shiroUserInstance == null) {
            notFound()
            return
        }

        if (shiroUserInstance.hasErrors()) {
            respond shiroUserInstance.errors, view:'edit'
            return
        }

        def usuario = ShiroUser.get(params.get("id"))
        usuario.username = shiroUserInstance.username
        if((shiroUserInstance.password?.trim()) && shiroUserInstance.passwordConfirm == shiroUserInstance.password){
            usuario.passwordHash = new Sha256Hash(shiroUserInstance.password).toHex()
        }
        usuario.permissions.clear()
        usuario.save()
        def permisos = shiroUserInstance.permisos.tokenize(',')
        permisos.each(){
            usuario.addToPermissions(it)
        }
        usuario.save()
        redirect(action:'index')
    }

    @Transactional
    def delete(ShiroUser shiroUserInstance) {

        if (shiroUserInstance == null) {
            notFound()
            return
        }

        shiroUserInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ShiroUser.label', default: 'ShiroUser'), shiroUserInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional
    def downloadFormat(){
        InputStream contentStream
        try {
            def file = new File(grailsApplication.config.grails.excel.location+controllerName +".xls")
            response.setHeader "Content-disposition", "attachment; filename="+controllerName +".xls"
            response.setHeader("Content-Length", "file-size")
            response.setContentType("file-mime-type")
            contentStream = file.newInputStream()
            response.outputStream << contentStream
            webRequest.renderView = false
        } finally {
            response.outputStream.flush()
        }
    }
    @Transactional
    def upload(){
        
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'shiroUser.label', default: 'ShiroUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
