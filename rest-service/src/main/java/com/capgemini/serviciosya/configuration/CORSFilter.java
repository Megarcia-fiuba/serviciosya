package com.capgemini.serviciosya.configuration;

import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CORSFilter implements Filter {


    public CORSFilter () {

        super ();
    }


    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept");
        filterChain.doFilter (servletRequest, servletResponse);
    }

    @Override
    public void destroy () {}

    @Override
    public void init (FilterConfig arg0) {}
}