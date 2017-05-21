package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This filter intends to verify if user in logged-in  or not and sends back to respective page
 * @author junior
 */
public class SessionFilter implements Filter {

    protected ServletContext servletContext;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //get request, response and session
       HttpServletRequest req = (HttpServletRequest) request;
       HttpServletResponse resp = (HttpServletResponse) response;
       HttpSession session = req.getSession(false);
       boolean isLoggedIn = session != null && session.getAttribute("currentSessionUser") != null;
       //if the user is note logged
       if(!isLoggedIn){
          resp.sendRedirect("login_page.jsp");//move user to login page
       }else{
          //propagate to next element in the filter chain
          chain.doFilter(request, response); 
       }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
