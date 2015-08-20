package vn.kms.lp.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostgresDataSource {
    private static final Logger log = LoggerFactory.getLogger(PostgresDataSource.class);
    private static final String url = "jdbc:postgresql://localhost:5432/java_web_basic";
    private static final String user = "postgres";
    private static final String password = "123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error("Can not open connection to DB.", e);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return connection;
    }
}