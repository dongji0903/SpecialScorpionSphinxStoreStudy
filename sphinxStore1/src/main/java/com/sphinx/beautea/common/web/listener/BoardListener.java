package com.sphinx.beautea.common.web.listener;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class BoardListener implements ApplicationContextAware {

	private final int amount = 12;
	
	@Override
	public void setApplicationContext(ApplicationContext ctxt)
			throws BeansException {

		WebApplicationContext webContext = (WebApplicationContext) ctxt;
		ServletContext context = webContext.getServletContext();
		context.setAttribute("amount", amount);
	}

}
