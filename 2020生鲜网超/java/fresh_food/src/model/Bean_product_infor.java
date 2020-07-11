package model;

public class Bean_product_infor {
	public static final String[] tableTitles={"生鲜编号","生鲜类别","商品编号","商品名称","数量","价格","会员价","商品描述"};
	
	private int product_id;
	private String product_name;
	private String product_specification;
	private String product_details;
	private int fresh_food_id;
	private String fresh_food_name;
	private String fresh_food_describe;
	private float product_price;
	private float product_VIP_price;
	private int product_num;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_specification() {
		return product_specification;
	}
	public void setProduct_specification(String product_specification) {
		this.product_specification = product_specification;
	}
	public String getProduct_details() {
		return product_details;
	}
	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}
	public int getFresh_food_id() {
		return fresh_food_id;
	}
	public void setFresh_food_id(int fresh_food_id2) {
		this.fresh_food_id = fresh_food_id2;
	}
	public String getFresh_food_name() {
		return fresh_food_name;
	}
	public void setFresh_food_name(String fresh_food_name) {
		this.fresh_food_name = fresh_food_name;
	}
	public String getFresh_food_describe() {
		return fresh_food_describe;
	}
	public void setFresh_food_describe(String fresh_food_describe) {
		this.fresh_food_describe = fresh_food_describe;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public float getProduct_VIP_price() {
		return product_VIP_price;
	}
	public void setProduct_VIP_price(float product_VIP_price) {
		this.product_VIP_price = product_VIP_price;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	
	//tableTitles={"商品id","商品名称","数量","价格","会员价"}
	public String getCell(int col){
		String result = null;
		
		if(col==0)
			result = String.valueOf(getFresh_food_id());
		else if(col==1)
			result = getFresh_food_name();
		else if(col==2) 
			result = String.valueOf(getProduct_id());
		else if(col==3) 
			result = getProduct_name();
		else if(col==4) 
			result = String.valueOf(getProduct_num());
		else if(col==5) 
			result = String.valueOf(getProduct_price());
		else if(col==6)
			result = String.valueOf(getProduct_VIP_price());
		else if(col==7)
			result = getFresh_food_describe();
		else 
			result = "";
		return result;
	}
	
}
