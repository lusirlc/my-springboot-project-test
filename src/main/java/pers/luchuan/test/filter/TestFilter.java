package pers.luchuan.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created By Chuan Lu On 2019/3/9 15:16
 */
@WebFilter(filterName = "TestFilter", servletNames = "UserServlet")
public class TestFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("Filter work");
		filterChain.doFilter(servletRequest,servletResponse);
	}
	
	@Override
	public void destroy() {
	
	}
}
