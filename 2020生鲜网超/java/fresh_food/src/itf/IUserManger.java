package itf;

import java.util.List;

import model.Bean_admin_infor;
import model.Bean_customer_infor;
import model.Bean_order_form_details;
import model.Bean_product_order_form;
import util.BaseException;

public interface IUserManger {
	//����Աע��
	public Bean_admin_infor reg(String userid,String name, String pwd,String pwd2) throws BaseException;
	//����Ա��¼
	public Bean_admin_infor login(String userid,String pwd)throws BaseException;
	//����Ա�޸�����
	public void changePwd(Bean_admin_infor user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	//����Աɾ���û�
	public void deletecustomer(Bean_customer_infor customer)throws BaseException;
	//����Ա��ʾ�����û�
	public List<Bean_customer_infor> loadallCustomer()throws BaseException;
	//����Ա������Ʒ
//	public Bean_product_order_form buyproduct(Bean_product_order_form order_form)throws BaseException;
	//�û��������
	public List<Bean_product_order_form> list()throws BaseException;
}
