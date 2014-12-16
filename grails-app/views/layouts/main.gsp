<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<!DOCTYPE html>
<html lang="en-us">
    <head>
        <meta charset="utf-8">
        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

        <title>Sistema de Carga de Indicadores</title>
        <meta name="description" content="">
        <meta name="author" content="">

                <!-- Use the correct meta names below for your web application
                         Ref: http://davidbcalhoun.com/2010/viewport-metatag 
                         
                <meta name="HandheldFriendly" content="True">
                <meta name="MobileOptimized" content="320">-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

                <!-- Basic Styles -->                
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'smartAdmin/css', file: 'bootstrap.min.css')}">
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'smartAdmin/css', file: 'font-awesome.min.css')}">

                <!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'smartAdmin/css', file: 'smartadmin-production.css')}">
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'smartAdmin/css', file: 'smartadmin-skins.css')}">


                <!-- SmartAdmin RTL Support is under construction
                <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->

                <!-- We recommend you use "your_style.css" to override SmartAdmin
                     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
                <link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

                <!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'smartAdmin/css', file: 'demo.css')}">

                <!-- FAVICONS -->
        <link rel="shortcut icon" href="${resource(dir: 'smartAdmin/img/favicon', file: 'favicon.ico')}" type="image/x-icon">
        <link rel="icon" href="${resource(dir: 'smartAdmin/img/favicon', file: 'favicon.ico')}" type="image/x-icon">

                <!-- GOOGLE FONT -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">
        <g:layoutHead/>
    <r:layoutResources />

</head>
<body class="">
        <!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->

                <!-- HEADER -->
    <header id="header">
        <div id="logo-group">

                                <!-- PLACE YOUR LOGO HERE -->
            <span id="logo" style="margin-top: 0px;"> <img src="${resource(dir: 'smartAdmin/img', file: 'logo.png')}" alt="SmartAdmin"  style="width: 340px;" > </span>
            <!-- END LOGO PLACEHOLDER -->

                                <!-- Note: The activity badge color changes when clicked and resets the number to 0
                                Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->				
        </div>

                        <!-- projects dropdown -->

<!-- end projects dropdown -->

                        <!-- pulled right: nav area -->
        <shiro:authenticated>
        <div class="pull-right">

                                <!-- collapse menu button -->
            <div id="hide-menu" class="btn-header pull-right">
                <span> <a href="javascript:void(0);" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
            </div>
            <!-- end collapse menu -->

                                <!-- logout button -->
            <div id="logout" class="btn-header transparent pull-right">
                <span>
                    <g:link controller="auth" action="signOut" title="Sign Out">
                        <i class="fa fa-sign-out"></i>
                    </g:link>
                </span>
            </div>
            <!-- end logout button -->

