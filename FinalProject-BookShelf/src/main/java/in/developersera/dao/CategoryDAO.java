package in.developersera.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import in.developersera.exception.CategoryException;
import in.developersera.pojo.Category;


public class CategoryDAO extends DAO {

    public Category get(String title) throws CategoryException {
        try {
            begin();
            Query q=getSession().createQuery("from Category where title= :title");
            q.setString("title",title);
            Category category=(Category)q.uniqueResult();
            return category;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not obtain the named category " + title + " " + e.getMessage());
        }
    }
    
    public List<Category> getCategory() throws CategoryException {
        try {
            begin();
            Query q=getSession().createQuery("from Category");
            List<Category> categoryList = q.list();
            return categoryList;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not obtain the named category " + e.getMessage());
        }
    }

    public Category create(String title) throws CategoryException {
        try {
            begin();
            Category cat = new Category(title);
            getSession().save(cat);
            commit();
            return cat;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new CategoryException("Exception while creating category: " + e.getMessage());
        }
    }

    public void update(Category category) throws CategoryException {
        try {
            begin();
            getSession().update(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not save the category", e);
        }
    }

    public void delete(Category category) throws CategoryException {
        try {
            begin();
            getSession().delete(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not delete the category", e);
        }
    }
}