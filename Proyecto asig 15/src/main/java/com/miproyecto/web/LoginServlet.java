package com.miproyecto.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
String u=req.getParameter("usuario");
String p=req.getParameter("password");
if(("admin".equals(u)&&"1234".equals(p))||("user".equals(u)&&"pass".equals(p))){
HttpSession s=req.getSession();
s.setAttribute("usuario",u);
res.sendRedirect("perfil.jsp");
}else{
req.setAttribute("error","Usuario o contraseña incorrectos");
req.getRequestDispatcher("login.jsp").forward(req,res);
}
}
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
if("logout".equals(req.getParameter("action"))){
HttpSession s=req.getSession(false);
if(s!=null)s.invalidate();
}
res.sendRedirect("login.jsp");
}
}
