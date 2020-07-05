package model;

public class Bean_order_form_details {
	private String product_id;
	private String fresh_food_id;
	private String full_discount_id;
	private String order_form_id;
	private int order_form_sum;
	private float order_form_price;
	private float discount;
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getFresh_food_id() {
		return fresh_food_id;
	}
	public void setFresh_food_id(String fresh_food_id) {
		this.fresh_food_id = fresh_food_id;
	}
	public String getFull_discount_id() {
		return full_discount_id;
	}
	public void setFull_discount_id(String full_discount_id) {
		this.full_discount_id = full_discount_id;
	}
	public String getOrder_form_id() {
		return order_form_id;
	}
	public void setOrder_form_id(String order_form_id) {
		this.order_form_id = order_form_id;
	}
	public int getOrder_form_sum() {
		return order_form_sum;
	}
	public void setOrder_form_sum(int order_form_sum) {
		this.order_form_sum = order_form_sum;
	}
	public float getOrder_form_price() {
		return order_form_price;
	}
	public void setOrder_form_price(float order_form_price) {
		this.order_form_price = order_form_price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
}
