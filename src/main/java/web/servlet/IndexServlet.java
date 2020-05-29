package web.servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if ( currentUser == null){
            req.setAttribute("messageHello", "Hello Guest");
        }
        else {
            req.setAttribute("messageHello", "Hello " + currentUser.getName() );
        }
        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }

}
