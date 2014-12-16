
<%@ page import="com.lucasian.nsjp.indicadores.PentahoStepLog" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'pentahoStepLog.label', default: 'PentahoStepLog')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-18" data-widget-colorbutton="false" data-widget-editbutton="false" role="widget">
            <header role="heading">
                <h2><strong><g:message code="default.list.label" args="[entityName]" /></strong></h2>				
                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
            <div role="content">
                <div class="jarviswidget-editbox">
                    <input class="form-control" type="text">
                    <span class="note"><i class="fa fa-check text-success"></i> Change title to update and save instantly!</span>
                </div>
                <div class="widget-body no-padding">
                    
                    <div class="widget-body-toolbar">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <ul class="demo-btns">
                                    <li>
                                        <g:link class="btn btn-primary" action="create">                                        
                                            <i class="fa fa-plus"></i> <span class="hidden-mobile"><g:message code="default.new.label" args="[entityName]" /></span>
                                        </g:link>
                                    </li>
                                    <li>
                                        <g:link class="btn btn-primary" action="downloadFormat">                                        
                                            <i class="fa fa-cloud-download"></i> <span class="hidden-mobile"><g:message code="default.file.download" default="Descargar formato" /></span>
                                        </g:link>
                                    </li>
                                    <li>
                                        <g:link class="btn btn-primary" action="upload">                                        
                                            <i class="fa fa-cloud-upload"></i> <span class="hidden-mobile"><g:message code="default.file.upload" default="Subir formato" /></span>
                                        </g:link>
                                    </li>
                                </ul>
                                
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
                    <div class="custom-scroll table-responsive" >
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    
                                        <g:sortableColumn property="transname" title="${message(code: 'pentahoStepLog.transname.label', default: 'Transname')}" />
                                        
                                        <g:sortableColumn property="stepname" title="${message(code: 'pentahoStepLog.stepname.label', default: 'Stepname')}" />
                                        
                                        <g:sortableColumn property="logDate" title="${message(code: 'pentahoStepLog.logDate.label', default: 'Log Date')}" />
                                        
                                        <g:sortableColumn property="linesWritten" title="${message(code: 'pentahoStepLog.linesWritten.label', default: 'Lines Written')}" />
                                        
                                        <g:sortableColumn property="errores" title="${message(code: 'pentahoStepLog.errores.label', default: 'Errores')}" />
                                        
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <g:each in="${pentahoStepLogInstanceList}" status="i" var="pentahoStepLogInstance">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        
                                        <td>${fieldValue(bean: pentahoStepLogInstance, field: "transname")}</td>
                                        
                                        <td>${fieldValue(bean: pentahoStepLogInstance, field: "stepname")}</td>
                                        
                                        <td><g:formatDate date="${pentahoStepLogInstance.logDate}" /></td>
                                        
                                        <td>${fieldValue(bean: pentahoStepLogInstance, field: "linesWritten")}</td>
                                        
                                        <td>${fieldValue(bean: pentahoStepLogInstance, field: "errores")}</td>
                                        
                                        <td>
                                        <g:link action="show" id="${pentahoStepLogInstance.id}" class="btn btn-primary">Detalle</g:link>
                                        </td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>			
                        <luc:paginate total="${pentahoStepLogInstanceCount ?: 0}" />			                        
                    </div>
                </div>
            </div>  
        </div>        
<!--a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a-->
    </body>
</html>
