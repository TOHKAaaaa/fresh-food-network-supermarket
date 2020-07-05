package model;

import java.security.Timestamp;

public class Bean_full_product_associate {
	private String full_discount_id;
	private String product_id;
	private String fresh_food_id;
	private Timestamp product_discount_start_time;
	private Timestamp product_discount_end_time;
	
	public String getFull_discount_id() {
		return full_discount_id;
	}
	public void setFull_discount_id(String full_discount_id) {
		this.full_discount_id = full_discount_id;
	}
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
	public Timestamp getProduct_discount_start_time() {
		return product_discount_start_time;
	}
	public void setProduct_discount_start_time(Timestamp product_discount_start_time) {
		this.product_discount_start_time = product_discount_start_time;
	}
	public Timestamp getProduct_discount_end_time() {
		return product_discount_end_time;
	}
	public void setProduct_discount_end_time(Timestamp product_discount_end_time) {
		this.product_discount_end_time = product_discount_end_time;
	}
	
	
}
