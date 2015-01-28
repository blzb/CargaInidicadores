/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lucasian.nsjp.indicadores

import org.grails.plugins.excelimport.*
import java.text.DecimalFormat

/**
 *
 * @author Angel
 */
class LucasianExcelImporter extends AbstractExcelImporter {
    def tableName
    Map excelConfiguration = [                  
        'procuraduriaActoEquivalente': [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'nuc',
                  'B':'montoMulta',
                  'C':'delitoGrupo',
                  'D':'delitoSubgrupo',
                  'E':'delito',
                  'F':'delitoModalidad',
                  'G':'delitoModus',
                  'H':'distrito',
                  'I':'municipio',
                  'J':'año',
                  'K':'mes',
                  'L':'dia',
                  'M':'unidadClave',
                  'N':'unidadNombre'
            ]
        ],
    'comisionActuacionesPoliciales': [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'corporacion',
                  'D':'tipoActuacion',
                  'B':'tipoActuacionGrupo',
                  'C':'tipoActuacionSubgrupo',
                  'E':'municipio',
                  'F':'distrito',
                  'G':'año',
                  'H':'mes',
                  'I':'dia'
            
            ]
        ],
    'comisionCustodios': [
            sheet:'ESTADO FE FUERZA DIARIO', 
            startRow: 3,
            columnMap:  [
                  'A':'Centro',
                  'B':'Hombres',
                  'C':'Mujeres',
                  'D':'total',
                  'E':'IncapacitadosHombres',
                  'F':'IncapacitadosMujeres',
                  'G':'VacacionesHombres',
                  'H':'VacacionesMujeres',
                  'I':'InasistenciasHombres',
                  'J':'InasistenciasMujeres',
                  'K':'DescansoHombres',
                  'L':'DescansoMujeres',
                  'M':'ComisionadosHombres',
                  'N':'ComisionadosMujeres',
                  'O':'CursoHombres',
                  'P':'CursoMujeres',
                  'Q':'OtrosHombres',
                  'R':'OtrosMujeres',
                  'S':'ServicioHombres',
                  'T':'ServicioMujeres',
                  'U':'Total',
                  'V':'AusenciasHombre',
                  'W':'AusenciasMujeres'                
            ]
        ],
    'comisionDetenidos': [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'corporacion',
                  'B':'imputadoGenero',
                  'C':'imputadoEdad',
                  'D':'imputadoEscolaridad',
                  'E':'imputadoEstadoCivil',
                  'F':'imputadoOcupacion',
                  'H':'municipio',
                  'I':'colonia',
                  'J':'codigoPostal',
                  'K':'calle',
                  'L':'entrecalle',
                  'M':'numero',
                  'N':'latitud',
                  'O':'longitud',
                  'P':'año',
                  'Q':'mes',
                  'R':'dia',
                  'G':'distrito'
            ]
        ],
    'comisionProgramasIndividualizados' : [
            sheet:'CP', 
            startRow: 17,
            columnMap:  [
                  'A':'actividad',
                  'B':'estrategia',
                  'C':'lineaAccion',
                  'D':'acuna',
                  'E':'piedrasNegras',
                  'F':'saltilloVaronil',
                  'G':'saltilloFemenil',
                  'H':'sanPedro',
                  'I':'torreon',
                  'J':'total'
            ]
        ],
    'comisionPoblacionVulnerableIndigenas' : [
            sheet:'INDIGENAS', 
            startRow: 80,
            columnMap:  [
                  'A':'Etnia',
                  'B':'ComunProcesadosHombres',
                  'C':'ComunProcesadosMujeres',
                  'D':'ComunSentenciadosHombres',
                  'E':'ComunSentenciadosMujeres',
                  'F':'FederalProcesadosHombres',
                  'G':'FederalProcesadosMujeres',
                  'H':'FederalSentenciadosHombres',
                  'I':'FederalSentenciadosMujeres',
                  'J':'Total'                    
            ]
        ],
    'comisionPoblacionVulnerableSenectos' : [
            sheet:'SENECTOS', 
            startRow: 20,
            columnMap:  [
                  'A':'Rango',
                  'B':'ComunProcesadosHombres',
                  'C':'ComunProcesadosMujeres',
                  'D':'ComunSentenciadosHombres',
                  'E':'ComunSentenciadosMujeres',
                  'F':'FederalProcesadosHombres',
                  'G':'FederalProcesadosMujeres',
                  'H':'FederalSentenciadosHombres',
                  'I':'FederalSentenciadosMujeres',
                  'J':'Total'                    
            ]
        ],
    'comisionPoblacionVulnerableDiscapacidades' : [
            sheet:'DISCAPACIDADES', 
            startRow: 60,
            columnMap:  [
                  'A':'Tipo',
                  'B':'ComunProcesadosHombres',
                  'C':'ComunProcesadosMujeres',
                  'D':'ComunSentenciadosHombres',
                  'E':'ComunSentenciadosMujeres',
                  'F':'FederalProcesadosHombres',
                  'G':'FederalProcesadosMujeres',
                  'H':'FederalSentenciadosHombres',
                  'I':'FederalSentenciadosMujeres',
                  'J':'Total'                    
            ]
        ],
    'comisionPoblacionVulnerableExtranjeros' : [
            sheet:'EXTRANJEROS', 
            startRow: 84,
            columnMap:  [
                  'A':'Pais',
                  'B':'ComunProcesadosHombres',
                  'C':'ComunProcesadosMujeres',
                  'D':'ComunSentenciadosHombres',
                  'E':'ComunSentenciadosMujeres',
                  'F':'FederalProcesadosHombres',
                  'G':'FederalProcesadosMujeres',
                  'H':'FederalSentenciadosHombres',
                  'I':'FederalSentenciadosMujeres',
                  'J':'Total'                    
            ]
        ],
        
    'comisionPoblacionVulnerableInimputables' : [
            sheet:'ENFERMOS MENTALES', 
            startRow: 1,
            columnMap:  [
                  'B':'Centro',
                  'C':'EnfermosComunProcesadosHombres',
                  'D':'EnfermosComunProcesadosMujeres',
                  'E':'EnfermosComunSentenciadosHombres',
                  'F':'EnfermosComunSentenciadosMujeres',
                  'G':'EnfermosFederalProcesadosHombres',
                  'H':'EnfermosFederalProcesadosMujeres',
                  'I':'EnfermosFederalSentenciadosHombres',
                  'J':'EnfermosFederalSentenciadosMujeres',
                  'K':'Total',
                  'L':'InimputablesComunProcesadosHombres',
                  'M':'InimputablesComunProcesadosMujeres',
                  'N':'InimputablesComunSentenciadosHombres',
                  'O':'InimputablesComunSentenciadosMujeres',
                  'P':'InimputablesFederalProcesadosHombres',
                  'Q':'InimputablesFederalProceasdosMujeres',
                  'R':'InimputablesFederalSentenciadosHombres',
                  'S':'InimputablesFederalSentenciadosMujeres',
                  'T':'Subtotal'
            ]
        ],        
    'comisionMedidasCautelares' : [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'solicitanteTipo',
                  'B':'solicitanteNombre',
                  'C':'status',
                  'D':'tipoMedida',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'I':'municipio',
                  'H':'distrito'
            ]
        ],
    'comisionIphs' : [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'B':'agente',
                  'C':'puesto',
                  'D':'corporacion',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'N':'municipio',
                  'M':'distrito',
                  'H':'tipoParticipacion',
                  'I':'asunto',
                  'J':'operativo',
                  'K':'faltaAdministrativa',
                  'L':'folioIph',
                  'O':'calle',
                  'P':'numero',
                  'Q':'entrecalle',
                  'R':'colonia',
                  'V':'delito',
                  'W':'delitoGravedad',
                  'A':'cnumeroEmpleado',
                  'S':'cp',
                  'T':'latitud',
                  'U':'longitud'            
            ]
        ],
    'comisionInternosEstadistica' : [
            sheet:'estadistica', 
            startRow: 7,
            columnMap:  [
                  'D':'centro',
                  'E':'ComunProcesadosHombres',
                  'F':'ComunProcesadosMujeres',
                  'G':'ComunSentenciadoHombres',
                  'H':'ComunSentenciadoMujeres',
                  'I':'ComunEjecutoriadoHombres',
                  'J':'ComunEjecutoriadoMujeres',
                  'K':'ComunIndiciadosHombres',
                  'L':'ComunIndiciadosMujeres',
                  'M':'SUBTOTAL',
                  'N':'FederalProcesadosHombres',
                  'O':'FederalProcesadosMujeres',
                  'P':'FederalSentenciadoHombres',
                  'Q':'FederalSentenciadoMujeres',
                  'R':'FederalEjecutoriadoHombres',
                  'S':'FederalEjecutoriadoMujeres',
                  'T':'FederalIndiciadosHombres',
                  'U':'FederalIndiciadosMujeres',
                  'V':'SUBTOTAL',
                  'W':'TOTAL',
                  'X':'CAPACIDAD',
                  'Z':'MixtoHombres',
                  'AA':'MixtoMujeres'
            ]
        ],
 'comisionInternosEnfermos' : [
            sheet:'enfermos', 
            startRow: 13,
            columnMap:  [
                  'B':'centro',
                  'D':'hepatitis',
                  'E':'vih',
                  'F':'tub'
            ]
        ], 
