package neu.edu.db.entity;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resumedb
 */
public class Resumedb extends HttpServlet {
	public String name;
	public String userName;
	public String password;
	public String DOB;
	public String gender;
	public int flag;
	public String about;
	public String location;
	public String education;
	public String gpa;
	public String project1;
	public String projectdesc1;
	public String project2;
	public String projectdesc2;
	public String project3;
	public String projectdesc3;
	public String reference;
	public String skill1;
	public String rating1;
	public String skill2;
	public String rating2;
	public String skill3;
	public String rating3;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public String getSkill1() {
		return skill1;
	}
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	public String getRating1() {
		return rating1;
	}
	public void setRating1(String rating1) {
		this.rating1 = rating1;
	}
	public String getSkill2() {
		return skill2;
	}
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
	public String getRating2() {
		return rating2;
	}
	public void setRating2(String rating2) {
		this.rating2 = rating2;
	}
	public String getSkill3() {
		return skill3;
	}
	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getRating3() {
		return rating3;
	}
	public void setRating3(String rating3) {
		this.rating3 = rating3;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProject1() {
		return project1;
	}
	public void setProject1(String project1) {
		this.project1 = project1;
	}
	public String getProjectdesc1() {
		return projectdesc1;
	}
	public void setProjectdesc1(String projectdesc1) {
		this.projectdesc1 = projectdesc1;
	}
	public String getProject2() {
		return project2;
	}
	public void setProject2(String project2) {
		this.project2 = project2;
	}
	public String getProjectdesc2() {
		return projectdesc2;
	}
	public void setProjectdesc2(String projectdesc2) {
		this.projectdesc2 = projectdesc2;
	}
	public String getProject3() {
		return project3;
	}
	public void setProject3(String project3) {
		this.project3 = project3;
	}
	public String getProjectdesc3() {
		return projectdesc3;
	}
	public void setProjectdesc3(String projectdesc3) {
		this.projectdesc3 = projectdesc3;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	

}
