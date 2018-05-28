<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="neu.edu.assign4.Location" %>
<%@page import="neu.edu.model.Resume" %>
<%Resume resume2= (Resume) request.getSession().getAttribute("r2");%>
<div class="form-group"> 
<label for="location">Location</label>
<p><% out.println(resume2.getLocation()); %></p>
</div>