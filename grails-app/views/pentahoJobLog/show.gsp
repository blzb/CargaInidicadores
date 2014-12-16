
<%@ page import="com.lucasian.nsjp.indicadores.PentahoJobLog" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'pentahoJobLog.label', default: 'PentahoJobLog')}" />
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
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseOne-1" class=""> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Datos del job </a></h4>
                            </div>
                            <div id="collapseOne-1" class="panel-collapse collapse in" style="height: auto;">
                                <div class="panel-body">
                                    <dl class="dl-horizontal">                                                        

                                        <dt><g:message code="pentahoJobLog.jobname.label" default="Jobname" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="jobname-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="jobname"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.status.label" default="Status" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="status"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.errores.label" default="Errores" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="errores-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="errores"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.startdate.label" default="Startdate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="startdate-label"><g:formatDate date="${pentahoJobLogInstance?.startdate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.enddate.label" default="Enddate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="enddate-label"><g:formatDate date="${pentahoJobLogInstance?.enddate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.channelId.label" default="Channel Id" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="channelId-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="channelId"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.linesRead.label" default="Lines Read" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesRead-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="linesRead"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.linesWritten.label" default="Lines Written" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesWritten-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="linesWritten"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.linesUpdated.label" default="Lines Updated" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesUpdated-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="linesUpdated"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.linesInput.label" default="Lines Input" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesInput-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="linesInput"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.linesOutput.label" default="Lines Output" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesOutput-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="linesOutput"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.linesRejected.label" default="Lines Rejected" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="linesRejected-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="linesRejected"/></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.logdate.label" default="Logdate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="logdate-label"><g:formatDate date="${pentahoJobLogInstance?.logdate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.depdate.label" default="Depdate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="depdate-label"><g:formatDate date="${pentahoJobLogInstance?.depdate}" /></span>

                                        </dd>				

                                        <dt><g:message code="pentahoJobLog.replaydate.label" default="Replaydate" /></dt>					
                                        <dd>

                                            <span class="property-value" aria-labelledby="replaydate-label"><g:formatDate date="${pentahoJobLogInstance?.replaydate}" /></span>

                                        </dd>				

                                    </dl> 
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseTwo-1" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Transformaciones ejecutadas</a></h4>
                            </div>
                            <div id="collapseTwo-1" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Transformacion</th>
                                                <th>Errores</th>
                                                <th># Batch</th>
                                                <th></th>
                                            </tr>                                            
                                        </thead>
                                        <tbody>
                                            <g:each in="${transformations}" status="i" var="transformation">
                                                <tr>
                                                    <td>
                                                        <g:fieldValue bean="${transformation}" field="transname"/>
                                                    </td>
                                                    <td>
                                                        <g:fieldValue bean="${transformation}" field="errores"/>
                                                    </td>
                                                    <td>
                                                        <g:fieldValue bean="${transformation}" field="idBatch"/>
                                                    </td>
                                                    <td>
                                                        <g:link controller="pentahoTransformationLog" action="show" id="${transformation.id}" class="btn btn-primary">Detalle</g:link>
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
                                    <span class="property-value" style="white-space: pre-wrap;" aria-labelledby="logField-label"><g:fieldValue bean="${pentahoJobLogInstance}" field="logField"/></span>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>  
        </div>	
    </body>
</html>
