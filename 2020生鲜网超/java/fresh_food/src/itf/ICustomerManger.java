package itf;

import java.security.Timestamp;
import java.util.List;

import model.Bean_customer_infor;
import model.Bean_product_order_form;
import util.BaseException;

public interface ICustomerManger {
	//�ͻ�ע��
	public Bean_customer_infor reg(String id,String name,int sex,String pwd,String pwd2,String phonenum,String email,String city,String regtime,int whetherVIP,String VIPtime)throws BaseException;
	//�ͻ���¼
	public Bean_customer_infor login(String userid,String pwd)throws BaseException;
	//�ͻ��޸�����
	public void changePwd(Bean_customer_infor user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	//�ͻ��޸ĸ�����Ϣ
	//�������Ա𣬵绰���룬�������䣬���ڳ���
	public Bean_customer_infor changeInfor (String name,String sex,String phonenum,String email,String city)throws BaseException;
	//�ͻ���Ϊ��Ա
	public Bean_customer_infor becomeVIP (int time)throws BaseException;
	//�ͻ����ѻ�Ա
	public Bean_customer_infor renewVIP (int time)throws BaseException;
	//�ѹ���Ʒ
	public List<Bean_product_order_form> list()throws BaseException;
}
