<%=packageName ? "package ${packageName}\n\n" : ''%>

import static org.springframework.http.HttpStatus.*
import java.text.*
import java.util.Locale
import grails.transaction.Transactional
import com.lucasian.nsjp.indicadores.ArchivosCargados
import org.apache.shiro.SecurityUtils

@Transactional(readOnly = true)
class ${className}Controller {
    def grailsApplication
    def excelService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def archivosCargadosService

    def index(Integer max) {
        params.max = Math.min(max ?: 25, 100)
        respond ${className}.list(params), model:[${propertyName}Count: ${className}.count()]
    }
    def indexFiles(Integer max){
        params.max = Math.min(max ?: 25, 100)
        def files = ArchivosCargados.findAllByTablaAndUsuarioAndStatus(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"subido")
        [filesCount:files.size(), files: files]
    }

    def show(${className} ${propertyName}) {
        respond ${propertyName}
    }

    def create() {
        respond new ${className}(params)
    }

    @Transactional
    def save(${className} ${propertyName}) {
        if (${propertyName} == null) {
            notFound()
            return
        }

        if (${propertyName}.hasErrors()) {
            respond ${propertyName}.errors, view:'create'
            return
        }

        ${propertyName}.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
                redirect ${propertyName}
            }
            '*' { respond ${propertyName}, [status: CREATED] }
        }
    }

    def edit(${className} ${propertyName}) {
        respond ${propertyName}
    }

    @Transactional
    def update(${className} ${propertyName}) {
        if (${propertyName} == null) {
            notFound()
            return
        }

        if (${propertyName}.hasErrors()) {
            respond ${propertyName}.errors, view:'edit'
            return
        }

        ${propertyName}.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: '${className}.label', default: '${className}'), ${propertyName}.id])
                redirect ${propertyName}
            }
            '*'{ respond ${propertyName}, [status: OK] }
        }
    }

    @Transactional
    def delete(${className} ${propertyName}) {

        if (${propertyName} == null) {
            notFound()
            return
        }

        ${propertyName}.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: '${className}.label', default: '${className}'), ${propertyName}.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional
    def downloadFormat(){
        InputStream contentStream
        try {
            def file = new File(grailsApplication.config.grails.excel.location+controllerName +".xlsx")
            response.setHeader "Content-disposition", "attachment; filename="+controllerName +".xlsx"
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
    def downloadFile(ArchivosCargados archivo){
        InputStream contentStream
        try {
            def file = new File(archivo.path)
            response.setHeader "Content-disposition", "attachment; filename="+archivo.nombre+".xlsx"
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
        redirect action: "pendientes", method: "GET"
    }
    @Transactional
    def cancelFile(ArchivosCargados archivo){
        if(archivo.status=="Subido"){
            excelService.cancelFile(archivo)
        }else{
            flash.message = "El archivo ya ha sido procesado anteriormente"
        }
        redirect action: "pendientes", method: "GET"
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
    def help(){
        [instance: new ${className}()]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
