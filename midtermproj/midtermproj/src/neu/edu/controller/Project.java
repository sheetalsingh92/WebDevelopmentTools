package neu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.db.entity.Resumedb;
import neu.edu.model.User;

/**
 * Servlet implementation class Project
 */
@WebServlet("/Project")
public class Project extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Project() {
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
			Resumedb resumedb= (Resumedb) request.getSession().getAttribute("resumedb");
			resumedb.setProject1(request.getParameter("project1"));
			resumedb.setProjectdesc1(request.getParameter("projectdesc1"));
			resumedb.setProject2(request.getParameter("project2"));
			resumedb.setProjectdesc2(request.getParameter("projectdesc2"));
			resumedb.setProject3(request.getParameter("project3"));
			resumedb.setProjectdesc3(request.getParameter("projectdesc3"));
			//request.getSession().setAttribute("r2", r2);
			response.sendRedirect("References.jsp");
		
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
