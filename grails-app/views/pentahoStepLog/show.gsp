
<%@ page import="com.lucasian.nsjp.indicadores.PentahoStepLog" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'pentahoStepLog.label', default: 'PentahoStepLog')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-18" data-widget-colorbutton="false" data-widget-editbutton="false" role="widget">
            <header role="heading">
                <h2><strong><g:message code="default.show.label" args="[entityName]" /></strong></h2>				
                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
            <div role="content">
                <div class="jarviswidget-editbox">
                    <input class="form-control" type="text">
                    <span class="note"><i class="fa fa-check text-success"></i> Change title to update and save instantly!</span>
                </div>
                <div class="widget-body no-padding">                        
                    <div class="widget-body-toolbar">
                        <div class="row">
                            <div class="col-xs-9 col-sm-5 col-md-5 col-lg-5">
                                <button type="btn " class="btn btn-success" onclick="window.history.back();">
                                    Regresar
                                </button>                                        
                            </div>
                        </div>
                    </div>
                    <g:if test="${flash.message}">
                        <p class="alert alert-info"> 
                            ${flash.message}
                            <button class="close" data-dismiss="alert">
                                ×
                            </button>

                        </p>
                    </g:if>
                    <dl class="dl-horizontal">                                                        

                        <dt><g:message code="pentahoStepLog.transname.label" default="Transname" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="transname-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="transname"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.stepname.label" default="Stepname" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="stepname-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="stepname"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.logDate.label" default="Log Date" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="logDate-label"><g:formatDate date="${pentahoStepLogInstance?.logDate}" /></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.linesWritten.label" default="Lines Written" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="linesWritten-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="linesWritten"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.errores.label" default="Errores" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="errores-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="errores"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.channelId.label" default="Channel Id" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="channelId-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="channelId"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.stepCopy.label" default="Step Copy" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="stepCopy-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="stepCopy"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.linesRead.label" default="Lines Read" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="linesRead-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="linesRead"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.linesUpdated.label" default="Lines Updated" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="linesUpdated-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="linesUpdated"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.linesInput.label" default="Lines Input" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="linesInput-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="linesInput"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.linesOutput.label" default="Lines Output" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="linesOutput-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="linesOutput"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.linesRejected.label" default="Lines Rejected" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="linesRejected-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="linesRejected"/></span>

                        </dd>				

                        <dt><g:message code="pentahoStepLog.idBatch.label" default="Id Batch" /></dt>					
                        <dd>

                            <span class="property-value" aria-labelledby="idBatch-label"><g:fieldValue bean="${pentahoStepLogInstance}" field="idBatch"/></span>

                        </dd>				

                    </dl>                                                                            
                </div>
            </div>  
        </div>	
    </body>
</html>
