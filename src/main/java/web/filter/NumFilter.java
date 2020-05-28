package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebFilter(filterName = "FilterNum", servletNames = "CalcServlet")

public class NumFilter extends HttpFilter {

    @Override

    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, NumberFormatException {

        if (req.getMethod().equals("POST")) {

            String num1 = req.getParameter("num1");
            String num2 = req.getParameter("num2");
            try {
                if ((Double.parseDouble(num1) < Double.MAX_VALUE && Double.parseDouble(num1) > Double.MIN_VALUE) &&
                        (Double.parseDouble(num2) < Double.MAX_VALUE && Double.parseDouble(num2) > Double.MIN_VALUE)) {
                    chain.doFilter(req, res);
                } else {
                    req.setAttribute("res", "Incorrect number");
                    getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, res);
                }
            } catch (NumberFormatException e) {
                req.setAttribute("res", "Incorrect number");
                getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, res);
            }
        }
        else chain.doFilter(req, res);
    }

}
