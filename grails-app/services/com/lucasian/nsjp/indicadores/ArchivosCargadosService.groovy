package com.lucasian.nsjp.indicadores

import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils
import org.springframework.context.MessageSource

@Transactional
class ArchivosCargadosService {
    def getArchivosAdmin(params){
        def roles = ShiroUser.findByUsername(SecurityUtils.subject.principal).roles
        def rolesNames = roles.collect{it.name}
        if(rolesNames.contains('Administrator')){            
             def tablas = ''
            if(rolesNames.size() == 1){
                [archivosCargadosInstanceList:ArchivosCargados.list(params), model:[ArchivosCargadosCount: ArchivosCargados.count()]]
            }else{
                rolesNames.each(){
                    if(it != 'Administrator'){
                        switch(it){
                        case 'Procuraduria':
                            tablas = 'procuraduria%'
                            break
                        case 'Tribunales':
                            tablas='tribunales%'
                            break
                        case 'Seguridad Publica':
                            tablas='comision%'
                            break
                        case 'Defensoria':
                            tablas = 'defensoria%'
                            break
                        }                                                                
                    }
                }
                def result = ArchivosCargados.findAllByTablaLike(tablas, params)
                def count = ArchivosCargados.countByTablaLike(tablas, params)
                [
                    archivosCargadosInstanceList:result,
                    archivosCargadosInstanceCount:count
                ]   
            } 
        }
        
    }
    def getArchivosPendiente(controllerName,params){
        [
            files:ArchivosCargados.findAllByTablaAndUsuarioAndStatus(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"Subido",params),
            filesCount:ArchivosCargados.countByTablaAndUsuarioAndStatus(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"Subido"),
            load: true,
            titulo: "Subir Archivo:"
        ]
    }
    def getArchivosCargados(controllerName,params){
        [
            files:ArchivosCargados.findAllByTablaAndUsuarioAndStatus(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"Cargado", params),
            filesCount:ArchivosCargados.countByTablaAndUsuarioAndStatus(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"Cargado"),
            load: false,
            titulo: "Archivos cargados:"
        ]
    }
    def getArchivosRechazados(controllerName,params){
        [
            files:ArchivosCargados.findAllByTablaAndUsuarioAndStatusLike(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"Rechazado%",params),
            filesCount:ArchivosCargados.countByTablaAndUsuarioAndStatusLike(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),"Rechazado%"),
            load: false,
            titulo: "Archivos cargados:"
        ]
    }
    def getArchivosCargadosAndRechazados(controllerName, params){
        [
            files:ArchivosCargados.findAllByTablaAndUsuarioAndStatusInList(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),["Rechazado: Manual","Rechazado: Tipo de Archivo Incorrecto","Rechazado: Formato Incorrecto","Cargado"],params),
            filesCount:ArchivosCargados.countByTablaAndUsuarioAndStatusInList(controllerName, ShiroUser.findByUsername(SecurityUtils.subject.principal),["Rechazado: Manual","Rechazado: Tipo de Archivo Incorrecto","Rechazado: Formato Incorrecto","Cargado"]),
            load: false,
            titulo: "Archivos cargados:"
        ]
    }
    def getArchivosHome(params){
        [
            files:ArchivosCargados.findAllByUsuarioAndStatus(ShiroUser.findByUsername(SecurityUtils.subject.principal),"Subido",params),
            filesCount:ArchivosCargados.countByUsuarioAndStatus(ShiroUser.findByUsername(SecurityUtils.subject.principal),"Subido"),
            load: true
        ]
    }
}
