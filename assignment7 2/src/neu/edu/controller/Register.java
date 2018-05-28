package neu.edu.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import neu.edu.ResumeDetails;
import neu.edu.dao.UserAccountDAO;
import neu.edu.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Autowired
    private UserAccountDAO userAccountDAO;

    @Autowired
    private ResumeDetails resumedb;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userParam = request.getParameter("user");
		String passwordParam = request.getParameter("pass");
		String name = request.getParameter("name");
		String dob =request.getParameter("dob");
		
		String gender= request.getParameter("gender");
		resumedb.setUsername(userParam);
		resumedb.setPassword(passwordParam);
		resumedb.setName(name);
		resumedb.setGender(gender);
		resumedb.setDob(dob);
	
		 Boolean rs =  userAccountDAO.insertDAO(resumedb);
		if(rs==false)
		{
			request.setAttribute("register-error", "User with this name already exists!!!");
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		else{
		response.sendRedirect("Login.jsp");
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
