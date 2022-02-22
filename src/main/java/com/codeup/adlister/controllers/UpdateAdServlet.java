package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="UpdateAdServlet", urlPatterns = "/updateAd")
public class UpdateAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
        long id = Long.parseLong(req.getParameter("id"));

//        System.out.println(id);
        req.setAttribute("id", id);
        Ad updatedAd = DaoFactory.getAdsDao().findById(id);
//        System.out.println(updatedAd);

        req.setAttribute("updatedAd", updatedAd );
        req.getRequestDispatcher("/WEB-INF/ads/updateAd.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);
        Ad updated = DaoFactory.getAdsDao().findById(id);
        System.out.println(updated.getTitle());
        System.out.println(updated.getId());
        String title = req.getParameter("title");
        updated.setTitle(title);

        String description = req.getParameter("description");
        updated.setDescription(description);

        System.out.println(updated.getId());
        System.out.println(updated.getUserId());
        System.out.println(updated.getTitle());
        System.out.println(updated.getDescription());
        DaoFactory.getAdsDao().updateAd(updated);
        req.getSession().setAttribute("updatedAd", updated);

        resp.sendRedirect("/profile");
    }
}
