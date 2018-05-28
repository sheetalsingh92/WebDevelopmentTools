<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="neu.edu.assign4.Education" %>
<%@page import="neu.edu.model.Resume" %>
<%Resume resume1= (Resume) request.getSession().getAttribute("r1");%>
<div class="form-group"> 
<label for="education">Education</label>
<p><% out.println(resume1.getEducation()); %></p>
</div>
<div class="form-group"> 
<label for="GPA">GPA</label>
<p><% out.println(resume1.getGpa()); %></p>
</div>

