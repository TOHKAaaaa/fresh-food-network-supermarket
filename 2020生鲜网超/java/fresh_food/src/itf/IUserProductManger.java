package itf;

import java.util.List;

import model.Bean_product_infor;
import util.BaseException;

public interface IUserProductManger {
	//管理员添加商品
	public Bean_product_infor addProduct(int product_id,String product_name,float price,float VIP_price,int fresh_food_id,String fresh_food_name,String product_describe)throws BaseException;
	//显示所有商品
	public List<Bean_product_infor> loadallProduct () throws BaseException;
	//管理员删除商品
	public void deleteProduct(Bean_product_infor product)throws BaseException;
	//管理员采购商品
	public Bean_product_infor buyProduct (int product_id,int fresh_food_id,int sum)throws BaseException;
	
}
