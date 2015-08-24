package vn.kms.lp.dao.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostgresDataSource {
    private static final Logger log = LoggerFactory.getLogger(PostgresDataSource.class);
    private static final String CONFIG_FILE_PATH = "database.properties";
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        Properties properties = new Properties();
        InputStream input;
        try {
            input = PostgresDataSource.class.getClassLoader().getResourceAsStream(CONFIG_FILE_PATH);
            properties.load(input);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error("Can not open connection to DB.", e);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return connection;
    }
}