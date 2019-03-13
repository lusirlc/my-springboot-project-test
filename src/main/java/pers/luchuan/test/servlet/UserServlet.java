package pers.luchuan.test.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By Chuan Lu On 2019/3/9 13:20
 */
@WebServlet(displayName = "UserServlet"
	,name = "UserServlet"
	,urlPatterns = {"/user/*","/user2/*"}
	,loadOnStartup = 1
	,initParams = {@WebInitParam(name="username",value = "张山")})
public class UserServlet extends HttpServlet {
	private String username;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		username = config.getInitParameter("username");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(username);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req,resp);
	}
}
