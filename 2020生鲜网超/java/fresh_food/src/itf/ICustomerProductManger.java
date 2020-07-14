package itf;

import java.util.List;

import model.Bean_product_infor;
import model.Bean_product_order_form;
import util.BaseException;

public interface ICustomerProductManger {
	//�ͻ�������Ʒ
	public Bean_product_order_form buyproduct(Bean_product_order_form order_form)throws BaseException;
	//��ʾ���ﳵ
	public List<Bean_product_order_form> loadall()throws BaseException;
	//�ͻ�ɾ����Ʒ
	public void delproduct(Bean_product_order_form order_form)throws BaseException;
	//�ͻ�������Ʒ
	public float paidOrder_form(Bean_product_order_form order_form)throws BaseException;
}
