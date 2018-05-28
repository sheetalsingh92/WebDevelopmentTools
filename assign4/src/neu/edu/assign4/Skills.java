package neu.edu.assign4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			Resume r3= (Resume) request.getSession().getAttribute("resumeabout");
			r3.setSkill1(request.getParameter("skill1"));
			r3.setRating1(request.getParameter("rating1"));
			r3.setSkill2(request.getParameter("skill2"));
			r3.setRating2(request.getParameter("rating2"));
			r3.setSkill3(request.getParameter("skill3"));
			r3.setRating3(request.getParameter("rating3"));
			request.getSession().setAttribute("r3", r3);
			response.sendRedirect("Output.jsp");
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
