
<%@page import="neu.edu.S1" %>
<%@page import="neu.edu.ResumePojo" %>
<%ResumePojo r1= (ResumePojo) request.getAttribute("resume");%>
<div class="form-group"> 
<label for="location">Location</label>
<p><% out.println(r1.getLocation()); %></p>
</div>

