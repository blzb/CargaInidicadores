package com.lucasian.nsjp.indicadores



import static org.springframework.http.HttpStatus.*
import java.text.*
import java.util.Locale
import grails.transaction.Transactional
import com.lucasian.nsjp.indicadores.ArchivosCargados
import org.apache.shiro.SecurityUtils

@Transactional(readOnly = true)
class PentahoJobLogController {
    def grailsApplication
    def excelService
    def logService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def archivosCargadosService

    def index(Integer max) {
        params.max = Math.min(max ?: 25, 100)

        logService.getJobLogs(params)
    }
 
    def show(PentahoJobLog pentahoJobLogInstance) {
        def transformations = logService.getTransformationsForJob(pentahoJobLogInstance)
        [pentahoJobLogInstance: pentahoJobLogInstance, transformations:transformations ]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pentahoJobLog.label', default: 'PentahoJobLog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
