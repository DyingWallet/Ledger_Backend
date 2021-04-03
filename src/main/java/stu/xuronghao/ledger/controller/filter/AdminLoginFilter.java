package stu.xuronghao.ledger.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@ServletComponentScan
//@Component("securityRequestFilter")
@WebFilter(urlPatterns = "/admin/*", filterName = "securityRequestFilter")

public class AdminLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        System.out.println(req.getRequestURI());
        //登录则放行
        if ((req.getRequestURI().indexOf("/login") != -1 || session.getAttribute("admin") != null || req.getRequestURI().indexOf("/adminlogin") != -1) || (req.getRequestURI().indexOf("/img/") != -1)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            wrapper.sendRedirect("/admin/login");
        }

    }

    @Override
    public void destroy() {

    }
}
