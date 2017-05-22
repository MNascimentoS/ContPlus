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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="msapplication-tap-highlight" content="no">
        <meta name="description" content="Página de administração do sistema Sonaes UNEB - Universidade do Estado da Bahia. ">
        <meta name="keywords" content="sonaes, uneb">
        <title>Home | Sonaes - Sistema Online de Acompanhamento Estudantil</title>
        <!-- Favicons-->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">
        <!-- CORE CSS-->
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
        <link href="css/estilo.css" type="text/css" rel="stylesheet" media="screen,projection">
        <link href="css/datapicker.css" type="text/css" rel="stylesheet" media="screen,projection">
        <!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
        <link href="css/prism.css" type="text/css" rel="stylesheet" media="screen,projection">
        <link href="js/plugins/perfect-scrollbar/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection">
        <link href="js/plugins/chartist-js/chartist.min.css" type="text/css" rel="stylesheet" media="screen,projection">
        <!--ICONS-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body>
        <% 
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
        %>
        <!--Initialize user-->
        <%    
        Usuario currentUser = (Usuario) (session.getAttribute("currentSessionUser")); 
        %>
        <!-- End Page Loading -->
        <!-- START NAVBAR -->
        <div id="navbar"></div>
        <!-- END NAVBAR -->
        <!-- START MAIN -->
        <div id="main">
            <!-- START WRAPPER -->
            <div class="wrapper">
                <!-- START LEFT SIDEBAR NAV-->
                <div id="left_menu"></div>
                <!-- END LEFT SIDEBAR NAV-->
                <!-- START CONTENT -->
                <section id="content">
                    <!--breadcrumbs start-->
                    <div id="breadcrumbs-wrapper" class=" grey lighten-3">
                        <div class="container">
                            <div class="row">
                                <div class="col s12 m12 l12">
                                    <h5 class="breadcrumbs-title">Novo Lançamento</h5>
                                    <ol class="breadcrumb">
                                        <li><a href="index_aux.jsp">Cont+</a></li>
                                        <li class="active">Novo Lançamento</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--breadcrumbs end-->
                    <!--start container-->
                    <div class="container">
                        <br/>
                        <form method="post" action="CadLancamentoServlet">
                            <div class="row">
                                <div class="input-field col s6 m3">
                                    <%ArrayList<Conta> allConta = Conta.getAllFromDatabase();%>
                                    <select id="conta" name="conta" class="browser-default" required>
                                        <option value="default" disabled selected>Conta</option>
                                        <%for (Conta conta : allConta) {
                                            %><option value="<%out.print(conta.getCodigo());%>"><%out.print(conta.getCodigo());%></option><%
                                        }%>
                                    </select>
                                </div>
                                <div class="input-field col s6 m6">
                                    <input id="name" name="name" type="text" class="validate" disabled>
                                </div>
                                <div class="input-field col s12 m3">
                                    <input id="date"  name="date"type="date" class="datepicker" required>
                                    <label for="date">Data</label>
                                </div>
                            </div>  
                            <div class="row">
                                <div class="input-field col s6">
                                    <select name="tipo" class="browser-default" required>
                                        <option value="credito">Crédito</option>
                                        <option value="debito">Débito</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    <input id="valor" name="valor" type="text" class="validate" required>
                                    <label for="valor">Valor</label>
                                </div>
                            </div>  
                            <div class="row">
                                <div class="input-field col s12">
                                    <textarea id="observacao" name="observacao" class="materialize-textarea"></textarea>
                                    <label for="observacao">Observação</label>
                                </div>
                            </div>
                            <!--botão para salvar as alterações-->
                            <div class="row">
                                <div class="col s12">
                                    <button class="btn button waves-effect waves-light grey" type="cancell">
                                    Cancelar
                                    </button>
                                    <button class="btn button waves-effect waves-light teal" type="submit">
                                    Salvar
                                    </button>
                                </div>
                            </div>
                        </form>
                        <div id="search" name="search" style="display: none;"></div>
                        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                    </div>
                    <!--end container-->
                </section>
                <!-- END CONTENT -->
            </div>
            <!-- END WRAPPER -->
        </div>
        <!-- END MAIN -->
        <!-- START FOOTER -->
        <footer class="page-footer teal">
            <div class="footer-copyright">
                <div class="container">
                    <span>Copyright © 2017 <a class="grey-text text-lighten-4" href="http://www.uneb.br/" target="_blank">Uneb</a> Todos os direitos reservados.</span>
                </div>
            </div>
        </footer>
        <!-- END FOOTER -->

        <!-- ================================================
        Scripts
        ================================================ -->

        <!-- jQuery Library -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
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
        <script type="text/javascript">
            $("#left_menu").load('menu_aux.jsp');
            $("#navbar").load('navbar_admin.jsp');
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
