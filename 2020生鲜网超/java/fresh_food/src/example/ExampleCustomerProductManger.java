package example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import itf.ICustomerProductManger;
import model.Bean_customer_infor;
import model.Bean_product_infor;
import model.Bean_product_order_form;
import util.BaseException;
import util.BusinessException;
import util.DBUtil;

public class ExampleCustomerProductManger implements ICustomerProductManger{

	@Override
	public Bean_product_order_form buyproduct(Bean_product_order_form order_form) throws BaseException {
		// TODO Auto-generated method stub
		Bean_product_order_form result = new Bean_product_order_form();
		java.sql.Connection conn = null;
		System.out.println(order_form.getProduct_id());
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT MAX(order_form_id)\r\n" + 
					"FROM product_order_form\r\n" + 
					"WHERE customer_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, Bean_customer_infor.currentLogincustomer.getCustomer_id());
			java.sql.ResultSet rs = pst.executeQuery();
			int max = 0;
			if(rs.next())
				max = rs.getInt(1)+1;
			rs.close();
			pst.close();
			sql = "INSERT INTO product_order_form(order_form_id,discount_id,customer_id,original_price,finally_price,order_form_state,fresh_food_id,product_id,product_num,product_name,addr_id)\r\n" + 
					"VALUES(?,?,?,?,?,0,?,?,?,?,1)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, String.valueOf(max));
			pst.setString(2, order_form.getDiscount_id());
			pst.setString(3, Bean_customer_infor.currentLogincustomer.getCustomer_id());
			pst.setFloat(4, order_form.getOriginal_price());
			pst.setFloat(5, order_form.getFinally_price());
			pst.setString(6, order_form.getFresh_food_id());
			pst.setString(7, order_form.getProduct_id());
			pst.setInt(8, order_form.getProduct_num());
			pst.setString(9, order_form.getProduct_name());
			pst.execute();
			pst.close();
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
	public List<Bean_product_order_form> loadall() throws BaseException {
		// TODO Auto-generated method stub
//		tableTitles={"订单编号","生鲜编号","商品编号","商品名称","数量","单价","最终价"};
		java.sql.Connection conn = null;
		List<Bean_product_order_form> result = new ArrayList<Bean_product_order_form> ();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT order_form_id,fresh_food_id,product_id,product_name,product_num,original_price,finally_price\r\n" + 
					"FROM product_order_form\r\n" + 
					"WHERE customer_id = ? AND order_form_state = 0\r\n" + 
					"ORDER BY order_form_id";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, Bean_customer_infor.currentLogincustomer.getCustomer_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bean_product_order_form p = new Bean_product_order_form();
				p.setOrder_form_id(rs.getString(1));
				p.setFresh_food_id(rs.getString(2));
				p.setProduct_id(rs.getString(3));
				p.setProduct_name(rs.getString(4));
				p.setProduct_num(rs.getInt(5));
				p.setOriginal_price(rs.getFloat(6));
				p.setFinally_price(rs.getFloat(7));
				result.add(p);
			}
			rs.close();
			pst.close();
			return result;
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
	public void delproduct(Bean_product_order_form order_form) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE product_order_form\r\n" + 
					"SET order_form_state = -1\r\n" + 
					"WHERE order_form_id = ? AND fresh_food_id = ? AND product_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, order_form.getOrder_form_id());
			pst.setString(2, order_form.getFresh_food_id());
			pst.setString(3, order_form.getProduct_id());
			pst.executeUpdate();
			pst.close();
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
	}

	@Override
	public float paidOrder_form(Bean_product_order_form order_form) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		float result = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT product_num*finally_price\r\n" + 
					"FROM product_order_form\r\n" + 
					"WHERE order_form_id = ? AND fresh_food_id = ? AND product_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, order_form.getOrder_form_id());
			pst.setString(2, order_form.getFresh_food_id());
			pst.setString(3, order_form.getProduct_id());
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				result = rs.getFloat(1);
			rs.close();
			pst.close();
			sql = "SELECT product_num\r\n" + 
					"FROM product_infor\r\n" + 
					"WHERE product_id = ? AND fresh_food_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, order_form.getProduct_id());
			pst.setString(2, order_form.getFresh_food_id());
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)<order_form.getProduct_num())
					throw new BusinessException("商品库存不足，无法购买！");
			}
			rs.close();
			pst.close();
			sql = "UPDATE product_infor\r\n" + 
					"SET product_num = product_num - ?\r\n" + 
					"WHERE fresh_food_id = ? AND product_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, order_form.getProduct_num());
			pst.setString(2, order_form.getFresh_food_id());
			pst.setString(3, order_form.getProduct_id());
			pst.executeUpdate();
			pst.close();
			sql = "UPDATE product_order_form\r\n" + 
					"SET order_form_state = 1\r\n" + 
					"WHERE order_form_id = ? AND fresh_food_id = ? AND product_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, order_form.getOrder_form_id());
			pst.setString(2, order_form.getFresh_food_id());
			pst.setString(3, order_form.getProduct_id());
			pst.executeUpdate();
			pst.close();
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
