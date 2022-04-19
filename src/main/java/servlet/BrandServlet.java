package servlet;

import store.CarRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BrandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brands", CarRepository.findAllBrand());
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }
}
