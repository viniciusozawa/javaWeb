<%-- 
    Document   : CadastroCidade
    Created on : 2 de mar de 2026, 14:17:10
    Author     : 02338079698
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Hello World!</h1>
        <form type="hidden" name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">

            <p><label>Cidade:</label> <input type="text" name="nomeCidade" value="" size="40"></p>
            <p><label>UF:</label> <input type="text" name="ufCidade" value="" size="5"></p>
            <input type="submit" value="Salvar" name="Salvar">
        </form>
    </body>
</html>
