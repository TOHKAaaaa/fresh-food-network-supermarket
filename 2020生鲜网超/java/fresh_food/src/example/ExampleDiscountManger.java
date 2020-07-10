package example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import itf.IDiscountManger;
import model.Bean_discount_infor;
import model.Bean_product_infor;
import util.BaseException;
import util.DBUtil;

public class ExampleDiscountManger implements IDiscountManger{

	@Override
	public List<Bean_discount_infor> loadallDiscount_infor(Bean_product_infor product_infor) throws BaseException {
		// TODO Auto-generated method stub
		List<Bean_discount_infor> result = new ArrayList<Bean_discount_infor>();
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

}
