package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import dao.ExpressDAO; 
import dao.UserDAO;
//import entity.Express;

public class LogInServlet extends HttpServlet{
    
	private UserDAO userDAO = UserDAO.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int isLogSuccess = -1;
		HttpSession session=request.getSession();
		System.out.println(username+" "+password);
		session.setAttribute("username", username);
	
		isLogSuccess = userDAO.logIn(username, password);
	
		if(isLogSuccess==1){
		
			response.sendRedirect("vote");
			//普通用户
		}
		else if(isLogSuccess==2){
			response.sendRedirect("MainMenu.html");
			//管理员
		}
		else 
			{
			 out.println("<script language='javascript'>alert('用户名或密码错误，请重新输入！')</script>");
	            out.println("<script language='javascript'>window.location.href='login.html'</script>");
			}
		/*用户名或密码错误，报错*/
		/*用户名判断正确跳转页面*/

	}


}
