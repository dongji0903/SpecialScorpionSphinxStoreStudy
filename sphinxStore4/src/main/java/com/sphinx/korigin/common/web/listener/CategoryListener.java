package com.sphinx.korigin.common.web.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class CategoryListener implements ApplicationContextAware {

	private WebApplicationContext context;
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context=(WebApplicationContext) applicationContext;
		System.out.println("리스너 동작함");
	}

}
