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
                <div class="widget-toolbar" role="menu">
                    <g:link class="btn btn-primary"  action="help"><i class="fa fa-question-circle"></i>Ayuda</g:link>
                </div>
                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
            <div role="content">
                <div class="jarviswidget-editbox">
                    <input class="form-control" type="text">
                    <span class="note"><i class="fa fa-check text-success"></i> Change title to update and save instantly!</span>
                </div>
                <div class="widget-body no-padding">
                    <%if(className != "ArchivosCargados" && className != "TablasExtraidas" ){ %>
                    <div class="widget-body-toolbar">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <ul class="demo-btns">
                                    <%if(className == "ConexionSIGI" ){ %>
                                    <li>
                                        <g:link class="btn btn-primary" action="create">                                        
                                            <i class="fa fa-plus"></i> <span class="hidden-mobile"><g:message code="default.new.label" args="[entityName]" /></span>
                                        </g:link>
                                    </li>
                                    <%}%>
                                    <li>
                                        <g:link class="btn btn-primary" action="downloadFormat">                                        
                                            <i class="fa fa-cloud-download"></i> <span class="hidden-mobile"><g:message code="default.file.download" default="Descargar formato" /></span>
                                        </g:link>
                                    </li>
                                    <li>
                                        <g:link class="btn btn-primary" action="upload">                                        
                                            <i class="fa fa-cloud-upload"></i> <span class="hidden-mobile"><g:message code="default.file.upload" default="Subir formato" /></span>
                                        </g:link>
                                    </li>
                                    <li>
                                        <g:link class="btn btn-danger" action="deleteAll">                                        
                                            <i class="fa fa-trash-o"></i> <span class="hidden-mobile"><g:message code="default.button.delete.label" default="Borrar" /> Todo</span>
                                        </g:link>
                                    </li>
                                </ul>
                                
                            </div>
                        </div>
                    </div>
                    <%} %>
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
                            <thead>
                                <tr>
                                    <%  excludedProps = Event.allEvents.toList() << 'id' << 'version'<<'path'
allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && it.type != null && !Collection.isAssignableFrom(it.type) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
props.eachWithIndex { p, i ->
    if (i < 5) {
        if (p.isAssociation()) { %>
                                    <th><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></th>
                                        <%      } else { %>
                                        <g:sortableColumn property="${p.name}" title="\${message(code: '${domainClass.propertyName}.${p.name}.label', default: '${p.naturalName}')}" />
                                        <%  }   }   } %>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <g:each in="\${${propertyName}List}" status="i" var="${propertyName}">
                                    <tr class="\${(i % 2) == 0 ? 'even' : 'odd'}">
                                        <%  props.eachWithIndex { p, i ->
                                        if (i < 5) {
                                            if (p.type == Boolean || p.type == boolean) { %>
                                        <td><g:formatBoolean boolean="\${${propertyName}.${p.name}}" /></td>
                                        <%          } else if (p.type == Date || p.type == java.sql.Date || p.type == java.sql.Time || p.type == Calendar) { %>
                                        <td><g:formatDate date="\${${propertyName}.${p.name}}" /></td>
                                        <%         }else if(p.type == java.lang.Integer){%>
                                        <td><g:formatNumber number="\${${propertyName}.${p.name}}" format="0"/></td>
                                        <%          } else { %>
                                        <td>\${fieldValue(bean: ${propertyName}, field: "${p.name}")}</td>
                                        <%  }   }   } %>
                                        <td>
                                        <g:link action="show" id="\${${propertyName}.id}" class="btn btn-primary">Detalle</g:link>
                                        </td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>            
                        <luc:paginate total="\${${propertyName}Count ?: 0}" />                                  
                    </div>
                </div>
            </div>  
        </div>        
<!--a class="home" href="\${createLink(uri: '/')}"><g:message code="default.home.label"/></a-->
    </body>
</html>