package com.lucasian.nsjp.indicadores

import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils

@Transactional
class LogService {
    def sessionFactory
    def getTablas(){
        def roles = ShiroUser.findByUsername(SecurityUtils.subject.principal).roles
        def rolesNames = roles.collect{it.name}
        def tablas = ''
        if(rolesNames.contains('Administrator')){            
            if(rolesNames.size() == 1){            
                tablas = '%'            
            }else{
                rolesNames.each(){
                    if(it != 'Administrator'){
                        switch(it){
                        case 'Procuraduria':
                            tablas = '%procuraduria%'
                            break
                        case 'Tribunales':
                            tablas='%tribunales%'
                            break
                        case 'Seguridad Publica':
                            tablas='%comision%'
                            break
                        case 'Defensoria':
                            tablas = '%defensoria%'
                            break
                        }                                                                
                    }
                }
            }             
        }
        tablas
    }
    def getJobLogs(params) {
        def tablas = getTablas()
        if(tablas == '%'){
            [pentahoJobLogInstanceList:PentahoJobLog.list(params),pentahoJobLogInstanceCount: PentahoJobLog.count()]
        }else{
            def result = PentahoJobLog.findAllByJobnameLike(tablas, params)
                def count = PentahoJobLog.countByJobnameLike(tablas, params)
                [
                    pentahoJobLogInstanceList:result,
                    pentahoJobLogInstanceCount:count
                ]
        }
    }
    def getTransformations(params){
        def tablas = getTablas()
        if(tablas == '%'){
            [pentahoTransformationLogInstanceList:PentahoTransformationLog.list(params),pentahoTransformationLogInstanceCount: PentahoTransformationLog.count()]
        }else{
            def result = PentahoTransformationLog.findAllByTransnameLike(tablas, params)
                def count = PentahoTransformationLog.countByTransnameLike(tablas, params)
                [
                    pentahoTransformationLogInstanceList:result,
                    pentahoTransformationLogInstanceCount:count
                ]
        }
    }
    def getTransformationsForJob(PentahoJobLog jobLog){        
        
        final session = sessionFactory.currentSession

        // Query string with :startId as parameter placeholder.
        final String query = "Select * from pentaho_transformation_log where channel_id in (Select channel_id from pentaho_job_channel_log where root_channel_id = :parent_channel_id and logging_object_type = 'TRANS') order by enddate asc"

        // Create native SQL query.
        final sqlQuery = session.createSQLQuery(query)

        // Use Groovy with() method to invoke multiple methods
        // on the sqlQuery object.
        final results = sqlQuery.with {
            // Set domain class as entity. 
            // Properties in domain class id, name, level will
            // be automatically filled.
            addEntity(PentahoTransformationLog)

            // Set value for parameter startId.
            setString('parent_channel_id', jobLog.channelId)

            // Get all results.
            list()
        }
    }
    def getStepsForTransformation(PentahoTransformationLog transLog){
   
        final session = sessionFactory.currentSession

        // Query string with :startId as parameter placeholder.
        final String query = "Select * from pentaho_step_log where channel_id in ( Select channel_id from pentaho_job_channel_log where parent_channel_id = :parent_channel_id and logging_object_type= 'STEP') and id_batch = :batch_id order by id asc"

        // Create native SQL query.
        final sqlQuery = session.createSQLQuery(query)

        // Use Groovy with() method to invoke multiple methods
        // on the sqlQuery object.
        final results = sqlQuery.with {
            // Set domain class as entity. 
            // Properties in domain class id, name, level will
            // be automatically filled.
            addEntity(PentahoStepLog)

            // Set value for parameter startId.
            setString('parent_channel_id', transLog.channelId)
            setLong('batch_id', transLog.idBatch)

            // Get all results.
            list()
        }        
    }
}
