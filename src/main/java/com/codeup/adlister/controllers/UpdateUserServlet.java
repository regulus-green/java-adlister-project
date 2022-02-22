// updateUserServlet

package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
//        long id = Long.parseLong(req.getParameter("id"));
//        req.setAttribute("id", id);
//        System.out.println(id);
        req.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        User updatedUser = DaoFactory.getUsersDao().findById(id);//        System.out.println(updatedUser.getEmail());
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        updatedUser.setUsername(username);;
        updatedUser.setEmail(email);

        System.out.println(id);
        System.out.println(username);
        System.out.println(email);


        DaoFactory.getUsersDao().updateUser(updatedUser);


        req.getSession().setAttribute("updatedUser", updatedUser);
        req.getSession().invalidate();
        resp.sendRedirect("/profile");
    }

}
