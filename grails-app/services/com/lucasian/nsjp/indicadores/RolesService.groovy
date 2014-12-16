package com.lucasian.nsjp.indicadores
import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils


@Transactional
class RolesService {
    def grailsApplication
    def getAsignablePermissions() {
        def usuario = ShiroUser.findByUsername(SecurityUtils.subject.principal)
        def roles = usuario.roles.collect{it.toString()}
        def permisos = grailsApplication.config.grails.app.permission.findAll{ 
            roles.contains(it.key) && it.key != "Administrator"
        }
        permisos
    }
    def getAsignableRole(){
        def usuario = ShiroUser.findByUsername(SecurityUtils.subject.principal)
        usuario.roles.find{it.name != "Administrator"}
    }
}
