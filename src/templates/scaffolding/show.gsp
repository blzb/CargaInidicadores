<% import grails.persistence.Event %>
<%=packageName%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
<div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-18" data-widget-colorbutton="false" data-widget-editbutton="false" role="widget">
                <header role="heading">
                    <h2><strong><g:message code="default.show.label" args="[entityName]" /></strong></h2>               
                <div class="widget-toolbar" role="menu">
                    <g:link class="btn btn-primary"  action="help">Ayuda</g:link>
                </div>
                    
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
                                <%if(className == "ConexionSIGI" ){ %>
                                <div class="col-xs-3 col-sm-7 col-md-7 col-lg-7 text-right">
                                    <g:link class="btn btn-success" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
                                </div>
                                <%}%>
                            </div>
                        </div>
                        <g:if test="\${flash.message}">
                            <p class="alert alert-info"> 
                                \${flash.message}
                                <button class="close" data-dismiss="alert">
                ×
                </button>
                                
                            </p>
            </g:if>
                        <dl style="padding-left:30px;padding-top:20px;">                                                        
                            <%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
                allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
                props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
                Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                props.each { p -> %>
                                        <dt><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></dt>                    
                                        <dd>
                    <%  if (p.isEnum()) { %>
                        <span class="property-value" aria-labelledby="${p.name}-label"><g:fieldValue bean="\${${propertyName}}" field="${p.name}"/></span>
                    <%  } else if (p.oneToMany || p.manyToMany) { %>
                        <g:each in="\${${propertyName}.${p.name}}" var="${p.name[0]}">
                        <span class="property-value" aria-labelledby="${p.name}-label"><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${${p.name[0]}.id}">\${${p.name[0]}?.encodeAsHTML()}</g:link></span>
                        </g:each>
                    <%  } else if (p.manyToOne || p.oneToOne) { %>
                        <span class="property-value" aria-labelledby="${p.name}-label"><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${${propertyName}?.${p.name}?.id}">\${${propertyName}?.${p.name}?.encodeAsHTML()}</g:link></span>
                    <%  } else if (p.type == Boolean || p.type == boolean) { %>
                        <span class="property-value" aria-labelledby="${p.name}-label"><g:formatBoolean boolean="\${${propertyName}?.${p.name}}" /></span>
                    <%  } else if (p.type == Date || p.type == java.sql.Date || p.type == java.sql.Time || p.type == Calendar) { %>
                        <span class="property-value" aria-labelledby="${p.name}-label"><g:formatDate date="\${${propertyName}?.${p.name}}" /></span>
                    <%  } else if(p.type == Integer){%>
                        <span class="property-value" aria-labelledby="${p.name}-label"><g:formatNumber number="\${${propertyName}?.${p.name}}" format="0" /></span>
                    <%  } else if (!p.type.isArray()) { %>
                        <span class="property-value" aria-labelledby="${p.name}-label"><g:fieldValue bean="\${${propertyName}}" field="${p.name}"/></span>
                    <%  } %>
                                        </dd>               
            <%  } %>                        
                        </dl>                                    
                        <div class="widget-footer">
                        <g:form url="[resource:${propertyName}, action:'delete']" method="DELETE">
                <fieldset class="buttons">
                                        <g:link class="btn btn-default" action="downloadFile" resource="\${${propertyName}}"><g:message code="default.button.download.label" default="Descargar archivo" /></g:link>  
                                        <%if(className == "ConexionSIGI" || className == "TablasExtraidas"){ %>
                                                            <g:link class="btn btn-default" action="edit" resource="\${${propertyName}}"><g:message code="default.button.edit.label" default="Edit" /></g:link>

                                        <%}%>                   
                    <g:actionSubmit class="btn btn-default" action="delete" value="\${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('\${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>               
            </div>                    
                </div>
            </div>  
        </div>  
    </body>
</html>