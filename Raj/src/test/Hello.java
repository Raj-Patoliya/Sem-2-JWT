package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = (String) request.getSession().getAttribute("login");
		String name = request.getParameter("login");
		response.getWriter().append(name);
		if(login != null)
		{
			response.getWriter().append(login);
			//response.sendRedirect("index.jsp");
		}
		else
		{
			response.getWriter().append(login);
			//response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("Raj") && password.equals("123"))
		{
			request.setAttribute("username", username);
			HttpSession session = request.getSession();
			session.setAttribute("login", "1");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("error", "Invalid Login");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
}
