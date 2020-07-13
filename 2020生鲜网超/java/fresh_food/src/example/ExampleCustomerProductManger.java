package example;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import itf.ICustomerProductManger;
import model.Bean_product_infor;
import model.Bean_product_order_form;
import util.BaseException;
import util.DBUtil;

public class ExampleCustomerProductManger implements ICustomerProductManger{

	@Override
	public Bean_product_order_form buyproduct(Bean_product_order_form order_form) throws BaseException {
		// TODO Auto-generated method stub
		Bean_product_order_form result = new Bean_product_order_form();
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<Bean_product_infor> loadall() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
