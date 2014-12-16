



<section>
    <label class="label"><g:message code="shiroUser.username.label" default="Usuario" /> <span class="required-indicator">*</span></label>
    <label class="input ${hasErrors(bean: shiroUserInstance, field: 'username', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
        <g:textField name="username" required="" value="${shiroUserInstance?.username}"/>

        <b class="tooltip tooltip-top-right">
            <i class="fa fa-warning txt-color-teal"></i> 
            <g:message code="shiroUser.username.tooltip" default="Username tooltip" /></b> 
    </label>
</section>    

<section>
    <label class="label"><g:message code="shiroUser.passwordHash.label" default="Contraseña" /> <span class="required-indicator">*</span></label>
    <label class="input ${hasErrors(bean: shiroUserInstance, field: 'passwordHash', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
        <g:passwordField name="password" value=""/>

        <b class="tooltip tooltip-top-right">
            <i class="fa fa-warning txt-color-teal"></i> 
            <g:message code="shiroUser.passwordHash.tooltip" default="Password Hash tooltip" /></b> 
    </label>
</section>    

<section>
    <label class="label"><g:message code="shiroUser.passwordHash.label" default="confirmar Contraseña" /> <span class="required-indicator">*</span></label>
    <label class="input ${hasErrors(bean: shiroUserInstance, field: 'passwordHash', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
        <g:passwordField name="passwordConfirm"  value=""/>

        <b class="tooltip tooltip-top-right">
            <i class="fa fa-warning txt-color-teal"></i> 
            <g:message code="shiroUser.passwordHash.tooltip" default="Password Hash tooltip" /></b> 
    </label>
</section>
       
<g:each in="${permission}" var="rolePermission">
<section>
    <label class="label">${rolePermission.key}</label>
    <div class="inline-group">
        <g:each in="${rolePermission.value}" var="perm">            
        <label class="checkbox">
            <g:if test="${asignedPermission?.contains(perm.value)}">
            <input type="checkbox" name="permisos" value="${perm.value}" checked="checked">
            <i></i>${perm.key}</label>              
            </g:if>
            <g:else>
            <input type="checkbox" name="permisos" value="${perm.value}" >
            <i></i>${perm.key}</label>                              
            </g:else>
        </g:each>
    </div>
</section>            
</g:each>
      


