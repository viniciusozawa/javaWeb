<%-- 
    Document   : CadastroCidade
    Created on : 2 de mar de 2026, 14:17:10
    Author     : 02338079698
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro Funcionario</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Hello World!</h1>
        <form type="hidden" name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador">
            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <p>${opcao}</p>
            <input type="hidden" name="codigoFuncionario" value="${codigoFuncionario}">
            <p><label>Nome:</label> <input type="text" name="nomeFuncionario" required="" value="${nomeFuncionario}" size="40"></p>
            <p><label>Salário:</label> <input type="text" name="salarioFuncionario" required="" value="${salarioFuncionario}" size="5"></p>
            <p><label>Nascimento:</label> <input type="date" name="nascimentoFuncionario" required="" value="${nascimentoFuncionario}" size="5"></p>
            <p><label>Cidade:</label>
                <select name="cidadeFuncionario">
                    <c:forEach var="funcionarios" items="${funcionarios}">
                        <option value="${funcionarios.codigoCidade}">${funcionarios.nomeCidade}</option>
                        
                    </c:forEach>
                   
                </select>

            </p> 
                
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
            
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
             <input type="hidden" name="opcao" value="cancelar">
            
        </form>    
            
        <h3>${mensagem}</h3>
        <table border="1">
            <c:if test="${not empty funcionarios}">
                <tr>
                    <th>CÓDIGO </th>
                    <th>NOME</th>
                    <th>UF</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="funcionarios" items="${listarFuncionario}">
                <tr>
                    <td>${funcionarios.codigoFuncionario}</td>
                    <td>${funcionarios.nomeFuncionario}</td>
                    <td>${funcionarios.salarioFuncionario}</td>
                    <td>${funcionarios.nascimentoFuncionario}</td>
                    <td>${funcionarios.cidadeFuncionario.nomeCidade}</td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador">
                            <input type="hidden" name="codigoFuncionario" value="${funcionarios.codigoFuncionario}">
                            <input type="hidden" name="nomeFuncionario" value="${funcionarios.nomeFuncionario}">
                            <input type="hidden" name="salarioFuncionario" value="${funcionarios.salarioFuncionario}">
                            <input type="hidden" name="nascimentoFuncionario" value="${funcionarios.nascimentoFuncionario}">
                            <input type="hidden" name="cidadeFuncionario" value="${funcionarios.cidadeFuncionario.codigoCidade}">
                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador">
                            <input type="hidden" name="codigoFuncionario" value="${funcionarios.codigoFuncionario}">
                            <input type="hidden" name="nomeFuncionario" value="${funcionarios.nomeFuncionario}">
                            <input type="hidden" name="salarioFuncionario" value="${funcionarios.salarioFuncionario}">
                            <input type="hidden" name="nascimentoFuncionario" value="${funcionarios.nascimentoFuncionario}">
                            <input type="hidden" name="cidadeFuncionario" value="${funcionarios.cidadeFuncionario.codigoCidade}">
                            <input type="hidden" name="opcao" value="enviarExcluir">
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
