package com.lucasian.nsjp.indicadores



import static org.springframework.http.HttpStatus.*
import java.text.*
import java.util.Locale
import grails.transaction.Transactional
import com.lucasian.nsjp.indicadores.ArchivosCargados
import org.apache.shiro.SecurityUtils

@Transactional(readOnly = true)
class ArchivosCargadosController {
    def grailsApplication
    def excelService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def archivosCargadosService

    def index(Integer max) {        
        params.max = Math.min(max ?: 25, 100)
        archivosCargadosService.getArchivosAdmin(params)
    }
    def indexFiles(Integer max){
        params.max = Math.min(max ?: 25, 100)
        def files = ArchivosCargados.findAllByTablaAndUsuarioAndStatus(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"subido")
        [filesCount:files.size(), files: files]
    }

    def show(ArchivosCargados archivosCargadosInstance) {
        respond archivosCargadosInstance
    }

    def create() {
        respond new ArchivosCargados(params)
    }

    @Transactional
    def save(ArchivosCargados archivosCargadosInstance) {
        if (archivosCargadosInstance == null) {
            notFound()
            return
        }

        if (archivosCargadosInstance.hasErrors()) {
            respond archivosCargadosInstance.errors, view:'create'
            return
        }

        archivosCargadosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'archivosCargados.label', default: 'ArchivosCargados'), archivosCargadosInstance.id])
                redirect archivosCargadosInstance
            }
            '*' { respond archivosCargadosInstance, [status: CREATED] }
        }
    }

    def edit(ArchivosCargados archivosCargadosInstance) {
        respond archivosCargadosInstance
    }

    @Transactional
    def update(ArchivosCargados archivosCargadosInstance) {
        if (archivosCargadosInstance == null) {
            notFound()
            return
        }

        if (archivosCargadosInstance.hasErrors()) {
            respond archivosCargadosInstance.errors, view:'edit'
            return
        }

        archivosCargadosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ArchivosCargados.label', default: 'ArchivosCargados'), archivosCargadosInstance.id])
                redirect archivosCargadosInstance
            }
            '*'{ respond archivosCargadosInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ArchivosCargados archivosCargadosInstance) {

        if (archivosCargadosInstance == null) {
            notFound()
            return
        }

        archivosCargadosInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ArchivosCargados.label', default: 'ArchivosCargados'), archivosCargadosInstance.id])
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
    /*
    @Transactional
    def cargados(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render(view:"indexFiles" ,model:archivosCargadosService.getArchivosCargados(controllerName,params))
    }
    */
    @Transactional
    def cargados(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render(view:"indexFiles" ,model:archivosCargadosService.getArchivosCargadosAndRechazados(controllerName,params))
    }    
    @Transactional
    def rechazados(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render(view:"indexFiles" ,model:archivosCargadosService.getArchivosRechazados(controllerName,params))
    }
    @Transactional
    def pendientes(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render(view:"indexFiles" ,model:archivosCargadosService.getArchivosPendiente(controllerName,params))
    }
    
    @Transactional
    def saveFile(FormatUploadCommand command){        
        def result = excelService.saveFile(command, controllerName)
        flash.message = result.mensaje
        if(result.id > 0){
            redirect action:"reviewFile", method:"GET", id: result.id
        }else{
            redirect action: "pendientes", method: "GET"
        }        
    }
    @Transactional
    def loadFile(ArchivosCargados archivo){
        if(archivo.status=="Subido"){
            excelService.loadFile(archivo)
        }else{
            flash.message = "El archivo ya ha sido procesado anteriormente"
        }
        redirect action: "index", method: "GET"
    }
    @Transactional
    def cancelFile(ArchivosCargados archivo){
        if(archivo.status=="Subido"){
            excelService.cancelFile(archivo)
        }else{
            flash.message = "El archivo ya ha sido procesado anteriormente"
        }
        redirect action: "index", method: "GET"
    }
    @Transactional
    def reviewFile(ArchivosCargados archivo){
        if(controllerName == 'comisionPoblacionVulnerable'){
            flash.message = 'EL ARCHIVO CONTIENE DEMASIADA INFORMACION PARA SER MOSTRADA SI NO ESTAS SEGURO DE LA INFORMACION RECHAZA ESTE ARCHIVO Y REVISA LOS DATOS ANTES DE SUBIRLO'
        }
        def loadable = false
        if(archivo.status == 'Subido'){
            loadable = true
        }
        [data: excelService.printFile(archivo), id: archivo.id, loadable:loadable]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'archivosCargados.label', default: 'ArchivosCargados'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
