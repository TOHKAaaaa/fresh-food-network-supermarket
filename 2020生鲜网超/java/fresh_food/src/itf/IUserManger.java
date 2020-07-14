package itf;

import java.util.List;

import model.Bean_admin_infor;
import model.Bean_customer_infor;
import model.Bean_order_form_details;
import model.Bean_product_order_form;
import util.BaseException;

public interface IUserManger {
	//管理员注册
	public Bean_admin_infor reg(String userid,String name, String pwd,String pwd2) throws BaseException;
	//管理员登录
	public Bean_admin_infor login(String userid,String pwd)throws BaseException;
	//管理员修改密码
	public void changePwd(Bean_admin_infor user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	//管理员删除用户
	public void deletecustomer(Bean_customer_infor customer)throws BaseException;
	//管理员显示所有用户
	public List<Bean_customer_infor> loadallCustomer()throws BaseException;
	//管理员购买商品
//	public Bean_product_order_form buyproduct(Bean_product_order_form order_form)throws BaseException;
	//用户消费情况
	public List<Bean_product_order_form> list()throws BaseException;
}
