<%-- 
    Document   : index
    Created on : 9 de fev de 2026, 14:39:37
    Author     : 02338079698
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nome = "vinics";
    if(nome.equals("vinicius")){
        nome = "ok";
    }else{
        nome= "nao";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>ola: <%= nome%></h2>
    </body>
</html>
