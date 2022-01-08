package stu.xuronghao.ledger.controller.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/Admin/*","/"}, filterName = "securityRequestFilter")

public class AdminLoginFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(AdminLoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        log.info(req.getRequestURI());
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
