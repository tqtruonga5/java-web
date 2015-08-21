package vn.kms.lp.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.kms.lp.dao.SearchProductDAO;
import vn.kms.lp.dao.utils.PostgresDataSource;
import vn.kms.lp.model.ProductModel;

public class SearchProductDAOImpl implements SearchProductDAO {
    private static SearchProductDAOImpl instance;
    private static final Logger log = LoggerFactory.getLogger(SearchProductDAOImpl.class);

    public synchronized static final SearchProductDAOImpl getInstance() {
        if (instance == null) {
            instance = new SearchProductDAOImpl();
        }
        return instance;
    }

    @Override
    public List<ProductModel> searchByFeatures(String name, String category, BigDecimal fromPrice, BigDecimal toPrice,
            String orderBy) {
        String query = "select * from Products where PRODUCT_NAME LIKE ? and PRODUCT_CATEGORY LIKE ? and PRODUCT_PRICE between ? and ? order by "+orderBy;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProductModel> products = new ArrayList<ProductModel>();

        try {
            connection = PostgresDataSource.getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + category + "%");
            ps.setBigDecimal(3, fromPrice);
            ps.setBigDecimal(4, toPrice);
//            ps.setString(5, orderBy);

            rs = ps.executeQuery();
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setId(rs.getInt("PRODUCT_ID"));
                product.setName(rs.getString("PRODUCT_NAME"));
                product.setCategory(rs.getString("PRODUCT_CATEGORY"));
                product.setDescription(rs.getString("PRODUCT_DESC"));
                product.setPrice(rs.getBigDecimal("PRODUCT_PRICE"));
                products.add(product);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
        return products;
    }
}
