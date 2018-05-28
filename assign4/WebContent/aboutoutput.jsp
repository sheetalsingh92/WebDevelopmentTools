<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="neu.edu.assign4.About" %>
<%@page import="neu.edu.model.Resume" %>
<%Resume r= (Resume) request.getSession().getAttribute("resumeabout");%>
<div class="form-group">
<label for="name" >Full Name</label><br/>
<p><% out.println(r.getName()); %></p>
</div>
<div class="form-group"> 
<label for="about">About Yourself</label>
<p><% out.println(r.getAbout()); %><p>
</div>