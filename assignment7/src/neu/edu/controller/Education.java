package neu.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.ResumeDetails;
import neu.edu.model.Resume;
import neu.edu.model.User;

/**
 * Servlet implementation class Education
 */
@WebServlet("/Education")
public class Education extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Education() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
User user1 = (User) request.getSession().getAttribute("user");
		
		if(user1==null){
		
			response.sendRedirect(response.encodeRedirectURL("Login.jsp"));
			
	}else{
			ResumeDetails resumedb= (ResumeDetails) request.getSession().getAttribute("resumedb");
			resumedb.setEducation(request.getParameter("education"));
			resumedb.setGpa(request.getParameter("gpa"));
			//request.getSession().setAttribute("r1", r1);
			response.sendRedirect("Location.jsp");
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
