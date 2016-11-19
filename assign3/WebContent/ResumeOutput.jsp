<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
<style>
		.container{
		margin-top:10px;
		}
</style>
</head>
<body>
<div class="container">
<%@ include file="/aboutoutput.jsp" %>
<%@ include file="/locationoutput.jsp" %>
<%@ include file="/educationoutput.jsp" %>
<%@ include file="/projectoutput.jsp" %>
<%@ include file="/skillsoutput.jsp" %>
</div>
</body>
</html>