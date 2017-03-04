package listeners;

import dao.h2.H2GunDao;
import dao.h2.H2UserDao;
import model.GunModel;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class Injector implements ServletContextListener {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        H2UserDao h2UserDao = new H2UserDao(dataSource);
        sce.getServletContext().setAttribute("UserDao", h2UserDao);
        sce.getServletContext().setAttribute("GunDao", new H2GunDao(
                dataSource,
                integer -> h2UserDao.get(integer).orElse(null),
                integer -> new GunModel().setId(integer)
        ));
    }
}
