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
<form action="DisplayForm" method="POST">
<div class="container">
<div class="form-group">
<label for="title" >Title</label><br/>
<input type="radio" id="title" name="radioField" value="Mr" checked />Mr
<input type="radio"  id="title" name="radioField" value="Miss"/>Miss
<input type="radio" id="title" name="radioField" value="Mrs"/>Mrs<br/> 
    </div>
<div class="form-group"> 
<label for="fullname">FullName</label>
<input type="text" class="form-control" name="fullname" id="fullname" placeholder="Alice Wonderland" min="3" required/>
<div id="error" style="color:red;"></div>
</div>
<div class="form-group"> 
<label for="DOB">DOB</label>
<input type="text" name="DOB" id="DOB" class="form-control" placeholder="mm/dd/yyy"  required />
<div id="errordate" style="color:red;"></div>
</div>
<div class="form-group"> 
<label for="addresstype">Address Type</label>
<select id="addresstype" class="form-control" name="addresstype">
  <option value="Home" >Home</option>
  <option value="Office" >Office</option>
</select>
</div>
<div class="form-group">
<label for="address">Address</label>
<textarea rows="4" cols="50" id="address" class="form-control" name="address" placeholder="Enter Address here.."></textarea>
</div>
<div class="form-group">
<label for="ssn">Last 4 digit of SSN</label>
<input type="password" class="form-control" name="ssn" id="ssn" placeholder="5085"  required/>
<div id="errorssn" style="color:red;"></div>
</div>
<div class="form-group">
<label for="phonenumber">Phone Number</label>
<input type="text" class="form-control" name="phonenumber" id="phonenumber" placeholder="0016577986781" required />
<div id="errorphone" style="color:red;"></div>
</div>
<input type="submit" onclick="return checkName()" class="btn btn-block btn-primary"/>
</div>
<script>
function checkName(){  
var fullnames = fullname.value;  
var ssns=ssn.value; 
var DOBs=DOB.value;
var phonenumbers=phonenumber.value;
var mnlen = 3;  
var mxlen = 100;  
var regexssn=/^[0-9]+$/;
var regexdate= /^(?:(?:(?:0?[13578]|1[02])(\/|-|\.)31)\1|(?:(?:0?[1,3-9]|1[0-2])(\/|-|\.)(?:29|30)\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:0?2(\/|-|\.)29\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9])|(?:1[0-2]))(\/|-|\.)(?:0?[1-9]|1\d|2[0-8])\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;
var regexphone=/^(001)\d{3}\d{3}\d{4}$/;
  
if(fullnames.length<mnlen || fullnames.length>mxlen)  
{   
document.getElementById("error").innerHTML ="Please enter name with length(3-100)";
 return false;
} 

else if(!regexdate.test(DOBs)) 
{
document.getElementById("error").innerHTML ="";
document.getElementById("errordate").innerHTML ="Enter date in mm/dd/yyyy format";
return false;
}
else if(!regexssn.test(ssns)) 
{
document.getElementById("errordate").innerHTML ="";
document.getElementById("error").innerHTML ="";
document.getElementById("errorssn").innerHTML ="Only numbers allowed";
return false;
}
else if(ssns.length!=4)
{
document.getElementById("error").innerHTML ="";
document.getElementById("errorssn").innerHTML ="Enter last 4 digits of SSN(only numbers)";
return false;
} 
else if(!regexphone.test(phonenumbers)) 
{
document.getElementById("errordate").innerHTML ="";
document.getElementById("error").innerHTML ="";
document.getElementById("errorssn").innerHTML ="";
document.getElementById("errorphone").innerHTML ="Enter phone number in 0016577986781 format";
return false;
}
else{

document.getElementById("errordate").innerHTML ="";
document.getElementById("error").innerHTML ="";
document.getElementById("errorssn").innerHTML ="";
document.getElementById("errorphone").innerHTML ="";
alert("Page submitted successfully");
return true;

}
}

</script>
</form>
</body>
</html>