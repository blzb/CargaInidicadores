
<%@ page import="com.lucasian.nsjp.indicadores.ArchivosCargados" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'archivosCargados.label', default: 'ArchivosCargados')}" />
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
                        <dl class="dl-horizontal">                                                        
                            
				<g:if test="${archivosCargadosInstance?.nombre}">
                                        <dt><g:message code="archivosCargados.nombre.label" default="Nombre" /></dt>					
                                        <dd>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${archivosCargadosInstance}" field="nombre"/></span>
					
                                        </dd>				
				</g:if>
			
				<g:if test="${archivosCargadosInstance?.path}">
                                        <dt><g:message code="archivosCargados.path.label" default="Path" /></dt>					
                                        <dd>
					
						<span class="property-value" aria-labelledby="path-label"><g:fieldValue bean="${archivosCargadosInstance}" field="path"/></span>
					
                                        </dd>				
				</g:if>
			
				<g:if test="${archivosCargadosInstance?.periodo}">
                                        <dt><g:message code="archivosCargados.periodo.label" default="Fecha Carga" /></dt>					
                                        <dd>
					
						<span class="property-value" aria-labelledby="periodo-label"><g:formatDate date="${archivosCargadosInstance?.periodo}" /></span>
					
                                        </dd>				
				</g:if>

                                <g:if test="${archivosCargadosInstance?.lastUpdated}">
                                        <dt><g:message code="archivosCargados.periodo.label" default="Ultima Actualizacion" /></dt>					
                                        <dd>
					
						<span class="property-value" aria-labelledby="periodo-label"><g:formatDate date="${archivosCargadosInstance?.lastUpdated}" /></span>
					
                                        </dd>				
				</g:if>


				<g:if test="${archivosCargadosInstance?.status}">
                                        <dt><g:message code="archivosCargados.status.label" default="Status" /></dt>					
                                        <dd>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${archivosCargadosInstance}" field="status"/></span>
					
                                        </dd>				
				</g:if>
			
				<g:if test="${archivosCargadosInstance?.tabla}">
                                        <dt><g:message code="archivosCargados.tabla.label" default="Tabla" /></dt>					
                                        <dd>
					
						<span class="property-value" aria-labelledby="tabla-label"><g:fieldValue bean="${archivosCargadosInstance}" field="tabla"/></span>
					
                                        </dd>				
				</g:if>
			
				<g:if test="${archivosCargadosInstance?.usuario}">
                                        <dt><g:message code="archivosCargados.usuario.label" default="Usuario" /></dt>					
                                        <dd>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="shiroUser" action="show" id="${archivosCargadosInstance?.usuario?.id}">${archivosCargadosInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
                                        </dd>				
				</g:if>
			                        
                        </dl>                                    
                </div>
            </div>  
        </div>	
	</body>
</html>
