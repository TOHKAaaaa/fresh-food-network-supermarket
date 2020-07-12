package example;

import java.security.Timestamp;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import itf.ICustomerManger;
import model.Bean_customer_infor;
import util.BaseException;
import util.BusinessException;
import util.DBUtil;

public class ExampleCustomerManger implements ICustomerManger {

	@Override
	public Bean_customer_infor reg(String id, String name, int sex, String pwd, String pwd2, String phonenum,
			String email, String city, String regtime, int whetherVIP, String VIPtime) throws BaseException {
		// TODO Auto-generated method stub
		if(id==null)
			throw new BusinessException("用户名为空！");
		if(name==null)
			throw new BusinessException("姓名为空！");
		if(pwd==null||pwd2==null)
			throw new BusinessException("密码为空！");
		if(!pwd.equals(pwd2))
			throw new BusinessException("两次密码不一致！");
		Bean_customer_infor result = new Bean_customer_infor();
		java.sql.Connection conn = null;
		try {
			String sexString = null;
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM customer_infor\r\n" + 
					"WHERE customer_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				throw new BusinessException("该用户名已存在！");
			rs.close();
			pst.close();
			sql = "INSERT INTO customer_infor(customer_id,customer_name,customer_sex,customer_pwd,customer_phonenum,customer_email,customer_city,customer_registration_date,customer_VIPwhether)\r\n" + 
					"VALUES (?,?,?,?,?,?,?,NOW(),?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, name);
			if(sex==1)
				sexString = "1";
			else if(sex==0)
				sexString = "0";
			pst.setString(3, sexString);
			pst.setString(4, pwd);
			pst.setString(5, phonenum);
			pst.setString(6, email);
			pst.setString(7, city);
		//	pst.setTimestamp(8, java.sql.Timestamp.valueOf(regtime));
			pst.setString(8, String.valueOf(whetherVIP));
		//	pst.setTimestamp(9,java.sql.Timestamp.valueOf(VIPtime));
			result.setCustomer_id(id);
			result.setCustomer_name(name);
			result.setCustomer_sex(sexString);
			result.setCustomer_pwd(pwd);
			result.setCustomer_phonenum(phonenum);
			result.setCustomer_email(email);
			result.setCustomer_city(city);
			result.setCustomer_registration_date(regtime);
			result.setCustomer_VIPwhether(whetherVIP);
			pst.execute();
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
	public Bean_customer_infor login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		Bean_customer_infor result = new Bean_customer_infor();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM customer_infor\r\n" + 
					"WHERE customer_id = ? AND customer_pwd = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, pwd);
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("用户名不存在或密码不正确！");
			rs.close();
			pst.close();
			sql = "SELECT customer_id,customer_name,customer_sex,customer_pwd,customer_phonenum,customer_email,customer_city,customer_registration_date,customer_VIPwhether,customer_VIPddl\r\n" + 
					"FROM customer_infor\r\n" + 
					"WHERE customer_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			rs = pst.executeQuery();
			if(rs.next()) {
				result.setCustomer_id(rs.getString(1));
				result.setCustomer_name(rs.getString(2));
				result.setCustomer_sex(rs.getString(3));
				result.setCustomer_pwd(rs.getString(4));
				result.setCustomer_phonenum(rs.getString(5));
				result.setCustomer_email(rs.getString(6));
				result.setCustomer_city(rs.getString(7));
				result.setCustomer_registration_date(String.valueOf(rs.getTimestamp(8)));
				result.setCustomer_VIPwhether(Integer.valueOf(rs.getString(9)));
				result.setCustomer_VIPddl(rs.getTimestamp(10));
			}
			pst.close();
			rs.close();
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
	public void changePwd(Bean_customer_infor user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(user.getCustomer_id()==null)
			throw new BusinessException("用户名不存在！");
		if(oldPwd==null)
			throw new BusinessException("密码错误！");
		if(!newPwd.equals(newPwd2))
			throw new BusinessException("两次密码不一致！");
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM customer_infor\r\n" + 
					"WHERE customer_id = ? AND customer_pwd = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getCustomer_id());
			pst.setString(2, oldPwd);
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("用户名不存在或密码错误！");
			rs.close();
			pst.close();
			sql = "UPDATE customer_infor \r\n" + 
					"SET customer_pwd = ? \r\n" + 
					"WHERE customer_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getCustomer_id());
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
	public Bean_customer_infor changeInfor(String name, String sex, String phonenum, String email, String city)
			throws BaseException {
		// TODO Auto-generated method stub
		Bean_customer_infor result = new Bean_customer_infor();
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE customer_infor\r\n" + 
					"SET customer_name = ?,customer_sex = ?,customer_phonenum = ?,customer_email = ?,customer_city = ?\r\n" + 
					"WHERE customer_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, sex);
			pst.setString(3, phonenum);
			pst.setString(4, email);
			pst.setString(5, city);
			pst.setString(6, Bean_customer_infor.currentLogincustomer.getCustomer_id());
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
	public Bean_customer_infor becomeVIP(int time) throws BaseException {
		// TODO Auto-generated method stub
		Bean_customer_infor result = new Bean_customer_infor();
		java.sql.Connection conn = null;
		if(Bean_customer_infor.currentLogincustomer.isCustomer_VIPwhether().equals("是"))
			throw new BusinessException("您已经是会员了，不需要再次成为会员！");
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE customer_infor \r\n" + 
					"SET customer_VIPwhether = 1 \r\n" + 
					"WHERE customer_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, Bean_customer_infor.currentLogincustomer.getCustomer_id());
			pst.executeUpdate();
			pst.close();
			sql = "UPDATE customer_infor SET customer_VIPddl = DATE_ADD(NOW(),INTERVAL ? MONTH) WHERE customer_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, time);
			pst.setString(2, Bean_customer_infor.currentLogincustomer.getCustomer_id());
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

	@Override
	public Bean_customer_infor renewVIP(int time) throws BaseException {
		// TODO Auto-generated method stub
		Bean_customer_infor result = new Bean_customer_infor();
		java.sql.Connection conn = null;
		if(Bean_customer_infor.currentLogincustomer.isCustomer_VIPwhether().equals("否"))
			throw new BusinessException("您还不是会员了，请先注册成为会员！");
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE customer_infor \r\n" + 
					"SET customer_VIPwhether = 1 \r\n" + 
					"WHERE customer_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, Bean_customer_infor.currentLogincustomer.getCustomer_id());
			pst.executeUpdate();
			pst.close();
			sql = "UPDATE customer_infor SET customer_VIPddl = DATE_ADD(customer_VIPddl,INTERVAL ? MONTH) WHERE customer_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, time);
			pst.setString(2, Bean_customer_infor.currentLogincustomer.getCustomer_id());
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
