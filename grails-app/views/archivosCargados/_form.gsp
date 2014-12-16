<%@ page import="com.lucasian.nsjp.indicadores.ArchivosCargados" %>



<div class="row">
<section class="col col-6">
   <label class="label"><g:message code="archivosCargados.nombre.label" default="Nombre" /> <span class="required-indicator">*</span></label>
   <label class="input ${hasErrors(bean: archivosCargadosInstance, field: 'nombre', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
   <g:textField name="nombre" required="" value="${archivosCargadosInstance?.nombre}"/>

   <b class="tooltip tooltip-top-right">
   <i class="fa fa-warning txt-color-teal"></i> 
   <g:message code="archivosCargados.nombre.tooltip" default="Nombre tooltip" /></b> 
   </label>
</section> 
</div>

<div class="row">
<section class="col col-6">
   <label class="label"><g:message code="archivosCargados.path.label" default="Path" /> <span class="required-indicator">*</span></label>
   <label class="input ${hasErrors(bean: archivosCargadosInstance, field: 'path', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
   <g:textField name="path" required="" value="${archivosCargadosInstance?.path}"/>

   <b class="tooltip tooltip-top-right">
   <i class="fa fa-warning txt-color-teal"></i> 
   <g:message code="archivosCargados.path.tooltip" default="Path tooltip" /></b> 
   </label>
</section> 
</div>

<div class="row">
<section class="col col-6">
   <label class="label"><g:message code="archivosCargados.periodo.label" default="Periodo" /> <span class="required-indicator">*</span></label>
   <label class="input ${hasErrors(bean: archivosCargadosInstance, field: 'periodo', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
   <g:datePicker name="periodo" precision="day"  value="${archivosCargadosInstance?.periodo}"  />

   <b class="tooltip tooltip-top-right">
   <i class="fa fa-warning txt-color-teal"></i> 
   <g:message code="archivosCargados.periodo.tooltip" default="Periodo tooltip" /></b> 
   </label>
</section> 
</div>

<div class="row">
<section class="col col-6">
   <label class="label"><g:message code="archivosCargados.status.label" default="Status" /> <span class="required-indicator">*</span></label>
   <label class="input ${hasErrors(bean: archivosCargadosInstance, field: 'status', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
   <g:textField name="status" required="" value="${archivosCargadosInstance?.status}"/>

   <b class="tooltip tooltip-top-right">
   <i class="fa fa-warning txt-color-teal"></i> 
   <g:message code="archivosCargados.status.tooltip" default="Status tooltip" /></b> 
   </label>
</section> 
</div>

<div class="row">
<section class="col col-6">
   <label class="label"><g:message code="archivosCargados.tabla.label" default="Tabla" /> <span class="required-indicator">*</span></label>
   <label class="input ${hasErrors(bean: archivosCargadosInstance, field: 'tabla', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
   <g:textField name="tabla" required="" value="${archivosCargadosInstance?.tabla}"/>

   <b class="tooltip tooltip-top-right">
   <i class="fa fa-warning txt-color-teal"></i> 
   <g:message code="archivosCargados.tabla.tooltip" default="Tabla tooltip" /></b> 
   </label>
</section> 
</div>

<div class="row">
<section class="col col-6">
   <label class="label"><g:message code="archivosCargados.usuario.label" default="Usuario" /> <span class="required-indicator">*</span></label>
   <label class="input ${hasErrors(bean: archivosCargadosInstance, field: 'usuario', 'state-error')} required"> <i class="icon-append fa fa-question-circle"></i>
   <g:select id="usuario" name="usuario.id" from="${com.lucasian.nsjp.indicadores.ShiroUser.list()}" optionKey="id" required="" value="${archivosCargadosInstance?.usuario?.id}" class="many-to-one"/>

   <b class="tooltip tooltip-top-right">
   <i class="fa fa-warning txt-color-teal"></i> 
   <g:message code="archivosCargados.usuario.tooltip" default="Usuario tooltip" /></b> 
   </label>
</section> 
</div>

