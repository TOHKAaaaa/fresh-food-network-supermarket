package itf;

import model.Bean_admin_infor;
import util.BaseException;

public interface IUserManger {
	//����Աע��
	public Bean_admin_infor reg(String userid,String name, String pwd,String pwd2) throws BaseException;
	//����Ա��¼
	public Bean_admin_infor login(String userid,String pwd)throws BaseException;
	//����Ա�޸�����
	public void changePwd(Bean_admin_infor user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
}
