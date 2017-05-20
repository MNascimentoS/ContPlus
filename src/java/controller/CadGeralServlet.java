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
import model.domain.CoordenadorAcademico;
import model.domain.CoordenadorDeCurso;
import model.domain.SecretarioAcademico;
import model.domain.SecretarioDeCurso;
import encryption.CryptMD5;

/**
 *
 * @author mateus
 */
@WebServlet(name = "CadGeralServlet", urlPatterns = {"/CadGeralServlet"})
public class CadGeralServlet extends HttpServlet {

    private static final int COORDENADOR_ACADEMICO = 1;
    private static final int COORDENADOR_CURSO = 2;
    private static final int SECRETARIO_ACADEMICO = 3;
    private static final int SECRETARIO_CURSO = 4;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome, cpf, login, senha;
        nome = request.getParameter("nome");
        String[] names = nome.split(" ");
        login = request.getParameter("matricula");
        cpf = request.getParameter("cpf");
        senha = cpf.substring(0, Math.min(6,cpf.length()));
        senha = CryptMD5.cryptWithMD5(senha);
        boolean cadastrado = false;
        
        int tipoCadastro = Integer.parseInt(request.getParameter("tipo"));
        switch(tipoCadastro) {
            case COORDENADOR_ACADEMICO: CoordenadorAcademico coordAcademico = new CoordenadorAcademico(names[0], login, senha);
                cadastrado = coordAcademico.insert();
                break;
            case COORDENADOR_CURSO: CoordenadorDeCurso coordCurso = new CoordenadorDeCurso(names[0], login, senha);
                cadastrado = coordCurso.insert();
                break;
            case SECRETARIO_ACADEMICO: SecretarioAcademico secAcademico = new SecretarioAcademico(names[0], login, senha);
                cadastrado = secAcademico.insert();
                break;
            case SECRETARIO_CURSO:  SecretarioDeCurso secCurso = new SecretarioDeCurso(names[0], login, senha);
                cadastrado = secCurso.insert();
                break;
        }
        response.sendRedirect("index_admin.jsp?cad=" + cadastrado);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
