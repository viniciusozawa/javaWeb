/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.viniciusozawainfoh.controller;

import br.edu.ifsuldeminas.viniciusozawainfoh.servico.WebConstante;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author 02338079698
 */

@WebServlet(WebConstante.BASE_PATH+"/CidadeControlador")
//designar uma classe como um servelts, mapeando de URL no Servidor Web(GlassFish)
public class CidadeControlador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response); 
        
        try {
            
        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parametros não são número válido"+e.getMessage());
        }catch (IllegalArgumentException ex){
            response.getWriter().println("Erro: "+ex.getMessage());
        }
    }
    
    
    
}
