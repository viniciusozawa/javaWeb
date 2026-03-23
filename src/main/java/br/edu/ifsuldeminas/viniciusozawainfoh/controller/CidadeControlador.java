/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.viniciusozawainfoh.controller;

import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.dao.CidadeDao;
import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.entity.Cidade;
import br.edu.ifsuldeminas.viniciusozawainfoh.servico.WebConstante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 02338079698
 */

@WebServlet(WebConstante.BASE_PATH+"/CidadeControlador")
//designar uma classe como um servelts, mapeando de URL no Servidor Web(GlassFish)
public class CidadeControlador extends HttpServlet{
    
    Cidade objCidade = new Cidade();
    CidadeDao objCidadeDaO = new CidadeDao();
    String nomeCidade=""; 
    String ufCidade= "";
    String opcao = "";
    String codCidade = "";
    
    @Override
    public void init() throws ServletException {
     
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            codCidade = request.getParameter("codCidade");
            nomeCidade = request.getParameter("nomeCidade");
            ufCidade = request.getParameter("ufCidade");
            
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
                default:throw new IllegalArgumentException("Opçãop invalida"+opcao);
            }
            
        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parametros não são número válido"+e.getMessage());
        }catch (IllegalArgumentException ex){
            response.getWriter().println("Erro: "+ex.getMessage());
        }
    }
    
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objCidade.setNomeCidade(nomeCidade);
        objCidade.setUfCidade(ufCidade);
        System.out.println("chegou");
        objCidadeDaO.salvar(objCidade);
        request.setAttribute("mensagem", "Cidade cadastrada com sucesso!");
        encaminharParaPagina(request, response);
    }
    
    private void enviarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codCidade", codCidade);
        request.setAttribute("nomeCidade", nomeCidade);
        request.setAttribute("ufCidade", ufCidade);
        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
     private void confirmarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         objCidade.setCodCidade(Integer.valueOf(codCidade));
         objCidade.setNomeCidade(nomeCidade);
         objCidade.setUfCidade(ufCidade);
         objCidadeDaO.alterar(objCidade);
         encaminharParaPagina(request, response);
         
     }
    
    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Cidade> cidades = objCidadeDaO.buscarTodasCidade();
        request.setAttribute("cidades", cidades);
        RequestDispatcher dispather = request.getRequestDispatcher("/CadastroCidade.jsp");
        dispather.forward(request, response);
    }
    
}
