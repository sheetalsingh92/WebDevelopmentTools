package neu.edu.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import neu.edu.database.JDBCConnectivity;
import neu.edu.db.entity.Resumedb;

/**
 * Servlet implementation class UserAccountDAO
 */
public class UserAccountDAO {

	private Connection conn;
	
	public UserAccountDAO() {
		// TODO Auto-generated constructor stub
		conn = JDBCConnectivity.getConnection();
	}
	
	
	public Resumedb validateLogin(String username,String password){
		Resumedb resumedb= null;
		String sql ="Select * from resume_details where username=? and password=? ";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
		
				if(rs.next()){
					resumedb = new  Resumedb();
					resumedb.setUserName(rs.getString(1));
					resumedb.setPassword(rs.getString(2));
					resumedb.setName(rs.getString("name"));
					resumedb.setAbout(rs.getString("about"));
					resumedb.setEducation(rs.getString("education"));
					resumedb.setGpa(rs.getString("gpa"));
					resumedb.setLocation(rs.getString("location"));
					resumedb.setSkill1(rs.getString("skill1"));
					resumedb.setRating1(rs.getString("rating1"));
					resumedb.setSkill2(rs.getString("skill2"));
					resumedb.setRating2(rs.getString("rating2"));
					resumedb.setSkill3(rs.getString("skill3"));
					resumedb.setRating3(rs.getString("rating3"));
					resumedb.setProject1(rs.getString("project1"));
					resumedb.setProjectdesc1(rs.getString("projectdesc1"));
					resumedb.setProject2(rs.getString("project2"));
					resumedb.setProjectdesc2(rs.getString("projectdesc2"));
					resumedb.setProject3(rs.getString("project3"));
					resumedb.setProjectdesc3(rs.getString("projectdesc3"));
					resumedb.setReference(rs.getString("reference"));
					
					
					//resumedb.setEducati(rs.getString());
					
					
					//resumedb.(rs.getString("username"));
					
				}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resumedb;
	}

	public Resumedb insertDAO(String username, String password, String name, String dob,String gender)
	{	Resumedb user =null;
		final int MYSQL_DUPLICATE_PK = 1062;
		 java.sql.Statement st =null;
		try {
			//conn= JDBCConnectivity.getConnection();
			String insertSql = "insert into resume_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(insertSql);
			pst.setString(1,username );
			pst.setString(2,password);
			pst.setString(3, name);
			pst.setString(4, dob);
			pst.setString(5, gender);
			pst.setString(6, null);
			pst.setString(7, null);
			
			pst.setString(8, null);
			pst.setString(9, null);
			pst.setString(10, null);
			pst.setString(11, null);
			pst.setString(12, null);
			pst.setString(13, null);
			pst.setString(14, null);
			pst.setString(15, null);
			pst.setString(16, null);
			pst.setString(17, null);
			pst.setString(18, null);
			pst.setString(19, null);
			pst.setString(20, null);
			pst.setString(21, null);
			pst.setString(22, null);
			pst.setInt(23, 0);
	
			
			

			int execUpdate = pst.executeUpdate();
			
			String selectSql = "select * from resume_details";
		 st = conn.createStatement();
			ResultSet rs =  st.executeQuery(selectSql);
			user = new Resumedb();
			while (rs.next()) {
				user.setUserName(rs.getString("username"));
				

			}
		} catch (SQLException e) {
			
		}
		
		return user;
	}
	
	public void insertresumevaluesDAO(Resumedb resume)
	{
		 java.sql.Statement st =null;
		try {
			//conn= JDBCConnectivity.getConnection();
			if(resume.getSkill1().equals(""))
			{
				resume.setRating1("");
			}
			if(resume.getSkill2().equals(""))
			{
				resume.setRating2("");
			}
			if(resume.getSkill3().equals(""))
			{
				resume.setRating3("");
			}
			if(resume.getProject1().equals(""))
			{
				resume.setProjectdesc1("");
			}
			if(resume.getProject2().equals(""))
			{
				resume.setProjectdesc2("");
			}
			if(resume.getProject3().equals(""))
			{
				resume.setProjectdesc3("");
			}
			String insertSql = "update resume_details set name=?,about=?,education=?,gpa=?,location=?,skill1=?,rating1=?,"
					+ "skill2=?,rating2=?,skill3=?,rating3=?,project1=?,projectdesc1=?,project2=?,projectdesc2=?,project3=?,projectdesc3=?,"
					+ "reference=?, flag=? where "
					+ "username=? ";
			PreparedStatement pst = conn.prepareStatement(insertSql);
			pst.setString(1, resume.getName());
			pst.setString(2, resume.getAbout());
			pst.setString(3, resume.getEducation());
			pst.setString(4, resume.getGpa());
			pst.setString(5, resume.getLocation());
			pst.setString(6, resume.getSkill1() );
			pst.setString(7, resume.getRating1());
			pst.setString(8, resume.getSkill2());
			pst.setString(9, resume.getRating2());
			pst.setString(10, resume.getSkill3());
			pst.setString(11, resume.getRating3());
			pst.setString(12, resume.getProject1());
			pst.setString(13, resume.getProjectdesc1());
			pst.setString(14, resume.getProject2());
			pst.setString(15, resume.getProjectdesc2());
			pst.setString(16, resume.getProject3());
			pst.setString(17, resume.getProjectdesc3());
			pst.setString(18, resume.getReference());
			pst.setInt(19, 1);
			pst.setString(20,resume.getUserName());
			
			int execUpdate = pst.executeUpdate();
			if(execUpdate == 1){
				resume.setFlag(1);
			}
			
				

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getFlagValue(String username){
		int flag=0;
		//Resumedb resumedb= null;
		String sql ="Select flag from resume_details where username=? ";
		System.out.println("Query :"+sql);
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			
			ResultSet rs = pst.executeQuery();
		
				if(rs.next()){
				flag = rs.getInt("flag");
				}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
		
	
	
}
