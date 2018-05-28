<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		String registerError = (String) request.getAttribute("register-error");
		if (registerError != null) {
			if ("User with this name already exists!!!".equals(registerError)) {
	%>
	<div>
		<h4>User with this name already exists!!! !!</h4>
	</div>
	<%
		}%>
		<% }%>
	<form action="<%=response.encodeUrl("Controller") %>" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="user" required/> </td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" required/> </td>
			</tr>	
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pass" required/> </td>
			</tr>
			
			<tr>
				<td>DOB:</td>
				<td><input type="Date" name="dob" required/> </td>
			</tr>
			<tr>
			<td>
			<select id="gender"  name="gender"  >
  			<option value="Female" >Female</option>
 			 <option value="Male" >Male</option> 
			</select>
			</td>
			</tr>
			<tr>
				<td rowspan="2" align="center">
						<input type="submit" name="action" value="Register"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>