package controller;

import model.*;
import userService.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/SaveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name= request.getParameter("name");
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setGender(gender);
		user.setUsername(username);
		user.setPassword(password);
		try {
			UserDao.saveUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("Login.jsp");
	}
}
