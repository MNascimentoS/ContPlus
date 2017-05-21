package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.domain.Usuario;
import encryption.CryptMD5;

/**
 * Este servlet realiza a lógica de negócio necessária para realizar a entrada
 * do usuário no sistema.
 *
 * @author junior
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

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

        String option = request.getParameter("option");
        HttpSession session = request.getSession(true);
        
        if (option.equals("login")) {
            Usuario usuario = new Usuario();
            usuario.setEmail(request.getParameter("user_name"));
            usuario.setSenha(CryptMD5.cryptWithMD5(request.getParameter("password")));
            //message for erros
            String errorMessage;
            //path to user index
            String indexPage;
            //user validate
            usuario.autenticar();
                
            if (usuario.eValido()) {
                switch (usuario.getTipo()) {
                    case "contador":
                        indexPage = "index_admin.jsp";
                        break;
                    case "auxiliar":
                        indexPage = "index_aux.jsp";
                        break;
                    default:
                        indexPage = "login_page.jsp";
                        break;
                }
                    
                //send the user to your respective index page
                session.setAttribute("currentSessionUser", usuario);
                response.sendRedirect(indexPage);
                
            } else {
                errorMessage = "Nome de usuário ou senha incorreto";
                request.setAttribute("error_message", errorMessage);
                request.getRequestDispatcher("login_page.jsp").forward(request, response);
            }
        } else if (option.equals("logout")) {
            session.invalidate();
            response.sendRedirect("login_page.jsp");
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
        //processRequest(request, response);
        request.getRequestDispatcher("login_page.jsp").forward(request, response);
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
