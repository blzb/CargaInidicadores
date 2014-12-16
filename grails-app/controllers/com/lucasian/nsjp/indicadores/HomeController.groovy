package com.lucasian.nsjp.indicadores
import org.apache.shiro.SecurityUtils
class HomeController {

    def archivosCargadosService
    def index(Integer max){
        params.max = Math.min(max ?: 10, 100)
        if(SecurityUtils.subject.hasRole('Administrator')){
            redirect(controller: "pentahoJobLog", action: "index")
        }else{
            def salida = archivosCargadosService.getArchivosHome(params)
            salida            
        }
    }
}
