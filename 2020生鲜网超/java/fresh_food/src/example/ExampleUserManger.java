package example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import itf.IUserManger;
import model.Bean_admin_infor;
import model.Bean_customer_infor;
import model.Bean_order_form_details;
import model.Bean_product_order_form;
import util.BaseException;
import util.BusinessException;
import util.DBUtil;

public class ExampleUserManger implements IUserManger {

	@Override
	public Bean_admin_infor reg(String userid,String name, String pwd, String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		Bean_admin_infor result = new Bean_admin_infor();
		if(userid==null)
			throw new BusinessException("用户名为空！");
		if(!pwd.equals(pwd2))
			throw new BusinessException("两次密码输入不一致！");
		if(pwd==null||pwd2==null)
			throw new BusinessException("密码不能为空！");
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM admin_infor\r\n" + 
					"WHERE admin_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				throw new BusinessException("用户名已存在！");
			rs.close();
			pst.close();
			sql = "INSERT INTO admin_infor(admin_id,admin_name,admin_pwd)\r\n" + 
					"VALUES (?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, name);
			pst.setString(3, pwd);
			pst.execute();
			return result;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;	
	}

	@Override
	public Bean_admin_infor login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Bean_admin_infor result = new Bean_admin_infor();
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM admin_infor\r\n" + 
					"WHERE admin_id = ? AND admin_pwd = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, pwd);
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("用户名不存在或密码错误！");
			rs.close();
			pst.close();
			sql = "SELECT admin_id,admin_name,admin_pwd\r\n" + 
					"FROM admin_infor\r\n" + 
					"WHERE admin_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			rs = pst.executeQuery();
			if(rs.next()) {
				result.setAdmin_id(rs.getString(1));
				result.setAdmin_name(rs.getString(2));
				result.setAdmin_pwd(rs.getString(3));
			}
			pst.close();
			rs.close();
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
	public void changePwd(Bean_admin_infor user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		if(oldPwd==null)
			throw new BusinessException("旧密码不能为空！");
		if(newPwd==null||newPwd2==null)
			throw new BusinessException("新密码不能为空！");
		if(newPwd.equals(newPwd2)==false)
			throw new BusinessException("两次密码不一致！");
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM admin_infor\r\n" + 
					"WHERE admin_id = ? AND admin_pwd = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getAdmin_id());
			pst.setString(2, oldPwd);
			java.sql.ResultSet rs = pst.executeQuery();
			
			if(!rs.next())
				throw new BusinessException("用户名不存在或密码错误！");
			rs.close();
			pst.close();
			sql = "UPDATE admin_infor\r\n" + 
					"SET admin_pwd = ?\r\n" + 
					"WHERE admin_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getAdmin_id());
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
	public void deletecustomer(Bean_customer_infor customer) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM customer_infor\r\n" + 
					"WHERE customer_id = ? AND customer_VIPwhether = 1";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, customer.getCustomer_id());
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				throw new BusinessException("该客户还是VIP，无法删除！");
			rs.close();
			pst.close();
			sql = "DELETE FROM customer_infor WHERE customer_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, customer.getCustomer_id());
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
	public List<Bean_customer_infor> loadallCustomer() throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		List<Bean_customer_infor> result = new ArrayList<Bean_customer_infor>();
		try {
			conn = DBUtil.getConnection();
			//{"客户用户名","客户姓名","客户性别","客户电话","是否为VIP","VIP过期时间"}
			String sql = "SELECT customer_id,customer_name,customer_sex,customer_phonenum,customer_VIPwhether\r\n" + 
					"FROM customer_infor\r\n" + 
					"ORDER BY customer_id";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bean_customer_infor bean_customer_infor = new Bean_customer_infor();
				bean_customer_infor.setCustomer_id(rs.getString(1));
				bean_customer_infor.setCustomer_name(rs.getString(2));
				bean_customer_infor.setCustomer_sex(rs.getString(3));
				bean_customer_infor.setCustomer_phonenum(rs.getString(4));
				bean_customer_infor.setCustomer_VIPwhether(rs.getInt(5));
//				bean_customer_infor.setCustomer_VIPddl(rs.getTimestamp(6));
				result.add(bean_customer_infor);
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
	public List<Bean_product_order_form> list() throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		List<Bean_product_order_form> result = new ArrayList<Bean_product_order_form>();
		try {
			conn = DBUtil.getConnection();
//			CustomerTitle[]={"客户编号","订单编号","生鲜编号","商品编号","商品名称","数量","结算单价"};
			String sql = "SELECT customer_id,order_form_id,fresh_food_id,product_id,product_name,product_num,finally_price\r\n" + 
					"FROM product_order_form\r\n" + 
					"WHERE order_form_state = 1\r\n" + 
					"ORDER BY customer_id";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bean_product_order_form bean_customer_infor = new Bean_product_order_form();
				bean_customer_infor.setCustomer_id(rs.getString(1));
				bean_customer_infor.setOrder_form_id(rs.getString(2));
				bean_customer_infor.setFresh_food_id(rs.getString(3));
				bean_customer_infor.setProduct_id(rs.getString(4));
				bean_customer_infor.setProduct_name(rs.getString(5));
				bean_customer_infor.setProduct_num(rs.getInt(6));
				bean_customer_infor.setFinally_price(rs.getFloat(7));
				result.add(bean_customer_infor);
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

//	@Override
//	public Bean_product_order_form buyproduct(Bean_product_order_form order_form) throws BaseException {
//		// TODO Auto-generated method stub
//		java.sql.Connection conn = null;
//		Bean_product_order_form result = new Bean_product_order_form();
//		try {
//			conn = DBUtil.getConnection();
//			String sql = "";
//			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}finally {
//			if(conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}

	

}
