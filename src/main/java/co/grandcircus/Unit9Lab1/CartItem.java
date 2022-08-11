package co.grandcircus.Unit9Lab1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cartItems")
public class CartItem {
	
	@Id
	public String id;
	private String product;
	private Double price;
	private Integer quantity;
	
	
	
	public CartItem() {
	}
	public CartItem(String product, Double price, Integer quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	public CartItem(String id, String product, Double price, Integer quantity) {
		this.id = id;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	



}
