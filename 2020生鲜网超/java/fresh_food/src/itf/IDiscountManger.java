package itf;

import model.Bean_discount_infor;
import util.BaseException;

public interface IDiscountManger {
	//œ‘ æ”≈ª›»Ø
	public Bean_discount_infor loadallDiscount_infor()throws BaseException;
}
