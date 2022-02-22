package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PasswordServlet", urlPatterns = "/password")
public class PasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/password.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        User updatedUser = DaoFactory.getUsersDao().findById(id);

        String password = req.getParameter("password");

        updatedUser.setPassword(password);

        System.out.println(id);

        DaoFactory.getUsersDao().updateUser(updatedUser);

        req.getSession().setAttribute("updatedUser", updatedUser);
        req.getSession().invalidate();
        resp.sendRedirect("/profile");

    }
}
