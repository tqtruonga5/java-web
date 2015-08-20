package vn.kms.lp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kms.lp.dao.ProductDAO;
import vn.kms.lp.dao.impl.ProductDAOImpl;
import vn.kms.lp.model.ProductModel;

@WebServlet({ "/productServlet/*" })
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = -1449661662263439546L;
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = ProductDAOImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println(pathInfo);
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            if ("list".equals(pathParts[1])) {
                doGetList(req, resp);
                return;
            }
        }
        doGetById(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println(pathInfo);
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            if ("update".equals(pathParts[1]))
                ;
        }
    }

    /**
     * Fetch all TestModel and forward to list.jsp to render
     */
    private void doGetList(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setAttribute("products", productDAO.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/product/list.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Fetch TestModel by id and forward to view.jsp to render
     */
    private void doGetById(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id").toString());
            System.out.println(id);
            ProductModel model = productDAO.getById(id);
            request.setAttribute("model", model);
        } catch (Exception ignore) {
            // Ignore all exception
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/product/form.jsp");
        dispatcher.forward(request, response);
    }

}
