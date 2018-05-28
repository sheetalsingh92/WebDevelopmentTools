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
	
	<h1>Welcome ${user.name}</h1>
		<Button name="action" value="NextInsertDetails" type="submit">Insert all the details of Resume</Button>
		
	
	
	</form>
</body>
</html>