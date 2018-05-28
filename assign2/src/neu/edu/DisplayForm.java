package neu.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayForm
 */
public class DisplayForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DisplayForm() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		String title = request.getParameter("radioField");
		String fullName = request.getParameter("fullname");
		String DOB = request.getParameter("DOB");
		String addressType = request.getParameter("addresstype");
		String address = request.getParameter("address");
		String ssn = request.getParameter("ssn");
		String phoneNumber = request.getParameter("phonenumber");
		PrintWriter pw = response.getWriter();
		pw.append("<html>");
		pw.append("<head>");
		pw.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		pw.append("<title>Person Details</title>");

		pw.append(
				"<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\"/>");
		pw.append("<style>");
		pw.append(".invalid{");
		pw.append("color:red;");
		pw.append("}");
		pw.append(".valid{");
		pw.append("color:green;");
		pw.append("}");
		pw.append("</style>");
		pw.append("</head>");
		pw.append("<body>");
		pw.append("<div class=\"container\">");
		
		pw.append("		<h1><u>Values Captured are:</u></h1>");
		pw.append("		<h2 class=\"valid\"><u>Name:</u> " + title + "  " + fullName + "</h2>");

		ServletConfig config = getServletConfig();
		String dateValue = config.getInitParameter("chkdate");
		if (DOB.matches(dateValue)) {

			pw.append("		<h2 class=\"valid\">Date of Birth: " + DOB + "</h2>");

		} else {
			pw.append("		<h2 class=\"invalid\">Invalid input for Date of Birth</h2>");

		}
		pw.append("		<h2 class=\"valid\"><u>Address Type:</u> " + addressType + "</h2>");
		pw.append("		<h2 class=\"valid\"><u>Address:</u> " + address + "</h2>");
		String ssnValue = config.getInitParameter("checkssn");
		if (ssn.matches(ssnValue)) {

			pw.append("		<h2 class=\"valid\"><u>Last four digit of SSN:</u> " + ssn + "</h2>");

		} 
		else {
			pw.append("		<h2 class=\"invalid\">Invalid input for SSN</h2>");

		}
		
		String PhoneValue = config.getInitParameter("checkBoxMin");

		if (phoneNumber.matches(PhoneValue)) {

			pw.append("		<h2 class=\"valid\"><u>Phone Number:</u>" + phoneNumber + "</h2>");

		} else {
			pw.append("		<h2 class=\"invalid\">Invalid input for Phone Number</h2>");

		}

		pw.append("</div>");
		pw.append("</form>");
		pw.append("</body>");
		pw.append("</html>");

	}
	
}
