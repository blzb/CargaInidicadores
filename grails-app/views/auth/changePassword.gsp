<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main"/>
        <title>Cambio de password</title>
    </head>
    <body>
        <div class="jarviswidget jarviswidget-sortable" id="wid-id-1" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false" role="widget" style="">
            <header role="heading">
                <span class="widget-icon"> <i class="fa fa-edit"></i> </span>
                <h2>Perfil</h2>

                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>

                                <!-- widget div-->
            <div role="content">

                                        <!-- widget edit box -->
                <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->

                </div>
                <!-- end widget edit box -->

                                        <!-- widget content -->
                <div class="widget-body no-padding">
                        <g:if test="${flash.message}">
                            <p class="alert alert-warning"> 
                                ${flash.message}
                                <button class="close" data-dismiss="alert">
				×
				</button>
                                
                            </p>
			</g:if>
                    <g:form action="saveNewPassword" class="smart-form">
                        <header>
                            Cambio de Password
                        </header>

                        <fieldset>

                            <section>
                                <label class="label">Nueva contraseña</label>
                                <label class="input">
                                    <input type="password" name="newPassword"/>                                    
                                </label>
                            </section>
                            <section>
                                <label class="label">Confirmar nueva contraseña</label>
                                <label class="input">
                                    <input type="password" name="confirmPassword"/>                                    
                                </label>
                            </section>
                        </fieldset>
                        <footer>
                            <button type="submit" class="btn btn-primary">
                                Guardar
                            </button>
                            <g:link uri="/" class="btn btn-default" >
                                Cancelar
                            </g:link>
                        </footer>
                    </g:form>

                </div>
                <!-- end widget content -->

            </div>
            <!-- end widget div -->

        </div>
    </body>
</html>
