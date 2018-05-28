<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Controller">
<div align="right"><a href="<%=response.encodeURL("Logout")%>">Logout</a></div>
<div class="container">
<div class="form-group">
<label for="skills"><b>Skills</b></label>
<input type="text" class="form-control" name="skill1" id="skills" placeholder="Java." value="${resumedb.skill1 }" /><br/>
<input type="number" class="form-control" name="rating1" id="skills" placeholder="rating out of 10" min="1" max="10"  value="${resumedb.rating1}"><br/><br/>
<input type="text" class="form-control" name="skill2" id="skills" placeholder="Skill2" value="${resumedb.skill2}"/><br/>
<input type="number" class="form-control" name="rating2" id="skills" placeholder="rating out of 10" min="1" max="10" value="${resumedb.rating2}"><br/><br/>
<input type="text" class="form-control" name="skill3" id="skills" placeholder="Skill3" value="${resumedb.skill3}"/><br/>
<input type="number" class="form-control" name="rating3" id="skills" placeholder="rating out of 10" min="1" max="10" value="${resumedb.rating3}"><br/>
</div>
</div>
<Button  name="action" value="nextskill">SUBMIT</Button>
<Button name="action" value="backskill" >BACK</Button>
</form>
</body>
</html>