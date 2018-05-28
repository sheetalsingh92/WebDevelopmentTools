<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></div>
	<form action="Controller" method="post">
	
	<h1>Welcome ${resumedb.name}</h1>
	<table border="1">
	<tr>
	<th>Name</th>
	<th>About</th>
	<th>Education</th>
	<th>GPA</th>
	<th>Location</th>
	<th>Skill1</th>
	<th>Rating1</th>
	<th>Skill2</th>
	<th>Rating2</th>
	<th>Skill3</th>
	<th>Rating3</th>
	<th>Project1</th>
	<th>ProjectDesc1</th>
	<th>Project2</th>
	<th>ProjectDesc2</th>
	<th>Project3</th>
	<th>ProjectDesc3</th>
	<th>Reference</th>
	</tr>
	<tr>
	<td>${resumedb.name}</td>
	<td>${resumedb.about}</td>
	<td>${resumedb.education}</td>
	<td>${resumedb.gpa}</td>
	<td>${resumedb.location}</td>
	<td>${resumedb.skill1}</td>
	<td>${resumedb.rating1}</td>
	<td>${resumedb.skill2}</td>
	<td>${resumedb.rating2}</td>
	<td>${resumedb.skill3}</td>
	<td>${resumedb.rating3}</td>
	<td>${resumedb.project1}</td>
	<td>${resumedb.projectdesc1}</td>
	<td>${resumedb.project2}</td>
	<td>${resumedb.projectdesc2}</td>
	<td>${resumedb.project3}</td>
	<td>${resumedb.projectdesc3}</td>
	<td>${resumedb.reference}</td>
	
	</tr>
	</table>
	<Button name="action" value="displayresume" type="submit">View Details</Button>
		<Button name="action" value="NextDashboard" type="submit">Update the resume</Button>
		
	
	
	</form>
</body>
</html>