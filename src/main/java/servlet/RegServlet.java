package servlet;

import model.User;
import store.Hibernate;
import store.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (UserRepository.findUser(email) == null) {
            UserRepository.add(User.of(name, email, password));
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("error", "Пользователь зарегестрирован");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        }
    }

}