/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Ontologia;

/**
 *
 * @author Filipe
 */
@WebServlet(name = "ControllerJena", urlPatterns = {"/listarOntologias", "/selecionarOntologias"})
@MultipartConfig
public class ControllerJena extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getRequestURI().contains("/selecionarOntologias")) {
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

        if (request.getRequestURI().contains("/listarOntologias")) {

            String pastaProgeto = getServletContext().getRealPath("");
            String nomeArquivo = upLoad(request, response, pastaProgeto);
            String uri = request.getParameter("uri");

            Ontologia ont = new Ontologia(nomeArquivo, uri);
            request.setAttribute("ClassesOnt", ont.listarClasses());
            request.getRequestDispatcher("/WEB-INF/viewClasses.jsp").forward(request, response);
        }
    }

    public String upLoad(HttpServletRequest request, HttpServletResponse response, String pastaProgeto) throws IOException, ServletException {
        String pastaArquivos = "arquivos";
        String salvarEm = pastaProgeto + File.separator + pastaArquivos;
        File pasta = new File(salvarEm);
        if (!pasta.exists()) {
            pasta.mkdir();
        }
        Part arquivoSelecionado = request.getPart("arquivo");
        String nomeArquivo = arquivoSelecionado.getSubmittedFileName();
        //gravar o arquivo no disco
        String caminhoArquivo = salvarEm + File.separator + nomeArquivo;
        arquivoSelecionado.write(caminhoArquivo);
        return caminhoArquivo;
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
