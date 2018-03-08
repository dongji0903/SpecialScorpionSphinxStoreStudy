package com.sphinx.beautea.common.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BttFilter implements Filter {
	private FilterConfig config;
	private String encoding;
	private String DEFAULT_ENCODING = "UTF-8";
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		encoding = config.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			request.setCharacterEncoding(encoding);
		} catch (UnsupportedEncodingException e) {
			encoding = DEFAULT_ENCODING;
			request.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		encoding = null;
		config = null;
	}


}
