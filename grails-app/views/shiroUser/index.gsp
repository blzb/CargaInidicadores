

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'shiroUser.label', default: 'ShiroUser')}" />
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
                    <div class="widget-body-toolbar">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <ul class="demo-btns">
                                    <li>
                                        <g:link class="btn btn-primary" action="create">                                        
                                            <i class="fa fa-plus"></i> <span class="hidden-mobile"><g:message code="default.new.label" args="[entityName]" /></span>
                                        </g:link>
                                    </li>                                    
                                </ul>
                                
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
                    <div class="custom-scroll table-responsive" >
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    
                                        <g:sortableColumn property="username" title="${message(code: 'shiroUser.username.label', default: 'Usuario')}" />
                                        
                                        
                                </tr>
                            </thead>
                            <tbody>
                                <g:each in="${shiroUserInstanceList}" status="i" var="shiroUserInstance">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        
                                        <td><g:link action="show" id="${shiroUserInstance.id}">${fieldValue(bean: shiroUserInstance, field: "username")}</g:link></td>
                                        
                                        
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>			
                        <luc:paginate total="${shiroUserInstanceCount ?: 0}" />			                        
                    </div>
                </div>
            </div>  
        </div>        
<!--a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a-->
    </body>
</html>
