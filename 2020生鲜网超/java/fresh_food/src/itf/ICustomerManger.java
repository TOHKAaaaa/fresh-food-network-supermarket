package itf;

import java.security.Timestamp;

import model.Bean_customer_infor;
import util.BaseException;

public interface ICustomerManger {
	//客户注册
	public Bean_customer_infor reg(String id,String name,int sex,String pwd,String pwd2,String phonenum,String email,String city,String regtime,int whetherVIP,String VIPtime)throws BaseException;
	//客户登录
	public Bean_customer_infor login(String userid,String pwd)throws BaseException;
	//客户修改密码
	public void changePwd(Bean_customer_infor user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	//客户修改个人信息
	//姓名，性别，电话号码，电子邮箱，所在城市
	public Bean_customer_infor changeInfor (String name,String sex,String phonenum,String email,String city)throws BaseException;
}
