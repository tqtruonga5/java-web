package vn.kms.lp.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.kms.lp.dao.ProductDAO;
import vn.kms.lp.dao.utils.PostgresDataSource;
import vn.kms.lp.model.ProductModel;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void save(ProductModel product) {
        String query = "insert into Products (PRODUCT_ID, PRODUCT_NAME, PRODUCT_CATEGORY,PRODUCT_DESC,PRODUCT_PRICE) "
                + "values (?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = PostgresDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getCategory());
            ps.setString(4, product.getDescription());
            ps.setBigDecimal(5, product.getPrice());
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
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
                rs.close();
                ps.close();
                connection.close();
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
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Product updated with id=" + product.getId());
            } else
                System.out.println("No Product found with id=" + product.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Product deleted with id=" + id);
            } else
                System.out.println("No Product found with id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ProductModel> getAll() {
        String query = "select * from Products";
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
                System.out.println("Product Found::" + product);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        ProductModel product = productDAO.getById(1);
        System.out.println(product.getName());

        product.setId(4);
        product.setName("SH");
        product.setCategory("Category1");
        product.setDescription("Xe may Honda");
        product.setPrice(new BigDecimal(10000000));
        productDAO.update(product);
        productDAO.getAll();
    }
}
