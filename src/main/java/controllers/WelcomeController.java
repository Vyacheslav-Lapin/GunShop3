package controllers;

import dao.GunDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static model.User.FIRST_NAME_KEY;

@WebServlet("/")
public class WelcomeController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_GUNS_KEY = "AllGuns";

    private GunDao gunDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        gunDao = (GunDao) config.getServletContext().getAttribute("GunDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
                .map(o -> String.format("Hello, %s!", o))
                .orElse("Hello!");

        req.setAttribute(WELCOME_KEY, s);
        req.setAttribute(ALL_GUNS_KEY, gunDao.getAll());

        req.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(req, resp);
    }
}
