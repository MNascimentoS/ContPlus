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
import model.domain.Discente;
import model.domain.ProcessoAdministrativo;

/**
 * Responsible for record a adm process
 * @author junior
 */
@WebServlet(name = "ProcessServlet", urlPatterns = {"/ProcessServlet"})
public class ProcessServlet extends HttpServlet {

    private final int VERIFY_PROCESS_NUMBER = 1;
    private final int VERIFY_MATRICULA_NUMBER = 2;  
    private final int RECORD = 3;      
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
        //getting the option
        int option = Integer.parseInt(request.getParameter("option"));
        //verify what to do
        switch(option){
            case VERIFY_PROCESS_NUMBER:
                 int process_number = Integer.parseInt(request.getParameter("process_number"));
                 ProcessoAdministrativo processo = new ProcessoAdministrativo();
                 processo.setNumero(process_number);
                 if(processo.jaExiste()){
                    response.setContentType("text/plain");
                    response.getWriter().write("jaExiste");
                 }else{
                    response.setContentType("text/plain");
                    response.getWriter().write("naoExiste");
                 }
                 break;
            case VERIFY_MATRICULA_NUMBER:
                String matricula_number = request.getParameter("matricula_number");
                Discente discente = new Discente();
                discente.setMatricula(matricula_number);
                if(discente.existe()){
                    response.setContentType("text/plain");
                    response.getWriter().write("Existe");
                }else{
                    response.setContentType("text/plain");
                    response.getWriter().write("naoExiste"); 
                }
                break;
            case RECORD:
                ProcessoAdministrativo novo_processo = new ProcessoAdministrativo();
                novo_processo.setNumero(Integer.parseInt(request.getParameter("process_number")));
                novo_processo.setMotivo(request.getParameter("reason"));
                Discente discente2 = new Discente();
                discente2.setMatricula(request.getParameter("usuario"));
                discente2.existe();
                novo_processo.setDiscente(discente2.getId());
                String aprovado = request.getParameter("group1");
                if(aprovado.equals("true")){
                    novo_processo.setAprovado(true);
                }else{
                    novo_processo.setAprovado(false);
                }
                
                //record
                if(novo_processo.gravar()){
                   request.setAttribute("process", "Novo processo cadastrado"); 
                }else{
                   request.setAttribute("process", "Falha ao cadastrar processo");                
                }
                request.getRequestDispatcher("index_coord.jsp").forward(request, response);               
                break;
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
