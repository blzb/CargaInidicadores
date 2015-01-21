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
                <div class="widget-body">                                        
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="alert alert-warning alert-block">
                                <a class="close" data-dismiss="alert" href="#">×</a>
                                <h4 class="alert-heading">Peligro!</h4>
                                Si presiona el boton de Borrar se eliminaran TODOS los datos que contenga la tabla de staging y no se veran reflejados en los tableros de control
                                <p class="text-align-left">
                                    <br>
                                    <g:form action="confirmDeleteAll">
                                        <g:link class="btn btn-default" action="index">Cancelar</g:link>
                                        <g:submitButton name="create" class="btn  btn-danger" value="\${message(code: 'default.button.delete.label', default: 'Borrar')}" />                                        
                                    </g:form>
                                </p>
                            </div>

                        </div>

                    </div>                    
                </div>
            </div>  
        </div>				

    </body>
</html>