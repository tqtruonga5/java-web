package vn.kms.lp.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kms.lp.dao.ProductDAO;
import vn.kms.lp.dao.impl.ProductDAOImpl;
import vn.kms.lp.model.ProductModel;

@WebServlet({ "/ProductServlet/*" })
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = -1449661662263439546L;
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = ProductDAOImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            if ("list".equals(pathParts[1])) {
                doGetList(request, response);
                return;
            } else if ("delete".equals(pathParts[1])) {
                doDeleteById(request, response);
                return;
            } else if ("update".equals(pathParts[1])) {
                doGetById(request, response);
            } else {
                request.setAttribute("action", "Add New");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/product/form.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        ProductModel product = new ProductModel();
        
        product.setName(request.getParameter("name").toString());
        product.setCategory(request.getParameter("category").toString());
        product.setDescription(request.getParameter("description").toString());
        product.setPrice(new BigDecimal(request.getParameter("price").toString()));
        
        if (request.getParameter("id").equals("")) {
            productDAO.save(product);
        } else {
            product.setId(Integer.parseInt(request.getParameter("id").toString()));
            productDAO.update(product);
        }
        response.sendRedirect(getServletContext().getContextPath() + "/search.jsp");
    }

    /**
     * Fetch all Product and forward to list.jsp to render
     */
    private void doGetList(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<ProductModel> products = productDAO.getAll();
        request.setAttribute("products", products);
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
            ProductModel product = productDAO.getById(id);
            request.setAttribute("product", product);
            request.setAttribute("action", "Update");
        } catch (Exception e) {
            log(e.getMessage(), e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/product/form.jsp");
        dispatcher.forward(request, response);
    }

    private void doDeleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id").toString());
            productDAO.deleteById(id);
        } catch (Exception e) {
        }
        response.sendRedirect(request.getContextPath()+"/search.jsp");
    }
}
