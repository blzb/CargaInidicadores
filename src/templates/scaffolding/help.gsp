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
                <h2><strong>Propiedades del indicador</strong></h2>				
                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
            <div role="content">
                <div class="jarviswidget-editbox">
                    <input class="form-control" type="text">
                    <span class="note"><i class="fa fa-check text-success"></i> Change title to update and save instantly!</span>
                </div>
                <div class="widget-body no-padding">                                        
                    <div class="widget-body-toolbar">

                    </div>

                    <table class="table table-striped table-bordered table-hover dataT">
                        <thead>
                            <tr>
                                <th>Propiedad</th>
                                <th>Descripcion</th>
                            </tr>                           
                        </thead>
                        <tbody>
                            <g:each in="\${instance.properties}">
                                <tr>
                                    <td>\${message(code:'${domainClass.propertyName}.'+it.key+'.label', defaul:it.key)}</td>
                                    <td>\${message(code:'${domainClass.propertyName}.'+it.key+'.description', default:'description')}</td>                                    
                                </tr>                                
                            </g:each>                            
                        </tbody>
                    </table>

                </div>
            </div>  
        </div>				

    </body>
</html>