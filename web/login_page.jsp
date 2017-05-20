<%--
    Document   : login page, página de login
    Created on : Apr 18, 2017, 10:22:17 AM
    Author     : junior
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"
    import="model.domain.Adm"
    import="model.domain.Usuario"
%>
<!DOCTYPE html>
<html lang="pt-br">

<!--================================================================================
	Item Name: Login screen
	Version: 1.0
	Author: GeeksLabs
        Modified by: Júnior
	Author URL: http://www.themeforest.net/user/geekslabs
================================================================================ -->

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="msapplication-tap-highlight" content="no">
  <meta name="description" content="Página de login do sistema Sonaes UNEB - Universidade do Estado da Bahia. ">
  <meta name="keywords" content="sonaes, uneb">
  <title>Login | Sonaes - Sistema Online de Acompanhamento Estudantil</title>
  <!-- Favicons-->
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
  <link rel="icon" href="images/favicon.ico" type="image/x-icon">
  <!-- CORE CSS-->
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="css/page-center.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="css/login.css" type="text/css" rel="stylesheet" media="screen,projection">
  <!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
  <link href="css/prism.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="js/plugins/perfect-scrollbar/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection">
  <!--ICONS-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body class=" blue lighten-2">
  <!-- Start Page Loading -->
  <div id="loader-wrapper">
      <div id="loader"></div>
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
  </div>
  <% 
    /*Verify if has a user session*/
    if(session.getAttribute("currentSessionUser")!= null){
        Usuario currentUser = (Usuario) (session.getAttribute("currentSessionUser")); 
        if(currentUser != null){
           if(currentUser.getTipo().equals("adm")){
              response.sendRedirect("index_admin.jsp");
           }else if(currentUser.getTipo().equals("coord de curso")){
               response.sendRedirect("index_coord.jsp");
           }else if(currentUser.getTipo().equals("discente")){
               response.sendRedirect("index_disc.jsp");
           }
        }
    } 
  %>
  <!-- End Page Loading -->
  <!--Login FORM-->
  <main id="login-page">
    <div class="col s12 z-depth-4 card-panel">
        <form class="login-form" id="login-form" action="Login" method="post">
            <div class="row">
              <div class="input-field col s12 center">
                <img src="images/logo_sonaes.png" alt="sonaes logo" id="logo-img" height="70">
                <p class="center login-form-text">Sonaes - Sistema Online de Acompanhamento Estudantil</p>
              </div>
            </div>
            <%
               //if has a error messsage to show, show it ;)- like wrong user
               if(request.getAttribute("error_message") != null){%>
               <div class="row">
                   <div class="col s12 center">
                      <p class="center" style="color:#FF5252;font-size:14px;"><%= request.getAttribute("error_message") %></p>
                   </div>
               </div>   
               <%}
            %>
            <!--User input-->
            <div class="row margin">
              <div class="input-field col s10">
                <i class="material-icons prefix">perm_identity</i>
                <input id="user_name" name="user_name" type="text" maxlength="12" autofocus required>
                <label for="user_name">Usuário</label>
              </div>
              <!--Show a validate text below user name input-->
              <div class="col s12 center" style="display:none;" id="user_name_error_div">
                <font size="1" class="error_input" id="user_name_error">nome de usuário curto</font>
              </div>
            </div>
            <!--pass input -->
            <div class="row margin">
              <div class="input-field col s10">
                <i class="material-icons prefix">lock</i>
                <input id="password" name="password" type="password" maxlength="10" required>
                <label for="password">Senha</label>
              </div>
              <!--Show an validate text below user password input-->
              <div class="col s12 center" style="display:none;" id="pass_error_div">
                <font size="1" class="error_input" id="pass_error">digite uma senha válida</font>
              </div>
            </div>

            <div class="row">
              <div class="input-field col s12">
                  <input style="display:none;" name="option" value="login" type="text"></input>
                  <button class="btn waves-effect waves-light col s12  green" type="submit" name="action"><strong>ENTRAR</strong></button>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s9 center">
                  <p class="margin right-align medium-small"><a href="page-forgot-password.html">Esqueceu a senha?</a></p>
              </div>
            </div>
      </form>
    </div>
  </main>
  <!--end form -->

  <!--Footer-->
  <div id="footer">
      <a href="http://www.uneb.br/" ><img class="ft_image" src="images/uneb_logo.png"/></a>
      <a href="http://www.csi.uneb.br/"> <img class="ft_image" src="images/csi_logo.png"/></a>
  </div>

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
  <!--plugins.js - Some Specific JS codes for Plugin Settings-->
  <script type="text/javascript" src="js/plugins.js"></script>
  <!--script to validate fields-->
  <script type="text/javascript" src="js/validate_login.js"></script>
</body>

</html>
