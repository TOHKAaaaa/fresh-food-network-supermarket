package example;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import itf.IUserManger;
import model.Bean_admin_infor;
import model.Bean_customer_infor;
import util.BaseException;
import util.BusinessException;
import util.DBUtil;

public class ExampleUserManger implements IUserManger {

	@Override
	public Bean_admin_infor reg(String userid,String name, String pwd, String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		Bean_admin_infor result = new Bean_admin_infor();
		if(userid==null)
			throw new BusinessException("�û���Ϊ�գ�");
		if(!pwd.equals(pwd2))
			throw new BusinessException("�����������벻һ�£�");
		if(pwd==null||pwd2==null)
			throw new BusinessException("���벻��Ϊ�գ�");
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
				throw new BusinessException("�û����Ѵ��ڣ�");
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
				throw new BusinessException("�û��������ڻ��������");
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
			throw new BusinessException("�����벻��Ϊ�գ�");
		if(newPwd==null||newPwd2==null)
			throw new BusinessException("�����벻��Ϊ�գ�");
		if(newPwd.equals(newPwd2)==false)
			throw new BusinessException("�������벻һ�£�");
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
				throw new BusinessException("�û��������ڻ��������");
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
				throw new BusinessException("�ÿͻ�����VIP���޷�ɾ����");
			rs.close();
			pst.close();
			sql = "DELETE FROM customer_infor WHERE customer_id = ?";
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

}
