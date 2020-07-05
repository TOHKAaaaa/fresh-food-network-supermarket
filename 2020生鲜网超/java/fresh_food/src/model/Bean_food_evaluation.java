package model;

import java.security.Timestamp;

public class Bean_food_evaluation {
	private String product_id;
	private String fresh_food_id;
	private String customer_id;
	private String evaluation_infor;
	private String photos;
	private Timestamp evaluation_date;
	private int evaluation_star;
	
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
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getEvaluation_infor() {
		return evaluation_infor;
	}
	public void setEvaluation_infor(String evaluation_infor) {
		this.evaluation_infor = evaluation_infor;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public Timestamp getEvaluation_date() {
		return evaluation_date;
	}
	public void setEvaluation_date(Timestamp evaluation_date) {
		this.evaluation_date = evaluation_date;
	}
	public int getEvaluation_star() {
		return evaluation_star;
	}
	public void setEvaluation_star(int evaluation_star) {
		this.evaluation_star = evaluation_star;
	}
	
	
}
