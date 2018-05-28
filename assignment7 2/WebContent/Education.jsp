<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller" method="post">
<div align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></div>
<div class="container">
<div class="form-group"> 
<label for="education"><b>Education</b></label><br/>
<input type="text" class="form-control" name="education" id="education" placeholder="Masters at NEU.." value="${resumedb.education}" required/><br/>
<label for="gpa"><b>GPA</b></label><br/>
<select id="gpa" class="form-control" name="gpa" value="${resumedb.gpa}" required>
  <option value="Above 3.3" >Above 3.3</option>
  <option value="Below 3.3" >Below 3.3</option> 
</select>
</div>
<Button name="action" value="nexteducation" type="submit">NEXT</Button>
		<Button name="action" value="backeducation" >BACK</Button>	
</div>
</div>
</form>
</body>
</html>