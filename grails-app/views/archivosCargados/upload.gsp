<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'archivosCargados.label', default: 'ArchivosCargados')}" />
        <title><g:message code="default.upload.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-18" data-widget-colorbutton="false" data-widget-editbutton="false" role="widget">
            <header role="heading">
                <h2><strong>Subir Formato</strong></h2>				
                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
            <div role="content">
                <div class="jarviswidget-editbox">
                    <input class="form-control" type="text">
                    <span class="note"><i class="fa fa-check text-success"></i> Change title to update and save instantly!</span>
                </div>
                <div class="widget-body no-padding">
                    <g:if test="${flash.message}">
                        <p class="alert alert-warning"> 
                            ${flash.message}
                            <button class="close" data-dismiss="alert">
                                ×
                            </button>

                        </p>
                    </g:if>                       

                    <g:form class="smart-form" url="[action:'saveFile']" enctype="multipart/form-data">
                        <header>
                            Datos del Formato
                        </header>                                                
                        <fieldset>
                            <section>
                                <label class="label">Archivo</label>
                                <div class="input input-file" accept=".xls">
                                    <span class="button"><input  type="file" id="file" name="archivo" onchange="this.parentNode.nextSibling.value = this.value">Buscar</span><input type="text" placeholder="Incluir formato" readonly="">
                                </div>
                            </section>
                        </fieldset>
                        <footer>
                            <g:submitButton name="create" class="btn  btn-sm btn-primary" value="${message(code: 'default.button.create.label', default: 'Subir')}" />
                            <button type="button" class="btn  btn-sm btn-default" onclick="window.history.back();">
                                Cancelar
                            </button>
                        </footer>
                        <script type="text-javascript">
                        </script>
                    </g:form>
                </div>
            </div>  
        </div>				
    </body>
</html>