package com.commerce.controller;
import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commerce.model.dao.AdminDao;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/AuthServlet")

public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao loginDao;

    public void init() {
        loginDao = new AdminDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("AuthAdmin.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String username = request.getParameter("login");
        String password = request.getParameter("pass");
        System.out.println("login: "+username);
        System.out.println("pass: "+password);
        if (loginDao.validate(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminServlet");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Welcome.jsp");
        }
    }
}