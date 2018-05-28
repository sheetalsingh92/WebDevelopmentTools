package neu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class About
 */
public class About extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public About() {
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
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String about = request.getParameter("about");
		PrintWriter pw = response.getWriter();
		pw.append("<html>");
		pw.append("<head>");
		pw.append(
				"<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\"/>");
		
		pw.append("<style>");
		pw.append(".container{");
		pw.append("margin-top:10px;");
		pw.append("}");
		pw.append("</style>");
		pw.append("</head>");
		pw.append("<body>");
		pw.append("<div class=\"container\">");
		pw.append("<div>");
		response.getWriter().println("Name->"+name);
		pw.append("</div>");
	
		pw.append("<div>");
		response.getWriter().println("About Me->"+about);
		pw.append("</div>");
		pw.append("</div>");
		pw.append("</body>");
		pw.append("</html>");
		RequestDispatcher rd =request.getRequestDispatcher("/Location");
		rd.include(request, response);
	}

}
