<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="neu.edu.assign4.Skills" %>
<%@page import="neu.edu.model.Resume" %>
<%Resume resume3= (Resume) request.getSession().getAttribute("r3");%>
<div class="form-group">
<label for="skills">Skills</label>
<p><% out.println("Skill1->"+resume3.getSkill1()); %></p>
<p><% out.println("Rating->"+resume3.getRating1()); %></p>
<p><% out.println("Skill2->"+resume3.getSkill2()); %></p>
<p><% out.println("Rating->"+resume3.getRating2()); %></p>
<p><% out.println("Skill3->"+resume3.getSkill3()); %></p>
<p><% out.println("Rating->"+resume3.getRating3()); %></p>
</div>