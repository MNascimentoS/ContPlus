<%--
    Document   : login page, página de login
    Created on : May 20, 2017, 20:22:17 PM
    Author     : junior
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"
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
  <meta name="description" content="Página de login do sistema ContPlus">
  <meta name="keywords" content="sonaes, uneb">
  <title>Login | ContPlus - A Contabilidade do seu jeito!</title>
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

<body class=" white">
  <!-- Start Page Loading -->
  <div id="loader-wrapper">
      <div id="loader"></div>
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
  </div>
  <!-- End Page Loading -->
  <!--Login FORM-->
  <main id="login-page">
    <div class="col s12 z-depth-4 card-panel">
        <form class="login-form" id="login-form" action="Login" method="post">
            <div class="row">
              <div class="input-field col s12 center">
                <img src="images/logo.png" alt="sonaes logo" id="logo-img" height="70">
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
                <input id="user_name" name="user_name" type="email" maxlength="254" autofocus required>
                <label for="user_name">E-mail</label>
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
  <!--plugins.js - Some Specific JS codes for Plugin Settings-->
  <script type="text/javascript" src="js/plugins.js"></script>
  <!--script to validate fields-->
  <script type="text/javascript" src="js/validate_login.js"></script>
</body>

</html>
