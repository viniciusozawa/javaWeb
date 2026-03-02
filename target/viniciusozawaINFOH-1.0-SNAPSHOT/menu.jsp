<%-- 
    Document   : menu
    Created on : 2 de mar de 2026, 13:32:31
    Author     : 02338079698
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css"/>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/index.jsp">HOME</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">CIDADE</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlado">FUNCIONÁRIO</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></li>
                <li><a href="${pageContext.request.contextPath}/logout.jsp">LOGOUT</a></li>
                
                
            </ul>

        </nav>
        
    </body>
</html>
