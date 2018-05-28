package neu.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.dao.UserAccountDAO;
import neu.edu.db.entity.Resumedb;
import neu.edu.model.User;


/**
 * Servlet implementation class Login
 */
@WebServlet(value = "/Login", 
initParams = 
{ 	@WebInitParam(name = "SUCCESS", value = "Dashboard.jsp"),
	@WebInitParam(name = "FAIL", value = "Login.jsp") 
})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
		request.getSession().invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		Resumedb resume;
		//boolean isLogin = false;
		UserAccountDAO userAccountDAO = new UserAccountDAO();
		 resume = userAccountDAO.validateLogin(userParam, passwordParam);
		
	
		HttpSession session = request.getSession();
		String nextPage = "SUCCESS";
		if (resume ==null) {
			nextPage = "FAIL";
			
			request.setAttribute("login-error", "username-password-mismatch");
			String url = getServletConfig().getInitParameter(nextPage);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		
		} 
		
		else if(resume !=null)
		{
			User userSession= null;
			nextPage = "SUCCESS";
			//HttpSession session = request.getSession();
			resume.setFlag(userAccountDAO.getFlagValue(userParam));
			userSession = new User();

			userSession.setName(userParam);
			userSession.setSessionId(session.getId());
			userSession.setActive(true);
			session.setAttribute("user", userSession);
			session.setAttribute("resumedb", resume);
			
			if (resume.getFlag()!=0){
				
				String url = getServletConfig().getInitParameter(nextPage);

				//RequestDispatcher rd = request.getRequestDispatcher("/"+url);
				//rd.forward(request, response);
				
				response.sendRedirect(response.encodeRedirectURL(url));
			}
			else
			{
				response.sendRedirect(response.encodeRedirectURL("InsertDetails.jsp"));
			}
		}
		
	
	}

}