'comisionInternosDelitos' : [
            sheet:'Hoja3', 
            startRow: 9,
            columnMap:  [
                  'A':'centro',
                  'B':'RoboHombre',
                  'C':'RoboMujer',
                  'D':'HomicidioHombre',
                  'E':'HomicidioMujer',
                  'F':'ViolacionHombre',
                  'G':'ViolacionMujer',
                  'H':'SaludHombre',
                  'I':'SaludMujer',
                  'J':'ArmaHombre',
                  'K':'ArmaMujer',
                  'L':'EquiparadoHombre',
                  'M':'EquiparadoMujer',
                  'N':'SecuestroHombre',
                  'O':'SecuestroMujer',
                  'P':'FacilitacionHombre',
                  'Q':'FacilitacionMujer',
                  'R':'OrganizadaHombre',
                  'S':'OrganizadaMujer',
                  'T':'PudorHombre',
                  'U':'PudorMujer',
                  'V':'DañosHombre',
                  'W':'DañosMujer',
                  'X':'LesionesHombre',
                  'Y':'LesionesMujer',
                  'Z':'PrivacionLibertadHombre',
                  'AA':'PrivacionLibertadMujer',
                  'AB':'NarcoticosHombre',
                  'AC':'NarcoticosMujer',
                  'AD':'OtrosHombre',
                  'AE':'OtrosMujer'
            ]
        ],        
    'comisionEvaluacionMedidas': [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'tipoResultado',
                  'C':'municipio',
                  'B':'distrito',
                  'D':'codigoPostal',
                  'E':'año',
                  'F':'mes',
                  'G':'dia'
            ]
        ],
    'comisionSupervisionMedidas' : [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'tipoDelitoGrupo',
                  'B':'tipoDelitoSubgrupo',
                  'C':'tipoDelito',
                  'D':'tipoMedida',
                  'E':'statusSupervicion',
                  'F':'estado',
                  'G':'municipio',
                  'H':'distrito',
                  'I':'colonia',
                  'J':'codigoPostal',
                  'K':'año',
                  'L':'mes',
                  'M':'dia'
            ]
        ],
    'tribunalesSentencias' : [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'nuc',
                  'C':'tipoSentencia',
                  'D':'causaEjecutoria',
                  'I':'municipio',
                  'H':'distrito',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'B':'numeroExpediente'
            ]
        ],
    'tribunalesSegundaInstancia':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'salaPenal',
                  'B':'tribunalDistrital',
                  'C':'tipoResolucionNombre',
                  'D':'tipoRecurso',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'I':'municipio',            
                  'H':'distrito'
            ]
        ],
    'tribunalesPlazosInvestigacion':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'C':'plazoInvestigacionHora',
                  'D':'aprobadoHora',
                  'A':'nuc',
                  'F':'municipio',
                  'E':'distrito',
                  'G':'año',
                  'H':'mes',
                  'I':'dia',
                  'B':'numeroExpediente'
            ]
        ],
    'tribunalesNotificaciones':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'D':'statusNotificacion',
                  'A':'nuc',
                  'C':'tipoNotificacion',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'I':'municipio',
                  'H':'distrito',
                  'B':'numeroExpediente'
            ]
        ],
    'tribunalesMedidasCautelares':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'tipoMedida',
                  'B':'statusMedida',
                  'D':'municipio',
                  'C':'distrito',
                  'E':'año',
                  'F':'mes',
                  'G':'dia'
            ]
        ],
    'tribunalesCausas':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'M':'tipoDelitoGrupo',
                  'P':'tipoDelitoModus',
                  'Q':'tipoDelitoModalidad',
                  'N':'tipoDelitoSubgrupo',
                  'O':'tipoDelito',
                  'A':'nuc',
                  'C':'victimaGenero',
                  'D':'victimaEdad',
                  'E':'victimaEscolaridad',
                  'F':'victimaEstadoCivil',
                  'G':'victimaOcupacion',
                  'H':'imputadoGenero',
                  'B':'numeroExpediente',
                  'J':'imputadoEscolaridad',
                  'K':'imputadoEstadoCivil',
                  'L':'imputadoOcupacion',
                  'R':'año',
                  'S':'mes',
                  'T':'dia',
                  'V':'municipio',
                  'U':'distrito',
                  'I':'imputadoEdad'
            ]
        ],
    'tribunalesBeneficios':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'C':'sentenciadoNombre',
                  'D':'sentenciadoGenero',
                  'E':'sentenciadoEscolaridad',
                  'F':'sentenciadoEdad',
                  'G':'sentenciadoOcupacion',
                  'A':'nuc',
                  'H':'tipoBeneficio',
                  'I':'status',
                  'N':'municipio',
                  'M':'distrito',
                  'J':'año',
                  'K':'mes',
                  'L':'dia',
                  'B':'numeroExpediente'
            ]
        ],
    'tribunalesAuxilioJudicial':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'estadoOrigen',
                  'B':'municipioOrigen',
                  'C':'distritoOrigen',
                  'D':'estadoDestino',
                  'E':'municipioDestino',
                  'F':'distritoDestino',
                  'G':'tipoAuxilioGrupo',
                  'H':'tipoAuxilioNombre',
                  'I':'año',
                  'J':'mes',
                  'K':'dia',
                  'L':'semana'
            ]
        ],
   'tribunalesAudiencias':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'C':'etapa',
                  'D':'tipoAudiencia',
                  'E':'statusAudiencia',
                  'I':'año',
                  'J':'mes',
                  'K':'dia',
                  'F':'folioAudiencia',
                  'G':'participante',
                  'H':'rolParticipante',
                  'M':'municipio',
                  'L':'distrito',
                  'A':'nuc',
                  'B':'numeroExpediente'
            ]
        ],
    'tribunalesAmparos':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'nuc',
                  'D':'tipoResolucion',
                  'C':'tipoAmparo',
                  'H':'distrito',
                  'I':'municipio',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'B':'numeroExpediente'
            ]
        ],
    'procuraduriaTiempoAtencion':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'ministerioTipo',
                  'B':'ministerio',
                  'D':'municipio',
                  'C':'distrito',
                  'J':'unidadProcuraduria',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'H':'tiempoSegundos',
                  'I':'claveUnidad'
            ]
        ],
    'procuraduriaRecursosInterpuestos':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
				  'A':'nuc',
                  'B':'tipoRecurso',
                  'C':'ministerioGrupo',
				  'D':'ministerio',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'H':'distrito',
                  'I':'municipio',
                  'J':'claveUnidad',
                  'K':'nombreUnidad'                  
            ]
        ],
    'procuraduriaJusticiaAlternativa':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'B':'imputadoGenero',
                  'C':'imputadoEdad',
                  'D':'imputadoEscolaridad',
                  'E':'imputadoEstadoCivil',
                  'F':'imputadoOcupacion',
                  'G':'victimaGenero',
                  'H':'victimaEdad',
                  'I':'victimaEscolaridad',
                  'K':'victimaOcupacion',
                  'J':'victimaEstadoCivil',
                  'L':'municipio',
                  'M':'distrito',
                  'N':'delitoGrupo',
                  'O':'delitoSubgrupo',
                  'P':'delito',
                  'S':'añoIngreso',
                  'T':'mesIngreso',
                  'U':'diaIngreso',
                  'V':'añoTermino',
                  'W':'mesTermino',
                  'X':'diaTermino',
                  'Q':'delitoModus',
                  'R':'delitoModalidad',
                  'Z':'unidadNombre',
                  'Y':'unidadClave',
                  'A':'nuc'
            ]
        ],
    'procuraduriaJudicializados':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'B':'imputadoGenero',
                  'C':'imputadoEdad',
                  'D':'imputadoEscolaridad',
                  'E':'imputadoEstadoCivil',
                  'F':'imputadoOcupacion',
                  'G':'victimaGenero',
                  'H':'victimaEdad',
                  'I':'victimaEscolaridad',
                  'J':'victimaEstadoCivil',
                  'K':'victimaOcupacion',
                  'L':'delitoGrupo',
                  'M':'delitoSubgrupo',
                  'N':'delitoNombre',
                  'A':'nuc',
                  'R':'municipio',
                  'Q':'distrito',
                  'S':'año',
                  'T':'mes',
                  'U':'dia',
                  'O':'delitoModalidad',
                  'P':'delitoModus',
                  'W':'unidadNombre',
                  'V':'unidadClave'
            ]
        ],
    'procuraduriaInvestigaciones':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'C':'unidadInvestigacion',
                  'J':'municipio',
                  'I':'distrito',
                  'F':'año',
                  'G':'mes',
                  'H':'dia',
                  'D':'claveUnidad',
                  'E':'nombreUnidad',
                  'A':'nuc',
                  'B':'claveUnidadInvestigacion'
            ]
        ],
    'procuraduriaExpediente':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'B':'funcionario',
                  'C':'puesto',
                  'D':'institucion',
                  'K':'unidad',
                  'F':'municipio',
                  'E':'distrito',
                  'G':'año',
                  'H':'mes',
                  'I':'dia',
                  'M':'estatus',
                  'L':'etapa',
                  'A':'nuc',
                  'J':'unidadClave'
            ]
        ],
    'procuraduriaDeterminaciones':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'F':'imputadoGenero',
                  'G':'imputadoEdad',
                  'H':'imputadoEscolaridad',
                  'I':'imputadoOcupacion',
                  'A':'nuc',
                  'Q':'municipio',
                  'P':'distrito',
                  'AB':'tipoDaterminacionNombre',
                  'R':'año',
                  'S':'mes',
                  'T':'dia',
                  'J':'imputadoEstadoCivil',
                  'K':'victimaGenero',
                  'L':'victimaEdad',
                  'M':'victimaEstadoCivil',
                  'N':'victimaEscolaridad',
                  'O':'victimaOcupacion',
                  'U':'delitoGrupo',
                  'V':'delitoSubgrupo',
                  'W':'delitoNombre',
                  'X':'delitoModus',
                  'Y':'delitoModalidad',
                  'Z':'unidadClave',
                  'AA':'unidadNombre',
                  'C':'funcionarioNombre',
                  'B':'funcionarioPuesto',
                  'D':'funcionarioUnidad',
                  'E':'funcionarioInstitucion'
            ]
        ],
    'procuraduriaDetenidos':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'B':'imputadoGenero',
                  'C':'imputadoEdad',
                  'D':'imputadoEscolaridad',
                  'E':'imputadoEstadoCivil',
                  'F':'imputadoOcupacion',
                  'G':'estado',
                  'I':'municipio',
                  'J':'colonia',
                  'K':'calle',
                  'L':'entrecalle',
                  'M':'numero',
                  'O':'latitud',
                  'P':'longitud',
                  'N':'codigoPostal',
                  'Q':'corporacion',
                  'R':'conclusionNombre',
                  'S':'añor',
                  'T':'mes',
                  'U':'dia',
                  'H':'distrito',
                  'V':'unidadClave',
                  'W':'unidadNombre',
                  'A':'nuc'
            ]
        ],
    'procuraduriaDelitos':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'S':'dia',
                  'R':'mes',
                  'Q':'año',
                  'X':'entreCalle',
                  'AA':'latitud',
                  'AB':'longitud',
                  'Y':'numero',
                  'W':'calle',
                  'V':'colonia',
                  'U':'municipio',
                  'B':'imputadoGenero',
                  'C':'imputadoEdad',
                  'D':'imputadoEscolaridad',
                  'E':'imputadoOcupacion',
                  'G':'victimaGenero',
                  'H':'victimaEdad',
                  'I':'victimaEscolaridad',
                  'J':'victimaOcupacion',
                  'L':'tipoDelitoGrupo',
                  'N':'tipoDelitoNombre',
                  'M':'tipoDelitoSubgrupo',                  
                  'A':'nuc',
                  'O':'modus',
                  'P':'modalidad',
                  'K':'victimaEstadoCivil',
                  'F':'imputadoEstadoCivil',
                  'AC':'claveUnidad',
                  'AD':'nombreUnidad',
                  'T':'distrito',
				  'Z':'codigoPostal'
            ]
        ],
    'procuraduriaAtencionVictimas':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'B':'imputadoGenero',
                  'C':'imputadoEdad',
                  'D':'imputadoEscolaridad',
                  'E':'imputadoEstadoCivil',
                  'F':'imputadoOcupacion',
                  'G':'victimaGenero',
                  'H':'victimaEdad',
                  'I':'victimaEscolaridad',
                  'J':'victimaEstadoCivil',
                  'K':'victimaOcupacion',
                  'L':'tipoAtencion',
                  'M':'año',
                  'N':'mes',
                  'O':'dia',
                  'Q':'municipio',
                  'P':'distrito',
                  'R':'unidadClave',
                  'S':'unidadNombre',
                  'A':'nuc'
            ]
        ],
    'defensoriaGestiones':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'defensor',
                  'B':'puesto',
                  'C':'distrito',
                  'E':'nuc',
                  'G':'etapaSubgrupo',
                  'H':'etapaGrupo',
                  'I':'etapaNombre',
                  'J':'tipoGestionGrupo',
                  'K':'tipoGestionSubgrupo',
                  'L':'tipoGestionNombre',
                  'M':'año',
                  'N':'mes',
                  'O':'dia',
                  'D':'municipio',
                  'P':'valor',
                  'F':'numeroExpediente'
            ]
        ],
    'defensoriaConclusiones':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'defensor',
                  'B':'puesto',
                  'C':'distrito',
                  'D':'municipio',
                  'E':'conclusionGrupo',
                  'F':'conclusionSubgrupo',
                  'G':'conclusionNombre',
                  'H':'etapaGrupo',
                  'I':'etapaSubgrupo',
                  'J':'etapaNombre',
                  'K':'año',
                  'L':'mes',
                  'M':'dia',                    
                  'P':'valor',
                  'N':'numeroExpediente',
                  'O':'nuc'
            ]
        ],
    'defensoriaCausas': [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'defensor',
                  'B':'puesto',
                  'C':'municipio',
                  'D':'distrito',
                  'E':'año',
                  'F':'mes',
                  'G':'dia',
                  'H':'nuc',
                  'I':'numeroCausa',
                  'J':'impGenero',
                  'K':'impEdad',
                  'L':'impEscolaridad',
                  'M':'impEstadoCivil',
                  'N':'impOcupacion',
                  'Q':'tipoDelito',
                  'R':'tipoDelitoModus',
                  'S':'tipoDelitoModalidad',
                  'O':'tipoDelitoGrupo',
                  'P':'tipoDelitoSubgrupo'
            ]
        ],
    'defensoriaAtenciones': [
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'solicitanteGrupo',
                  'B':'solicitanteSubgrupo',
                  'C':'solicitanteNombre',
                  'D':'año',
                  'E':'mes',
                  'F':'dia',
                  'G':'tipoAtencionGrupo',
                  'H':'tipoAtencionSubgrupo',
                  'I':'tipoAtencionNombre',
                  'J':'distritoJudicial',
                  'K':'municipio',
                  'L':'valor'
            ]
        ],
    'defensoriaAsuntos':[
            sheet:'Hoja1', 
            startRow: 2,
            columnMap:  [
                  'A':'defensor',
                  'B':'puesto',
                  'C':'etapaGrupo',
                  'D':'etapaSubgrupo',
                  'E':'etapaNombre',
                  'F':'nuc',
                  'K':'distrito',
                  'G':'numeroExpediente',
                  'L':'municipio',
                  'H':'año',
                  'I':'mes',
                  'J':'dia',
                  'M':'valor'
            ]
        ]
    ]

    //can also configure injection in resources.groovy
    def getExcelImportService() {
        ExcelImportService.getService()
    }

    public LucasianExcelImporter(fileName, tableName) {
        super(fileName)
        this.tableName = tableName
    }

    List<Map> getRows(startRow = 1) {
        List result
        def conf = excelConfiguration[tableName]        
        if(startRow == 0){
            conf.startRow = 0
        }                
        result = excelImportService.columns(workbook, conf)        
        def pattern = "0"
        def simple = new DecimalFormat(pattern)
        for(int i = 0 ; i< result.size(); i++){
            for(def key: result.get(i).keySet()){                
                if(result.get(i).get(key).getClass().toString().contains("String")) {
                    result.get(i).put(key, result.get(i).get(key).toUpperCase())
                }else if(result.get(i).get(key).getClass().toString().contains("Double")) {
                    result.get(i).put(key,simple.format(result.get(i).get(key)))
                }
            }
        }
        result
    }
}

