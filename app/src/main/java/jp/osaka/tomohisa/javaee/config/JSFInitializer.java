package jp.osaka.tomohisa.javaee.config;

import java.time.LocalDateTime;

import jakarta.faces.webapp.FacesServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration;

//@WebListener
public class JSFInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");

        // index.html をデフォルトページに設定
        servletContext.setInitParameter("welcome-file-list", "index.xhtml");

        // FacesServlet の登録
        ServletRegistration.Dynamic facesServlet = (ServletRegistration.Dynamic) servletContext
                .addServlet("FacesServlet", FacesServlet.class);

        if (facesServlet != null) {
            facesServlet.addMapping("/app/*");
        }

        servletContext.setAttribute("serverStartMessage",
                "サーバが起動しました。");
        servletContext.setAttribute("serverStartTime",
                LocalDateTime.now().toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 何もしない
    }

}
