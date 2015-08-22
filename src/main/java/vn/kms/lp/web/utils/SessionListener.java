package vn.kms.lp.web.utils;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener,
        HttpSessionAttributeListener {
    private static int totalActiveSessions = 0;

    public static int getTotalActiveSessions() {
        return totalActiveSessions;
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        totalActiveSessions++;
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.err.println("create ....");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("destroy");
        if (totalActiveSessions > 0) {
            totalActiveSessions--;
        }
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
