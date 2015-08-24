package vn.kms.lp.web.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryConfiguration.class);
    private static List<String> categories;
    private static final String CONFIG_FILE_PATH = "categories.properties";

    public static List<String> getAllCategories() {
        return categories;
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(CategoryConfiguration.class.getClassLoader().getResourceAsStream(CONFIG_FILE_PATH));
            categories = Arrays.asList(properties.getProperty("categories").split(","));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
