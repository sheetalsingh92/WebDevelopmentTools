<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="neu.edu.S1" %>
<%@page import="neu.edu.ResumePojo" %>
<%ResumePojo r2= (ResumePojo) request.getAttribute("resume");%>
<div class="form-group"> 
<label for="education">Education</label>
<p><% out.println(r2.getEducation()); %></p>
</div>
<div class="form-group"> 
<label for="GPA">GPA</label>
<p><% out.println(r2.getGpa()); %></p>
</div>

