package com.lucasian.nsjp.indicadores

import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils
import java.util.UUID
import org.apache.poi.ss.usermodel.DateUtil
@Transactional
class ExcelService {
    def grailsApplication
    static Map meses = [
        'ENERO':1,
        'FEBRERO':2,
        'MARZO':3,
        'ABRIL': 4,
        'MAYO' : 5,
        'JUNIO' : 6,
        'JULIO' : 7,
        'AGOSTO' : 8,
        'SEPTIEMBRE' : 9,
        'OCTUBRE' : 10,
        'NOVIEMBRE' : 11,
        'DICIEMBRE' : 12        
    ]
    

    def loadFile(ArchivosCargados archivo){
        if(archivo.status=="Subido"){
            if(archivo.tabla == 'comisionCustodios'){
                loadCustodios(archivo)
            }else if(archivo.tabla == 'comisionInternos'){
                loadInternos(archivo)
            }else if(archivo.tabla=='comisionProgramasIndividualizados'){
                loadProgramas(archivo)
            }else if(archivo.tabla=='comisionPoblacionVulnerable'){
                loadVulnerables(archivo)
            }else{
                LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path, archivo.tabla)
                def clase = grailsApplication.getDomainClass("com.lucasian.nsjp.indicadores."+archivo.tabla.capitalize())
                def result = importer.getRows(10)
                result.each(){
                    def instance = clase.newInstance()
                    instance.properties = it
                    instance.save(failOnError:true)
                }
                archivo.status="Cargado"
                archivo.save()
            }
        }
    }
    def cancelFile(ArchivosCargados archivo){
        if(archivo.status=="Subido"){
            def clase = grailsApplication.getDomainClass("com.lucasian.nsjp.indicadores."+archivo.tabla.capitalize())
            archivo.status="Rechazado: Manual"
            archivo.save()
        }
    }
    def printFile(ArchivosCargados archivo){
        def nombre
        if(archivo.tabla == 'comisionCustodios'){
            nombre = 'comisionCustodios'
            LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path,nombre)
            
            def result = importer.getRows(0)
            println(getFechaCustodios(result))
            def titulos = result.get(1)
            def maxValue = titulos.findLastIndexOf {
                it.value != null
            }
            def nuevaLista=[]
            maxValue++
            result.each(){ row->
                def index = 0
                def valores = row.collect(){
                    it.value
                }
                nuevaLista<<valores.subList(0,maxValue)
            }
            nuevaLista            
        }else if(archivo.tabla == 'comisionProgramasIndividualizados'){
            nombre = 'comisionProgramasIndividualizados'
            LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path,nombre)            
            def result = importer.getRows(0)            
            def nuevaLista=[]
            result.each(){ row->
                def index = 0
                def valores = row.collect(){
                    it.value
                }
                nuevaLista<<valores
            }            
            nuevaLista            
        }else if(archivo.tabla=='comisionInternos'){            
            nombre = 'comisionInternosEstadistica'
            LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path,nombre)
            def result = importer.getRows(0)
            def nuevaLista=[]
            nuevaLista<<(['***']*27)
            result.each(){ row->
                def index = 0
                def valores = row.collect(){
                    it.value
                }
                nuevaLista<<valores
            }
            nombre = 'comisionInternosEnfermos'
            nuevaLista<<(['***']*27)
            importer = new LucasianExcelImporter(archivo.path,nombre)
            result = importer.getRows(0)
            result.each(){ row->
                def index = 0
                def valores = row.collect(){
                    it.value
                }
                nuevaLista<<valores                
            }            
            nombre = 'comisionInternosDelitos'
            nuevaLista<<(['***']*27)
            importer = new LucasianExcelImporter(archivo.path,nombre)
            result = importer.getRows(0)
            result.each(){ row->
                def index = 0
                def valores = row.collect(){
                    it.value
                }
                nuevaLista<<valores               
            }              
            nuevaLista
        }else if(archivo.tabla=='comisionPoblacionVulnerable'){            
            []
        }else{
            LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path,archivo.tabla)            
            def result = importer.getRows(0)
            def titulos = result.get(1)
            def maxValue = titulos.findLastIndexOf {
                it.value != null
            }
            def nuevaLista=[]
            maxValue++
            result.each(){ row->
                def index = 0
                def valores = row.collect(){
                    it.value
                }
                nuevaLista<<valores.subList(0,maxValue)
            }
            nuevaLista
        }
    }
    def saveFile(FormatUploadCommand command, String controllerName){
        def usuario = ShiroUser.findByUsername(SecurityUtils.subject.principal)
        def storagePath = grailsApplication.config.grails.excel.upload.location+controllerName
        def mensaje =""
        def id = 0
        def storagePathDirectory = new File(storagePath)
        if (!storagePathDirectory.exists()) {
            print "CREATING DIRECTORY "+storagePath
            if (storagePathDirectory.mkdirs()) {
                println "SUCCESS"
            } else {
                println "FAILED"
            }
        }
        def name = controllerName+UUID.randomUUID().toString()
        /*
        def periodo
        if(command.tipoCaptura == 'diaria'){
        periodo = command.fechaDias
        command.fechaDias = command.fechaDias.replaceAll('/','_')
        name= controllerName+"-"+command.fechaDias+"-diaria-"+command.distrito
        }else if(command.tipoCaptura == 'semanal'){
        periodo = command.sAño+"/"+command.sSemana
        name= controllerName+"-"+command.sAño+"_"+command.sSemana+"-semanal-"+command.distrito
        }else if(command.tipoCaptura == 'mensual'){
        periodo = command.fechaMeses
        command.fechaMeses = command.fechaMeses.replaceAll('/','_')
        name= controllerName+"-"+command.fechaMeses+"-mensual-"+command.distrito
        }
         */
        def archivo
        def partes = command.archivo.getOriginalFilename().split('\\.')
        if (!command.archivo.isEmpty()) {
            archivo = new File(storagePath+"/"+name+"."+partes.last())
            command.archivo.transferTo(archivo)
            mensaje = "Archivo almacenado correctamente"
            def archivosCargados = new ArchivosCargados(
                nombre: name,
                periodo: new Date(),
                status: 'Subido',
                tabla: controllerName,
                path: archivo.absolutePath ,
                usuario: usuario
            )
            archivosCargados.save()
            try{
                printFile(archivosCargados)
                id=archivosCargados.id
            }catch(java.lang.IllegalArgumentException iae){
                archivosCargados.status = 'Rechazado: Tipo de Archivo Incorrecto'
                mensaje = "EL ARCHIVO NO FUE CARGADO POR NO SER DEL FORMATO CORRECTO, REVISA HAYAS SUBIDO EL ARCHIVO CORRECTO"
            }catch(java.lang.IndexOutOfBoundsException iobe){
                archivosCargados.status = 'Rechazado: Formato Incorrecto'
                mensaje = "EL ARCHIVO NO FUE CARGADO YA QUE NO TIENE EL FORMATO REQUERIDO, DESCARGA EL ARCHIVO Y LLENALO NUEVAMENTE"
            }
        } else {
            mensaje = "Archivo no almacenado: contenido vacio"
        }
        [mensaje:mensaje, id:id]
    }
    def loadCustodios(ArchivosCargados archivo){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path, archivo.tabla)
        def result = importer.getRows(0)
        def partesFecha = getFechaCustodios(result)
        importer = new LucasianExcelImporter(archivo.path, archivo.tabla)
        result = importer.getRows(10)
        def year = partesFecha[2]
        def month = partesFecha[1]
        def day = partesFecha[0]
        result.each(){
            if(it.Centro != null && !it.Centro.contains('TOTAL') && !it.Centro.contains('OBSERVA')){
                def centro = getStandardName(it.Centro.trim())
                if(centro=="ACUÑA") centro = "ACUNA"
                def datosPenal = datosPenales[centro]
                def custodiosHombres =
                [
                    tipoCentroPenitenciario:datosPenal.tipo,
                    centroPenitenciario: datosPenal.nombre,
                    genero:'HOMBRES',
                    enServicio:it.ServicioHombres?: 0,
                    año: year,
                    mes: month,
                    dia: day,
                    municipio: datosPenal.municipio,
                    distrito: datosPenal.distrito,
                    incapacitados:it.IncapacitadosHombres?: 0,
                    vacaciones: it.VacacionesHombres?: 0,
                    inasistencias: it.AusenciasHombre?: 0,
                    descanso: it.DescansoHombres?: 0,
                    comisionados: it.ComisionadosHombres?: 0,
                    enCursos: it.CursoHombres?: 0,
                    otrosPermisos: it.OtrosHombres?: 0,
                    total: it.Hombres?: 0
                ]
                def custodiosMujeres =
                [
                    tipoCentroPenitenciario:datosPenal.tipo,
                    centroPenitenciario: datosPenal.nombre,
                    genero:'MUJERES',
                    enServicio:it.ServicioMujeres?: 0,
                    año: year,
                    mes: month,
                    dia: day,
                    municipio: datosPenal.municipio,
                    distrito: datosPenal.distrito,
                    incapacitados:it.IncapacitadosMujeres?: 0,
                    vacaciones: it.VacacionesMujeres?: 0,
                    inasistencias: it.AusenciasMujeres?: 0,
                    descanso: it.DescansoMujeres?: 0,
                    comisionados: it.ComisionadosMujeres?: 0,
                    enCursos: it.CursoMujeres?: 0,
                    otrosPermisos: it.OtrosMujeres?: 0,
                    total: it.Mujeres?: 0
                ]                
                def hombres = new ComisionCustodios(custodiosHombres)
                hombres.save(failOnError: true)
                
                def mujeres = new ComisionCustodios(custodiosMujeres)
                mujeres.save(failOnError: true)
            }
            archivo.status="Cargado"
            archivo.save()
        }
    }
    def loadInternosSituacionJuridica(year, month, day, result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        def grupo = 'SITUACION JURIDICA'
        result.each(){
            if(it.centro != null && !it.centro.contains('TOTAL') && !it.centro.contains('OBSERVA')){                
                it.centro = getStandardName(it.centro)
                def datosPenal = datosPenales[it.centro]                
                def commonData = [
                    centroPenitenciarioTipo: datosPenal.tipo,                    centroPenitenciario: datosPenal.nombre,
                    municipio: datosPenal.municipio,                    distrito: datosPenal.distrito,
                    año: year,                    mes: month,
                    dia: day,                    capacidadInternamiento:it.CAPACIDAD,
                    clasificacionInternosGrupo:grupo
                ]
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'PROCESADOS',numeroInternos:it.ComunProcesadosHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'SENTENCIADOS',numeroInternos:it.ComunSentenciadoHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'SENTECIADOS EJECUTORIADOS',numeroInternos:it.ComunEjecutoriadoHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'INDICIADOS',numeroInternos:it.ComunIndiciadosHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'PROCESADOS',numeroInternos:it.ComunProcesadosMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'SENTENCIADOS',numeroInternos:it.ComunSentenciadoMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'SENTECIADOS EJECUTORIADOS',numeroInternos:it.ComunEjecutoriadoMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO COMUN',clasificacionInternos:'INDICIADOS',numeroInternos:it.ComunIndiciadosMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'PROCESADOS',numeroInternos:it.FederalProcesadosHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'SENTENCIADOS',numeroInternos:it.FederalSentenciadoHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'SENTECIADOS EJECUTORIADOS',numeroInternos:it.FederalEjecutoriadoHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'INDICIADOS',numeroInternos:it.FederalIndiciadosHombres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'PROCESADOS',numeroInternos:it.FederalProcesadosMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'SENTENCIADOS',numeroInternos:it.FederalSentenciadoMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'SENTECIADOS EJECUTORIADOS',numeroInternos:it.FederalEjecutoriadoMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FUERO FEDERAL',clasificacionInternos:'INDICIADOS',numeroInternos:it.FederalIndiciadosMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'MIXTO',clasificacionInternos:'MIXTO',numeroInternos:it.MixtoMujeres ?: 0]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'MIXTO',clasificacionInternos:'MIXTO',numeroInternos:it.MixtoHombres ?: 0]
                    )).save(failOnError: true)                            
            }
        } 
    }
    def getFechaInternos(result){
        def partesFecha
        result.each(){ row->
            if(row.centro?.contains('AL ')){
                    def fecha = row.centro.toUpperCase()
                    fecha = fecha.replace('AL ','')
                    partesFecha = fecha.split(' DE ')
                    partesFecha[1] = meses[partesFecha[1]]                    
            }
        }
        partesFecha
    }
    def getFechaCustodios(result){
        def partesFecha = result.first().Centro.split('\\.')[1].replace('EN SERVICIO','').trim().replace(' DEL','').replace(' DE','').split(' ')
        partesFecha[1] = getMonth(partesFecha[1])
        partesFecha        
    }
    def getFechaProgramas(result){
        def partesFecha 
        result.each(){ row->
            if(row.actividad == 'REPORTE DE ACTIVIDADES SEMANAL'){
                String fecha = row.saltilloFemenil.format("dd/MM/yyyy")				
				partesFecha = fecha.split('/')                									
            }
        }
        partesFecha
    }
    def loadInternosEnfermedad(year, month, day, result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales

        def grupo = 'ENFERMEDADES'
        result.each(){
            if(it.centro != null && !it.centro.contains('TOTAL') && !it.centro.contains('OBSERVA')){                
                it.centro = getStandardName(it.centro)
                def datosPenal = datosPenales[it.centro]                
                def commonData = [
                    centroPenitenciarioTipo: datosPenal.tipo,                    centroPenitenciario: datosPenal.nombre,
                    municipio: datosPenal.municipio,                    distrito: datosPenal.distrito,
                    año: year,                    mes: month,
                    dia: day,                    capacidadInternamiento:0,
                    clasificacionInternosGrupo:grupo
                ]
                (new ComisionInternos(
                        commonData+[internoGenero: 'SIN DATO',
                            clasificacionInternosSubgrupo:'HEPATITIS C',
                            clasificacionInternos:'HEPATITIS C',
                            numeroInternos:it.hepatitis ?: 0
                        ]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'SIN DATO',
                            clasificacionInternosSubgrupo:'VIH',
                            clasificacionInternos:'VIH',
                            numeroInternos:it.vih ?: 0
                        ]
                    )).save(failOnError: true)
                (new ComisionInternos(
                        commonData+[internoGenero: 'SIN DATO',
                            clasificacionInternosSubgrupo:'TUBERCULOSIS',
                            clasificacionInternos:'TUBERCULOSIS',
                            numeroInternos:it.tub ?: 0
                        ]
                    )).save(failOnError: true)
            }
        } 
    }    
    def loadInternosDelitos(year, month, day, result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        def grupo = 'DELITOS'
        result.each(){
            if(it.centro != null && !it.centro.contains('TOTAL') && !it.centro.contains('OBSERVA')){                
                it.centro = getStandardName(it.centro)
                def datosPenal = datosPenales[it.centro]                
                def commonData = [
                    centroPenitenciarioTipo: datosPenal.tipo,                    centroPenitenciario: datosPenal.nombre,
                    municipio: datosPenal.municipio,                    distrito: datosPenal.distrito,
                    año: year,                    mes: month,
                    dia: day,                    capacidadInternamiento:0,
                    clasificacionInternosGrupo:grupo
                ]
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'ROBO',clasificacionInternos:'ROBO',numeroInternos:it.RoboHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'HOMICIDIO',clasificacionInternos:'HOMICIDIO',numeroInternos:it.HomicidioHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'VIOLACIÓN',clasificacionInternos:'VIOLACIÓN',numeroInternos:it.ViolacionHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'CONTRA LA SALUD',clasificacionInternos:'CONTRA LA SALUD',numeroInternos:it.SaludHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'PORTACION DE ARMA DE FUEGO',clasificacionInternos:'PORTACION DE ARMA DE FUEGO',numeroInternos:it.ArmaHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'EQUIPARADO A LA VIOLACIÓN',clasificacionInternos:'EQUIPARADO A LA VIOLACIÓN',numeroInternos:it.EquiparadoHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'SECUESTRO',clasificacionInternos:'SECUESTRO',numeroInternos:it.SecuestroHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'FACILITACION DELICTIVA',clasificacionInternos:'FACILITACION DELICTIVA',numeroInternos:it.FacilitacionHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'DELINCUENCIA ORGANIZADA	',clasificacionInternos:'DELINCUENCIA ORGANIZADA',numeroInternos:it.OrganizadaHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'ATENTADOS AL PUDOR',clasificacionInternos:'ATENTADOS AL PUDOR',numeroInternos:it.PudorHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'DAÑOS',clasificacionInternos:'DAÑOS',numeroInternos:it.DañosHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'LESIONES',clasificacionInternos:'LESIONES',numeroInternos:it.LesionesHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'PRIVACION ILEGAL DE LA LIBERTAD',clasificacionInternos:'PRIVACION ILEGAL DE LA LIBERTAD',numeroInternos:it.PrivacionLibertadHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'POSESION DE NARCOTICOS',clasificacionInternos:'POSESION DE NARCOTICOS',numeroInternos:it.NarcoticosHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'HOMBRE',clasificacionInternosSubgrupo:'OTROS',clasificacionInternos:'OTROS',numeroInternos:it.OtrosHombre ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'ROBO',clasificacionInternos:'ROBO',numeroInternos:it.RoboMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'HOMICIDIO',clasificacionInternos:'HOMICIDIO',numeroInternos:it.HomicidioMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'VIOLACIÓN',clasificacionInternos:'VIOLACIÓN',numeroInternos:it.ViolacionMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'CONTRA LA SALUD',clasificacionInternos:'CONTRA LA SALUD',numeroInternos:it.SaludMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'PORTACION DE ARMA DE FUEGO',clasificacionInternos:'PORTACION DE ARMA DE FUEGO',numeroInternos:it.ArmaMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'EQUIPARADO A LA VIOLACIÓN',clasificacionInternos:'EQUIPARADO A LA VIOLACIÓN',numeroInternos:it.EquiparadoMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'SECUESTRO',clasificacionInternos:'SECUESTRO',numeroInternos:it.SecuestroMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'FACILITACION DELICTIVA',clasificacionInternos:'FACILITACION DELICTIVA',numeroInternos:it.FacilitacionMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'DELINCUENCIA ORGANIZADA	',clasificacionInternos:'DELINCUENCIA ORGANIZADA',numeroInternos:it.OrganizadaMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'ATENTADOS AL PUDOR',clasificacionInternos:'ATENTADOS AL PUDOR',numeroInternos:it.PudorMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'DAÑOS',clasificacionInternos:'DAÑOS',numeroInternos:it.DañosMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'LESIONES',clasificacionInternos:'LESIONES',numeroInternos:it.LesionesMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'PRIVACION ILEGAL DE LA LIBERTAD',clasificacionInternos:'PRIVACION ILEGAL DE LA LIBERTAD',numeroInternos:it.PrivacionLibertadMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'POSESION DE NARCOTICOS',clasificacionInternos:'POSESION DE NARCOTICOS',numeroInternos:it.NarcoticosMujer ?: 0]
                    )).save(failOnError: true)                                            
                (new ComisionInternos(
                        commonData+[internoGenero: 'MUJER',clasificacionInternosSubgrupo:'OTROS',clasificacionInternos:'OTROS',numeroInternos:it.OtrosMujer ?: 0]
                    )).save(failOnError: true)                                            
            }
        }        
    }
    def loadInternos(ArchivosCargados archivo){        
        LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path, 'comisionInternosEnfermos')
        def result = importer.getRows(0)
        def fecha = getFechaInternos(result)
        importer = new LucasianExcelImporter(archivo.path, 'comisionInternosEstadistica')
        result = importer.getRows(10)        
        loadInternosSituacionJuridica(fecha[2], fecha[1], fecha[0], result)
        importer = new LucasianExcelImporter(archivo.path, 'comisionInternosEnfermos')
        result = importer.getRows(10)
        loadInternosEnfermedad(fecha[2], fecha[1], fecha[0], result)
        importer = new LucasianExcelImporter(archivo.path, 'comisionInternosDelitos')
        result = importer.getRows(10)
        loadInternosDelitos(fecha[2], fecha[1], fecha[0], result)                
        archivo.status="Cargado"
        archivo.save()
    }
 
    def loadProgramas(ArchivosCargados archivo){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path, 'comisionProgramasIndividualizados')        
        def result = importer.getRows(0)
        def fechaPartes = getFechaProgramas(result)        
        importer = new LucasianExcelImporter(archivo.path, 'comisionProgramasIndividualizados')        
        result = importer.getRows(10)
        
        def year = fechaPartes[2]
        def month = fechaPartes[1]
        def day = 0
        def week = fechaPartes[0]
        def estrategia = ""
        def categoriaActividad =""
        def acuna =[
            centroPenitenciario:datosPenales['ACUNA'].nombre,
            centroPenitenciarioTipo: datosPenales['ACUNA'].tipo,        
            distrito: datosPenales['ACUNA'].distrito,
            municipio:datosPenales['ACUNA'].municipio
        ] 
        def piedras =[
            centroPenitenciario:datosPenales['P. NEGRAS'].nombre,
            centroPenitenciarioTipo: datosPenales['P. NEGRAS'].tipo,        
            distrito: datosPenales['P. NEGRAS'].distrito,
            municipio:datosPenales['P. NEGRAS'].municipio
        ] 
        def saltilloV =[
            centroPenitenciario:datosPenales['SALTILLO VAR.'].nombre,
            centroPenitenciarioTipo: datosPenales['SALTILLO VAR.'].tipo,        
            distrito: datosPenales['SALTILLO VAR.'].distrito,
            municipio:datosPenales['SALTILLO VAR.'].municipio
        ] 
        def saltilloF =[
            centroPenitenciario:datosPenales['SALTILLO FEM.'].nombre,
            centroPenitenciarioTipo: datosPenales['SALTILLO FEM.'].tipo,        
            distrito: datosPenales['SALTILLO FEM.'].distrito,
            municipio:datosPenales['SALTILLO FEM.'].municipio
        ] 
        def sanPedro =[
            centroPenitenciario:datosPenales['SAN PEDRO.'].nombre,
            centroPenitenciarioTipo: datosPenales['SAN PEDRO.'].tipo,        
            distrito: datosPenales['SAN PEDRO.'].distrito,
            municipio:datosPenales['SAN PEDRO.'].municipio
        ] 
        def torreon =[
            centroPenitenciario:datosPenales['TORREON'].nombre,
            centroPenitenciarioTipo: datosPenales['TORREON'].tipo,        
            distrito: datosPenales['TORREON'].distrito,
            municipio:datosPenales['TORREON'].municipio
        ] 
        result.each(){
            if(it.actividad != null && !it.actividad.contains('Ingresos') && !it.actividad.contains('Egresos')  && !it.actividad.contains('Hombres')  && !it.actividad.contains('Mujeres')){
                if(it.estrategia != null){
                    estrategia = it.estrategia ?: 'SIN DATO'
                    categoriaActividad = it.actividad                    
                }else{
                    def common = [
                        tipoProgramaSubgrupo: categoriaActividad,
                        tipoProgramaGrupo: estrategia,
                        año: year,
                        mes: month,
                        semana: week
                    ]
                    (new ComisionProgramasIndividualizados(common+acuna+[tipoPrograma: it.actividad,valor:it.acuna ?: 0])).save(failOnError: true)
                    (new ComisionProgramasIndividualizados(common+piedras+[tipoPrograma: it.actividad,valor:it.piedrasNegras ?: 0])).save(failOnError: true)
                    (new ComisionProgramasIndividualizados(common+saltilloV+[tipoPrograma: it.actividad,valor:it.saltilloVaronil ?: 0])).save(failOnError: true)
                    (new ComisionProgramasIndividualizados(common+saltilloF+[tipoPrograma: it.actividad,valor:it.saltilloFemenil ?: 0])).save(failOnError: true)
                    (new ComisionProgramasIndividualizados(common+sanPedro+[tipoPrograma: it.actividad,valor:it.sanPedro ?: 0])).save(failOnError: true)                    
                    (new ComisionProgramasIndividualizados(common+torreon+[tipoPrograma: it.actividad,valor:it.torreon ?: 0])).save(failOnError: true)
                }
            }
            archivo.status="Cargado"
            archivo.save()
        }
    }
    def loadVulnerables(ArchivosCargados archivo){
        LucasianExcelImporter importer = new LucasianExcelImporter(archivo.path, 'comisionPoblacionVulnerableIndigenas')
        def result = importer.getRows(10)        
        loadVulnerablesIndigenas( result)        
        importer = new LucasianExcelImporter(archivo.path, 'comisionPoblacionVulnerableSenectos')
        result = importer.getRows(10)        
        loadVulnerablesSenectos(result)
        importer = new LucasianExcelImporter(archivo.path, 'comisionPoblacionVulnerableExtranjeros')
        result = importer.getRows(10)        
        loadVulnerablesExtranjeros(result)
        importer = new LucasianExcelImporter(archivo.path, 'comisionPoblacionVulnerableDiscapacidades')
        result = importer.getRows(10)        
        loadVulnerablesDiscapacitados(result)  
        importer = new LucasianExcelImporter(archivo.path, 'comisionPoblacionVulnerableInimputables')
        result = importer.getRows(10)        
        loadVulnerablesInimputables(result)
        archivo.status="Cargado"
        archivo.save()        
    }
    def loadVulnerablesIndigenas(result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        def tipo_vulnerable = 'INDIGENAS'
        def nextIsCentro = false
        def centro = ""
        def commonData = [:]
        for(int i = 0; i<result.size(); i++){
            def it = result.get(i)
            if(it.Etnia == "0"){
                break
            }
            if(it.Etnia != null && !it.Etnia.contains('TOTAL') && !it.Etnia.contains('ETNÍA') && !it.Etnia.contains('POBLACIÓN INDIGENA')&& !it.Etnia.contains('ENTIDAD FEDERATIVA')&& !it.Etnia.contains('COAHUILA') ){                
                if(it.Etnia == 'CENTRO'){
                    nextIsCentro = true
                }else{
                    if(nextIsCentro){
                        centro = getStandardName(it.Etnia)
                        nextIsCentro = false												
						if(centro=="CENTRO PENITENCIARIO TORREÓN") centro = "CENTRO PENITENCIARIO TORREON"
						if(centro=="CENTRO PENITENCIARIO CIUDAD ACUÑA") centro = "CENTRO PENITENCIARIO CIUDAD ACUNA"
                        def datosPenal = datosPenales[centro]                                        
                        commonData = [
                            centroPenitenciarioTipo: datosPenal.tipo,
                            centroPenitenciario: datosPenal.nombre,
                            municipio: datosPenal.municipio,
                            distrito: datosPenal.distrito,
                            año: it.FederalSentenciadosHombres,
                            mes: getMonth(it.ComunSentenciadosHombres),
                            dia: 0,                    
                            tipoInternoSubgrupo: tipo_vulnerable
                        ]   
                    }else{
                        if(commonData?.tipoInternoSubgrupo){ 
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Etnia,tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosMujeres?: 0])).save(failOnError: true)
                        }
                    }
                }
            }
        }           
    }
    def loadVulnerablesSenectos( result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        def tipo_vulnerable = 'SENECTOS'
        def nextIsCentro = false
        def centro = ""
        def commonData=[:]
        for(int i = 0; i<result.size(); i++){
            def it = result.get(i)
            if(it.Rango == "0"){
                break
            }
            if(it.Rango != null && !it.Rango.contains('TOTAL') &&!it.Rango.contains('SENECTA')&& !it.Rango.contains('RANGO DE EDAD') && !it.Rango.contains('POBLACIÓN INDIGENA')&& !it.Rango.contains('ENTIDAD FEDERATIVA')&& !it.Rango.contains('COAHUILA') ){                
                if(it.Rango == 'CENTRO'){
                    nextIsCentro = true
                }else{
                    if(nextIsCentro){
                        centro = getStandardName(it.Rango)
                        nextIsCentro = false
						if(centro=="CENTRO PENITENCIARIO TORREÓN") centro = "CENTRO PENITENCIARIO TORREON"
						if(centro=="CENTRO PENITENCIARIO CIUDAD ACUÑA") centro = "CENTRO PENITENCIARIO CIUDAD ACUNA"
                        def datosPenal = datosPenales[centro]                                        
                        commonData = [
                            centroPenitenciarioTipo: datosPenal.tipo,
                            centroPenitenciario: datosPenal.nombre,
                            municipio: datosPenal.municipio,
                            distrito: datosPenal.distrito,
                            año: it.FederalSentenciadosHombres,
                            mes: getMonth(it.ComunSentenciadosMujeres),
                            dia: 0,                    
                            tipoInternoSubgrupo: tipo_vulnerable
                        ]                         
                    }else{   
                        if(commonData?.tipoInternoSubgrupo){ 
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Rango,tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosMujeres?: 0])).save(failOnError: true)                        
                        }
                    }
                }
            }
        }           
    }
    def loadVulnerablesDiscapacitados( result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        def tipo_vulnerable = 'DISCAPACITADOS'
        def nextIsCentro = false
        def centro = ""
        def commonData = [:]
        for(int i = 0; i<result.size(); i++){
            def it = result.get(i)
            if(it.Tipo == "0"){
                break
            }
            if(it.Tipo != null && !it.Tipo.contains('T O T A L') && 
                !it.Tipo.contains('TIPO') && !it.Tipo.contains('PADECIMIENTOS') &&
                !it.Tipo.contains('DE LA VISTA') && !it.Tipo.contains('OIDO')&&
                !it.Tipo.contains('DEL HABLA') && !it.Tipo.contains('PARA MOVERSE')&&
                !it.Tipo.contains('DE LA CABEZA') && !it.Tipo.contains('OTROS') && !it.Tipo.contains('NOTA')
                && !it.Tipo.contains('ENTIDAD FEDERATIVA')&& !it.Tipo.contains('COAHUILA') ){                
                if(it.Tipo == 'CENTRO'){
                    nextIsCentro = true
                }else{
                    if(nextIsCentro){
                        centro = getStandardName(it.Tipo)
                        nextIsCentro = false
						if(centro=="CENTRO PENITENCIARIO TORREÓN") centro = "CENTRO PENITENCIARIO TORREON"
						if(centro=="CENTRO PENITENCIARIO CIUDAD ACUÑA") centro = "CENTRO PENITENCIARIO CIUDAD ACUNA"
                        def datosPenal = datosPenales[centro]                                        
                        commonData = [
                            centroPenitenciarioTipo: datosPenal.tipo,
                            centroPenitenciario: datosPenal.nombre,
                            municipio: datosPenal.municipio,
                            distrito: datosPenal.distrito,
                            año: it.FederalSentenciadosHombres,
                            mes: getMonth(it.ComunSentenciadosMujeres),
                            dia: 0,                    
                            tipoInternoSubgrupo: tipo_vulnerable
                        ]   
                    }else{
                        if(commonData?.tipoInternoSubgrupo){ 
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Tipo.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosMujeres?: 0])).save(failOnError: true)
                        }
                    }
                }
            }
        }           
    }
    def loadVulnerablesExtranjeros( result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        def tipo_vulnerable = 'EXTRANJEROS'
        def nextIsCentro = false
        def centro = ""
        def commonData = [:]
        for(int i = 0; i<result.size(); i++){
            def it = result.get(i)
            if(it.Pais == "0"){
                break
            }
            if(it.Pais != null && !it.Pais.contains('TOTAL') && !it.Pais.contains('PAIS') && !it.Pais.contains('EXTRANJEROS')&& !it.Pais.contains('ENTIDAD FEDERATIVA')&& !it.Pais.contains('COAHUILA') && !it.Pais.contains('NOTA')){                
                if(it.Pais == 'CENTRO'){
                    nextIsCentro = true
                }else{
                    if(nextIsCentro){
                        centro = getStandardName(it.Pais)
                        nextIsCentro = false
						if(centro=="CENTRO PENITENCIARIO TORREÓN") centro = "CENTRO PENITENCIARIO TORREON"
						if(centro=="CENTRO PENITENCIARIO CIUDAD ACUÑA") centro = "CENTRO PENITENCIARIO CIUDAD ACUNA"
                        def datosPenal = datosPenales[centro]                                        
                        commonData = [
                            centroPenitenciarioTipo: datosPenal.tipo,
                            centroPenitenciario: datosPenal.nombre,
                            municipio: datosPenal.municipio,
                            distrito: datosPenal.distrito,
                            año: it.FederalSentenciadosHombres,
                            mes: getMonth(it.ComunSentenciadosMujeres),
                            dia: 0,                    
                            tipoInternoSubgrupo: tipo_vulnerable
                        ]   
                    }else{
                        if(commonData?.tipoInternoSubgrupo){ 
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosHombres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.ComunSentenciadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalProcesadosMujeres?: 0])).save(failOnError: true)
                        (new ComisionPoblacionVulnerable(commonData+[tipoInterno:it.Pais.toUpperCase(),tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.FederalSentenciadosMujeres?: 0])).save(failOnError: true)
                        }
                    }
                }
            }
        }           
    }  
    def loadVulnerablesInimputables( result){
        def datosPenales = grailsApplication.config.grails.excel.datosPenales
        def tipo_vulnerable = 'ENFERMOS MENTALES'
        def nextIsCentro = false
        def fecha = [:]
        for(int i = 0; i<result.size(); i++){
            def it = result.get(i)            
            if(it.Centro == "0"){
                break
            }
            if(it.Centro != null && !it.Centro.contains('INIMPUTABLES') && !it.Centro.contains('CENTRO DE RECLUSIÓN') ){                			    
                if(i == 0){
                    fecha = [
                        año: it.InimputablesFederalProcesadosHombres,
                        mes: getMonth(it.EnfermosFederalProcesadosMujeres),
                        dia: 0
                    ]
                }else{                    
                    def centro = getStandardName(it.Centro)
					if(centro=="CENTRO PENITENCIARIO TORREÓN") centro = "CENTRO PENITENCIARIO TORREON"
					if(centro=="CENTRO PENITENCIARIO CIUDAD ACUÑA") centro = "CENTRO PENITENCIARIO CIUDAD ACUNA"
                    def datosPenal = datosPenales[centro]                      					
                    def  commonData = [
                        centroPenitenciarioTipo: datosPenal.tipo,
                        centroPenitenciario: datosPenal.nombre,
                        municipio: datosPenal.municipio,
                        distrito: datosPenal.distrito,
                        tipoInternoSubgrupo: tipo_vulnerable
                    ]+fecha
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.EnfermosComunProcesadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.EnfermosComunSentenciadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.EnfermosFederalProcesadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.EnfermosFederalSentenciadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.EnfermosComunProcesadosMujeres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.EnfermosComunSentenciadosMujeres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.EnfermosFederalProcesadosMujeres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'ENFERMOS MENTALES',tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.EnfermosFederalSentenciadosMujeres?: 0])).save(failOnError: true)                        

                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.InimputablesComunProcesadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.InimputablesComunSentenciadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.InimputablesFederalProcesadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'HOMBRE',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.InimputablesFederalSentenciadosHombres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.InimputablesComunProcesadosMujeres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO COMUN',numero:it.InimputablesComunSentenciadosMujeres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'MUJER',situacionJuridca:'PROCESADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.InimputablesFederalProcesadosMujeres?: 0])).save(failOnError: true)
                    (new ComisionPoblacionVulnerable(commonData+[tipoInterno:'INIMPUTABLES',tipoInternoGrupo:'MUJER',situacionJuridca:'SENTENCIADOS',situacionJuridicaGrupo:'FUERO FEDERAL',numero:it.InimputablesFederalSentenciadosMujeres?: 0])).save(failOnError: true)                        

                                
                }
            }
        }           
    }    
    def getMonth(mes){
        return meses[mes.toUpperCase()]
    }
    def getStandardName(centro){
        println("NOMBRE DEL CENTRO RECIBIDO"+centro)
        switch(centro){
        case 'Centro Penitenciario Torreón':
            'TORREON'
            break
        case 'Centro Penitenciario Piedras Negras':
                'P. NEGRAS'
            break
        case 'Centro Penitenciario Varonil Saltillo':
                'SALTILLO VAR.'
            break
        case 'Centro Penitenciario Sabinas':
                'SABINAS'
            break
        case 'Centro Penitenciario Ciudad Acuña':
                'ACUNA'
            break
        case 'Centro Penitenciario San Pedro':
                'SAN PEDRO.'
            break
        case 'Centro Penitenciario Femenil Saltillo':
                'SALTILLO FEM.'
            break
        case 'ACUÑA':
                'ACUNA'
            break
        case 'CD. ACUÑA':
                'ACUNA'
            break
        case 'P.NEGRAS':
                'P. NEGRAS'
            break
        case 'P. NEGRAS':
                'P. NEGRAS'
            break
        case 'P.NEGRAS FEM.':
                'FEMENIL P. NEGRAS.'
            break
        case 'P. NEGRAS FEM.':
                'FEMENIL P. NEGRAS.'
            break            
        case 'SALTILLO VAR.':
                'SALTILLO VAR.'
            break
        case 'SALTILLO FEM.':
                'SALTILLO FEM.'
            break
        case 'SAN PEDRO':
                'SAN PEDRO.'
            break
        case 'TORREON':
                'TORREON'
            break
        case 'TORREÓN':
                'TORREON'
            break
        default:
            centro
            break
        }
    }
}
