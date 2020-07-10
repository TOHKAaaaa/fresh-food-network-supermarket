package itf;

import java.util.List;

import model.Bean_discount_infor;
import model.Bean_product_infor;
import util.BaseException;

public interface IDiscountManger {
	//œ‘ æ”≈ª›»Ø
	public List<Bean_discount_infor> loadallDiscount_infor(Bean_product_infor product_infor)throws BaseException;
}
