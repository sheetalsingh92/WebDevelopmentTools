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
<div class="form-group"> 
<div class="container">
<label for="location">Location</label>
<input type="text" class="form-control" name="location" id="location" placeholder="Boston,MA"  value="${r2.location}" />

<Button name="action" value="nextlocation" type="submit">NEXT</Button>
<Button name="action" value="backLocation" >BACK</Button>
</div>
</div>
</form>
</body>
</html>