<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="neu.edu.ResumeDetails" %>
    <%ResumeDetails resume= (ResumeDetails) request.getSession().getAttribute("resume");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></div>
<form action="Controller" method="post">
<div class="form-group">
<p><b>Resume Details</b></p>
<p>Full Name ->${resumedb.name}</p>
</div>
<div class="form-group"> 
<p>About Yourself - > ${resumedb.about}<p>
</div>
<div class="form-group"> 
<p>Education -> ${resumedb.education}</p>
</div>
<div class="form-group"> 
<p>GPA -> ${resumedb.gpa}</p>
</div>
<div class="form-group"> 
<p>Location -> ${resumedb.location }</p>
</div>
<div class="form-group">
<label for="project">Projects</label>
<p>Project1 -> ${resumedb.project1 }</p>
<p>Project Description -> ${resumedb.projectdesc1}</p>
<p>Project2 -> ${resumedb.project2 }</p>
<p>Project Description -> ${resumedb.projectdesc2}</p>
<p>Project3 -> ${resumedb.project3 }</p>
<p>Project Description -> ${resumedb.projectdesc3}</p>
</div>
<div class="form-group"> 
<p>Reference -> ${resumedb.reference }</p>
</div>
<div class="form-group">
<label for="skills">Skills</label>
<p>Skill1 -> ${resumedb.skill1 }</p>
<p>Rating1 -> ${resumedb.rating1 }</p>
<p>Skill1 -> ${resumedb.skill2 }</p>
<p>Rating2 -> ${resumedb.rating2 }</p>
<p>Skill1 -> ${resumedb.skill3 }</p>
<p>Rating3 -> ${resumedb.rating3 }</p>
</div>
<div>
	<Button type="submit" name="action" value="backviewdetails">Back</Button>
	</div>
	</form>
</body>
</html>