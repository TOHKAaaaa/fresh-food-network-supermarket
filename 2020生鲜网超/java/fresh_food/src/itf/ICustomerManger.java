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
}
