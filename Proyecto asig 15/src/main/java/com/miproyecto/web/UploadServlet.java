package com.miproyecto.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
String path=getServletContext().getRealPath("")+"uploads";
File d=new File(path); if(!d.exists()) d.mkdir();
Part f=req.getPart("file");
String name=f.getSubmittedFileName();
f.write(path+File.separator+name);
req.setAttribute("message","Archivo "+name+" subido exitosamente.");
req.getRequestDispatcher("perfil.jsp").forward(req,res);
}
}
