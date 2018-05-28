package neu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Education_new
 */
public class Education_new extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Education_new() {
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
		String education = request.getParameter("education");
		String gpa = request.getParameter("gpa");
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
		response.getWriter().println("Education->"+education);
		pw.append("<br/>");
		response.getWriter().println("GPA->"+gpa);
		pw.append("</div>");
		pw.append("</div>");
		pw.append("</body>");
		pw.append("</html>");
		RequestDispatcher rd =request.getRequestDispatcher("/Project_new");
		rd.include(request, response);
	}

}
