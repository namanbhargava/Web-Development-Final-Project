package in.developersera.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import in.developersera.exception.EmployeeLoginException;
import in.developersera.pojo.Employee;


public class EmployeeDAO extends DAO{
	
	public static Employee checkEmployee(Employee employee) throws EmployeeLoginException {
        try {
        	//boolean login = false;
            begin();
            Query query = getSession().createQuery("from Employee where userName= :userName and password= :password and role= :role");
            query.setString("userName", employee.getUserName());
            query.setString("password", employee.getPassword());
            query.setString("role", employee.getRole());
            Employee empResult = (Employee)query.uniqueResult();
//            if(!(empResult.equals(null)))
//            {
//            	login = true;
//            }
            commit();
            return empResult;
        } catch (HibernateException e) {
            rollback();
            throw new EmployeeLoginException("UserName and Password may be wrong "  + e.getMessage());
        }
    }

}
