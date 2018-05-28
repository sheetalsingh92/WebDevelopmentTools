<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
<div class="form-group"> 
<form action="Controller" method="post">
<div align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></div>
<label for="project"><b>Project Description</b></label><br/>
<input type="text" class="form-control" name="project1" id="project" placeholder="Project Name: XXXX" value="${resumedb.project1}"/><br/>
<input type="text" class="form-control" name="projectdesc1" id="project" placeholder="projectdesc....." value="${resumedb.projectdesc1}"/><br/><br/>
<input type="text" class="form-control" name="project2" id="project" placeholder="Project Name: XXXX" value="${resumedb.project2}"/><br/>
<input type="text" class="form-control" name="projectdesc2" id="project" placeholder="projectdesc" value="${resumedb.projectdesc2}"/><br/><br/>
<input type="text" class="form-control" name="project3" id="project" placeholder="Project Name: XXXX" value="${resumedb.project3}" /><br/>
<input type="text" class="form-control" name="projectdesc3" id="project" placeholder="projectdesc" value="${resumedb.projectdesc3}"/><br/>
<Button name="action" value="nextproject" >NEXT</Button>
<Button name="action" value="backproject" >BACK</Button>
</form>
</div>
</div>
</body>
</html>