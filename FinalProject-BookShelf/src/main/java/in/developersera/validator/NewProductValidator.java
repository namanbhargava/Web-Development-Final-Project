package in.developersera.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import in.developersera.dao.CategoryDAO;
import in.developersera.dao.ProductDao;
import in.developersera.pojo.Category;
import in.developersera.pojo.ProductPojo;

@Component
public class NewProductValidator  implements Validator {

	@Autowired
	@Qualifier("productDao")
	ProductDao productDao;
	
	public boolean supports(Class aClass) {
		return ProductPojo.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		ProductPojo newProduct = (ProductPojo) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price", "Price Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.description", "Description Required");
	
		
		if (errors.hasErrors()) {
            return;//Skip the rest of the validation rules
        }
        
	
//		try {
//			Category c = categoryDAO.get(newCategory.getTitle());
//			if(c !=null)
//				errors.rejectValue("title", "error.invalid.category", "Category already Exists");
//			
//		} catch (CategoryException e) {
//			System.err.println("Exception in Category Validator");
//		}
//		
		
		
	
	}
}

