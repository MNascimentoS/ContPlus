<%--
    Document   : admin page, página do admin
    Created on : Apr 20, 2017, 21:11:39 PM
    Author     : mateus
    Modified on: May 7, 2017 by Junior
--%>

<%@page import="model.domain.Conta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.domain.Usuario"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"
 import="model.domain.Usuario"
%>

<%@page import="model.database.DatabaseMySQL" %>
<!DOCTYPE html>
<html lang="pt-br">
<!--================================================================================
	Item Name: Home Screen
	Version: 1.0
	Author: GeeksLabs
        Modified by: Mateus Nascimento
	Author URL: http://www.themeforest.net/user/geekslabs
================================================================================ -->

    <head>
        <!-- CORE CSS-->
    </head>

    <body>
        <% 
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
        %>
        <!-- START CONTENT -->
        <section id="content">
            <!--breadcrumbs start-->
            <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                <div class="container">
                    <div class="row">
                        <div class="col s12 m12 l12">
                            <h5 class="breadcrumbs-title">Gerar Balanço Patrimonial</h5>
                            <ol class="breadcrumb">
                                <li><a href="index_aux.jsp">Cont+</a></li>
                                <li class="active">Balanço Patrimonial</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <!--breadcrumbs end-->
            <!--start container-->
            <div class="container">
                <br/>
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="dateI"  name="dateI" type="date" class="datepicker" required>
                            <label for="dateI">Data Inicial</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="dateF"  name="dateF" type="date" class="datepicker" required>
                            <label for="dateF">Data Final</label>
                        </div>
                    </div>  
                    <br/>
                    <!--botão para salvar as alterações-->
                    <div class="row">
                        <div class="col s12">
                            <button class="btn button waves-effect waves-light grey" type="cancell">
                                Cancelar
                            </button>
                            <button id="submit" class="btn button waves-effect waves-light teal" type="submit" onclick="gerarBalanco()">
                                Gerar
                            </button>
                        </div>
                    </div>
                <br/>
                <div id="balanco-div" class="center" style="display: none;" >
                    <div id="balanco" class="card small" style="margin: auto; width: 760px; height: auto; padding: 5px;">
                        <br/><br/>
                        <div class="preloader-wrapper big active">
                            <div class="spinner-layer spinner-green-only">
                                <div class="circle-clipper left">
                                    <div     class="circle"></div>
                                </div>
                                <div class="gap-patch">
                                    <div class="circle"></div>
                                </div>
                                <div class="circle-clipper right">
                                    <div class="circle"></div>
                                </div>
                            </div>
                        </div>
                        <br/><br/>
                    </div>
                    <br/>
                    <button onclick="gerarPDF()" class="btn button waves-effect waves-light teal" type="submit">
                        Imprimir
                    </button>
                </div>
            </div>
            <!--end container-->
        </section>
        <!-- END CONTENT -->

        <!-- ================================================
        Scripts
        ================================================ -->

        <!-- jQuery Library -->
        <script type="text/javascript" src="js/jquery-2.1.1.js"></script>
        <!--materialize js-->
        <script type="text/javascript" src="js/materialize.js"></script>
        <!--prism-->
        <script type="text/javascript" src="js/prism.js"></script>
        <!--scrollbar-->
        <script type="text/javascript" src="js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
        <!-- chartist -->
        <script type="text/javascript" src="js/plugins/chartist-js/chartist.min.js"></script>

        <!--plugins.js - Some Specific JS codes for Plugin Settings-->
        <script type="text/javascript" src="js/plugins.js"></script>
        <script type="text/javascript" src="js/padrao.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js"></script>
        <script type="text/javascript" src="js/html2canvas.js"></script>
        <script type="text/javascript" src="js/balanco.js"></script>
        <script type="text/javascript">
            $('.datepicker').pickadate({
                selectMonths: true, 
                selectYears: 15,
                labelMonthNext: 'Próximo mês',
                labelMonthPrev: 'Mês Anterior',
                labelMonthSelect: 'Selecione um mês',
                labelYearSelect: 'Selecione um ano',
                monthsFull: [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
                monthsShort: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
                weekdaysFull: [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabado' ],
                weekdaysShort: [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
                weekdaysLetter: [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
                today: 'Hoje',
                clear: 'Limpar',
                close: 'Fechar'
            });
            $('#conta').on('change', function (e) {
                var optionSelected = $("option:selected", this);
                var labelSelected = optionSelected.text();
                $("#search").load("search.jsp?find=conta&conta=" + labelSelected);
                var nomeInput = document.getElementById("name");  

                setTimeout(function(){
                    var name = $("#search")["0"].firstElementChild.name;
                    nomeInput.value = name;
                }, 500);
            });
        </script>

    </body>

</html>
