

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'shiroUser.label', default: 'ShiroUser')}" />
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
                                <div class="col-xs-3 col-sm-7 col-md-7 col-lg-7 text-right">
                                    <g:link class="btn btn-success" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
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
                            
				<g:if test="${shiroUserInstance?.username}">
                                        <dt><g:message code="shiroUser.username.label" default="Usuario" /></dt>					
                                        <dd>
                                            <ul>
						<li><g:fieldValue bean="${shiroUserInstance}" field="username"/></li>
                                            </ul>
                                        </dd>	
                                        <br/>
				</g:if>
				<g:if test="${shiroUserInstance?.roles}">
                                        <dt><g:message code="shiroUser.roles.label" default="Roles" /></dt>					
                                        <dd>
                                            <ul>
						<g:each in="${shiroUserInstance.roles}" var="r">
						<li>${r?.encodeAsHTML()}</li>
						</g:each>
                                            </ul>
                                        </dd>
                                        <br/>
				</g:if>
			
				<g:if test="${shiroUserInstance?.permissions}">
                                        <dt><g:message code="shiroUser.permissions.label" default="Permisos" /></dt>					
                                        <dd>
                                            <ul>
                                            <g:each in="${shiroUserInstance?.permissions}">
                                                <li>${it.replace(":*","")}</li>
                                            </g:each>
                                            </ul>
					
                                        </dd>				
				</g:if>
			
			                        
                        </dl>                                    
                        <div class="widget-footer">
                        <g:form url="[resource:shiroUserInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-default" action="edit" resource="${shiroUserInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                                        
                                        <g:if test="${shiroUserInstance.roles.findAll(){it.name=="Administrator"}.size()==0}">
					<g:actionSubmit class="btn btn-default" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                        </g:if>
				</fieldset>
			</g:form>				
			</div>                    
                </div>
            </div>  
        </div>	
	</body>
</html>
