<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Details</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
 
</head>
<body>
<form action="S1" method="post">
<%@ include file="/ResumeAboutinput.jsp" %>
<%@ include file="/locationinput.jsp" %>
<%@ include file="/educationinput.jsp" %>
<%@ include file="/projectinput.jsp" %>
<%@ include file="/skillsinput.jsp" %>
<input type="submit"  class="btn btn-block btn-primary"/>
</div>
</form>
</body>
</html>