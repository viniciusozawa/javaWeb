<%-- 
    Document   : CadastroCidade
    Created on : 2 de mar de 2026, 14:17:10
    Author     : 02338079698
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <input type="hidden" name="codCidade" value="${codCidade}">
            <p><label>Cidade:</label> <input type="text" name="nomeCidade" value="${nomeCidade}" size="40"></p>
            <p><label>UF:</label> <input type="text" name="ufCidade" value="${ufCidade}" size="5"></p>
            <input type="submit" value="Salvar" name="Salvar">
        </form>
        <h3>${mensagem}</h3>
        <table border="1">
            <c:if test="${not empty cidades}">
                <tr>
                    <th>CÓDIGO </th>
                    <th>NOME</th>
                    <th>UF</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="cidades" items="${cidades}">
                <tr>
                    <td>${cidades.codCidade}</td>
                    <td>${cidades.nomeCidade}</td>
                    <td>${cidades.ufCidade}</td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
                            <input type="hidden" name="codCidade" value="${cidades.codCidade}">
                            <input type="hidden" name="nomeCidade" value="${cidades.nomeCidade}">
                            <input type="hidden" name="ufCidade" value="${cidades.ufCidade}">
                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
                            <input type="hidden" name="codCidade" value="${cidades.codCidade}">
                            <input type="hidden" name="nomeCidade" value="${cidades.nomeCidade}">
                            <input type="hidden" name="ufCidade" value="${cidades.ufCidade}">
                            <input type="hidden" name="opcao" value="excluir">
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
