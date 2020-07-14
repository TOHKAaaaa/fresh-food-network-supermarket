package itf;

import java.util.List;

import model.Bean_product_infor;
import model.Bean_product_order_form;
import util.BaseException;

public interface ICustomerProductManger {
	//客户购买商品
	public Bean_product_order_form buyproduct(Bean_product_order_form order_form)throws BaseException;
	//显示购物车
	public List<Bean_product_order_form> loadall()throws BaseException;
	//客户删除商品
	public void delproduct(Bean_product_order_form order_form)throws BaseException;
	//客户结算商品
	public float paidOrder_form(Bean_product_order_form order_form)throws BaseException;
}
