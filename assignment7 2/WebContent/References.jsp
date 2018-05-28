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
<label for="project"><b>Reference</b></label>
<input type="text" class="form-control" name="reference" id="project" placeholder="xyz" value="${resumedb.reference}" /><br/>
<Button name="action" value="nextreference" >NEXT</Button>
<Button name="action" value="backreference" >BACK</Button>
</form>
</body>
</html>