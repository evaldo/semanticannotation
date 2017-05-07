/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Ontologia;

/**
 *
 * @author Filipe
 */
@WebServlet(name = "ControllerJena", urlPatterns = {"/listarOntologias", "/selecionarOntologias"})
public class ControllerJena extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (request.getRequestURI().contains("/listarOntologias")) {

            String nomeclasse = request.getParameter("nomeClasse");
            String nomeArquivo = request.getParameter("arq_ontologia");
            String uri = request.getParameter("uri");

            if (sessao.getAttribute("ontSessao") == null) {
                Ontologia ont = new Ontologia(nomeArquivo, uri);

                sessao.setAttribute("ontSessao", ont);
            }
            
            Ontologia ontSessao = (Ontologia) sessao.getAttribute("ontSessao");
            
            request.setAttribute("ClassesOnt", ontSessao.listarClasses());
            
            request.setAttribute("arq_ontologiaTxt",ontSessao.getInputFileName());
            request.setAttribute("uriTxt",ontSessao.getURI());
            
            if (nomeclasse != null ) {//verificar lógica
                System.out.println(nomeclasse);
                request.setAttribute("SubClassesOnt", ontSessao.listarSubClasses(nomeclasse));
                
                        
            }

            request.getRequestDispatcher("/WEB-INF/viewClasses.jsp").forward(request, response);

        }

        if (request.getRequestURI().contains("/selecionarOntologias")) {
            sessao.invalidate();
            request.getRequestDispatcher("/WEB-INF/formOntologia.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
