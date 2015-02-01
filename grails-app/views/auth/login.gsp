<!DOCTYPE html>
<html lang="en-us">
    <head>
        <meta charset="utf-8">
        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

        <title> Login </title>
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
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'sm artAdmin/css', file: 'smartadmin-skins.css')}">


<!-- SmartAdmin RTL Support is under construction
        <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->

                <!-- We recommend you use "your_style.css" to override SmartAdmin
                     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
                <link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'smartAdmin/css', file: 'demo.css')}">
        <link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'smartAdmin/css', file: 'lockscreen.css')}">

                <!-- FAVICONS -->
        <link rel="shortcut icon" href="${resource(dir: 'smartAdmin/img/favicon', file: 'favicon.ico')}" type="image/x-icon">
        <link rel="icon" href="${resource(dir: 'smartAdmin/img/favicon', file: 'favicon.ico')}" type="image/x-icon">

                <!-- GOOGLE FONT -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">


    </head>
    <body>

        <div id="main" role="main">

                        <!-- MAIN CONTENT -->

            <g:form action="signIn" class="lockscreen animated flipInY" >
                <div class="logo" style="background-color: #296191; text-align: center;">
                    <h1 class="semi-bold"><img src="${resource(dir: 'smartAdmin/img', file: 'logo-o.png')}" alt="" /></h1>
                </div>
                <div>
                    <div>	
                        <g:if test="${flash.message}">
                            <h4 class="alert alert-danger">${flash.message}</h4>
                        </g:if>


                                          <!--h1><i class="fa fa-user fa-3x text-muted air hidden-mobile" style="right: 25px;"></i></h1-->
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </span>
                            <input class="form-control" type="text" name="username" placeholder="Usuario" value="${username}">							
                        </div>
                        <br/>
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-unlock-o"></i>
                            </span>
                            <input class="form-control" type="password" name="password" placeholder="Contraseña">							
                        </div>
                        <!--div class="input-group" style="margin-bottom:12px;width: 250px;">
                            Recordarme: <g:checkBox name="rememberMe" value="${rememberMe}" />
                        </div-->
                        <br/>
                        <input type="submit" value="Entrar" class="btn btn-primary" style="width: 100%;"/>
						<br/>
						<br/>
						<center>
							Powered by <a target="_blank" href="http://www.lucasianmexico.com">Lucasian Labs México</a>
						</center>
                    </div>

                </div>                
            </g:form>

        </div>

                <!--================================================== -->	

                <!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)
                <script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>-->

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

    </body>    
</html>
    <!--
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:form action="signIn">
    <input type="hidden" name="targetUri" value="${targetUri}" />
    <table>
      <tbody>
        <tr>
          <td>Username:</td>
          <td><input type="text" name="username" value="${username}" /></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type="password" name="password" value="" /></td>
        </tr>
        <tr>
          <td>Remember me?:</td>
          <td><g:checkBox name="rememberMe" value="${rememberMe}" /></td>
        </tr>
        <tr>
          <td />
          <td><input type="submit" value="Sign in" /></td>
        </tr>
      </tbody>
    </table>
  </g:form>
    -->
