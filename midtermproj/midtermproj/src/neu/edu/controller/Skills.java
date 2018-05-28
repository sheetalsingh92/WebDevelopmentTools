package neu.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.dao.UserAccountDAO;
import neu.edu.db.entity.Resumedb;
import neu.edu.model.Resume;
import neu.edu.model.User;

/**
 * Servlet implementation class Skills
 */
@WebServlet("/Skills")
public class Skills extends HttpServlet {
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
User user1 = (User) request.getSession().getAttribute("user");
		
		if(user1==null){
		
			response.sendRedirect(response.encodeRedirectURL("Login.jsp"));
			
	}else{
			Resumedb resume= (Resumedb) request.getSession().getAttribute("resumedb");
		
			resume.setSkill1(request.getParameter("skill1"));
			resume.setRating1(request.getParameter("rating1"));
			resume.setSkill2(request.getParameter("skill2"));
			resume.setRating2(request.getParameter("rating2"));
			resume.setSkill3(request.getParameter("skill3"));
			resume.setRating3(request.getParameter("rating3"));
			//request.getSession().setAttribute("r3", r3);
			
			UserAccountDAO userAccountDAO = new UserAccountDAO();
			
			userAccountDAO.insertresumevaluesDAO(resume);
			response.sendRedirect("Dashboard.jsp");
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
