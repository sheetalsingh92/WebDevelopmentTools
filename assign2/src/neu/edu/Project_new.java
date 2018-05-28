package neu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Project_new
 */
public class Project_new extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Project_new() {
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
		String[] project1 = request.getParameterValues("project1");
		String[] projectdesc1 = request.getParameterValues("projectdesc1");
		String[] project2 = request.getParameterValues("project2");
		String[] projectdesc2 = request.getParameterValues("projectdesc2");
		String[] project3 = request.getParameterValues("project3");
		String[] projectdesc3 = request.getParameterValues("projectdesc3");
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
		response.getWriter().println("Project Details");
		pw.append("<br/>");
		for (String s: project1)
			if(!s.equals(""))
		{	response.getWriter().println("Project Name->" +" "+s);
			pw.append("<br/>");
		for (String p:projectdesc1)
		{
			if(!s.equals("") && !p.equals(""))
			response.getWriter().println("Project Description->" +" "+p);
			
		}
		}
		pw.append("</div>");
		pw.append("<div>");
		for (String s: project2)
			if(!s.equals(""))
		{	response.getWriter().println("Project Name->" +" "+s);
		pw.append("<br/>");
		for (String p:projectdesc2)
		{	if(!s.equals("") && !p.equals(""))
			response.getWriter().println("Project Description->" +" "+p);
		}
		}
		pw.append("</div>");
		pw.append("<div>");
		for (String s: project3)
		{	if(!s.equals(""))
			response.getWriter().println("Project Name->" +" "+s);
			pw.append("<br/>");
		for (String p:projectdesc3)
		{	if(!s.equals("") && !p.equals(""))
			response.getWriter().println("Project Description->" +" "+p);
		}
		}
		pw.append("</div>");
		pw.append("</div>");
		pw.append("</body>");
		
		pw.append("</html>");
		RequestDispatcher rd =request.getRequestDispatcher("/Skills");
		rd.include(request, response);
	}

}
