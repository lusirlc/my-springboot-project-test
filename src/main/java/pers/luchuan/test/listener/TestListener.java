package pers.luchuan.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created By Chuan Lu On 2019/3/9 15:52
 */
@WebListener
public class TestListener implements ServletContextListener{
	
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("Servlet has initialized");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("Servlet has destroyed");
	}
}
