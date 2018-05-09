package in.developersera.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_tbl")
public class Cart implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartid;
	
	@Column(name="status")
	private int status=0;
	
	
	@ManyToOne
	@JoinColumn(name="productpojo_id")
	private ProductPojo productpojo;
	
	
	@ManyToOne
	@JoinColumn(name="userpojo_id")
	private UserPojo userpojo;
	
	@Column(name="quantity")
	private int quantity;
	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UserPojo getUserpojo() {
		return userpojo;
	}

	public void setUserpojo(UserPojo userpojo) {
		this.userpojo = userpojo;
	}

	public ProductPojo getProductpojo() {
		return productpojo;
	}

	public void setProductpojo(ProductPojo productpojo) {
		this.productpojo = productpojo;
	}

}
