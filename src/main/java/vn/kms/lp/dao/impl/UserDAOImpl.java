package vn.kms.lp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.kms.lp.dao.UserDAO;
import vn.kms.lp.dao.utils.PostgresDataSource;
import vn.kms.lp.model.UserModel;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean validate(String username, String password) {
        boolean status = false;
        String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
        Connection connection = null;
        
        try {
            connection = PostgresDataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            ps.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return status;
    }

    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    private static UserDAO instance;

    @Override
    public UserModel getByUsername(String username) {

        return null;
    }

    public synchronized static final UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }
}
