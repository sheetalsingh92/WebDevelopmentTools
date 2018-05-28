package neu.edu.assign4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		boolean isLogin = false;
		
		
		if ("pass".equals(passwordParam)) {
			isLogin = true;
		}
		HttpSession session = request.getSession();
		String nextPage = "SUCCESS";
		if (!isLogin) {
			nextPage = "FAIL";
			
			request.setAttribute("login-error", "username-password-mismatch");
		} else {
			
			User user = new User();
			user.setName(userParam);
			user.setSessionId(session.getId());
			user.setActive(true);

			session.setAttribute("user", user);

		}
		String url = getServletConfig().getInitParameter(nextPage);

		//RequestDispatcher rd = request.getRequestDispatcher("/"+url);
		//rd.forward(request, response);
		
		response.sendRedirect(response.encodeRedirectURL(url));
	}

}
