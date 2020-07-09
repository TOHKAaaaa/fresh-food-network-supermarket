package itf;

import java.util.List;

import model.Bean_product_infor;
import util.BaseException;

public interface ICustomerProductManger {
	//客户购买商品
	
	//显示所有商品
	public List<Bean_product_infor> loadall()throws BaseException;
}
