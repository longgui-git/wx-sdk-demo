package cn.trawe.operation.base.third.common.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 跨域过滤器
 *
 * @author 岩
 * @date 2018/6/5
 */
@WebFilter(filterName = "CORSFilter", urlPatterns = "/*")
@Component
public class CORSFilter implements Filter {
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----启动跨域过滤器----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, X-Token, token");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
