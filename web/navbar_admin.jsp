<!--
    Document   : navbar_default
    Created on : Apr 28, 2017, 19:26:30
    Author     : mateus
-->
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="css/default_navbar.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <!-- START NAVBAR -->
        <div id="navbar" class="navbar-fixed">
            <nav>
                <div class="nav-wrapper">
                    <h1 class="logo-wrapper"><a class="brand-logo darken-1"><img id="logo" src="images/white_logo.png" alt="ContPlus"></a> <span class="logo-text">SonAEs</span></h1>
                    <ul class="right hide-on-med-and-down">
                        <li><a href="javascript:void(0);" class="waves-effect waves-block waves-light toggle-fullscreen"><i class="material-icons">settings_overscan</i></a>
                        </li>
                        <li>
                            <form action="Login" method="post">
                                 <input style="display:none;" name="option" value="logout" type="text">
                                 <button style="background:none!important; color: inherit; border: none;" class="waves-effect waves-block waves-light" type="submit" name="action"><i class="material-icons">power_settings_new</i></button>
                            </form>
                            <!--<a href="logout.jsp" class="waves-effect waves-block waves-light chat-collapse"></a>-->
                        </li>
                    </ul>

                </div>
            </nav>
        </div>
        <!-- END NAVBAR -->
        <!-- ================================================
        Scripts
        ================================================ -->
        <!--plugins.js - Some Specific JS codes for Plugin Settings-->
        <script type="text/javascript" src="js/plugins.js"></script>
    </body>
</html>
