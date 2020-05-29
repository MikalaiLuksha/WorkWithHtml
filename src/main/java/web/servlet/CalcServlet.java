package web.servlet;

import service.ServiceCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @WebServlet(name = "CalcServlet", urlPatterns = "/calc")

public class CalcServlet extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
        }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ServiceCalc serviceCalc = new ServiceCalc();
            double num1 = Double.parseDouble(req.getParameter("num1"));
            double num2 = Double.parseDouble(req.getParameter("num2"));
            String operation = req.getParameter("operation");
            double res = serviceCalc.calculation(operation, num1, num2);
            String symbol = serviceCalc.symbol(operation);
            String stringRes = "" + num1 + " " + symbol + " " + num2 + " = " + res;
            req.setAttribute("res", stringRes);
            getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
            List <String> result = (List) req.getSession().getAttribute("result");
            result.add(stringRes);
        }
}
