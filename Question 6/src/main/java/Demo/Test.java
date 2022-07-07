package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Cookie[] ck =  request.getCookies();
		int c = 0;
		if(ck != null)
		{
			for(int i = 0;i<ck.length;i++)
			{
				if(ck[i].getName().equals("count"))
				{
					c=1;
					ck[i].setValue(String.valueOf(1+Integer.parseInt(ck[i].getValue())));
					response.addCookie(ck[i]);
					out.print("<h1> The Nos of Count is "+ck[i].getValue()+"</h1>");
				}
			}
		}
		if(c==0)
		{
			Cookie ck1 =  new Cookie("count","1");
			response.addCookie(ck1);
			out.print("<h1> The Nos of Count is "+ck1.getValue()+"</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.sendRedirect("Home.jsp");
	}
}
