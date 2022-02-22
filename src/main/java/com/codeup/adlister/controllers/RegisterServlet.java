package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input

        boolean inputHasErrors = false;
        if (username.isEmpty()) {
//            checks to see if user entered in a username if not, sends error message.
            request.getSession().setAttribute("error", "Please enter a username.");
            inputHasErrors = true;
        } else if (DaoFactory.getUsersDao().findByUsername(username) != null) {
            //            checks to see if username entered is in use. if it is, sends error message.
            request.setAttribute("userError", "That user name is already in use");
            inputHasErrors = true;
        }
        if (email.isEmpty()) {
//            checks to see if user entered an email address. if not an error message is sent.
            request.getSession().setAttribute("error", "Please enter an email.");
            inputHasErrors = true;
        }
        if (password.isEmpty()) {
//            checks to see if user entered a password. if not an error message is sent.
            request.getSession().setAttribute("error", "Please enter in a password for your account.");
            inputHasErrors = true;
        } else if (!password.equals(passwordConfirmation)) {
//            makes sure that passwords match. if not an error message is sent.
            request.getSession().setAttribute("error", "Your passwords do not match. Please re-enter.");
            inputHasErrors = true;
        }



        if (inputHasErrors) {
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            try {
//               if there are errors, user is sent back to register and info is not submitted.
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            // create and save a new user
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");





        }

    }
}