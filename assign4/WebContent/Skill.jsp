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
<label for="skills">Skills</label>
<input type="text" class="form-control" name="skill1" id="skills" placeholder="Java." value="${r3.skill1 }" /><br/>
<input type="number" class="form-control" name="rating1" id="skills" placeholder="rating out of 10" min="1" max="10"  value="${r3.rating1}"><br/><br/>
<input type="text" class="form-control" name="skill2" id="skills" placeholder="Skill2" value="${r3.skill2}"/><br/>
<input type="number" class="form-control" name="rating2" id="skills" placeholder="rating out of 10" min="1" max="10" value="${r3.rating2}"><br/><br/>
<input type="text" class="form-control" name="skill3" id="skills" placeholder="Skill3" value="${r3.skill3}"/><br/>
<input type="number" class="form-control" name="rating3" id="skills" placeholder="rating out of 10" min="1" max="10" value="${r3.rating3}"><br/>
</div>
</div>
<Button type="submit" name="action" value="nextskill">SUBMIT</Button>
</form>
</body>
</html>