package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterCurrentUser", servletNames = {"CalcServlet", "LogoutServlet"})

public class CurrentUserFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("currentUser") == null){
            req.setAttribute("message", "Need authorisation");
            getServletContext().getRequestDispatcher("/").forward(req, res);
        }
        else {
            chain.doFilter(req, res);
        }
    }
}
