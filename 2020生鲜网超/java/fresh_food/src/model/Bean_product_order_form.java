package model;

import java.security.Timestamp;

public class Bean_product_order_form {
	private String order_form_id;
	private String discount_id;
	private String customer_id;
	private String addr_id;
	private String order_form_state;
	private float original_price;
	private float finally_price;
	private Timestamp request_send_time;
	
	public String getOrder_form_id() {
		return order_form_id;
	}
	public void setOrder_form_id(String order_form_id) {
		this.order_form_id = order_form_id;
	}
	public String getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(String discount_id) {
		this.discount_id = discount_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}
	public String getOrder_form_state() {
		return order_form_state;
	}
	public void setOrder_form_state(String order_form_state) {
		this.order_form_state = order_form_state;
	}
	public float getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(float original_price) {
		this.original_price = original_price;
	}
	public float getFinally_price() {
		return finally_price;
	}
	public void setFinally_price(float finally_price) {
		this.finally_price = finally_price;
	}
	public Timestamp getRequest_send_time() {
		return request_send_time;
	}
	public void setRequest_send_time(Timestamp request_send_time) {
		this.request_send_time = request_send_time;
	}
	
}