<!-- end multiple lang -->

        </div>
        </shiro:authenticated>
        <!-- end pulled right: nav area -->

    </header>
    <!-- END HEADER -->

                <!-- Left panel : Navigation area -->
                <!-- Note: This width of the aside area can be adjusted through LESS variables -->
    <shiro:authenticated>
    <aside id="left-panel">

                        <!-- User info -->
        <div class="login-info">
            <span>

                <a href="javascript:void(0);" >
                    <span>
                        <shiro:principal/> 
                    </span>

                </a> 

            </span>
        </div>

            <!-- end user info -->

                        <!-- NAVIGATION : This navigation is also responsive

                        To make this navigation dynamic please make sure to link the node
                        (the reference to the nav > ul) after page load. Or the navigation
                        will not initialize.
                        -->
        <nav>
                <!-- NOTE: Notice the gaps after each icon usage <i></i>..
                Please note that these links work a bit different than
                traditional hre="" links. See documentation for details.
                -->

            <ul>
                <li>
                    <a href="#" class="perfil"><i class="fa fa-lg fa-fw fa-user"></i> <span class="menu-item-parent">Perfil</span></a>
                    <ul>
                        <li>
                            <g:link controller="auth" action="changePassword">Cambiar Contraseña</g:link>
                            </li>
                        </ul>
                    </li>
                <li>
                    <a href="#" class="perfil"><i class="fa fa-lg fa-fw fa-question-circle"></i> <span class="menu-item-parent">Ayuda</span></a>
                    <ul>
                        <li>
                            <g:link controller="help" action="tutoriales">Tutoriales</g:link>
                            </li>
                        </ul>
                    </li>                   
                    <shiro:hasRole name="Administrator">
                        <li>
                            <a href="#" class="administracion"><i class="fa fa-lg fa-fw fa-gears "></i> <span class="menu-item-parent">Administracion</span></a>
                            <ul>
                                <li>
                                <g:link controller="tablasExtraidas">Bitacora Carga SIGI</g:link>
                                </li>
                                <li>
                                <g:link controller="archivosCargados">Biracora Carga Manual</g:link>
                                </li>
                                <li>
                                <g:link controller="conexionSIGI">Conexiones a SIGI</g:link>
                                </li>
                                <li>
                                <g:link controller="pentahoJobLog">Bitacora de Jobs</g:link>
                                </li>
                                <li>
                                <g:link controller="pentahoTransformationLog">Bitacora de Transformaciones</g:link>
                                </li>
                                <li>
                                <g:link controller="shiroUser">Usuarios</g:link>
                                </li>
                            </ul>

                    </li>                
                </shiro:hasRole>
                <shiro:hasRole name="Seguridad Publica">
                    <li>
                        <a href="#" class="comision"><i class="fa fa-lg fa-fw fa-shield"></i> <span class="menu-item-parent">Seguridad Publica</span></a>
                        <ul>
                            <shiro:hasPermission permission="comisionActuacionesPoliciales:*">
                                <li>
                                    <a href="#" id="comisionActuacionesPoliciales" class="comisionActuacionesPoliciales">
                                        <span class="menu-item-parent">Actuaciones Policiales</span>
                                    </a>
                                    <ul style="display: none;">
                                        <li class="">
                                            <g:link controller="comisionActuacionesPoliciales" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionActuacionesPoliciales" action="pendientes" >
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionActuacionesPoliciales" action="cargados" >
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>	
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionCustodios:*">
                                    <li>
                                        <a href="#" class="comisionCustodios">
                                            <span class="menu-item-parent">Custodios</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionCustodios" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionCustodios" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionCustodios" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionDetenidos:*">
                                    <li>
                                        <a href="#" class="comisionDetenidos">
                                            <span class="menu-item-parent">Detenidos</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionDetenidos" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionDetenidos" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionDetenidos" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionEvaluacionMedidas:*">
                                    <li>
                                        <a href="#" class="comisionEvaluacionMedidas">
                                            <span class="menu-item-parent">Evaluacion Medidas Cautelares</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionEvaluacionMedidas" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionEvaluacionMedidas" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionEvaluacionMedidas" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionInternos:*">
                                    <li>
                                        <a href="#" class="comisionInternos">
                                            <span class="menu-item-parent">Internos</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionInternos" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionInternos" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionInternos" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionIphs:*">
                                    <li>
                                        <a href="#" class="comisionIphs">
                                            <span class="menu-item-parent">IPHs</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionIphs" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionIphs" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionIphs" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionMedidasCautelares:*">
                                    <li>
                                        <a href="#" class="comisionMedidasCautelares">
                                            <span class="menu-item-parent">Medidas Cautelares</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionMedidasCautelares" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionMedidasCautelares" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionMedidasCautelares" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionPoblacionVulnerable:*">
                                    <li>
                                        <a href="#" class="comisionPoblacionVulnerable">
                                            <span class="menu-item-parent">Poblacion Vulnerable</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionPoblacionVulnerable" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionPoblacionVulnerable" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionPoblacionVulnerable" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionProgramasIndividualizados:*">
                                    <li>
                                        <a href="#" class="comisionProgramasIndividualizados">
                                            <span class="menu-item-parent">Programas Individualizados</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionProgramasIndividualizados" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionProgramasIndividualizados" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionProgramasIndividualizados" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="comisionSupervisionMedidas:*">
                                    <li>
                                        <a href="#" class="comisionSupervisionMedidas">
                                            <span class="menu-item-parent">Supervision de Medias Cautelares</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="comisionSupervisionMedidas" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionSupervisionMedidas" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="comisionSupervisionMedidas" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasRole>
                <shiro:hasRole name="Procuraduria">
                    <li>
                        <a href="#" class="procuraduria"><i class="fa fa-lg fa-fw fa-building"></i> <span class="menu-item-parent">Procuraduria</span></a>
                        <ul>
                            <shiro:hasPermission permission="procuraduriaActoEquivalente:*">
                                    <li>
                                        <a href="#" class="procuraduriaActoEquivalente">
                                            <span class="menu-item-parent" >Acto Equivalente</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaActoEquivalente" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaActoEquivalente" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaActoEquivalente" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaAtencionVictimas:*">
                                    <li>
                                        <a href="#" class="procuraduriaAtencionVictimas">
                                            <span class="menu-item-parent">Atencion a Victimas</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaAtencionVictimas" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaAtencionVictimas" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaAtencionVictimas" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaDelitos:*">
                                    <li>
                                        <a href="#" class="procuraduriaDelitos">
                                            <span class="menu-item-parent">Delitos</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaDelitos" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaDelitos" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaDelitos" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaDetenidos:*">
                                    <li>
                                        <a href="#" class="procuraduriaDetenidos">
                                            <span class="menu-item-parent">Detenidos</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaDetenidos" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaDetenidos" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaDetenidos" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaDeterminaciones:*">
                                    <li>
                                        <a href="#" class="procuraduriaDeterminaciones">
                                            <span class="menu-item-parent">Determinaciones</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaDeterminaciones" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaDeterminaciones" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaDeterminaciones" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaExpediente:*">
                                    <li>
                                        <a href="#" class="procuraduriaExpediente">
                                            <span class="menu-item-parent">Expediente</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaExpediente" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaExpediente" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaExpediente" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaInvestigaciones:*">
                                    <li>
                                        <a href="#" class="procuraduriaInvestigaciones">
                                            <span class="menu-item-parent">Investigaciones</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaInvestigaciones" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaInvestigaciones" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaInvestigaciones" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaJudicializados:*">
                                    <li>
                                        <a href="#" class="procuraduriaJudicializados">
                                            <span class="menu-item-parent">Judicializados</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaJudicializados" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaJudicializados" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaJudicializados" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaJusticiaAlternativa:*">
                                    <li>
                                        <a href="#" class="procuraduriaJusticiaAlternativa">
                                            <span class="menu-item-parent">Justicia Alternativa</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaJusticiaAlternativa" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaJusticiaAlternativa" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaJusticiaAlternativa" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaRecursosInterpuestos:*">
                                    <li>
                                        <a href="#" class="procuraduriaRecursosInterpuestos">
                                            <span class="menu-item-parent">Recursos Interpuestos</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaRecursosInterpuestos" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaRecursosInterpuestos" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaRecursosInterpuestos" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="procuraduriaTiempoAtencion:*">
                                    <li>
                                        <a href="#" class="procuraduriaTiempoAtencion">
                                            <span class="menu-item-parent">Tiempo de Atencion</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="procuraduriaTiempoAtencion" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaTiempoAtencion" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="procuraduriaTiempoAtencion" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasRole>
                <shiro:hasRole name="Tribunales">
                    <li>
                        <a href="#" class="tribunales"><i class="fa fa-lg fa-fw fa-legal"></i> <span class="menu-item-parent">Poder Judicial</span></a>
                        <ul>
                            <shiro:hasPermission permission="tribunalesAmparos:*">
                                    <li>
                                        <a href="#" class="tribunalesAmparos">
                                            <span class="menu-item-parent">Amparos</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesAmparos" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesAmparos" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesAmparos" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesAudiencias:*">
                                    <li>
                                        <a href="#" class="tribunalesAudiencias">
                                            <span class="menu-item-parent">Audiencias</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesAudiencias" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesAudiencias" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesAudiencias" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesAuxilioJudicial:*">
                                    <li>
                                        <a href="#" class="tribunalesAuxilioJudicial">
                                            <span class="menu-item-parent">Auxilio Judicial</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesAuxilioJudicial" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesAuxilioJudicial" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesAuxilioJudicial" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesBeneficios:*">
                                    <li>
                                        <a href="#" class="tribunalesBeneficios">
                                            <span class="menu-item-parent">Beneficios Otorgados</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesBeneficios" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesBeneficios" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesBeneficios" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesCausas:*">
                                    <li>
                                        <a href="#" class="tribunalesCausas">
                                            <span class="menu-item-parent">Causas</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesCausas" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesCausas" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesCausas" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesMedidasCautelares:*">
                                    <li>
                                        <a href="#" class="tribunalesMedidasCautelares">
                                            <span class="menu-item-parent">Medidas Cautelares</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesMedidasCautelares" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesMedidasCautelares" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesMedidasCautelares" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesNotificaciones:*">
                                    <li>
                                        <a href="#" class="tribunalesNotificaciones">
                                            <span class="menu-item-parent">Notificaciones</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesNotificaciones" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesNotificaciones" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesNotificaciones" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesPlazosInvestigacion:*">
                                    <li>
                                        <a href="#" class="tribunalesPlazosInvestigacion">
                                            <span class="menu-item-parent">Plazos de Investigacion</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesPlazosInvestigacion" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesPlazosInvestigacion" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesPlazosInvestigacion" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesSegundaInstancia:*">
                                    <li>
                                        <a href="#" class="tribunalesSegundaInstancia">
                                            <span class="menu-item-parent">Segunda Instancia</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesSegundaInstancia" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesSegundaInstancia" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesSegundaInstancia" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="tribunalesSentencias:*">
                                    <li>
                                        <a href="#" class="tribunalesSentencias">
                                            <span class="menu-item-parent">Sentencias</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="tribunalesSentencias" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesSentencias" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="tribunalesSentencias" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasRole>
                <shiro:hasRole name="Defensoria">
                    <li>
                        <a href="#" class="defensoria"><i class="fa fa-lg fa-fw fa-briefcase"></i> <span class="menu-item-parent">Defensoria Publica</span></a>
                        <ul>
                            <shiro:hasPermission permission="defensoriaAtenciones:*">
                                    <li>
                                        <a href="#" class="defensoriaAtenciones">
                                            <span class="menu-item-parent">Atenciones</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="defensoriaAtenciones" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaAtenciones" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaAtenciones" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="defensoriaAsuntos:*">
                                    <li>
                                        <a href="#" class="defensoriaAsuntos">
                                            <span class="menu-item-parent">Asuntos</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="defensoriaAsuntos" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaAsuntos" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaAsuntos" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="defensoriaCausas:*">
                                    <li>
                                        <a href="#" class="defensoriaCausas">
                                            <span class="menu-item-parent">Causas</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="defensoriaCausas" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaCausas" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaCausas" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="defensoriaConclusiones:*">
                                    <li>
                                        <a href="#" class="defensoriaConclusiones">
                                            <span class="menu-item-parent">Conclusiones</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="defensoriaConclusiones" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaConclusiones" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaConclusiones" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                            <shiro:hasPermission permission="defensoriaGestiones:*">
                                    <li>
                                        <a href="#" class="defensoriaGestiones">
                                            <span class="menu-item-parent">Gestiones</span>
                                        </a>
                                        <ul style="display: none;">
                                            <li class="">
                                            <g:link controller="defensoriaGestiones" action="index">
                                                Datos Existentes
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaGestiones" action="pendientes">
                                                Carga de Archivos
                                            </g:link>                                                    
                                        </li>
                                        <li class="">
                                            <g:link controller="defensoriaGestiones" action="cargados">
                                                Archivos Cargados
                                            </g:link>                                                    
                                        </li>
                                    </ul>
                                </li>
                            </shiro:hasPermission>
                        </ul>
                    </li>		
                </shiro:hasRole>
            </ul>
        </nav>
        <span class="minifyme"> <i class="fa fa-arrow-circle-left hit"></i> </span>

    </aside>
    </shiro:authenticated>
    <!-- END NAVIGATION -->

                <!-- MAIN PANEL -->
    <div id="main" role="main">


                        <!-- MAIN CONTENT -->
        <div id="content">

            <g:layoutBody/>
            <r:layoutResources />
        </div>
        <!-- END MAIN CONTENT -->

    </div>
    <!-- END MAIN PANEL -->

                <!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
                Note: These tiles are completely responsive,
                you can add as many as you like
                -->		
    <div id="shortcut" style="display: none;">
        <ul>
            <li>
                <g:link controller="auth" action="changePassword"  class="jarvismetro-tile big-cubes  bg-color-pinkDark">
                    <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>Cambiar Contraseña</span> </span> 
                </g:link>
            </li>
        </ul>
    </div>            
    <!-- END SHORTCUT AREA -->

                <!--================================================== -->

                <!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
    <script data-pace-options='{ "restartOnRequestAfter": true }' src="${resource(dir: 'smartAdmin/js/plugin/pace', file: 'pace.min.js')}"></script>

                <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script>
        if (!window.jQuery) {
				document.write('<script src="${resource(dir: 'smartAdmin/js/libs/jquery-2.0.2.min.js', file: 'mobile.css')}"><\/script>');
        }
    </script>

    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
    <script>
        if (!window.jQuery.ui) {
				document.write('<script src="${resource(dir: 'smartAdmin/js/libs/', file: 'jquery-ui-1.10.3.min.js')}"><\/script>');
        }
    </script>

                <!-- JS TOUCH : include this plugin for mobile drag / drop touch events
                <script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

                <!-- BOOTSTRAP JS -->
    <script src="${resource(dir: 'smartAdmin/js/bootstrap/', file: 'bootstrap.min.js')}"></script>

                <!-- CUSTOM NOTIFICATION -->
    <script src="${resource(dir: 'smartAdmin/js/notification/', file: 'SmartNotification.min.js')}"></script>

                <!-- JARVIS WIDGETS -->
    <script src="${resource(dir: 'smartAdmin/js/smartwidgets/', file: 'jarvis.widget.min.js')}"></script>

                <!-- EASY PIE CHARTS -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/easy-pie-chart/', file: 'jquery.easy-pie-chart.min.js')}"></script>

                <!-- SPARKLINES -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/sparkline/', file: 'jquery.sparkline.min.js')}"></script>

                <!-- JQUERY VALIDATE -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/jquery-validate/', file: 'jquery.validate.min.js')}"></script>

                <!-- JQUERY MASKED INPUT -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/masked-input/', file: 'jquery.maskedinput.min.js')}"></script>

                <!-- JQUERY SELECT2 INPUT -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/select2/', file: 'select2.min.js')}"></script>

                <!-- JQUERY UI + Bootstrap Slider -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/bootstrap-slider/', file: 'bootstrap-slider.min.js')}"></script>

                <!-- browser msie issue fix -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/msie-fix/', file: 'jquery.mb.browser.min.js')}"></script>

                <!-- FastClick: For mobile devices -->
    <script src="${resource(dir: 'smartAdmin/js/plugin/fastclick/', file: 'fastclick.js')}"></script>

                <!--[if IE 7]>

                <h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

                <![endif]-->

                <!-- Demo purpose only -->
    <script src="${resource(dir: 'smartAdmin/js/', file: 'demo.js')}"></script>

                <!-- MAIN APP JS FILE -->
    <script src="${resource(dir: 'smartAdmin/js/', file: 'app.js')}"></script>

                <!-- PAGE RELATED PLUGIN(S) 
                <script src="..."></script>-->
    <script src="${resource(dir: 'smartAdmin/js/plugin/x-editable/', file: 'moment.min.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/x-editable/', file: 'es.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/x-editable/', file: 'combodate.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/datatables/', file: 'jquery.dataTables-cust.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/datatables/', file: 'ColReorder.min.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/datatables/', file: 'FixedColumns.min.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/datatables/', file: 'ColVis.min.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/datatables/', file: 'ZeroClipboard.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/datatables/', file: 'TableTools.min.js')}"></script>
    <script src="${resource(dir: 'smartAdmin/js/plugin/datatables/', file: 'DT_bootstrap.js')}"></script>


    <script type="text/javascript">

        // DO NOT REMOVE : GLOBAL FUNCTIONS!

        $(document).ready(function() {
        var pagina = '${controllerName}';
        var grupo;
        var menu;
        if(pagina == 'tablasExtraidas' || pagina == 'shiroUser' || pagina=='archivosCargados' || pagina =='conexionSIGI' || pagina == 'pentahoJobLog' || pagina=='pentahoTransformationLog'){
            menu = '.administracion';
        }else if(pagina == 'auth'){
            menu = '.perfil';
        }else{
        if(pagina.indexOf('procuraduria')>-1){
            grupo = 'procuraduria';
        }
        if(pagina.indexOf('comision')>-1){
            grupo = 'comision';
        }
        if(pagina.indexOf('tribunales')>-1){
            grupo = 'tribunales';
        }
        if(pagina.indexOf('defensoria')>-1){
            grupo = 'defensoria';
        }
        menu = '.'+grupo+' ,.'+pagina;
        }
        console.log(menu);
        $(menu).trigger( "click" );
        
        pageSetUp();

        $('.fechaCombo').combodate({customClass:'date-form-control', smartDays: true, maxYear:2030});
        console.log('Setting tipos de captura');
        jQuery('input[name=tipoCaptura]').click(function(){
        jQuery('.valorTipo').hide();
        jQuery('#'+this.value).show();
        });
        jQuery('.dataT').dataTable({
				"sPaginationType" : "bootstrap_full"
			});
        })

    </script>

                <!-- Your GOOGLE ANALYTICS CODE Below -->
    <script type="text/javascript">
        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
        _gaq.push(['_trackPageview']);

        (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
        })();

    </script>

</body>

</html>
