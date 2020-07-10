package example;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import itf.IDiscountManger;
import model.Bean_discount_infor;
import util.BaseException;
import util.DBUtil;

public class ExampleDiscountManger implements IDiscountManger{

	@Override
	public Bean_discount_infor loadallDiscount_infor() throws BaseException {
		// TODO Auto-generated method stub
		Bean_discount_infor result = new Bean_discount_infor();
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
