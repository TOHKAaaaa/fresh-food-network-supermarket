package example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import itf.IDiscountManger;
import model.Bean_discount_infor;
import model.Bean_product_infor;
import util.BaseException;
import util.BusinessException;
import util.DBUtil;

public class ExampleDiscountManger implements IDiscountManger{

	//{"�����Ż�ȯid","��������","��������","����۸�","���ü۸�"}
	@Override
	public List<Bean_discount_infor> loadallDiscount_infor(Bean_product_infor product_infor) throws BaseException {
		// TODO Auto-generated method stub
		List<Bean_discount_infor> result = new ArrayList<Bean_discount_infor>();
		java.sql.Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT discount_id,start_date,end_date,discount_price,apply_price\r\n" + 
					"FROM discount_infor\r\n" + 
					"WHERE product_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, product_infor.getProduct_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bean_discount_infor p = new Bean_discount_infor();
				p.setDiscount_id(rs.getString(1));
				p.setStart_date(rs.getTimestamp(2));
				p.setEnd_date(rs.getTimestamp(3));
				p.setDiscount_price(rs.getFloat(4));
				p.setApply_price(rs.getFloat(5));
				result.add(p);
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
	public Bean_discount_infor addDiscount(Bean_discount_infor discount_infor) throws BaseException {
		// TODO Auto-generated method stub
		//�Ż�ȯid����ʼ���ڣ��������ڣ���Ʒ���������𣬿��ü۸񣬼���۸�
		Bean_discount_infor result = new Bean_discount_infor();
		java.sql.Connection conn = null;
		if(discount_infor.getDiscount_price()<0)
			throw new BusinessException("����۸���С��0��");
		if(discount_infor.getApply_price()<0)
			throw new BusinessException("���ü۸���С��0!");
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT 1\r\n" + 
					"FROM discount_infor\r\n" + 
					"WHERE discount_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, discount_infor.getDiscount_id());
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				throw new BusinessException("�Ѿ����ڸñ�ŵ��Ż�ȯ��");
			rs.close();
			pst.close();
			sql = "SELECT 1\r\n" + 
					"FROM discount_infor\r\n" + 
					"WHERE product_id = ? AND fresh_food_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, discount_infor.getProduct_id());
			pst.setString(2, discount_infor.getFresh_food_id());
			rs = pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("��Ʒ��Ż����ʱ�Ų����ڣ�");
			rs.close();
			pst.close();
			sql = "INSERT INTO discount_infor(discount_id,start_date,end_date,product_id,fresh_food_id,apply_price,discount_price)\r\n" + 
					"VALUES(?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, discount_infor.getDiscount_id());
			pst.setTimestamp(2, discount_infor.getStart_date());
			pst.setTimestamp(3, discount_infor.getEnd_date());
			pst.setString(4, discount_infor.getProduct_id());
			pst.setString(5, discount_infor.getFresh_food_id());
			pst.setFloat(6, discount_infor.getApply_price());
			pst.setFloat(7, discount_infor.getDiscount_price());
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
	public void deleteDiscount(Bean_discount_infor discount_infor) throws BaseException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		Bean_discount_infor result = new Bean_discount_infor();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT TIMESTAMPDIFF(SECOND,NOW(),end_date),TIMESTAMPDIFF(SECOND,start_date,NOW())\r\n" + 
					"FROM discount_infor\r\n" + 
					"WHERE product_id = ? AND fresh_food_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, discount_infor.getProduct_id());
			pst.setString(2, discount_infor.getFresh_food_id());
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>=0&&rs.getInt(2)<=0)
					throw new BusinessException("���ڻ����Ż��ڼ䣬�޷�ɾ��!");
			}
			pst.close();
			rs.close();
			sql = "DELETE FROM discount_infor\r\n" + 
					"WHERE product_id = ? AND fresh_food_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, discount_infor.getProduct_id());
			pst.setString(2, discount_infor.getFresh_food_id());
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
