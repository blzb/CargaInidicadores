<% import grails.persistence.Event %>
<%=packageName%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
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
                    <g:if test="\${flash.message}">
                        <p class="alert alert-info"> 
                            \${flash.message}
                            <button class="close" data-dismiss="alert">
                                ×
                            </button>
                        </p>
                    </g:if>
                    <div class="custom-scroll table-responsive" >
                        <table class="table table-bordered">                                                        
                            <tbody>  
                                <g:each in="\${data}" status="i" var="itemList">
                                    <tr>
                                        <g:each in="\${itemList}">    
                                            <g:if test="\${it=="***"}">
                                                <td style="background-color: black;"></td>
                                            </g:if>
                                            <g:else>
                                                <td>
                                                    \${it}
                                                </td>
                                            </g:else>
                                        </g:each>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>			
                    </div>                    
                    <div class="widget-footer">  
                        <button type="button" class="btn btn-default" onclick="window.history.back();">
													Regresar
												</button>
                        <g:link class="btn btn-default" action="downloadFile" id="\${id}"><g:message code="default.button.download.label" default="Descargar archivo" /></g:link> 
                        <g:if test="\${loadable}">
                            <g:link action="cancelFile" class="btn btn-danger" id="\${id}">
                                Rechazar Datos
                            </g:link>
                            <g:link action="loadFile" class="btn btn-success" id="\${id}">
                                Aceptar Datos
                            </g:link>                        
                        </g:if>
                    </div>                   

                </div>
            </div>  
        </div>        
<!--a class="home" href="\${createLink(uri: '/')}"><g:message code="default.home.label"/></a-->
    </body>
</html>
