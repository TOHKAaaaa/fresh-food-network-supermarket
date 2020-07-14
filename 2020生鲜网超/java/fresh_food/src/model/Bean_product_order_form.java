package model;

import java.security.Timestamp;

public class Bean_product_order_form {
	public static final String[] tableTitles={"订单编号","生鲜编号","商品编号","商品名称","数量","单价","最终价"};
	
	private String order_form_id;
	private String discount_id;
	private String customer_id;
	private String addr_id;
	private String order_form_state;
	private float original_price;
	private float finally_price;
	private Timestamp request_send_time;
	private String product_id;
	private String fresh_food_id;
	private int product_num;
	private String product_name;
	private float apply_price;
	private float discount_price;
	
	
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
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
	
//	tableTitles={"订单编号","生鲜编号","商品编号","商品名称","数量","单价","最终价"};
	public String getCell(int col) {
		String result;
		if(col==0)
			result = this.getOrder_form_id();
		else if (col==1) 
			result = this.getFresh_food_id();
		else if (col==2)
			result = this.getProduct_id();
		else if (col==3)
			result = this.getProduct_name();
		else if (col==4)
			result = String.valueOf(this.getProduct_num());
		else if(col==5)
			result = String.valueOf(this.getOriginal_price());
		else if(col==6)
			result = String.valueOf(this.getFinally_price());
		else
			result = "";
		return result;
	}
//	CustomerTitle[]={"客户编号","订单编号","生鲜编号","商品编号","商品名称","数量","结算单价"};
	public String getconCell(int col) {
		String result;
		if(col==0)
			result = this.getCustomer_id();
		else if(col==1)
			result = this.getOrder_form_id();
		else if(col==2)
			result = this.getFresh_food_id();
		else if(col==3)
			result = this.getProduct_id();
		else if(col==4)
			result = this.getProduct_name();
		else if(col==5)
			result = String.valueOf(this.getProduct_num());
		else if(col==6)
			result = String.valueOf(this.getFinally_price());
		else
			result = "";
		return result;
	}
}
