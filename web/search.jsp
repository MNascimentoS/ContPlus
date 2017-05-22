<%@page import="model.domain.Historico"%>
<%@page import="model.domain.Historico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.domain.Conta"%>
<%@page import="model.database.DatabaseMySQL" %>
<!DOCTYPE html>
<%
   String find = request.getParameter("find"); 
   Conta conta = null;
   String dataI, dataF;
   dataI = dataF = "";
   if (find.equals("conta")) {
        conta = new Conta();
        String codigo = request.getParameter("conta"); 
        conta.setCodigo(codigo);
        conta.fillFromDatabase();
   } else if (find.equals("balanco")) {
        dataI = request.getParameter("dataI"); 
        dataF = request.getParameter("dataF"); 
   }
%>
<html lang="pt-br">

    <body>
        <%if (find.equals("conta")) { %>
            <input id="<%out.print(conta.getCodigo());%>" name="<%out.print(conta.getNome());%>">
        <%} else if (find.equals("balanco")/* && !dataI.equals("") && !dataF.equals("")*/) { %>
        <%
                ArrayList<Historico> allHistorico = Historico.getAllFromDatabase(); 
                
        %>
                <div class="tg-wrap"><table class="tg" style="table-layout: fixed; width: 750px">
                    <colgroup>
                        <col style="width: 250px">
                        <col style="width: 125px">
                        <col style="width: 250px">
                        <col style="width: 125px">
                    </colgroup>
                    <tr>
                        <th class="tg-4m1c" colspan="4">Balanço Patrimonial</th>
                    </tr>
                    <tr>
                        <td class="tg-jqao" colspan="2">Ativo</td>
                        <td class="tg-jqao" colspan="2">Passivo</td>
                    </tr>
                    <%for (int i = 0; i < allHistorico.size(); i++) {%>
                    <tr>
                                
                        <td class="tg-z5sk"><%out.print(allHistorico.get(i).getConta_codigo());%></td>
                        <td class="tg-z5sk"><%out.print(allHistorico.get(i).getValor());%></td>
                                
                            <%for (int j = i; j < allHistorico.size(); j++) {%>
                                <%if (allHistorico.get(j).isPassivo() && !allHistorico.get(j).wasShowerd()) {%>
                                    <%allHistorico.get(j).setShowed(true);%>
                                    <td class="tg-z5sk"><%out.print(allHistorico.get(j).getConta_codigo());%></td>
                                    <td class="tg-z5sk"><%out.print(allHistorico.get(j).getValor());%></td>
                                <%}%>
                            <%}%>
                            
                        
                    </tr>
                    <%}%>
                    <tr>
                        <td class="tg-jqao">Total Ativo</td>
                        <td class="tg-8sld">1000</td>
                        <td class="tg-jqao">Total Passivo</td>
                        <td class="tg-8sld">1000</td>
                    </tr>
                </table>
            </div>
                    
        <%}%>
    </body>

</html>
