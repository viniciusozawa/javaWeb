/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.viniciusozawainfoh.controller;

import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.dao.CidadeDao;
import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.dao.FuncionarioDao;
import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.entity.Cidade;
import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.entity.Funcionario;
import br.edu.ifsuldeminas.viniciusozawainfoh.servico.WebConstante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 
 */
@WebServlet(WebConstante.BASE_PATH + "/FuncionarioControlador")
//designar uma classe como um servelts, mapeando de URL no Servidor Web(GlassFish)
public class FuncionarioControlador extends HttpServlet {

    Funcionario objFuncinario ;
    FuncionarioDao objFuncuinarDao ;
    
    String nomeFuncionario = "";
    String salarioFuncionario = "";
    String nascimentoFuncionario = "";
    String codigoFuncionario = "";
    String cidadeFuncionario = "";
    
    
    String opcao = "";


    @Override
    public void init() throws ServletException {
        objFuncinario = new Funcionario();
        objFuncuinarDao = new FuncionarioDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            codigoFuncionario = request.getParameter("codigoFuncionario");
            nomeFuncionario = request.getParameter("nomeFuncionario");
            salarioFuncionario = request.getParameter("salarioFuncionario");
            nascimentoFuncionario = request.getParameter("nascimentoFuncionario");
            cidadeFuncionario = request.getParameter("cidadeFuncionario");

            switch (opcao) {
                case "cadastrar":
                    cadastrar(request, response);

                    break;
                case "enviarAlterar":
                    enviarAlterar(request, response);
                    break;
                case "confirmarAlterar":
                    confirmarAlterar(request, response);
                    break;
                case "cancelar":
                    cancelar(request, response);
                    break;
                case "enviarExcluir":
                    enviarExcluir(request, response);
                    break;
                case "confirmarExcluir":
                    confirmarExcluir(request, response);
                    break;
                default:
                    throw new IllegalArgumentException("Opçãop invalida" + opcao);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parametros não são número válido" + e.getMessage());
        } catch (IllegalArgumentException ex) {
            response.getWriter().println("Erro: " + ex.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objFuncinario.setNomeFuncionario(nomeFuncionario);
        objFuncinario.setNascimentoFuncionario(LocalDate.parse(nascimentoFuncionario) );
        objFuncinario.setSalarioFuncionario(Double.valueOf(salarioFuncionario));
        objFuncinario.getCidadeFuncionario().setCodCidade(Integer.valueOf(cidadeFuncionario));
        objFuncuinarDao.salvar(objFuncinario);
        
        request.setAttribute("mensagem", "Funcionario cadastrada com sucesso!");
        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigoFuncionario", codigoFuncionario);
        request.setAttribute("nomeFuncionario", nomeFuncionario);
        request.setAttribute("salarioFuncionario", salarioFuncionario);
        request.setAttribute("nascimentoFuncionario", nascimentoFuncionario);
        request.setAttribute("cidadeFuncionario", cidadeFuncionario);
        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "edite");
        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objFuncinario.setCodigoFuncionario(Integer.valueOf(codigoFuncionario));
        objFuncinario.setNomeFuncionario(nomeFuncionario);
        objFuncinario.setNascimentoFuncionario(LocalDate.parse(nascimentoFuncionario) );
        objFuncinario.setSalarioFuncionario(Double.valueOf(salarioFuncionario));
        objFuncinario.getCidadeFuncionario().setCodCidade(Integer.valueOf(cidadeFuncionario));
        objFuncuinarDao.alterar(objFuncinario);
        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Funcionario> funcionarios = objFuncuinarDao.buscarTodasCidade();
        request.setAttribute("funcionarios", funcionarios);
        RequestDispatcher dispather = request.getRequestDispatcher("/CadastroFuncionario.jsp");
        dispather.forward(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigoFuncionario", "0");
        request.setAttribute("nomeFuncionario", "");
        request.setAttribute("salarioFuncionario", "0");
        request.setAttribute("nascimentoFuncionario", "");
        request.setAttribute("cidadeFuncionario", "");
        request.setAttribute("opcao", "cadastrar");
        encaminharParaPagina(request, response);
    }
    
    private void enviarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigoFuncionario", codigoFuncionario);
        request.setAttribute("nomeFuncionario", nomeFuncionario);
        request.setAttribute("salarioFuncionario", salarioFuncionario);
        request.setAttribute("nascimentoFuncionario", nascimentoFuncionario);
        request.setAttribute("cidadeFuncionario", cidadeFuncionario);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem", "Confirmar os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
    
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objFuncinario.setCodigoFuncionario(Integer.valueOf(codigoFuncionario));
        
        objFuncuinarDao.exclui(objFuncinario);
        encaminharParaPagina(request, response);

    }
}
