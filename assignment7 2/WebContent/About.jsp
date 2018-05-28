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
<label for="name" ><b>Full Name</b></label><br/>
<input type="text" id="name" name="name" class="form-control"  placeholder="Alice Wonderland"  required value="${resumedb.name}" />
 </div>
<div class="form-group"> 
<label for="about"><b>About Yourself</b></label><br/>
<input type="text" class="form-control" name="about" id="about" placeholder="Software Developer.."  value="${resumedb.about}" />
</div>

<Button name="action" value="nextabout" type="submit" >NEXT</Button>
		<Button name="action" value="backabout" CausesValidation="false" >BACK</Button>
</div>
</form>
</body>
</html>