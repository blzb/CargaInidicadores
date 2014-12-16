<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<div class="panel-group smart-accordion-default" id="accordion-2">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseOne-1" class=""> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Carga de Archivos </a></h4>
        </div>
        <div id="collapseOne-1" class="panel-collapse collapse in" style="height: auto;">
            <div class="panel-body">
                <div class="content">
                    <table bgcolor="">
                        <tbody>
                            <tr>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'demo.png')}"/></td>
                                <td>
                                    <h4>Demostracion</h4>
                                    <p class="">Puedes observar la demostracion sin interactuar</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/carga', file: 'demo.html')}');">Ver</a>
                                </td>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'tutorial.png')}"/></td>
                                <td>
                                    <h4>Tutorial</h4>
                                    <p class="">Interactua con la demostracion siguiendo las indicaciones</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/carga', file: 'tutorial.html')}');">Ver</a>
                                </td>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'practice.png')}"/></td>
                                <td>
                                    <h4>Practica</h4>
                                    <p class="">Interactua con la presentacion por tu cuenta con avisos en caso de error</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/carga', file: 'practice.html')}');">Ver</a>
                                </td>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'test.png')}"/></td>
                                <td>
                                    <h4>Examen</h4>
                                    <p class="">Interactua con la presentacion sin indicaciones y obten una calificacion al final</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/carga', file: 'test.html')}');">Ver</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>                                                                                
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion-2" href="#collapseTwo-1" class="collapsed"> <i class="fa fa-fw fa-plus-circle txt-color-green"></i> <i class="fa fa-fw fa-minus-circle txt-color-red"></i> Cambio de contraseña </a></h4>
        </div>
        <div id="collapseTwo-1" class="panel-collapse collapse" style="height: 0px;">
            <div class="panel-body">
                <div class="content">
                    <table bgcolor="">
                        <tbody>
                            <tr>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'demo.png')}"/></td>
                                <td>
                                    <h4>Demostracion</h4>
                                    <p class="">Puedes observar la demostracion sin interactuar</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/cambioPass', file: 'demo.html')}');">Ver</a>
                                </td>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'tutorial.png')}"/></td>
                                <td>
                                    <h4>Tutorial</h4>
                                    <p class="">Interactua con la demostracion siguiendo las indicaciones</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/cambioPass', file: 'tutorial.html')}');">Ver</a>
                                </td>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'practice.png')}"/></td>
                                <td>
                                    <h4>Practica</h4>
                                    <p class="">Interactua con la presentacion por tu cuenta con avisos en caso de error</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/cambioPass', file: 'practice.html')}');">Ver</a>
                                </td>
                                <td class="small" style="vertical-align: top; padding-right:10px;"><img src = "${resource(dir: 'images', file: 'test.png')}"/></td>
                                <td>
                                    <h4>Examen</h4>
                                    <p class="">Interactua con la presentacion sin indicaciones y obten una calificacion al final</p>
                                    <a class="btn btn-default" href="" onclick = "window.open('${resource(dir: 'presenter/cambioPass', file: 'test.html')}');">Ver</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>                                
            </div>
        </div>
    </div>
</div>    