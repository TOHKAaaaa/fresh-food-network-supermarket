package model;

import java.security.Timestamp;

public class Bean_discount_infor {
	public static final String[] tableTitles={"优惠券id","启用日期","到期日期","减免价格","可用价格"};
	
	private String discount_id;
	private String product_id;
	private String fresh_food_id;
	private String discount_details;
	private float apply_price;
	private float discount_price;
	private Timestamp start_date;
	private Timestamp end_date;
	public String getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(String discount_id) {
		this.discount_id = discount_id;
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
	public String getDiscount_details() {
		return discount_details;
	}
	public void setDiscount_details(String discount_details) {
		this.discount_details = discount_details;
	}
	public float getApply_price() {
		return apply_price;
	}
	public void setApply_price(float apply_price) {
		this.apply_price = apply_price;
	}
	public float getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(float discount_price) {
		this.discount_price = discount_price;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
//	tableTitles={"优惠券id","启用日期","到期日期","减免价格","可用价格"}
	public String getCell(int col){
		String result;
		if(col==0) 
			result = getDiscount_id();
		else if(col==1) 
			result = String.valueOf(getStart_date());
		else if(col==2) 
			result = String.valueOf(getEnd_date());
		else if(col==3) 
			result = String.valueOf(getDiscount_price());
		else if(col==4) 
			result = String.valueOf(getApply_price());
		else 
			result = "";
		return result;
	}
	
	
}
