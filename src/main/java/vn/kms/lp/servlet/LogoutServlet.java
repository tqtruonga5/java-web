package vn.kms.lp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/logout" })
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 8583302137578126368L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session!=null){
            session.removeAttribute("user");
            session.invalidate();
        }
        resp.sendRedirect("index.jsp");
    }
}
