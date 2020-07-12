package itf;

import java.util.List;

import model.Bean_discount_infor;
import model.Bean_product_infor;
import util.BaseException;

public interface IDiscountManger {
	//��ʾ�Ż�ȯ
	public List<Bean_discount_infor> loadallDiscount_infor(Bean_product_infor product_infor)throws BaseException;
	//����Ż�ȯ
	public Bean_discount_infor addDiscount(Bean_discount_infor discount_infor)throws BaseException;
	//ɾ���Ż�ȯ
	public void deleteDiscount(Bean_discount_infor discount_infor)throws BaseException;
}
