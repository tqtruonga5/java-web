package vn.kms.lp.dao.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
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
    private static DBConnectionManager connectionManager;

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
            connectionManager = new DBConnectionManager(driver, url, user, password);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static Connection getConnection() {
        return connectionManager.getConnectionFromPool();
    }

    public static void returnConnectionToPool(Connection connection) {
        connectionManager.returnConnectionToPool(connection);
    }
}