/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ontologia;

/**
 *
 * @author Filipe
 */
@WebServlet(name = "ControllerJena", urlPatterns = {"/listarOntologias","/teste"})
public class ControllerJena extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("/listarOntologias")) {
            String classe =  request.getParameter("nomeClasse");
            String inputFileName = "c://urbanus.owl";
            Ontologia ont = new Ontologia(inputFileName);
            
            request.setAttribute("ClassesOnt", ont.listarClasses());
            
            if(classe != null || classe == ""){
            request.setAttribute("SubClassesOnt", ont.listarSubClasses(classe));
            }
            System.out.println(ont.listarClasses());
        request.getRequestDispatcher("/WEB-INF/viewClasses.jsp").forward(request, response);

        }
        
        if (request.getRequestURI().contains("/teste")) {
        request.getRequestDispatcher("/WEB-INF/newjsp.jsp").forward(request, response);
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
