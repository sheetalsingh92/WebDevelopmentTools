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
<form action="About" method="post">
<div class="container">
<div class="form-group">
<label for="name" >Full Name</label><br/>
<input type="text" id="name" name="name" class="form-control"  placeholder="Alice Wonderland" required/>
 </div>
<div class="form-group"> 
<label for="about">About Yourself</label>
<textarea class="form-control" name="about" id="about" placeholder="Software Developer...." required></textarea>
</div>
<div class="form-group"> 
<label for="location">Location</label>
<textarea class="form-control" name="location" id="location" placeholder="Boston,MA" required></textarea>
</div>
<div class="form-group"> 
<label for="education">Education</label>
<textarea class="form-control" name="education" id="education" placeholder="Masters at NEU.." required></textarea><br/>
<select id="gpa" class="form-control" name="gpa">
  <option value="Above 3.3" >Above 3.3</option>
  <option value="Below 3.3" >Below 3.3</option> 
</select>
</div>
<div class="form-group"> 

<label for="project">Project Description</label>
<div id="note" style="color:green;"><p>Note:Project Description without corresponding Project name will not be displayed</p></div>
<input type="text" class="form-control" name="project1" id="project" placeholder="Project Name: XXXX" /><br/>
<textarea class="form-control" name="projectdesc1" id="project" placeholder="projectdesc....." ></textarea><br/><br/>
<input type="text" class="form-control" name="project2" id="project" placeholder="Project Name: XXXX" /><br/>
<textarea class="form-control" name="projectdesc2" id="project" placeholder="projectdesc" ></textarea><br/><br/>
<input type="text" class="form-control" name="project3" id="project" placeholder="Project Name: XXXX" /><br/>
<textarea class="form-control" name="projectdesc3" id="project" placeholder="projectdesc" ></textarea><br/>
</div>

<div class="form-group">
<label for="skills">Skills</label>
<div id="note" style="color:green;"><p>Note:Rating value without corresponding skill name will not be displayed</p></div>
<input type="text" class="form-control" name="skill1" id="skills" placeholder="Java." /><br/>
<input type="number" class="form-control" name="rating1" id="skills" placeholder="rating out of 10" min="1" max="10" ><br/><br/>
<input type="text" class="form-control" name="skill2" id="skills" placeholder="Skill2" /><br/>
<input type="number" class="form-control" name="rating2" id="skills" placeholder="rating out of 10" min="1" max="10" ><br/><br/>
<input type="text" class="form-control" name="skill3" id="skills" placeholder="Skill3" /><br/>
<input type="number" class="form-control" name="rating3" id="skills" placeholder="rating out of 10" min="1" max="10"><br/>

</div>
<input type="submit"  class="btn btn-block btn-primary"/>
</div>

</form>
</body>
</html>