package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("<html>");
		pw.append(" <head>");
		pw.append("<link type=\"text/css\" rel=\"stylesheet\" href=\"<%=request.getContextPath()%>/Style.css\"/>");
		pw.append("<title>Sheetal Singh Resume</title>");
		pw.append("<style>");
		pw.append("body");
		pw.append("{");
		pw.append("margin:0 auto;");
		pw.append("width:70%;");
		pw.append("border: 5px solid;");
		pw.append("padding: 15px;");
		pw.append("text-align:justify;");
			 
		pw.append("}");
		
		pw.append("#personaldetails{");
		pw.append("position: absolute;");
		pw.append("z-index: 1;");
		pw.append("margin-top: 16px;");
			
		pw.append("}");

		pw.append(".wrapper{"
				+ "background-color:#E3EDD8;"
				+ "padding: 20px;"
				+ "}");

		pw.append("#profilepic{"
			+"clear:both;"
			+"float:right;"
			
		+"}");
		pw.append("#header{"
		    +"z-index: 1;"
		    +"height:100px;"
		    +"margin-bottom: 10px;"
		    +"}");

		pw.append("#name {"
		    +"float:left;"
			+"font-size: 20px;"
			+"font-family: Verdana, sans-serif;"	
		+"}");

		pw.append("#right_footer{"
			+"clear:both;"
			+"float:right;"
		+"}");

		pw.append("#right_footer ul li{"
			+"list-style-type:none;"
			+"display:inline;"
		+"}");

		pw.append("#email a{"
			+"font-size: 15px;"
			+"font-family: Verdana, sans-serif;"
			+"clear:both;"
			+"float:left;"
		+"}");

		pw.append("#contact {"
		  
			+"font-size: 13px;"
			+"font-family: Verdana, sans-serif;"
			+"clear:both;"
			+"float:left;"
		    +"}");

		pw.append("#address{"
			+"font-size: 13px;"
			+"font-family: Verdana, sans-serif;"
			+"clear:both;"
			+"float:left;"
			+"}");
		pw.append("a:hover {"
		    +"font-weight: bold;"
		+"}");

		pw.append("#job-title{"
			+"margin top:20px;"
		+"}");
    
		pw.append("#footer {"
		    +"height:40px;"
		   
		    +"}");

		pw.append("#myProgress {"
		  +"position: relative;"
		  +"width: 100%;"
		  +"height: 30px;"
		  +"background-color: #ddd;"
		+"}");

		pw.append("#web, #client, #applications, #prog {"
		  +"position: absolute;"
		  +"width: 1%;"
		  +"height: 100%;"
		  +"background-color: #4CAF50;"
		+"}");
		    
		pw.append("h3 {"
		    +"text-decoration: underline;"
			+"margin-bottom:0px;"
		    +"}");
		pw.append("p{"
				+"margin-top:5px;"
				 +"font-weight:normal;"
				+"line-height:23px;"
			+"}");
		pw.append("#job-responsibilities {"
		    +"padding: 1px;"
		    +"}");


		pw.append("#course-name {"
		    +"font-weight:bold;"
		    +"}");

		pw.append("#company-name {"
		    +"height:2px;"
		    +"text-decoration:underline;"
			+"margin-top:8px;"
			+"margin-bottom: 24px;"
		    +"}");
		pw.append("#job-title {"
		    +"margin-top: 20px;"
		    +"}");

		pw.append("#heading {"
		    +"font-weight:bold;"

		    +"}");
	
		pw.append("ul{"
			    +"margin-left: -22px;"
		    +"font-weight: normal;"
			+"line-height:23px;"
		+"}");

		pw.append("</style>");
		pw.append("</head>");
		pw.append(" <body onload=\"move(); move1(); move2(); move3();\">");
		pw.append("<div class=\"wrapper\">");
		pw.append("<div id=\"header\">");
		pw.append("<div id=\"personaldetails\">");
		pw.append("<div id=\"name\"><b>SHEETAL SINGH</b></div>");
		pw.append("<div id=\"email\"><a href=\"mailto:sheetalkhatri91@gmail.com\" target=\"_blank\">sheetalkhatri91@gmail.com</a></div>");
		pw.append("<div id=\"address\">75 Saint Alphonsus Street,Boston,MA,02120</div>");
		pw.append("<div id=\"contact\">617-708-6082</div>");
		pw.append("</div>");
		pw.append("<div id=\"profilepic\"><img src=\"sheetal_profile.png\" width=\"125px\" height=\"100px\" alt=\"profile_pic\"/></div>");
		pw.append("</div>");
		pw.append("<div class=\"education\">");
		pw.append("<h3>EDUCATION</h3>");
		pw.append("<p><b>Northeastern University,Boston,MA</b>");
		pw.append("Master's of Science in Information Systems");
		pw.append("Relevant Courses: Application Engineering Development, Database Management, Web Tools, Advances in data Science.");
		pw.append("</p>");
		pw.append("<p><b>Mumbai University, India</b>");
		pw.append("Bachelor of Engineering in Information Technoloy");
		pw.append("</p>");
		pw.append("</div>");

		pw.append("<div class=\"content\">");
		pw.append("<h3>SUMMARY</h3>");
		pw.append("<p>");
		pw.append("Professional Software Developer having more than two years of experience covering all phases of Software Development Life Cycle (SDLC) namely requirement analysis, design, development, testing, implementation, documentation and end-user training of web based applications. </p>");
		pw.append("<h4><b>Technical Skills:</b></h4>");
		pw.append("<ul>");
		pw.append("<li>Programming Language: C++, VB, C#");
		pw.append("<div id=\"myProgress\">");
		pw.append("<div id=\"prog\"><div id=\"label\">82%</div></div></div></li>");
		pw.append("<li>Web Application Development(ASP.NET, HTML, CSS, Web API, PHP)");
		pw.append("<div id=\"myProgress\">");
		pw.append("<div id=\"web\"><div id=\"label\">85%</div></div></div></li>");
		pw.append("<li>Client-side Technologies: JavaScript, JQUERY");
		pw.append("<div id=\"myProgress\">");
		pw.append("<div id=\"client\"><div id=\"label\">75%</div></div></div></li>");
		pw.append("<li>Applications: NetBeans, Git, Bit Bucket, Eclipse, WebStorm IDE");
		pw.append("<div id=\"myProgress\">");
		pw.append("<div id=\"applications\"><div id=\"label\">80%</div></div></div></li>");
		pw.append("</ul>");
		pw.append("</p>");
		pw.append("<h3>PROFESSIONAL EXPERIENCE</h3>");
		pw.append("<h4 id=\"company-name\">Infinite Computing Systems Pvt. Ltd., India</h4>");
		pw.append("<p id=\"job-title\"><strong>Software Developer</strong></p>");          
		
		pw.append("<ul>");
		pw.append("<li>Worked with clients like <b>Chestnut Global Partners, Citibank and Republic Parking.</b></li>");
		pw.append("<li>Gained Expertise in using various software tools, languages and methodologies with special expertise in Microsoft .NET technologies and experience of developing end-to-end web applications on ASP.Net.</li>");
		pw.append("<li>Worked on Visual Studio 2013 using C# concepts and DotNetNuke. Also, worked on SQL server.</li>");
		pw.append("<li>Created skins and user controls for a DNN Website. Hands on experience in HTML and CSS.</li>");
		pw.append("<li>Have been part of an onshore development team in Bangkok, Thailand. There we as a team reduced the execution time of development process by 2 days with analysis, design, code development, unit testing and defect fixing which in a way increased efficiency.</li>");
		pw.append("<li>Performed Software development under CMMI-III Processes.</li></ul>");
			
				
		pw.append("<h3>ACADEMIC PROJECTS</h3>");
		pw.append("<h4 id=\"company-name\">Secure Web Browser</h4>");
		pw.append("<p>Developed a browser to handle security threats by providing each user an encrypted master password, so that he will be able to access all his accounts. The browser has dynamic links to the database stored in the pen-drive.</p>");
					
		pw.append("<h4 id=\"company-name\">Alzheimer Patient Care</h4>");
		pw.append("<p>Developed a swing application to provide Alzheimer patient care facilities. In this application a request-response  model was built for communication regarding patient's data between receptionist,Doctor,Caretaker,etc.  </p>");
					
		pw.append("<h4 id=\"company-name\">Rossmann Sales Data Prediction</h4>");
		pw.append("<p>Developed a website with the functionality to analyze Sales of Rossmann Stores in Germany. Various languages and tools used in this project were R Programming,ASP.Net,C#,VS 2015,Microsoft Azure, Power BI,AWS,etc. In this project, we predicted, classified and even build clusters for Sales of the Rossmann Stores.</p>");
					
				
		pw.append("<h3>PERSONAL INFORMATION</h3>");
		pw.append("<p>");
		pw.append("<ul>");
		pw.append("<li>");
		pw.append("I am a confident,smart working and highly motivated person. I believe in always being open to learn new things. </li>");
		pw.append("<li> <span id=\"course-name\">Languages Known:</span>English, Hindi</li>");
		pw.append("<li>");
		pw.append("<span id=\"course-name\">Hobbies:</span>perform Bharatnatyam(Indian classical dance), listening music, surfing Internet.</li>"); 
		pw.append("<li>");
		pw.append("<span id=\"course-name\">Places Visited:</span>India, USA, Thailand</li></ul>");
		pw.append("</p>");
		           
		pw.append("<h3>Declaration</h3>");
		pw.append("<p>");
		pw.append("I hereby declare that the details furnished above are true and correct to the best of my knowledge and belief.</p>");
		pw.append("</div>");
		pw.append("<div id=\"footer\">");
		pw.append("<div id=\"right_footer\">");
		pw.append("<ul>");
		pw.append("<li><a href=\"https://www.instagram.com/sheetalsingh01/\" target=\"_blank\"><img src=\"insta.png\" width=\"40px\" height=\"40px\"/></a></li>");
			pw.append("<li><a href=\"https://www.linkedin.com/in/sheetal-singh-222ab0115/\"target=\"_blank\"><img src=\"linkedin.png\" width=\"40px\" height=\"40px\" style=\"margin-left: 4px;\"/></a></li>");
			pw.append("</ul>");
			pw.append("</div>");
			pw.append("</div>");
			
			pw.append("<script>");
			pw.append("function move() {");
			pw.append("var elem = document.getElementById(\"web\");");
			pw.append(" var width = 1;");
			pw.append(" var id = setInterval(frame, 10);");
			pw.append(" function frame() {");
			pw.append("if (width >= 85) {");
			pw.append(" clearInterval(id);");
			pw.append("} else {");
			pw.append("width++;");
			pw.append(" elem.style.width = width + '%';");
			pw.append("}");
			pw.append("}");
			pw.append("}");

			pw.append("function move1() {");
			pw.append("var elem = document.getElementById(\"client\");");
			pw.append(" var width = 1;");
			pw.append(" var id = setInterval(frame, 10);");
			pw.append(" function frame() {");
			pw.append("if (width >= 75) {");
			pw.append(" clearInterval(id);");
			pw.append("} else {");
			pw.append("width++;");
			pw.append(" elem.style.width = width + '%';");
			pw.append("}");
			pw.append("}");
			pw.append("}");

			pw.append("function move2() {");
			pw.append("var elem = document.getElementById(\"applications\");");
			pw.append(" var width = 1;");
			pw.append(" var id = setInterval(frame, 10);");
			pw.append(" function frame() {");
			pw.append("if (width >= 80) {");
			pw.append(" clearInterval(id);");
			pw.append("} else {");
			pw.append("width++;");
			pw.append(" elem.style.width = width + '%';");
			pw.append("}");
			pw.append("}");
			pw.append("}");


			pw.append("function move3() {");
			pw.append("var elem = document.getElementById(\"prog\");");
			pw.append(" var width = 1;");
			pw.append(" var id = setInterval(frame, 10);");
			pw.append(" function frame() {");
			pw.append("if (width >= 82) {");
			pw.append(" clearInterval(id);");
			pw.append("} else {");
			pw.append("width++;");
			pw.append(" elem.style.width = width + '%';");
			pw.append("}");
			pw.append("}");
			pw.append("}");

			pw.append("</script>");
		pw.append("</body>");
		pw.append("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
