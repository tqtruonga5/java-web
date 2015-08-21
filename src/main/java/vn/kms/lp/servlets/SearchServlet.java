package vn.kms.lp.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kms.lp.dao.SearchProductDAO;
import vn.kms.lp.dao.impl.SearchProductDAOImpl;
import vn.kms.lp.model.ProductModel;

@WebServlet({ "/SearchServlet/*" })
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 861313209271193884L;
    private SearchProductDAO searchProductDAO;

    @Override
    public void init() throws ServletException {
        searchProductDAO = SearchProductDAOImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductModel> products = Collections.emptyList();
        
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        BigDecimal fromPrice = new BigDecimal(req.getParameter("price-from").toString());
        BigDecimal toPrice = new BigDecimal(req.getParameter("price-to").toString());
        String orderBy = req.getParameter("order-by");
        
        System.out.println(name +" "+category +" " + fromPrice + " "+ toPrice +" "+orderBy);
        
        products = searchProductDAO.searchByFeatures(name, category, fromPrice, toPrice,orderBy);
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/search.jsp");
        dispatcher.forward(req, resp);
    }
}