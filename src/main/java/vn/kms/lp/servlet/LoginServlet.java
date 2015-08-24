package vn.kms.lp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.kms.lp.dao.UserDAO;
import vn.kms.lp.dao.impl.UserDAOImpl;
import vn.kms.lp.model.UserModel;
import vn.kms.lp.web.utils.MD5Hashing;

@WebServlet({ "/LoginServlet" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = MD5Hashing.getHashedPassword(req.getParameter("password"));
        UserDAO userDAO = UserDAOImpl.getInstance();

        if (userDAO.validate(username, password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", username);
            response.sendRedirect("search.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, response);
        }
    }
}