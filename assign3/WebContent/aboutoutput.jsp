<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="neu.edu.S1" %>
<%@page import="neu.edu.ResumePojo" %>
<%ResumePojo r= (ResumePojo) request.getAttribute("resume");%>

<div class="form-group">
<label for="name" >Full Name</label><br/>
<p><% out.println(r.getName()); %></p>
</div>
<div class="form-group"> 
<label for="about">About Yourself</label>
<p><% out.println(r.getAbout()); %><p>
</div>
	


