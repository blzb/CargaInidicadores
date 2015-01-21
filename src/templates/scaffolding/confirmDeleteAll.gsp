<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
        <title><g:message code="default.upload.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-18" data-widget-colorbutton="false" data-widget-editbutton="false" role="widget">
            <header role="heading">
                <h2><strong>Confirmacion</strong></h2>				
                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
            <div role="content">
                <div class="jarviswidget-editbox">
                    <input class="form-control" type="text">
                    <span class="note"><i class="fa fa-check text-success"></i> Change title to update and save instantly!</span>
                </div>
                <div class="widget-body no-padding">                                        
                    <div class="widget-body-toolbar">

                    </div>
                    <p>
                        ¿Estas seguro que deseas borrar todos los registros de la tabla?, Si borras estos datos no los veras reflejados en los tableros de control                        
                    </p>
                    <g:form action="confirmDeleteAll">
                        <g:submitButton name="create" class="btn  btn-sm btn-danger" value="\${message(code: 'default.button.delete.confirm.message', default: 'Confirmar')}" />
                        <g:link class="btn  btn-sm btn-default" action="index">Cancelar</g:link>
                    </g:form>
                </div>
            </div>  
        </div>				

    </body>
</html>