package com.miproyecto.web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(urlPatterns={"/perfil.jsp","/upload"})
public class AuthFilter implements Filter {
public void doFilter(ServletRequest r,ServletResponse s,FilterChain c)throws IOException,ServletException{
HttpServletRequest rq=(HttpServletRequest)r;
HttpServletResponse rs=(HttpServletResponse)s;
HttpSession ses=rq.getSession(false);
if(ses!=null && ses.getAttribute("usuario")!=null){
c.doFilter(r,s);
}else{
rs.sendRedirect(rq.getContextPath()+"/login.jsp");
}
}
}
