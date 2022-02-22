package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchByIdServlet", urlPatterns = "/searchById")
public class SearchByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/ads/searchById.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);
//        DaoFactory.getAdsDao().updateAd(oldId, newId.id);
        Ad searchId = DaoFactory.getAdsDao().findById(id);
//        req.setAttribute("id", DaoFactory.getAdsDao().findById(id));
        req.setAttribute("searchId", searchId);
        req.getRequestDispatcher("/WEB-INF/ads/searchById.jsp").forward(req, resp);
//        resp.sendRedirect("/ads");
    }
}
