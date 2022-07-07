package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import userDao.UserService;

/**
 * Servlet implementation class UserAuth
 */
@WebServlet("/UserAuth")
public class UserAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
	   	String password = request.getParameter("password");
	   	Login login = new Login();
	   	login.setUsername(username);
	   	login.setPassword(password);
	   	ResultSet rs = null;
	   	try {
			rs = UserService.login(login);
		} catch (Exception e) {

			response.sendRedirect("Login.jsp");
		}
		request.setAttribute("rs", rs);
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}
}
