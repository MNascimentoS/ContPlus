<%--
    Document   : admin page, página do admin
    Created on : Apr 20, 2017, 21:11:39 PM
    Author     : mateus
    Modified on: May 7, 2017 by Junior
--%>

<%@page import="model.domain.Usuario"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"
 import="model.domain.Adm"
 import="model.domain.Usuario"
 import="model.domain.Notificacao"
%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.database.DatabaseMySQL" %>
<%
    ArrayList<Usuario> allUsuario = Usuario.listar();
    int countCoordAcad = 0;
    int countCoordCurso = 0;
    int countSecAcad = 0;
    int countSecCurso = 0;
    for (Usuario user : allUsuario) {
        if (user.getTipo().equals("coord acadêmico")) {
            countCoordAcad++;
        }
        if (user.getTipo().equals("coord de curso")) {
            countCoordCurso++;
        }
        if (user.getTipo().equals("secretario acadêmico")) {
            countSecAcad++;
        }
        if (user.getTipo().equals("secretario de curso")) {
            countSecCurso++;
        }
    }
    
    ArrayList<Notificacao> allNotificacao = new Notificacao().getAllFromDatabase();
%>
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
  <link href="css/navbar.css" type="text/css" rel="stylesheet">
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
      Usuario currentUser = (Adm) (session.getAttribute("currentSessionUser")); 
    %>
    <!-- Start Page Loading -->
    <div id="loader-wrapper">
        <div id="loader"></div>
        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>
    </div>
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

      <!-- //////////////////////////////////////////////////////////////////////////// -->
      <!-- START CONTENT -->
      <section id="content">

        <!--breadcrumbs start-->
        <div id="breadcrumbs-wrapper" class=" grey lighten-3">
          <div class="container">
            <div class="row">
              <div class="col s12 m12 l12">
                <h5 class="breadcrumbs-title">Página Inicial</h5>
                <ol class="breadcrumb">
                    <li><a href="index_admin.jsp">Sonaes</a></li>
                    <li class="active">Home</li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        <!--breadcrumbs end-->
        <!--start container-->
        <div class="container">
          <br>
          <div class="row">
              <div class="col s12 m6 l9">
            <div class="card">
                <div class="card-content green white-text">
                    <p class="card-stats-title"><i class="mdi-social-group-add"></i> Total de Acesso</p>
                    <h4 class="card-stats-number">566</h4>
                    <p class="card-stats-compare"><i class="mdi-hardware-keyboard-arrow-up"></i> 10% <span class="green-text text-lighten-5">da semana passada</span>
                    </p>
                </div>
                <div class="card-action  green darken-2">
                    <div id="clients-bar"></div>
                </div>
            </div>
              </div>
            <div class="col s12 m6 l3">
                    <div class="card"  style="text-align: center">
                        <div class="card-content deep-purple white-text">
                            <p class="card-stats-title"><i class="material-icons">comment</i> Mensagens Recebidas</p>
                            <%
                                int countNot = 0;
                                for (Notificacao notif : allNotificacao) {
                                    countNot++;
                                }
                            %>
                            <h4 class="card-stats-number"><%if (countNot > 50) out.print("+50"); else out.print(countNot);%></h4>
                        </div>
                        <div class="card-action deep-purple darken-2">
                          <div id="clients-bar"><a href="#" data-activates="chat-out" class="waves-effect waves-light chat-collapse">   Chat</a></div>
                      </div>
                    </div>
            </div>
          </div>
              </div>
            <div class="row">
                <div class="col s12 m6 l3">
                  <div class="card" style="text-align: center">
                      <div class="card-content orange white-text">
                            <p><i class="material-icons">person</i> Quantidade de Coordenadores Acadêmicos</p>
                            <h4 class="card-stats-number"><%out.print(countCoordAcad);%></h4>
                      </div>
                      <div class="card-action orange darken-2">
                          <div id="clients-bar"><a href="#"> Detalhes</a></div>
                      </div>
                  </div>
                </div>
                <div class="col s12 m6 l3">
                  <div class="card" style="text-align: center">
                      <div class="card-content blue white-text">
                            <p><i class="material-icons">person</i> Quantidade de Coordenadores de Curso</p>
                            <h4 class="card-stats-number"><%out.print(countCoordCurso);%></h4>
                      </div>
                      <div class="card-action blue darken-2">
                          <div id="clients-bar"><a href="#"> Detalhes</a></div>

                      </div>
                  </div>
                </div>
                <div class="col s12 m6 l3">
                    <div class="card"  style="text-align: center">
                        <div class="card-content red white-text">
                            <p><i class="material-icons">person</i> Quantidade de Secretários de Curso</p>
                            <h4 class="card-stats-number"><%out.print(countSecAcad);%></h4>
                        </div>
                        <div class="card-action red darken-2">
                            <div id="clients-bar"><a href="#"> Detalhes</a></div>
                        </div>
                    </div>
                </div>
                <div class="col s12 m6 l3">
                  <div class="card" style="text-align: center">
                      <div class="card-content blue-grey green white-text">
                            <p><i class="material-icons">person</i> Quantidade de Secretários Acadêmicos</p>
                            <h4 class="card-stats-number"><%out.print(countSecCurso);%></h4>
                      </div>
                      <div class="card-action blue-grey darken-2">
                          <div id="clients-bar"><a href="#"> Detalhes</a></div>

                      </div>
                  </div>
                </div>
            <div class="section">
            <div class="divider"></div>
            <br><br><br>
          </div>
        </div>
        <!--end container-->
      </section>
      <!-- END CONTENT -->

      <!-- //////////////////////////////////////////////////////////////////////////// -->
        <!-- START RIGHT SIDEBAR NAV-->
        <div id="right_menu"></div>
        <!-- LEFT RIGHT SIDEBAR NAV-->

    </div>
    <!-- END WRAPPER -->

  </div>
  <!-- END MAIN -->



  <!-- //////////////////////////////////////////////////////////////////////////// -->

  <!-- START FOOTER -->
  <footer class="page-footer blue">
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
        $("#left_menu").load('menu_admin.jsp #left-sidebar-nav');
        $("#right_menu").load('mensagens.jsp');
        $("#navbar").load('navbar_admin.jsp');
        var params = getURLParams();
        if (params.cad === "true") Materialize.toast('Cadastrado com Sucesso!', 4000);
        else if (params.cad === "false") Materialize.toast('Erro no Cadastro!', 4000);
        if (params.alter === "true") Materialize.toast('Alterado com Sucesso!', 4000);
        else if (params.alter === "false") Materialize.toast('Erro na Alteração!', 4000);
    </script>

</body>

</html>
