package itf;

import java.util.List;

import model.Bean_product_infor;
import model.Bean_product_order_form;
import util.BaseException;

public interface ICustomerProductManger {
	//客户购买商品
	public Bean_product_order_form buyproduct(Bean_product_order_form order_form)throws BaseException;
	//显示购物车
	public List<Bean_product_infor> loadall()throws BaseException;
}
