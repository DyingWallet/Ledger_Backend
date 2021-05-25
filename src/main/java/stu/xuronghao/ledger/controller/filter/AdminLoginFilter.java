package stu.xuronghao.ledger.controller.filter;

import stu.xuronghao.ledger.utils.ConstantVariable;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@ServletComponentScan
//@Component("securityRequestFilter")
@WebFilter(urlPatterns = "/Admin/*", filterName = "securityRequestFilter")

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
        if ((req.getRequestURI().contains("login") || session.getAttribute("admin") != null || req.getRequestURI().contains("/adminLogin")) || (req.getRequestURI().contains("/img/"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            wrapper.sendRedirect("/Admin/login");
        }

    }

    @Override
    public void destroy() {

    }
}
