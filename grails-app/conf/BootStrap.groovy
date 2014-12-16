import org.apache.shiro.crypto.hash.Sha256Hash
import com.lucasian.nsjp.indicadores.*
class BootStrap {

    def init = { servletContext ->
//This code is only for demo purposes
        def adminRole = ShiroRole.findByName("Administrator")
        if(!adminRole){
          adminRole = new ShiroRole(name: 'Administrator')
          adminRole.addToPermissions("shiroUser:*")
          adminRole.addToPermissions("archivosCargados:*")
          adminRole.addToPermissions("tablasExtraidas:*")          
          adminRole.addToPermissions('Home:*')
          adminRole.addToPermissions('help:*')
          adminRole.addToPermissions('pentahoTransformationLog:*')
          adminRole.addToPermissions('pentahoStepLog:*')
          adminRole.addToPermissions('pentahoJobEntryLog:*')
          adminRole.addToPermissions('pentahoJobLog:*')
          adminRole.addToPermissions('conexionSIGI:*')
          adminRole.save(failOnError:true)
        }
        def procuraduriaRol =  ShiroRole.findByName("Procuraduria")
        if(!procuraduriaRol){
            procuraduriaRol = new ShiroRole(name: 'Procuraduria')
            procuraduriaRol.addToPermissions('Home:*')
            adminRole.addToPermissions('help:*')
            procuraduriaRol.save(failOnError:true)            
        }
        def tribunalesRol =  ShiroRole.findByName("Tribunales")
        if(!tribunalesRol){
            tribunalesRol = new ShiroRole(name: 'Tribunales')
            tribunalesRol.addToPermissions("Home:*")
            adminRole.addToPermissions('help:*')
            tribunalesRol.save(failOnError:true)            
        }
        def seguridadRol =  ShiroRole.findByName("Seguridad Publica")
        if(!seguridadRol){
            seguridadRol = new ShiroRole(name: 'Seguridad Publica')
            seguridadRol.addToPermissions('Home:*')
            adminRole.addToPermissions('help:*')
            seguridadRol.save(failOnError:true)            
        }
        def defensoriaRol =  ShiroRole.findByName("Defensoria")
        if(!defensoriaRol){
            defensoriaRol = new ShiroRole(name: 'Defensoria')
            defensoriaRol.addToPermissions('Home:*')
            adminRole.addToPermissions('help:*')
            defensoriaRol.save(failOnError:true)            
        }
        def admin = ShiroUser.findByUsername('admin')
        if(!admin){
          def hash = new Sha256Hash("changeit").toHex()
          admin = new ShiroUser(firstName:"Administator",lastName:"User", 
          username: 'admin', email:"me@the.internet")
          admin.passwordHash = hash
          admin.save(failOnError:true)
          adminRole.addToUsers(admin)
          adminRole.save(failOnError:true)
        } 
        def adminProcu = ShiroUser.findByUsername('pgc')
        if(!adminProcu){
          def hash = new Sha256Hash("pgc").toHex()
          adminProcu = new ShiroUser(firstName:"Procuraduria",lastName:"Administrador", 
          username: 'pgc', email:"me@the.internet")
          adminProcu.passwordHash = hash
          adminProcu.save(failOnError:true)
          procuraduriaRol.addToUsers(adminProcu)
          procuraduriaRol.save(failOnError:true)
          adminRole.addToUsers(adminProcu)
          adminRole.save(failOnError:true)
          adminProcu.addToPermissions("procuraduriaActoEquivalente:*")
          adminProcu.addToPermissions("procuraduriaAtencionVictimas:*")
          adminProcu.addToPermissions("procuraduriaDelitos:*")
          adminProcu.addToPermissions("procuraduriaDetenidos:*")
          adminProcu.addToPermissions("procuraduriaDeterminaciones:*")
          adminProcu.addToPermissions("procuraduriaExpediente:*")
          adminProcu.addToPermissions("procuraduriaInvestigaciones:*")
          adminProcu.addToPermissions("procuraduriaJudicializados:*")
          adminProcu.addToPermissions("procuraduriaJusticiaAlternativa:*")
          adminProcu.addToPermissions("procuraduriaRecursosInterpuestos:*")
          adminProcu.addToPermissions("procuraduriaTiempoAtencion:*")
          
        } 
        def adminTrib = ShiroUser.findByUsername('pjc')
        if(!adminTrib){
          def hash = new Sha256Hash("pjc").toHex()
          adminTrib = new ShiroUser(firstName:"Tribunales",lastName:"Administrador", 
          username: 'pjc', email:"me@the.internet")
          adminTrib.passwordHash = hash
          adminTrib.save(failOnError:true)
          tribunalesRol.addToUsers(adminTrib)
          tribunalesRol.save(failOnError:true)
          adminRole.addToUsers(adminTrib)
          adminRole.save(failOnError:true)
          adminTrib.addToPermissions("tribunalesAmparos:*")
          adminTrib.addToPermissions("tribunalesAudiencias:*")
          adminTrib.addToPermissions("tribunalesAuxilioJudicial:*")
          adminTrib.addToPermissions("tribunalesBeneficios:*")
          adminTrib.addToPermissions("tribunalesCausas:*")
          adminTrib.addToPermissions("tribunalesMedidasCautelares:*")
          adminTrib.addToPermissions("tribunalesNotificaciones:*")
          adminTrib.addToPermissions("tribunalesPlazosInvestigacion:*")
          adminTrib.addToPermissions("tribunalesSegundaInstancia:*")
          adminTrib.addToPermissions("tribunalesSentencias:*")                    
        } 
        def adminSeg = ShiroUser.findByUsername('cns')
        if(!adminSeg){
          def hash = new Sha256Hash("cns").toHex()
          adminSeg = new ShiroUser(firstName:"Comision",lastName:"Administrador", 
          username: 'cns', email:"me@the.internet")
          adminSeg.passwordHash = hash
          adminSeg.save(failOnError:true)
          seguridadRol.addToUsers(adminSeg)
          seguridadRol.save(failOnError:true)
          adminRole.addToUsers(adminSeg)
          adminRole.save(failOnError:true)
          adminSeg.addToPermissions("comisionActuacionesPoliciales:*")
          adminSeg.addToPermissions("comisionCustodios:*")
          adminSeg.addToPermissions("comisionDetenidos:*")
          adminSeg.addToPermissions("comisionEvaluacionMedidas:*")
          adminSeg.addToPermissions("comisionInternos:*")
          adminSeg.addToPermissions("comisionIphs:*")
          adminSeg.addToPermissions("comisionMedidasCautelares:*")
          adminSeg.addToPermissions("comisionPoblacionVulnerable:*")
          adminSeg.addToPermissions("comisionProgramasIndividualizados:*")
          adminSeg.addToPermissions("comisionSupervisionMedidas:*")
        } 
        def adminDef = ShiroUser.findByUsername('def')
        if(!adminDef){
          def hash = new Sha256Hash("def").toHex()
          adminDef = new ShiroUser(firstName:"Defensoria",lastName:"Administrador", 
          username: 'def', email:"me@the.internet")
          adminDef.passwordHash = hash
          adminDef.save(failOnError:true)
          defensoriaRol.addToUsers(adminDef)
          defensoriaRol.save(failOnError:true)
          adminRole.addToUsers(adminDef)
          adminRole.save(failOnError:true)
          adminDef.addToPermissions("defensoriaAtenciones:*")
          adminDef.addToPermissions("defensoriaAsuntos:*")
          adminDef.addToPermissions("defensoriaCausas:*")
          adminDef.addToPermissions("defensoriaConclusiones:*")
          adminDef.addToPermissions("defensoriaGestiones:*")
        } 
    }
    def destroy = {
    }
}
