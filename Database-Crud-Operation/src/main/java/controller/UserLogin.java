package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import userService.UserDao;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
			ResultSet rs = UserDao.getAllUser();
			out.print("<table style='border:1px solid black;'>");
			out.print("<tr>");
			out.print("<td> Id</td>");
			out.print("<td> Name </td>");
			out.print("<td> UserName</td>");
			out.print("<td> Password</td>");
			out.print("<td> Gender</td>");
			out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
				out.print("<td> "+rs.getInt("id")+"<br></td>");
				out.print("<td> "+rs.getString("name")+"<br></td>");
				out.print("<td> "+rs.getString("username")+"<br></td>");
				out.print("<td>  "+rs.getString("password")+"<br></td>");
				out.print("<td> "+rs.getString("gender")+"<br></td>");
				out.print("<tr>");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Login login = new Login();
		login.setPassword(password);
		login.setUsername(username);
		
		try {
			ResultSet rs = UserDao.loginAuth(login);
			out.print("<table style='border:1px solid black;'>");
			out.print("<tr>");
			out.print("<td> Id</td>");
			out.print("<td> Name </td>");
			out.print("<td> UserName</td>");
			out.print("<td> Password</td>");
			out.print("<td> Gender</td>");
			out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
				out.print("<td> "+rs.getInt("id")+"<br></td>");
				out.print("<td> "+rs.getString("name")+"<br></td>");
				out.print("<td> "+rs.getString("username")+"<br></td>");
				out.print("<td>  "+rs.getString("password")+"<br></td>");
				out.print("<td> "+rs.getString("gender")+"<br></td>");
				out.print("<tr>");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
