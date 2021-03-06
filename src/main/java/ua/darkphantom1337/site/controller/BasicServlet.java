package ua.darkphantom1337.site.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        String subDomain = req.getServerName().split("\\.")[0];
        System.out.println(subDomain);
        if (subDomain.equals("hosting")){
            req.getRequestDispatcher("/WEB-INF/view/hosting_main.jsp").forward(req,resp);
            //resp.getOutputStream().write("Hello world".getBytes());
            return;
        }
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req,resp);
        resp.getOutputStream().write(("Hello  host =- " + subDomain ).getBytes());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
