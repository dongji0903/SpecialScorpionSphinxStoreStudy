package com.sphinx.beautea.common.web.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FilePath implements ServletContextListener {

	private final int amount = 12;
	
    public FilePath() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	final String NeverPath = arg0.getServletContext().getRealPath("/") + "WEB-INF\\readfilepath\\";
    	final String CountryCode = NeverPath + "countrycode.txt";
    	final String EmailPath = NeverPath + "email.txt"; //이메일
    	final String useability = NeverPath + "useability.txt";
    	final String agreePrivacy = NeverPath + "agreePrivacy.txt";
    	arg0.getServletContext().setAttribute("emailtxt", EmailPath);
    	arg0.getServletContext().setAttribute("amount", amount);
    	arg0.getServletContext().setAttribute("countrycode", CountryCode);
    	arg0.getServletContext().setAttribute("useability", useability);
    	arg0.getServletContext().setAttribute("agreePrivacy", agreePrivacy);
         // TODO Auto-generated method stub
    }
	
}
