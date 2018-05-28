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

import neu.edu.db.entity.Resumedb;
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
		Resumedb resume = (Resumedb) request.getSession().getAttribute("resumedb");
		if(userAction.equals("Register")){
			RequestDispatcher rd = request.getRequestDispatcher("Register");
			rd.forward(request, response);	
		}
		else if(userAction.equals("Login")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
			}
		
		else if(userAction.equals("NextInsertDetails")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Insert");
			rd.forward(request, response);
			}
		else if(userAction.equals("NextDashboard")){
	
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard");
			rd.forward(request, response);
			}
		
		else if(userAction.equals("nextabout")){
			
			RequestDispatcher rd = request.getRequestDispatcher("About");
			rd.forward(request, response);
			}
		else if(userAction.equals("nexteducation")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Education");
			rd.forward(request, response);
			}

		else if(userAction.equals("nextlocation")){
	
			RequestDispatcher rd = request.getRequestDispatcher("Location");
			rd.forward(request, response);
			}

		else if(userAction.equals("nextskill")){
	
			RequestDispatcher rd = request.getRequestDispatcher("Skills");
			rd.forward(request, response);
			}
		
		else if(userAction.equals("BackDashboard")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
			}

		else if(userAction.equals("backabout")){
			System.out.println(resume.getFlag());
			if(resume.getFlag()==0)
			{RequestDispatcher rd = request.getRequestDispatcher("/InsertDetails.jsp");
			rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Dashboard.jsp");
				rd.forward(request, response);
			}
		}
		else if(userAction.equals("backeducation")){
			
			RequestDispatcher rd = request.getRequestDispatcher("/About.jsp");
			rd.forward(request, response);
		}
		
		else if(userAction.equals("backLocation")){
			
			RequestDispatcher rd = request.getRequestDispatcher("/Education.jsp");
			rd.forward(request, response);
			}

		else if(userAction.equals("displayresume")){
	
			RequestDispatcher rd = request.getRequestDispatcher("ViewDetails");
			rd.forward(request, response);
		}
		
		else if(userAction.equals("backviewdetails")){
			
			RequestDispatcher rd = request.getRequestDispatcher("/Dashboard.jsp");
			rd.forward(request, response);
		}
		
		else if(userAction.equals("nextproject")){
			
			RequestDispatcher rd = request.getRequestDispatcher("Project");
			rd.forward(request, response);
		}
		else if(userAction.equals("backproject")){
	
		RequestDispatcher rd = request.getRequestDispatcher("/Location.jsp");
		rd.forward(request, response);
		}
		else if(userAction.equals("nextreference")){
	
			RequestDispatcher rd = request.getRequestDispatcher("Reference");
			rd.forward(request, response);
		}
		else if(userAction.equals("backreference")){
	
			RequestDispatcher rd = request.getRequestDispatcher("/Project.jsp");
			rd.forward(request, response);
		}
		else if(userAction.equals("backskill")){
	
			RequestDispatcher rd = request.getRequestDispatcher("/References.jsp");
			rd.forward(request, response);
		}
		
		else if(userAction.equals("loginregister")){
			
			response.sendRedirect(response.encodeRedirectURL("Register.jsp"));
		}




	}
	


	
}
		


