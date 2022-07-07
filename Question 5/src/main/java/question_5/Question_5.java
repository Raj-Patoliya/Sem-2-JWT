package question_5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Question_5
 */
@WebServlet("/Question_5")
public class Question_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question_5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int i;
		String select = request.getParameter("parent");
		response.setContentType("text/html");
		if(select.equals("pdf")) {
			response.setContentType("application/pdf");
			OutputStream os = response.getOutputStream();
			InputStream is = getServletContext().getResourceAsStream("WEB-INF\\MTCA13201_JWT.pdf");
			while((i = is.read()) != -1) {
				os.write(i);
			}
		}
		else if(select.equals("image")) {
			response.setContentType("image/jpeg");
			OutputStream os = response.getOutputStream();
			InputStream is = getServletContext().getResourceAsStream("WEB-INF\\image.jpg");
			while((i = is.read()) != -1) {
				os.write(i);
			}
		}
		else if(select.equals("video")) {
			response.setContentType("video/mp4");
			OutputStream os = response.getOutputStream();
			InputStream is = getServletContext().getResourceAsStream("WEB-INF\\video.mkv");
			while((i = is.read()) != -1) {
				os.write(i);
			}
		}
	}
}
