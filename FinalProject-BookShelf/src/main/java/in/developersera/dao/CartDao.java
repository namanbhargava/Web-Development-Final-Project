package in.developersera.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import in.developersera.pojo.Cart;
import in.developersera.pojo.ProductPojo;
import in.developersera.pojo.UserPojo;

public class CartDao extends DAO {
	
	public void addProducttoCart(Cart c)
	{
		try {
			begin();
			getSession().save(c);
			commit();
			close();
			
		}
		catch(Exception e)
		{
			System.out.println("Error while inserting the Cart object");
		}
		
	}
	
	public List<Cart> getProductListFromId(String id)
	{
		List<Cart> listcart = null;
		try {
			begin();
			Query q = getSession().createQuery("from Cart where userpojo_id = :id and status = :status");
			q.setString("id", id);
			q.setInteger("status", 0);
			listcart = q.list();
			return listcart;
		}
		catch(Exception e)
		{
			rollback();
			System.out.println("Exception is "+ e);
		}
		
		return listcart;
		
	}
	
	public boolean checkInCart(String userid, int prodid)
	{
		
		try {
			begin();
			Query q = getSession().createQuery("from Cart where userpojo_id = :id and productpojo_id = :prodid and status = :status");
			q.setString("id", userid);
			q.setInteger("prodid", prodid);
			q.setInteger("status", 0);
			List<Cart> listcart = q.list();
			if(listcart.size()>0)
			{
				return true;
			}	
		}
		catch(Exception e)
		{
			rollback();
			System.out.println("---Exception is---" + e);
		}
		
		return false;
	}
	
	public int getQuantity(String userid, int prodid)
	{
		begin();
		Query q = getSession().createQuery("from Cart where userpojo_id = :id and productpojo_id = :prodid");
		q.setString("id", userid);
		q.setInteger("prodid", prodid);
		q.setMaxResults(1);
		Cart c = (Cart)q.uniqueResult();
		return c.getQuantity();
	}
	
	public void updateQuantity(Cart cart)
	{
		try {
		begin();
		int currentqty = getQuantity(cart.getUserpojo().getUserid(), cart.getProductpojo().getProductId());
		int recentqty = cart.getQuantity();
		int updatedQty = currentqty + recentqty;
		System.out.println(cart.getUserpojo().getUserid());
		System.out.println(cart.getProductpojo().getProductId());
		Query q = getSession().createSQLQuery("update cart_tbl set quantity = :updatedQty where userpojo_id = :user and productpojo_id = :prodid");
		q.setInteger("updatedQty", updatedQty);
		q.setString("user", cart.getUserpojo().getUserid());
		q.setInteger("prodid", cart.getProductpojo().getProductId());
		q.executeUpdate();
		commit();
		close();
		}
		catch(Exception e)
		{
			rollback();
			System.out.println("----Exception is----"+ e);
		}
	}
	
	public void updateStatus(String userid)
	{
		begin();
		Query q = getSession().createSQLQuery("update cart_tbl set status = :updatedStatus where userpojo_id = :user");
		q.setInteger("updatedStatus", 1);
		q.setString("user", userid);
		q.executeUpdate();
		commit();
		close();
	}
	
	
	
	
	
	public List<Cart> deleteProductsFromCart(String id, int prodid)
	{
		List<Cart> newList = null;
		
		try {
			begin();
			Query q = getSession().createQuery("delete from Cart where userpojo= :id and productpojo= :prodid and status= :status");
			q.setString("id", id);
			q.setInteger("prodid", prodid);
			q.setInteger("status", 0);
			int results = q.executeUpdate();
			commit();
			newList =getProductListFromId(id);
			return newList;
		}
		catch(Exception e)
		{
			rollback();
			System.out.println("----Exception is----"+ e);
		}
		
		return newList;
	}
	
	public List<Cart> getOrderedProducts(UserPojo up)
	{
		begin();
		Query q = getSession().createQuery("from Cart where userpojo_id = :id and status= :status");
		q.setString("id", up.getUserid());
		q.setInteger("status", 1);
		List<Cart> listCart = q.list();
		return listCart;
	}
	
	
}
