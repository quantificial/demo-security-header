package com.example.demoheader;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SecurityHeaderFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    String url = "";
    String queryString = "";
    if (request instanceof HttpServletRequest) {
    	 url = ((HttpServletRequest)request).getRequestURL().toString();
    	 queryString = ((HttpServletRequest)request).getQueryString();
    	 
    	 log.info(url);
    	 log.info(queryString);
    }
    
    if(url.contains(".js")) {
    	httpServletResponse.setHeader("Content-Security-Policy", "script-src 'self'; object-src 'self'; frame-ancestors 'none'");
    }else {
    	httpServletResponse.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-eval'; object-src 'self'; frame-ancestors 'none'");
    }
    
    
    //httpServletResponse.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-eval'; object-src 'self'; frame-ancestors 'none'");
    //httpServletResponse.setHeader("Content-Security-Policy", "script-src 'self'; object-src 'self'; frame-ancestors 'none'");
    httpServletResponse.setHeader("X-Content-Type-Options", "nosniff");
    httpServletResponse.setHeader("X-Frame-Options", "DENY");
    httpServletResponse.setHeader("X-XSS-Protection", "1; mode=block");
    httpServletResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
  }

}
