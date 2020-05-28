package web.servlet;

import entity.User;
import storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name = "RegServlet")

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserStorage userStorage = new UserStorage();
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userStorage.checkUserByLogin(login)) {
        userStorage.add(new User(login, name, password));
        resp.sendRedirect("/");
        }
        else {
            req.setAttribute("message", "Login can't be used");
            getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
        }
    }
}
