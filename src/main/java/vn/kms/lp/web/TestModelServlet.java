//
// Copyright (c) 2015 KMS Technology.
//
package vn.kms.lp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kms.lp.dao.TestDAO;
import vn.kms.lp.dao.impl.TestDAOMemoryImpl;
import vn.kms.lp.model.TestModel;

/**
 * @author thanhtran
 *
 */
@WebServlet({"/testmodel/*"})
public class TestModelServlet extends HttpServlet {

    private static final long serialVersionUID = 2368611017169777703L;

    private TestDAO testDAO;

    @Override
    public void init() throws ServletException {
        testDAO = TestDAOMemoryImpl.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            if ("list".equals(pathParts[1])) {
                doGetList(request, response);
                return;
            }
        }
        doGetById(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            TestModel model = new TestModel();
            model.setAttribute1(req.getParameter("attribute1"));
            model.setAttribute2(Long.parseLong(req.getParameter("attribute2")));
            testDAO.save(model);
            out.println("Success");
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Fetch TestModel by id and forward to view.jsp to render
     */
    private void doGetById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("testModelId").toString());
            TestModel model = testDAO.getById(id);
            request.setAttribute("model", model);
        } catch (Exception ignore) {
            // Ignore all exception
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/test/view.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Fetch all TestModel and forward to list.jsp to render
     */
    private void doGetList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", testDAO.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/test/list.jsp");
        dispatcher.forward(request, response);
    }
}
