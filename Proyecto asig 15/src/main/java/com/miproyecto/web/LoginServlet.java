package com.miproyecto.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String usuario = req.getParameter("usuario");
        String pass = req.getParameter("password");

        if (("admin".equals(usuario) && "1234".equals(pass)) ||
            ("user".equals(usuario) && "pass".equals(pass))) {

            HttpSession session = req.getSession();
            session.setAttribute("usuario", usuario);
            res.sendRedirect(req.getContextPath() + "/perfil.jsp");

        } else {
            req.setAttribute("error", "Usuario o contraseña incorrectos");
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("logout".equals(action)) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}