
<%@ page import="com.lucasian.nsjp.indicadores.PentahoTransformationLog" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'pentahoTransformationLog.label', default: 'PentahoTransformationLog')}" />
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
                                    
                                        <g:sortableColumn property="transname" title="${message(code: 'pentahoTransformationLog.transname.label', default: 'Transname')}" />
                                        
                                        <g:sortableColumn property="status" title="${message(code: 'pentahoTransformationLog.status.label', default: 'Status')}" />
                                        
                                        <g:sortableColumn property="startdate" title="${message(code: 'pentahoTransformationLog.startdate.label', default: 'Startdate')}" />
                                        
                                        <g:sortableColumn property="enddate" title="${message(code: 'pentahoTransformationLog.enddate.label', default: 'Enddate')}" />
                                        
                                        <g:sortableColumn property="errores" title="${message(code: 'pentahoTransformationLog.errores.label', default: 'Errores')}" />
                                        
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <g:each in="${pentahoTransformationLogInstanceList}" status="i" var="pentahoTransformationLogInstance">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        
                                        <td>${fieldValue(bean: pentahoTransformationLogInstance, field: "transname")}</td>
                                        
                                        <td>${fieldValue(bean: pentahoTransformationLogInstance, field: "status")}</td>
                                        
                                        <td><g:formatDate date="${pentahoTransformationLogInstance.startdate}" /></td>
                                        
                                        <td><g:formatDate date="${pentahoTransformationLogInstance.enddate}" /></td>
                                        
                                        <td>${fieldValue(bean: pentahoTransformationLogInstance, field: "errores")}</td>
                                        
                                        <td>
                                        <g:link action="show" id="${pentahoTransformationLogInstance.id}" class="btn btn-primary">Detalle</g:link>
                                        </td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>			
                        <luc:paginate total="${pentahoTransformationLogInstanceCount ?: 0}" />			                        
                    </div>
                </div>
            </div>  
        </div>        
<!--a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a-->
    </body>
</html>
