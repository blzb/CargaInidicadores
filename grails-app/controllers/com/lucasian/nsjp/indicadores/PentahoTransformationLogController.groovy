package com.lucasian.nsjp.indicadores



import static org.springframework.http.HttpStatus.*
import java.text.*
import java.util.Locale
import grails.transaction.Transactional
import com.lucasian.nsjp.indicadores.ArchivosCargados
import org.apache.shiro.SecurityUtils

@Transactional(readOnly = true)
class PentahoTransformationLogController {
    def grailsApplication
    def excelService
    def logService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def archivosCargadosService

    def index(Integer max) {
        params.max = Math.min(max ?: 25, 100)
        logService.getTransformations(params)
    }

    def show(PentahoTransformationLog pentahoTransformationLogInstance) {
        def steps = logService.getStepsForTransformation(pentahoTransformationLogInstance)        
        [pentahoTransformationLogInstance:pentahoTransformationLogInstance, steps: steps]
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pentahoTransformationLog.label', default: 'PentahoTransformationLog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
