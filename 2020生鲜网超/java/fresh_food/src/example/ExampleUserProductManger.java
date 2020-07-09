package example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import itf.IUserProductManger;
import model.Bean_product_infor;
import util.BaseException;
import util.BusinessException;
import util.DBUtil;

public class ExampleUserProductManger implements IUserProductManger{

	@Override
	public Bean_product_infor addProduct(String product_name, float price, float VIP_price, int fresh_food_id,
			String fresh_food_name) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		Bean_product_infor result = new Bean_product_infor();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM product_infor\r\n" + 
					"WHERE product_name = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, product_name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("存在同名商品！");
			rs.close();
			pst.close();
			int maxproductid=0;
			sql = "SELECT max(product_id)\r\n" + 
					"FROM product_infor\r\n" + 
					"WHERE fresh_food_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fresh_food_id);
			rs = pst.executeQuery();
			if(rs.next())
				maxproductid = rs.getInt(1) + 1;
			else
				maxproductid = 1;
			pst.close();
			rs.close();
			sql = "INSERT INTO product_infor(product_name,product_price,product_VIP_price,fresh_food_id,fresh_food_name,product_id)\r\n" + 
					"VALUE (?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, product_name);
			pst.setFloat(2, price);
			pst.setFloat(3, VIP_price);
			pst.setInt(4, fresh_food_id);
			pst.setString(5, fresh_food_name);
			pst.setInt(6, maxproductid);
			pst.execute();
			pst.close();
			result.setProduct_name(product_name);
			result.setProduct_price(price);
			result.setProduct_VIP_price(VIP_price);
			result.setFresh_food_id(fresh_food_id);
			result.setFresh_food_name(fresh_food_name);
			result.setProduct_id(maxproductid);
			return result;
		} catch (SQLException e) {
			// TODO: handle exception
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
	public List<Bean_product_infor> loadallProduct() throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		List<Bean_product_infor> result = new ArrayList<Bean_product_infor>();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT product_id,product_name,product_price,product_VIP_price,product_num,product_specification,product_details,fresh_food_id,fresh_food_name,fresh_food_describe\r\n" + 
					"FROM product_infor\r\n" + 
					"ORDER BY fresh_food_id";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bean_product_infor p = new Bean_product_infor();
				p.setProduct_id(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setProduct_price(rs.getFloat(3));
				p.setProduct_VIP_price(rs.getFloat(4));
				p.setProduct_num(rs.getInt(5));
				p.setProduct_specification(rs.getString(6));
				p.setProduct_details(rs.getString(7));
				p.setFresh_food_id(rs.getInt(8));
				p.setFresh_food_name(rs.getString(9));
				p.setFresh_food_describe(rs.getString(10));
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
	public void deleteProduct(Bean_product_infor product) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn =null;
		if(product.getProduct_num()>0)
			throw new BusinessException("该商品已经存在库存！");
		try {
			conn = DBUtil.getConnection();
			String sql = "DELETE FROM product_infor \r\n" + 
					"WHERE fresh_food_id = ? AND product_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, product.getFresh_food_id());
			pst.setInt(2, product.getProduct_id());
			pst.execute();
			pst.close();
			sql = "UPDATE product_infor SET product_id = 0 - product_id\r\n" + 
					"WHERE product_id > ? AND fresh_food_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, product.getProduct_id());
			pst.setInt(2, product.getFresh_food_id());
			pst.execute();
			pst.close();
			sql = "UPDATE product_infor SET product_id = -1 - product_id\r\n" + 
					"WHERE product_id < 0 AND fresh_food_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, product.getFresh_food_id());
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
	}

	@Override
	public Bean_product_infor buyProduct(int product_id,int fresh_food_id,int sum) throws BaseException {
		// TODO Auto-generated method stub
		Bean_product_infor result = new Bean_product_infor();
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE product_infor \r\n" + 
					"SET product_num = ?\r\n" + 
					"WHERE product_id = ? AND fresh_food_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sum);
			pst.setInt(2, product_id);
			pst.setInt(3, fresh_food_id);
			pst.execute();
			pst.close();
			result.setProduct_num(sum);
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

}
