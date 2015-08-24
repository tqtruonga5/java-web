package vn.kms.lp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.kms.lp.dao.ProductDAO;
import vn.kms.lp.dao.utils.PostgresDataSource;
import vn.kms.lp.model.ProductModel;

public class ProductDAOImpl implements ProductDAO {
    private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
    private static ProductDAO instance;

    public synchronized static final ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAOImpl();
        }
        return instance;
    }

    @Override
    public void save(ProductModel product) {
        String query = "insert into Products (PRODUCT_NAME, PRODUCT_CATEGORY,PRODUCT_DESC,PRODUCT_PRICE) "
                + "values (?,?,?,?)";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = PostgresDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setString(3, product.getDescription());
            ps.setBigDecimal(4, product.getPrice());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee saved with id=" + product.getId());
            } else
                System.out.println("Employee save failed with id=" + product.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                PostgresDataSource.returnConnectionToPool(connection);
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public ProductModel getById(int id) {
        String query = "select * from Products where PRODUCT_ID = ?";
        ProductModel product = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = PostgresDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                product = new ProductModel();
                product.setId(id);
                product.setName(rs.getString("PRODUCT_NAME"));
                product.setCategory(rs.getString("PRODUCT_CATEGORY"));
                product.setDescription(rs.getString("PRODUCT_DESC"));
                product.setPrice(rs.getBigDecimal("PRODUCT_PRICE"));
                System.out.println("Product Found::" + product);
            } else {
                System.out.println("No Employee found with id=" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
//                connection.close();
                PostgresDataSource.returnConnectionToPool(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public void update(ProductModel product) {
        String query = "update Products set PRODUCT_NAME=?,PRODUCT_CATEGORY=?,PRODUCT_DESC=?,PRODUCT_PRICE=? where PRODUCT_ID=?";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = PostgresDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setString(3, product.getDescription());
            ps.setBigDecimal(4, product.getPrice());
            ps.setInt(5, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from Products where PRODUCT_ID = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = PostgresDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public List<ProductModel> getAll() {
        String query = "select * from Products ";
        List<ProductModel> products = new ArrayList<ProductModel>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = PostgresDataSource.getConnection();
            ps = connection.prepareStatement(query);
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
