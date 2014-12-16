
<%@ page import="com.lucasian.nsjp.indicadores.PentahoTransformationLog" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'pentahoTransformationLog.label', default: 'PentahoTransformationLog')}" />
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
                                <g:link class="btn btn-success" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link>                                
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
                    <div class="panel-group smart-accordion-default" id="accordion-2">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseOne-1" class=""> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Datos de la transformacion </a></h4>
                            </div>
                            <div id="collapseOne-1" class="panel-collapse collapse in" style="height: auto;">
                                <div class="panel-body">
                                    <dl class="dl-horizontal">                                                        

                                        <dt><g:message code="pentahoTransformationLog.transname.label" default="Transname" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="transname-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="transname"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.status.label" default="Status" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="status"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.startdate.label" default="Startdate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="startdate-label"><g:formatDate date="${pentahoTransformationLogInstance?.startdate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.enddate.label" default="Enddate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="enddate-label"><g:formatDate date="${pentahoTransformationLogInstance?.enddate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.errores.label" default="Errores" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="errores-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="errores"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.channelId.label" default="Channel Id" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="channelId-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="channelId"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.linesRead.label" default="Lines Read" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesRead-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="linesRead"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.linesWritten.label" default="Lines Written" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesWritten-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="linesWritten"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.linesUpdated.label" default="Lines Updated" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesUpdated-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="linesUpdated"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.linesInput.label" default="Lines Input" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesInput-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="linesInput"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.linesOutput.label" default="Lines Output" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesOutput-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="linesOutput"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.linesRejected.label" default="Lines Rejected" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesRejected-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="linesRejected"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.logdate.label" default="Logdate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="logdate-label"><g:formatDate date="${pentahoTransformationLogInstance?.logdate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.depdate.label" default="Depdate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="depdate-label"><g:formatDate date="${pentahoTransformationLogInstance?.depdate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoTransformationLog.replaydate.label" default="Replaydate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="replaydate-label"><g:formatDate date="${pentahoTransformationLogInstance?.replaydate}" /></span>

                                        </dd>				

                                    </dl>                                    
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseTwo-1" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Pasos ejecutados</a></h4>
                            </div>
                            <div id="collapseTwo-1" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Transformacion</th>
                                                <th>Errores</th>
                                                <th># Lineas Leidas</th>
                                                <th># Lineas Escritas</th>
                                                <th></th>
                                            </tr>                                            
                                        </thead>
                                        <tbody>
                                            <g:each in="${steps}" status="i" var="step">
                                                <tr>
                                                    <td>
                                                        <g:fieldValue bean="${step}" field="stepname"/>
                                                    </td>
                                                    <td>
                                                        <g:fieldValue bean="${step}" field="errores"/>
                                                    </td>
                                                    <td>
                                                        <g:fieldValue bean="${step}" field="linesRead"/>
                                                    </td>
                                                    <td>
                                                        <g:fieldValue bean="${step}" field="linesWritten"/>
                                                    </td>
                                                    <td>
                                                        <g:link controller="pentahoStepLog" action="show" id="${step.id}" class="btn btn-primary">Detalle</g:link>
                                                        </td>
                                                    </tr>
                                            </g:each>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseThree-1" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Log de ejecucion </a></h4>
                            </div>
                            <div id="collapseThree-1" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <span class="property-value" style="white-space: pre-wrap;" aria-labelledby="logField-label"><g:fieldValue bean="${pentahoTransformationLogInstance}" field="logField"/></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>  
            </div>	
    </body>
</html>
