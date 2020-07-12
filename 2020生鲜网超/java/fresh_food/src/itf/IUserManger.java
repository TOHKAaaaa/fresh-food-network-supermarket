package itf;

import java.util.List;

import model.Bean_admin_infor;
import model.Bean_customer_infor;
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
}
