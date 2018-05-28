package neu.edu.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import neu.edu.ResumeDetails;
import neu.edu.util.HibernateUtil;

/**
 * Servlet implementation class UserAccountDAO
 */
public class UserAccountDAO {

	private Connection conn;
	
	public UserAccountDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ResumeDetails validateLogin(String username,String password){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createSQLQuery("select * from resume_details where username=:un and password=:pass ");
		query.setString("un", username);
		query.setString("pass", password);

	List resumeDetails =  query.list();
		//List<ResumeDetails> resumeDetails = (List<ResumeDetails>) query.list();
		Object row[];
		if (resumeDetails.size() > 0) {
		row = (Object[])resumeDetails.get(0);
			ResumeDetails resumeDetail = new ResumeDetails((String)row[0], (String)row[1],(String)row[2],(String)row[3],
				(String)row[4],(String)row[5],(String)row[6],(String)row[7],(String)row[8],(String)row[9],(String)row[10],(String)row[11],(String)row[12],
				(String)row[13],(String)row[14],(String)row[15],(String)row[16],(String)row[17],(String)row[18],(String)row[19],(String)row[20],(String)row[21],(Integer)row[22]);
			
			return resumeDetail;
		}
		try {
			session.close();
		} catch (Exception ex) {
			
		}
		return null;
		
	}

	public boolean insertDAO(ResumeDetails resumeDetails)
{	Transaction tx = null;
		
		try {
	Session session = HibernateUtil.getSessionFactory().openSession();
	

		resumeDetails.setFlag(0);
		tx = session.beginTransaction();
		session.save(resumeDetails);
		tx.commit();
		return true;

	} catch (Exception ex) {
		System.out.println(ex);
		try {
			tx.rollback();
		} catch (Exception e) {
		}
		
	}
		return false;
	}
	
	public void insertresumevaluesDAO(ResumeDetails resume)
	{	Session session = null;
		 java.sql.Statement st =null;
			
			session = HibernateUtil.getSessionFactory().openSession();
		
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
			
				Transaction tx = session.beginTransaction();
				resume.setFlag(1);
				session.update(resume);		
				tx.commit();
				


			} catch (Exception ex) {
				System.out.println(ex);
			} finally {
				
					session.close();
			
			}

		
			}
	
	
		
		
	
}
