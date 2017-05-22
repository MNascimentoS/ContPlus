<%@page import="model.domain.Conta"%>
<%@page import="model.database.DatabaseMySQL" %>
<!DOCTYPE html>
<%
   String find = request.getParameter("find"); 
   Conta conta = new Conta();
   if (find.equals("conta")) {
        String codigo = request.getParameter("conta"); 
        conta.setCodigo(codigo);
        conta.fillFromDatabase();
   }
%>
<html lang="pt-br">

    <body>
        <input id="<%out.print(conta.getCodigo());%>" name="<%out.print(conta.getNome());%>">
    </body>

</html>
