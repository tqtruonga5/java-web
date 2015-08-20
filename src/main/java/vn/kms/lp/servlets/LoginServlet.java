package vn.kms.lp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kms.lp.dao.UserDAO;
import vn.kms.lp.dao.impl.UserDAOImpl;
import vn.kms.lp.model.UserModel;

//@WebServlet(description = "Login Servlet", 
//            urlPatterns = { "/LoginServlet" }, 
//            initParams = {
//                @WebInitParam(name = "user", value = "Pankaj"), 
//                @WebInitParam(name = "password", value = "journaldev") 
//            }
//)

@WebServlet({ "/LoginServlet" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = UserDAOImpl.getInstance();

        if (userDAO.validate(username, password)) {
            PrintWriter out = response.getWriter();
            out.print("Success");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);

        }

    }
}