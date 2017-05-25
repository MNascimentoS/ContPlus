/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.domain.Historico;
import util.Utils;

/**
 *
 * @author mateus
 */
@WebServlet(name = "CadLancamentoServlet", urlPatterns = {"/CadLancamentoServlet"})
public class CadLancamentoServlet extends HttpServlet {

    private static final String INDEX_ADMIN = "index_admin.jsp";
    private static final String INDEX_AUX = "index_aux.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean cadastrado;
        Historico lancamento = new Historico();
        lancamento.setConta_codigo(request.getParameter("conta"));
        lancamento.setData(Utils.getFormatedData(request.getParameter("date")));
        lancamento.setTipo(request.getParameter("tipo"));
        lancamento.setValor(request.getParameter("valor"));
        lancamento.setObservacao(request.getParameter("observacao"));
        System.out.println(lancamento.toString());
        cadastrado = lancamento.insert();
        String header = request.getHeader("Referer");
        if (header.contains(INDEX_ADMIN)) {
            response.sendRedirect(INDEX_ADMIN + "?cad=" + cadastrado);
        } else if (header.contains(INDEX_AUX)) {
            response.sendRedirect(INDEX_AUX + "?cad=" + cadastrado);
        }
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
