package itf;

import java.util.List;

import model.Bean_product_infor;
import util.BaseException;

public interface ICustomerProductManger {
	//�ͻ�������Ʒ
	
	//��ʾ������Ʒ
	public List<Bean_product_infor> loadall()throws BaseException;
}
