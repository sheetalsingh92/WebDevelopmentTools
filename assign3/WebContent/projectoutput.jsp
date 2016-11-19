<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@page import="neu.edu.S1" %>
<%@page import="neu.edu.ResumePojo" %>
<%ResumePojo r3= (ResumePojo) request.getAttribute("resume");%>
<div class="form-group"> 
<label for="project">Project Description</label>
 <p><% out.println("Project1->"+r3.getProject1()); %></p>
 <p><% out.println("ProjectDesc1->"+r3.getProjectdesc1()); %></p>
 <p><% out.println("Project2->"+r3.getProject2()); %></p>
<p><% out.println("ProjectDesc2->"+r3.getProjectdesc2()); %></p> 
  <p><% out.println("Project3->"+r3.getProject3()); %></p>
  <p><% out.println("ProjectDesc3->"+r3.getProjectdesc3()); %></p>
</div>

		