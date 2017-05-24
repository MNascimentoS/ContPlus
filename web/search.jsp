<%@page import="util.Utils"%>
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
        <%} else if (find.equals("balanco") && !dataI.equals("") && !dataF.equals("")) { %>
        <%
                dataI = Utils.getData(dataI);
                dataF = Utils.getData(dataF);
                ArrayList<Historico> allHistorico = Historico.getAllFromDatabase(dataI, dataF); 
                String lastCodigo = "";
        %>
            <style type="text/css">
                .tg  {border-collapse:collapse;border-spacing:0;}
                .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;}
                .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-top-width:1px;border-bottom-width:1px;}
                .tg .tg-8sld{background-color:#26a69a;color:#ffffff;text-align:center;vertical-align:top}
                .tg .tg-hhim{font-size:13px;background-color:#26a69a;color:#ffffff;vertical-align:top}
                .tg .tg-4m1c{font-weight:bold;font-size:16px;background-color:#00695c;color:#ffffff;text-align:center;vertical-align:top}
                .tg .tg-jqao{font-weight:bold;font-size:16px;background-color:#26a69a;color:#ffffff;text-align:center;vertical-align:top}
                .tg .tg-z5sk{font-size:13px;background-color:#26a69a;color:#ffffff;text-align:center;vertical-align:top}
                .tg .tg-yw4l{vertical-align:top}
                @media screen and (max-width: 767px) {.tg {width: auto !important;}.tg col {width: auto !important;}.tg-wrap {overflow-x: auto;-webkit-overflow-scrolling: touch;}}
            </style>

            <div class="tg-wrap"><table class="tg" style="table-layout: fixed; width: 750px">
                <colgroup>
                <col style="width: 250px">
                <col style="width: 100px">
                <col style="width: 200px">
                <col style="width: 200px">
                </colgroup>
                <tr>
                    <th class="tg-4m1c" colspan="4">Balanço Patrimonial <%out.print("  " + dataI + " - " + dataF);%></th>
                </tr>
                <tr>
                    <td class="tg-jqao" colspan="2">Ativo</td>
                    <td class="tg-jqao">Débito</td>
                    <td class="tg-jqao">Crédito</td>
                </tr>
                <%
                    int valorA, valorP;
                    valorA = valorP = 0;
                %>
                <%for (Historico historico : allHistorico) {%>
                    <%if (historico.isAtivo()) {%>
                    <%
                        String codigoConta = historico.getConta_codigo();
                        String codigo = codigoConta.substring(0, Math.min(3,codigoConta.length()));
                        if (!lastCodigo.equals(codigo)) {
                            conta = new Conta();
                            conta.setCodigo(codigo);
                            conta.fillFromDatabase();
                    %>
                            <tr>
                            <td class="tg-z5sk" colspan="2"><%out.print(conta.getNome());%></td>
                            <td class="tg-z5sk"></td>
                            <td class="tg-z5sk"></td>
                            </tr>
                    <%
                            lastCodigo = codigo;
                        }
                        conta.setCodigo(codigoConta);
                        conta.fillFromDatabase();
                    %>
                    <tr>
                        <td class="tg-hhim" colspan="2"><%out.print(historico.getData()+ "   -   " + historico.getConta_codigo() + " - " + conta.getNome());%></td>
                        <%
                            if (historico.getTipo().equals("debito")) {
                                valorA += historico.getValorInt();
                                %>
                                <td class="tg-z5sk"><%out.print("R$" + historico.getValor());%></td>
                                <td class="tg-z5sk"></td>
                                <%
                            }
                        %>
                        <%
                            if (historico.getTipo().equals("credito")) {
                                valorA += historico.getValorInt();
                                %>
                                <td class="tg-z5sk"></td>
                                <td class="tg-z5sk"><%out.print("R$" + historico.getValor());%></td>
                                <%
                            }
                        %>
                    </tr>
                    <%}%>
                    
                <%}%>
                    
                <tr>
                    <td class="tg-jqao" colspan="2">Total Ativo</td>
                    <td class="tg-jqao" colspan="2"><%out.print("R$" + valorA);%></td>
                </tr>
                <tr>
                  <td class="tg-yw4l" colspan="4"></td>
                </tr>
                <tr>
                    <td class="tg-jqao" colspan="2">Passivo</td>
                    <td class="tg-jqao">Débito</td>
                    <td class="tg-jqao">Crédito</td>
                </tr>
                <%for (Historico historico : allHistorico) {%>
                    <%if (historico.isPassivo()) {%>
                    <%
                        String codigoConta = historico.getConta_codigo();
                        String codigo = codigoConta.substring(0, Math.min(3,codigoConta.length()));
                        if (!lastCodigo.equals(codigo)) {
                            conta = new Conta();
                            conta.setCodigo(codigo);
                            conta.fillFromDatabase();
                    %>
                            <tr>
                            <td class="tg-z5sk" colspan="2"><%out.print(conta.getNome());%></td>
                            <td class="tg-z5sk"></td>
                            <td class="tg-z5sk"></td>
                            </tr>
                    <%
                            lastCodigo = codigo;
                        }
                        conta.setCodigo(codigoConta);
                        conta.fillFromDatabase();
                    %>
                    <tr>
                        <td class="tg-hhim" colspan="2"><%out.print(historico.getData()+ "   -   " + historico.getConta_codigo() + " - " + conta.getNome());%></td>
                        <%
                            if (historico.getTipo().equals("debito")) {
                                valorP += historico.getValorInt();
                                %>
                                <td class="tg-z5sk"><%out.print("R$" + historico.getValor());%></td>
                                <td class="tg-z5sk"></td>
                                <%
                            }
                        %>
                        <%
                            if (historico.getTipo().equals("credito")) {
                                valorP += historico.getValorInt();
                                %>
                                <td class="tg-z5sk"></td>
                                <td class="tg-z5sk"><%out.print("R$" + historico.getValor());%></td>
                                <%
                            }
                        %>
                    </tr>
                    <%}%>
                    
                <%}%>
                <tr>
                    <td class="tg-jqao" colspan="2">Total Passivo</td>
                    <td class="tg-jqao" colspan="2"><%out.print("R$" + valorP);%></td>
                </tr>
            </table></div>
        <%}%>
    </body>

</html>
