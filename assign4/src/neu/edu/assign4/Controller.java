package neu.edu.assign4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.model.User;
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAction = request.getParameter("action");
		
	User user1 = (User) request.getSession().getAttribute("user");
		
		if(user1==null){
		
			response.sendRedirect(response.encodeRedirectURL("Login.jsp"));
			return;
			
	}
		if(userAction.equals("Login")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
			}
		
		if(userAction.equals("NextDashboard")){
	
			response.sendRedirect("About.jsp");
			}
		
		if(userAction.equals("nextabout")){
			
			RequestDispatcher rd = request.getRequestDispatcher("About");
			rd.forward(request, response);
			}
		if(userAction.equals("nexteducation")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Education");
			rd.forward(request, response);
			}

		if(userAction.equals("nextlocation")){
	
			RequestDispatcher rd = request.getRequestDispatcher("Location");
			rd.forward(request, response);
			}

		if(userAction.equals("nextskill")){
	
			RequestDispatcher rd = request.getRequestDispatcher("Skills");
			rd.forward(request, response);
			}
		
		if(userAction.equals("BackDashboard")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
			}

		if(userAction.equals("backabout")){
	
			RequestDispatcher rd = request.getRequestDispatcher("/Dashboard.jsp");
			rd.forward(request, response);
		}
		if(userAction.equals("backeducation")){
			
			RequestDispatcher rd = request.getRequestDispatcher("/About.jsp");
			rd.forward(request, response);
		}
		
if(userAction.equals("backLocation")){
			
			RequestDispatcher rd = request.getRequestDispatcher("/Education.jsp");
			rd.forward(request, response);
		}




	}
	


	
}
		


