package model;

import java.security.Timestamp;

public class Bean_limited_time_promotion_infor {
	private String limited_time_promotion_id;
	private String product_id;
	private String fresh_food_id;
	private int limited_time_promotion_sum;
	private float limited_time_promotion_price;
	private Timestamp associate_start_time;
	private Timestamp associate_end_time;
	
	public String getLimited_time_promotion_id() {
		return limited_time_promotion_id;
	}
	public void setLimited_time_promotion_id(String limited_time_promotion_id) {
		this.limited_time_promotion_id = limited_time_promotion_id;
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
	public int getLimited_time_promotion_sum() {
		return limited_time_promotion_sum;
	}
	public void setLimited_time_promotion_sum(int limited_time_promotion_sum) {
		this.limited_time_promotion_sum = limited_time_promotion_sum;
	}
	public float getLimited_time_promotion_price() {
		return limited_time_promotion_price;
	}
	public void setLimited_time_promotion_price(float limited_time_promotion_price) {
		this.limited_time_promotion_price = limited_time_promotion_price;
	}
	public Timestamp getAssociate_start_time() {
		return associate_start_time;
	}
	public void setAssociate_start_time(Timestamp associate_start_time) {
		this.associate_start_time = associate_start_time;
	}
	public Timestamp getAssociate_end_time() {
		return associate_end_time;
	}
	public void setAssociate_end_time(Timestamp associate_end_time) {
		this.associate_end_time = associate_end_time;
	}
	
	
}
