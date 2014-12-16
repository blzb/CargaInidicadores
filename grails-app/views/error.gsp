<!DOCTYPE html>
<html>
    <head>
        <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
            <meta name="layout" content="main">
        <g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>
        </head>
        <body>
            <div class="row">

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="text-center error-box">
                            <h1 class="error-text tada animated"><i class="fa fa-times-circle text-danger error-icon-shadow"></i> Error</h1>
                            <h2 class="font-xl"><strong>Ocurrio un error!</strong></h2>
                            <br>
                            <p class="lead semi-bold">
                                <strong>Se ha presentado un error tecnico. Te pedimos una disculpa.</strong><br><br>
                                <small>
                                    Guarda esta pagina y comunicate con tu administrador para informarle del error.
                                </small>
                                <!--
                                	<g:renderException exception="${exception}" />
                                -->
                            </p>
                        </div>

                    </div>

                </div>

            </div>

        </div>		
    </body>
</html>
