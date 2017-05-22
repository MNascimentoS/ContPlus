<%-- 
    Document   : menu_admin
    Created on : May 7, 2017, 2:52:30 PM
    Author     : junior
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"    
 import="model.domain.Usuario"
%>
<!DOCTYPE html>
<html lang="pt-br">
    <body>  
        <!--Initialize user-->
        <% Usuario currentUser = (Usuario) (session.getAttribute("currentSessionUser"));%>
        <aside id="left-sidebar-nav">
            <ul id="slide-out" class="side-nav fixed leftside-navigation">
                <li class="user-details teal">
                    <div class="row">
                        <div class="col col s4 m4 l4">
                            <img src="images/default_user.png" alt="" class="circle responsive-img valign profile-image">
                        </div>
                        <div class="col col s8 m8 l8">
                            <div class=" white-text profile-btn"><%= currentUser.getNome()%></div>
                            <p class="user-roal"><%= currentUser.getTipo()%></p>
                        </div>
                    </div>
                </li>
                <li class="bold"><a href="index_admin.jsp" class="waves-effect waves-cyan"><i class="material-icons">home</i> Home</a></li>
                <li class="bold"><a href="cad_usuario.jsp" class="waves-effect waves-cyan"><i class="material-icons">add</i> Cadastrar Usuarios</a></li>
            </ul>
            <a href="#" data-activates="slide-out" class="sidebar-collapse btn-floating btn-medium waves-effect waves-light hide-on-large-only darken-2 teal"><i class="material-icons" >menu</i></a>
        </aside>
        <!-- END LEFT SIDEBAR NAV-->
        <!-- ================================================
        Scripts
        ================================================ -->
        <!--scrollbar-->
        <script type="text/javascript" src="js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
        <!--plugins.js - Some Specific JS codes for Plugin Settings-->
        <script type="text/javascript" src="js/plugins.js"></script>
    </body>
</html>

