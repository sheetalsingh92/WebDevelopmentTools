package neu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Skills
 */
public class Skills extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Skills() {
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
		String[] skill1 = request.getParameterValues("skill1");
		String[] rating1 = request.getParameterValues("rating1");
		String[] skill2 = request.getParameterValues("skill2");
		String[] rating2 = request.getParameterValues("rating2");
		String[] skill3 = request.getParameterValues("skill3");
		String[] rating3 = request.getParameterValues("rating3");
		
	
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
		response.getWriter().println("Skills");
		pw.append("<br/>");
		for (String s: skill1 )
			if(!s.equals(""))
		{	response.getWriter().println("Skill Name->" +" "+s);
			pw.append(" ");
			pw.append(" ");
		for (String p:rating1)
		{
			if(!s.equals("") && !p.equals(""))
			response.getWriter().println("Skill Rating->" +" "+Integer.parseInt(p)*10+"%");
			
		}
		}
		pw.append("</div>");
		pw.append("<div>");
		for (String s: skill2)
			if(!s.equals(""))
		{	response.getWriter().println("Skill Name->" +" "+s);
		pw.append(" ");
		pw.append(" ");
		for (String p:rating2)
		{	if(!s.equals("") && !p.equals(""))
			response.getWriter().println("Skill Rating->" +" "+Integer.parseInt(p)*10+"%");
		}
		}
		pw.append("</div>");
		pw.append("<div>");
		for (String s: skill3)
		{	if(!s.equals(""))
			response.getWriter().println("Skill Name->" +" "+s);
		pw.append(" ");
		pw.append(" ");
		for (String p:rating3)
		{	if(!s.equals("") && !p.equals(""))
			response.getWriter().println("Skill Rating->" +" "+Integer.parseInt(p)*10+"%");
		}
		}
		pw.append("</div>");
		pw.append("</div>");
		pw.append("</div>");
		pw.append("</body>");
		pw.append("</html>");
	}

}
