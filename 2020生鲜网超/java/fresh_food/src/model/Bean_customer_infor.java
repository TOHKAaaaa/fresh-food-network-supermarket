package model;

import java.sql.Timestamp;

public class Bean_customer_infor {
	public static Bean_customer_infor currentLogincustomer = null;
	public static final String[] tableTitles= {"客户用户名","客户姓名","客户性别","客户电话","是否为VIP"};
	
	private String customer_id;
	private String customer_name;
	private String customer_sex;
	private String customer_pwd;
	private String customer_phonenum;
	private String customer_email;
	private String customer_city;
	private Timestamp customer_registration_date;
	private int customer_VIPwhether;
	private Timestamp customer_VIPddl;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_sex() {
		if(this.customer_sex.equals("男")||this.customer_sex.equals("女"))
			return this.customer_sex;
		if(this.customer_sex.equals("1"))
			return "男";
		else
			return "女";
	}
	public void setCustomer_sex(String customer_sex) {
		this.customer_sex = customer_sex;
	}
	public String getCustomer_pwd() {
		return customer_pwd;
	}
	public void setCustomer_pwd(String customer_pwd) {
		this.customer_pwd = customer_pwd;
	}
	public String getCustomer_phonenum() {
		return customer_phonenum;
	}
	public void setCustomer_phonenum(String customer_phonenum) {
		this.customer_phonenum = customer_phonenum;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_city() {
		return customer_city;
	}
	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	public Timestamp getCustomer_registration_date() {
		return customer_registration_date;
	}
	public void setCustomer_registration_date(String customer_registration_date) {
		this.customer_registration_date = Timestamp.valueOf(customer_registration_date);
	}
	public String isCustomer_VIPwhether() {
		if(customer_VIPwhether==1)
			return "是";
		else
			return "否";
	}
	public void setCustomer_VIPwhether(int customer_VIPwhether) {
		this.customer_VIPwhether = customer_VIPwhether;
	}
	public Timestamp getCustomer_VIPddl() {
		return customer_VIPddl;
	}
	public void setCustomer_VIPddl(Timestamp customer_VIPddl) {
		this.customer_VIPddl = customer_VIPddl;
	}
	//{"客户用户名","客户姓名","客户性别","客户电话","是否为VIP"}
	public String getCell(int col) {
		String result;
		if(col==0)
			result = getCustomer_id();
		else if(col==1)
			result = getCustomer_name();
		else if(col==2)
			result = getCustomer_sex();
		else if(col==3)
			result = getCustomer_phonenum();
		else if(col==4)
			result = String.valueOf(isCustomer_VIPwhether());
//		else if(col==5)
//			result = String.valueOf(getCustomer_VIPddl());
		else
			result = "";
		return result;
	}
	
}
