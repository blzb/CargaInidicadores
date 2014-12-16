<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'archivosCargados.label', default: 'ArchivosCargados')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
            <div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-18" data-widget-colorbutton="false" data-widget-editbutton="false" role="widget">
                <header role="heading">
                    <h2><strong>Formulario de Creación</strong></h2>				
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
                        <div class="widget-body-toolbar">
                            <div class="row">
                                <div class="col-xs-9 col-sm-5 col-md-5 col-lg-5">
                                    <g:link class="btn btn-success" action="index">
                                        <g:message code="default.list.label" args="[entityName]" />
                                    </g:link>
                                </div>
                                <div class="col-xs-3 col-sm-7 col-md-7 col-lg-7 text-right">
                                </div>
                            </div>
                        </div>
                        
                        <g:form class="smart-form" url="[resource:archivosCargadosInstance, action:'save']" >
                        <header>
                            <g:message code="default.create.label" args="[entityName]" />
                        </header>                        
                        <g:hasErrors bean="${archivosCargadosInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${archivosCargadosInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
                        <fieldset>
                        <g:render template="form"/>
                        </fieldset>
                        <footer>
                            <g:submitButton name="create" class="btn  btn-sm btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
			    <button type="button" class="btn  btn-sm btn-default" onclick="window.history.back();">
				Cancelar
			    </button>
			</footer>
                        </g:form>
                </div>
            </div>  
        </div>				
	</body>
</html>
