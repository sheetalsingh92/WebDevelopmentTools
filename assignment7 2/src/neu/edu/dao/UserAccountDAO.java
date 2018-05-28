package neu.edu.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.ResumeDetails;
import neu.edu.util.HibernateUtil;

/**
 * Servlet implementation class UserAccountDAO
 */
@Service
public class UserAccountDAO {

	private Connection conn;
	
	public UserAccountDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ResumeDetails resumeDetail;
	
	
	public ResumeDetails validateLogin(String username,String password){
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select * from resume_details where username=:un and password=:pass ");
		query.setString("un", username);
		query.setString("pass", password);

	List resumeDetails =  query.list();
		//List<ResumeDetails> resumeDetails = (List<ResumeDetails>) query.list();
		Object row[];
		if (resumeDetails.size() > 0) {
		row = (Object[])resumeDetails.get(0);
			resumeDetail.setUsername((String)row[0]);
			resumeDetail.setPassword((String)row[1]);
			resumeDetail.setName((String)row[2]);
			resumeDetail.setDob((String)row[3]);
			resumeDetail.setGender((String)row[4]);
			resumeDetail.setAbout((String)row[5]);
			resumeDetail.setEducation((String)row[6]);
			resumeDetail.setGpa((String)row[7]);
			resumeDetail.setLocation((String)row[8]);
			resumeDetail.setReference((String)row[9]);
			resumeDetail.setProject1((String)row[10]);
			resumeDetail.setProjectdesc1((String)row[11]);
			resumeDetail.setProject2((String)row[12]);
			resumeDetail.setProjectdesc2((String)row[13]);
			resumeDetail.setProject3((String)row[14]);
			resumeDetail.setProjectdesc3((String)row[15]);
			resumeDetail.setSkill1((String)row[16]);
			resumeDetail.setRating1((String)row[17]);
			resumeDetail.setSkill2((String)row[18]);
			resumeDetail.setRating2((String)row[19]);
			resumeDetail.setSkill3((String)row[20]);
			resumeDetail.setRating3((String)row[21]);
		
			resumeDetail.setFlag((Integer)row[22]);
			
			return resumeDetail;
		}
		try {
			session.close();
		} catch (Exception ex) {
			
		}
		return null;
		
	}

	@Transactional
	public boolean insertDAO(ResumeDetails resumeDetails)
{	Transaction tx = null;
		
		try {
	Session session = sessionFactory.openSession();
	

		resumeDetails.setFlag(0);
		session.save(resumeDetails);
		
		return true;

	} catch (Exception ex) {
		
		
	}
		return false;
	}
	
	@Transactional
	public void insertresumevaluesDAO(ResumeDetails resume)
	{	
			
		Session	session = sessionFactory.getCurrentSession();
		
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
			try {
			
				
				resume.setFlag(1);
				session.update(resume);		
			
				


			} catch (Exception ex) {
				System.out.println(ex);
			} 

		
			}
	
	
		
		
	
}
