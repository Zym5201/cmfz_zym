package com.baizhi.interceptor;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse rep = (HttpServletResponse)response;
        HttpSession session = req.getSession();
        Object admin = session.getAttribute("login_admin");
        if(admin!=null){
            chain.doFilter(request,response);
        }else{
            rep.sendRedirect(req.getContextPath()+"/back/admin/login.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}
