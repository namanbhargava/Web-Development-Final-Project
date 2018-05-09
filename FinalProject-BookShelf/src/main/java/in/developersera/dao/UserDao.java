package in.developersera.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import in.developersera.pojo.UserPojo;

public class UserDao extends DAO{
	
	public void addToDb(UserPojo Up)
	{
		
		try {
		begin();
		getSession().save(Up);
		commit();
		System.out.println("--------Adding to DB---------");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public UserPojo getUser(String userid, String password) {
		try {
			
			begin();
			Query q = getSession().createQuery("from UserPojo where userid = :userid and password = :password");
			q.setString("userid", userid);
			q.setString("password", password);	
			System.out.println("---------Checking userid and password------------");
			UserPojo userpojo = (UserPojo) q.uniqueResult();
			commit();
			close();
			return userpojo;
		} catch (HibernateException e) {
			System.out.println(e);
			
			rollback();
		}
		return null;
	}
	
	public UserPojo getUserDetails(String userid)
	{
		Query q = getSession().createQuery("from UserPojo where userid= :userid");
		q.setString("userid", userid);
		UserPojo up = (UserPojo)q.uniqueResult();
		close();
		return up;
	}
	
	public void updateUserDetails(UserPojo up)
	{
		try {
			begin();
			getSession().update(up);
			commit();
			close();
		}
		catch(HibernateException e)
		{
			rollback();
			System.out.println(e);
		}
		
	}
	
}


