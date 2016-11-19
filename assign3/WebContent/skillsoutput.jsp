<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@page import="neu.edu.S1" %>
<%@page import="neu.edu.ResumePojo" %>
<%ResumePojo r4= (ResumePojo) request.getAttribute("resume");%>
<div class="form-group">
<label for="skills">Skills</label>
<p><% out.println("Skill1->"+r4.getSkill1()); %></p>
<p><% out.println("Rating->"+r4.getRating1()); %></p>
<p><% out.println("Skill2->"+r4.getSkill2()); %></p>
<p><% out.println("Rating->"+r4.getRating2()); %></p>
<p><% out.println("Skill3->"+r4.getSkill3()); %></p>
<p><% out.println("Rating->"+r4.getRating3()); %></p>
</div>