package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demo
 */
@WebServlet("/demo")
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{    
		PrintWriter out = response.getWriter();
	    Cookie[] cookies = request.getCookies();
	    if(cookies == null )
	    {
	    	out.print("<h1>No One Has Visited Me</h1>");
	    	Cookie cookiesx = new Cookie("Count","0");
	    	response.addCookie(cookiesx);
	    }
	    else 
	    {
	    	for (int i = 0; i < cookies.length; i++) 
			{
	    		int x = Integer.parseInt(cookies[i].getValue());
	    		x++;
	    		String z = Integer.toString(x);
	    		out.print(" This Page is "+ cookies[i].getValue()+" times visited...");
	    		cookies[i].setValue(z);
	    		response.addCookie(cookies[i]);
			}
	    }	
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
