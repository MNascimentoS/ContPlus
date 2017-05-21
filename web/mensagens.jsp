<!--
    Document   : mensagens
    Created on : Apr 28, 2017, 21:00:30
    Author     : mateus
-->

<%@page import="java.util.ArrayList"%>
<%@page import="model.domain.Notificacao" %>
<%
    ArrayList<Notificacao> allNotificacao = new Notificacao().getAllFromDatabase();
%>

<!DOCTYPE html>
<html lang="pt-br">
    <body>  
        <aside id="right-sidebar-nav">
            <div class="right hide-on-med-and-down">
                <ul id="chat-out" class="side-nav rightside-navigation">
                    <li class="li-hover">
                        <ul class="chat-collapsible" data-collapsible="expandable">
                            <li>
                                <div class="collapsible-header light-blue white-text active"><i class="material-icons">list</i>Mensagens Recentes</div>
                                <div class="collapsible-body recent-activity">
                                    <%
                                    for (Notificacao notificacao : allNotificacao) {                                           
                                    %>
                                    
                                    <div class="recent-activity-list chat-out-list row">
                                        <div class="col s3 recent-activity-list-icon"><i class="material-icons">error</i></div>
                                        <div class="col s9 recent-activity-list-text">
                                            <a href="#"><%out.print(notificacao.getDaysFromNow());%></a>
                                            <p><%out.print(notificacao.getMensagem());%></p>
                                        </div>
                                    </div>
                                    <%
                                    }
                                    %>
                                </div>
                            </li>
                            <ul class="chat-collapsible">
                                <div class="collapsible-header red white-text"><i class="material-icons">clear</i>
                                     <form method="post" action="EsvaziarNotificacaoServlet">
                                         <button style="background: none!important; color: inherit; border: none" type="submit">Esvaziar</button>
                                     </form>
                                 </div>
                                
                            </ul>
                        </ul>
                    </li>
                </ul>
            </div>
        </aside>
        <!-- END LEFT SIDEBAR NAV-->
        <!-- ================================================
        Scripts
        ================================================ -->
        <!-- chartist -->
        <script type="text/javascript" src="js/plugins/chartist-js/chartist.min.js"></script>
        <!--plugins.js - Some Specific JS codes for Plugin Settings-->
        <script type="text/javascript" src="js/plugins.js"></script>
    </body>
</html>
