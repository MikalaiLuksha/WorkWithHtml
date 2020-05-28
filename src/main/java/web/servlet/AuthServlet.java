package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth", name = "AuthServlet")

public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.authService(login, password);
        if (user != null){
            req.getSession().setAttribute("currentUser", user);
            resp.sendRedirect("/");
        }
        else {
           String message = userService.authMessageService(login, password);
           req.setAttribute("message", message);
           getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
        }
    }
}
