package com.lucasian.nsjp.indicadores



import static org.springframework.http.HttpStatus.*
import java.text.*
import java.util.Locale
import grails.transaction.Transactional
import com.lucasian.nsjp.indicadores.ArchivosCargados
import org.apache.shiro.SecurityUtils

@Transactional(readOnly = true)
class PentahoStepLogController {
    def grailsApplication
    def excelService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def archivosCargadosService

    def index(Integer max) {
        params.max = Math.min(max ?: 25, 100)
        respond PentahoStepLog.list(params), model:[pentahoStepLogInstanceCount: PentahoStepLog.count()]
    }


    def show(PentahoStepLog pentahoStepLogInstance) {
        respond pentahoStepLogInstance
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pentahoStepLog.label', default: 'PentahoStepLog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
