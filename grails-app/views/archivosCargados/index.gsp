
<%@ page import="com.lucasian.nsjp.indicadores.ArchivosCargados" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'archivosCargados.label', default: 'ArchivosCargados')}" />
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
                                        <g:sortableColumn property="tabla" title="${message(code: 'archivosCargados.tabla.label', default: 'Tabla')}" />
                                        
                                        <g:sortableColumn property="periodo" title="${message(code: 'archivosCargados.periodo.label', default: 'Fecha Carga')}" />
                                        
                                        <g:sortableColumn property="lastUpdated" title="${message(code: 'archivosCargados.periodo.label', default: 'Ultima Actualizacion')}" />
                                        
                                        <g:sortableColumn property="status" title="${message(code: 'archivosCargados.status.label', default: 'Status')}" />
                                        
                                        
                                        
                                    <th><g:message code="archivosCargados.usuario.label" default="Usuario" /></th>
                                        
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <g:each in="${archivosCargadosInstanceList}" status="i" var="archivosCargadosInstance">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        
                                        <td><g:message code="${archivosCargadosInstance.tabla}.label" default="${archivosCargadosInstance.tabla}" /></td>
                                        
                                        <td><g:formatDate date="${archivosCargadosInstance.periodo}" /></td>
                                        <td><g:formatDate date="${archivosCargadosInstance.lastUpdated}" /></td>
                                        
                                        <td>${fieldValue(bean: archivosCargadosInstance, field: "status")}</td>
                                        
                                        
                                        
                                        <td>${fieldValue(bean: archivosCargadosInstance, field: "usuario")}</td>
                                        
                                        <td>
                                        <g:link action="show" id="${archivosCargadosInstance.id}" class="btn btn-primary">Detalle</g:link>
                                        <g:link action="reviewFile" id="${archivosCargadosInstance.id}" class="btn btn-primary">Revisar</g:link>
                                        </td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>			
                        <luc:paginate total="${archivosCargadosInstanceCount ?: 0}" />			                        
                    </div>
                </div>
            </div>  
        </div>        
<!--a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a-->
    </body>
</html>
