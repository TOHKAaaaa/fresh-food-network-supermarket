package model;

import java.security.Timestamp;

public class Bean_full_discount_infor {
	private String full_discount_id;
	private String full_discount_details;
	private int able_sum;
	private float discount;
	private Timestamp full_discount_start_time;
	private Timestamp full_discount_end_time;
	public String getFull_discount_id() {
		return full_discount_id;
	}
	public void setFull_discount_id(String full_discount_id) {
		this.full_discount_id = full_discount_id;
	}
	public String getFull_discount_details() {
		return full_discount_details;
	}
	public void setFull_discount_details(String full_discount_details) {
		this.full_discount_details = full_discount_details;
	}
	public int getAble_sum() {
		return able_sum;
	}
	public void setAble_sum(int able_sum) {
		this.able_sum = able_sum;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Timestamp getFull_discount_start_time() {
		return full_discount_start_time;
	}
	public void setFull_discount_start_time(Timestamp full_discount_start_time) {
		this.full_discount_start_time = full_discount_start_time;
	}
	public Timestamp getFull_discount_end_time() {
		return full_discount_end_time;
	}
	public void setFull_discount_end_time(Timestamp full_discount_end_time) {
		this.full_discount_end_time = full_discount_end_time;
	}
	
	
}
