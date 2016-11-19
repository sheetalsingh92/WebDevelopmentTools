package neu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1
 */
@WebServlet("/S1")
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResumePojo resume = new ResumePojo();
		resume.setName(request.getParameter("name"));
		resume.setAbout(request.getParameter("about"));
		resume.setLocation(request.getParameter("location"));
		resume.setEducation(request.getParameter("education"));
		resume.setGpa(request.getParameter("gpa"));
		resume.setProject1(request.getParameter("project1"));
		resume.setProject2(request.getParameter("project2"));
		resume.setProjectdesc1(request.getParameter("projectdesc1"));
		resume.setProjectdesc2(request.getParameter("projectdesc2"));
		resume.setProject3(request.getParameter("project3"));
		
		resume.setProjectdesc3(request.getParameter("projectdesc3"));
		resume.setSkill1(request.getParameter("skill1"));
		resume.setRating1(request.getParameter("rating1"));
		resume.setSkill2(request.getParameter("skill2"));
		resume.setRating2(request.getParameter("rating2"));
		resume.setSkill3(request.getParameter("skill3"));
		resume.setRating3(request.getParameter("rating3"));
		
		request.setAttribute("resume", resume);
		request.getRequestDispatcher("/ResumeOutput.jsp").forward(request, response);
		
		
	}

}
