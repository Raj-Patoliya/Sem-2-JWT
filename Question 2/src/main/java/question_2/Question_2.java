package question_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Question_2
 */
@WebServlet("/Question_2")
public class Question_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	      PrintWriter out = response.getWriter();  
	        
	    Enumeration<String> enums = request.getHeaderNames();  
	    out.print("<table style='border:2px solid black'");	        	      
	        while (enums.hasMoreElements()) {  
		        String headerName = (String) enums.nextElement();  
		        String headerValue = request.getHeader(headerName);  
		        out.print("<tr>");	        
		        out.print("<td style='border:2px solid black'>"+headerName + " </td><td style='border:2px solid black'> "+ headerValue + "</td><br>");  
		        out.print("</tr>");	        
	        }
	        out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
