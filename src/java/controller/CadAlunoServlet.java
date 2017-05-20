/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.domain.Discente;

/**
 *
 * @author mateus
 */
public class CadAlunoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String nome, login, senha, matricula, email, cpf, telefone;
        int campus, departamento, semIngresso, tipoIngresso, semCursado;
        
        nome = request.getParameter("name");
        cpf = request.getParameter("cpf");
        email = request.getParameter("email");
        telefone = request.getParameter("telcontato");
        /*campus = Integer.parseInt(request.getParameter("campus"));
        departamento = Integer.parseInt(request.getParameter("departamento"));
        semIngresso = Integer.parseInt(request.getParameter("semingresso"));
        tipoIngresso = Integer.parseInt(request.getParameter("tipoingresso"));
        semCursado = Integer.parseInt(request.getParameter("semcursado"));*/
        login = matricula = request.getParameter("matricula");
        senha = cpf.substring(0, Math.min(6,cpf.length()));
        
        Discente discente = new Discente(nome, login, senha);
        discente.setMatricula(matricula);
        discente.setContato(telefone);
        request.getRequestDispatcher("index_coord.jsp").forward(request, response);
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
