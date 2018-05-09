package in.developersera.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import in.developersera.exception.ProductException;
import in.developersera.pojo.ProductPojo;

public class ProductDao extends DAO{

	public List<ProductPojo> getProducts()
	{
		try {
			begin();
			Query q = getSession().createQuery("from ProductPojo where status = :status");
			q.setString("status", "approved");
			List<ProductPojo> prod = q.list();
			commit();
			System.out.println("---------Returning approved products-----------");
            return prod;
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
	
	
//	public List<ProductPojo> getCategoryProducts(String selectedCategory)
//	{
//		try {
//			begin();
//			Query q = getSession().createQuery("from ProductPojo where category = :category AND status = :status");
//			q.setString("category", selectedCategory);
//			q.setString("status", "approved");
//			List<ProductPojo> prod = q.list();
//			commit();
//			System.out.println("---------Returning "+selectedCategory+" products-----------");
//            return prod;
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//		
//		return null;
//	}
	
	public List<ProductPojo> rejectProduct(int productId)
	{
		try {
			begin();
			Query q = getSession().createSQLQuery("update product_tbl set status = :status where productId = :idp");
			q.setInteger("idp", productId);
			q.setString("status", "Rejected");
			int num = q.executeUpdate();
			commit();
			System.out.println("---------reject products-----------");
            return getUnderReviewedProducts();
		}
		catch(Exception e){
			System.out.println("---------reject products Error-----------"+e.toString());
		}		
		return null;
	}
	
	public List<ProductPojo> approveProduct(int productId)
	{
		try {
			begin();
			Query q = getSession().createSQLQuery("update product_tbl set status = :status where productId = :idp");
			q.setInteger("idp", productId);
			q.setString("status", "Approved");
			int num = q.executeUpdate();
			commit();
			System.out.println("---------approve products-----------");
            return getUnderReviewedProducts();
		}
		catch(Exception e){
			System.out.println("---------approve products Error-----------"+e.toString());
		}		
		return null;
	}
	
	public boolean create(ProductPojo product) throws ProductException {
        try {
            begin();
            //ProductPojo prod = new ProductPojo();
            getSession().save(product);
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
           
            throw new ProductException("Exception while creating product: " + e.getMessage());
        }
    }
	
	
	public List<ProductPojo> getUnderReviewedProducts()
	{
		try {
			begin();
			Query query = getSession().createQuery("from ProductPojo where status = :status");
			query.setString("status", "under review");
			List<ProductPojo> underReviewProduct = query.list();
			commit();
            return underReviewProduct;
		}
		catch(Exception e){
			System.out.println(e);
		}		
		return null;
	}
	
	public List<ProductPojo> getProductList(String keyword)
	{
		List<ProductPojo> list = new ArrayList<ProductPojo>();
    	try
    	{
    		begin();
    		Query q = getSession().createQuery("from ProductPojo where status = :status and productName like :like");
    		q.setString("status", "approved");
    		q.setString("like", "%"+keyword+"%");
    		list = q.list();
    		close();
    	}
    	catch(HibernateException e)
    	{
    		rollback();
    		System.out.println("Could not fetch list by applying restrictions to it.");
    		
    	}
    	return list;
    }
	
	
	public List<ProductPojo> getLimitedProducts(int pn)
	{
		List<ProductPojo> list = null;
		try {
			begin();
			int numDisplay= 2;
			Query q = getSession().createQuery("from ProductPojo where status = :status");
			q.setString("status", "approved");
			q.setFirstResult(numDisplay * (pn-1));
			q.setMaxResults(numDisplay);
			list = q.list();
			close();
			return list;
			
		}
		catch(HibernateException e)
		{
			rollback();
			System.out.println("---Exception is---" + e);
		}
		
		
		return list;
	}
	
	
	public ProductPojo getProductFromId(int id)
	{
		
		ProductPojo pj = null;
		
		try {
			begin();
			Query q = getSession().createQuery("from ProductPojo where id= :id");
			q.setInteger("id", id);
			q.setMaxResults(1);
			pj = (ProductPojo)q.uniqueResult();
			return pj;
		}
		
		catch(HibernateException e)
		{
			rollback();
			System.out.println("---Exception is---" + e);
		}
		
		return pj;
	}
	
	public List<String> getReportData()
	{
		List<String> list= null;
		
		try {
			begin();
			Query q = getSession().createSQLQuery("select category from product_tbl");
			list = (List<String>)q.list();
			close();
			return list;
			
		}
		catch(HibernateException e)
		{
			rollback();
			System.out.println("---Exception is---" + e);
		}
		
		return list;
	}
	
}
