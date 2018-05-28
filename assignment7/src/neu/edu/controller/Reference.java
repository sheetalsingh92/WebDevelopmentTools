package neu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.ResumeDetails;
import neu.edu.model.User;

/**
 * Servlet implementation class Reference
 */
@WebServlet("/Reference")
public class Reference extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reference() {
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
			
	}
		else{
			ResumeDetails resumedb= (ResumeDetails) request.getSession().getAttribute("resumedb");
			resumedb.setReference(request.getParameter("reference"));
			
			//request.getSession().setAttribute("r2", r2);
			response.sendRedirect("Skill.jsp");
		
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
