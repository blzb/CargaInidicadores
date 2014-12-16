<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'shiroUser.label', default: 'ShiroUser')}" />
        <title><g:message code="default.upload.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-18" data-widget-colorbutton="false" data-widget-editbutton="false" role="widget">
            <header role="heading">
                <h2><strong>Subir Formato</strong></h2>				
                <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
            <div role="content">
                <div class="jarviswidget-editbox">
                    <input class="form-control" type="text">
                    <span class="note"><i class="fa fa-check text-success"></i> Change title to update and save instantly!</span>
                </div>
                <div class="widget-body no-padding">
                    <g:if test="${flash.message}">
                        <p class="alert alert-info"> 
                            ${flash.message}
                            <button class="close" data-dismiss="alert">
                                ×
                            </button>

                        </p>
                    </g:if>                       

                    <g:form class="smart-form" url="[action:'saveFile']" enctype="multipart/form-data">
                        <header>
                            Datos del Formato
                        </header>                                                
                        <fieldset>
                            <section>
                                <label class="label">Archivo</label>
                                <div class="input input-file" accept=".xls">
                                    <span class="button"><input  type="file" id="file" name="archivo" onchange="this.parentNode.nextSibling.value = this.value">Buscar</span><input type="text" placeholder="Incluir formato" readonly="">
                                </div>
                            </section>

                            <section>
                                <label class="label">Distrito</label>
                                <label class="input">
                                    <input type="text" class="input-sm" name="distrito">
                                </label>
                            </section>
                            <section>
                                <label class="label">Tipo de Carga</label>
                                <div class="inline-group">
                                    <label class="radio" >
                                        <input type="radio" name="tipoCaptura" value="diaria" checked="checked" >
                                        <i></i>Diaria</label>
                                    <label class="radio">
                                        <input type="radio" name="tipoCaptura" value="semanal">
                                        <i></i>Semanal</label>
                                    <label class="radio">
                                        <input type="radio" name="tipoCaptura" value="mensual">
                                        <i></i>Mensual</label>
                                    
                                </div>
                            </section>
                            <section id="diaria" style="" class="valorTipo">
                                <label class="label">Año / Mes / Dia</label>
                                <label class="input">
                                    <input type="text" class="fechaCombo" id="date" data-format="DD/MM/YYYY" data-template="YYYY / MMMM / DD" name="fechaDias" >
                                </label>
                            </section>
                            <section id="mensual" style="display: none;" class="valorTipo">
                                <label class="label">Año / Mes</label>
                                <label class="input">
                                    <input type="text" class="fechaCombo" id="date" data-format="MM/YYYY" data-template="YYYY / MMMM " name="fechaMeses" >
                                </label>
                            </section>
                            <section id="semanal" style="display: none;" class="valorTipo">
                                <label class="label">Año / Semana</label>
                                <label class="input">
                                    <span class="combodate">
                                    <g:select name="sAño" from="[1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030]" style="width: auto;" class="date-form-control"/>
                                    /
                                    <g:select name="sSemana" from="[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52]" style="width: auto;" class="date-form-control"/>
                                    </span>
                                </label>
                            </section>
                        </fieldset>
                        <footer>
                            <g:submitButton name="create" class="btn  btn-sm btn-primary" value="${message(code: 'default.button.create.label', default: 'Subir')}" />
                            <button type="button" class="btn  btn-sm btn-default" onclick="window.history.back();">
                                Cancelar
                            </button>
                        </footer>
                        <script type="text-javascript">
                        </script>
                    </g:form>
                </div>
            </div>  
        </div>				
    </body>
</html>