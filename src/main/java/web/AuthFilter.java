package web;

import entity.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", servletNames = "AuthServlet")

public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        User user = (User) req.getSession().getAttribute("currentUser");
        if (user == null) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("message", "You have already authorisation");
            getServletContext().getRequestDispatcher("/").forward(req, res);
        }
    }
}

