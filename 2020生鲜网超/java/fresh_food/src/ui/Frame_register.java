package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Data;

//import cn.edu.zucc.personplan.PersonPlanUtil;
import util.BaseException;
import fresh_food.util;
import model.Bean_admin_infor;
import model.Bean_customer_infor;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Frame_register extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("注册");
	private Button btnCancel = new Button("取消");
	
	private JLabel labelUser = new JLabel("用户：");
	private JLabel labelPwd = new JLabel("密码：");
	private JLabel labelPwd2 = new JLabel("确认密码");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);
	private JPasswordField edtPwd2 = new JPasswordField(20);
	private final JLabel labelUserType = new JLabel("用户名：");
	private JTextField textField;
	private final JRadioButton admin_radioButton = new JRadioButton("管理员");
	private final JRadioButton user_radioButton = new JRadioButton("用户");
	public Frame_register(Dialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		labelUser.setBounds(31, 26, 45, 18);
		workPane.add(labelUser);
		edtUserId.setBounds(90, 23, 166, 24);
		workPane.add(edtUserId);
		labelPwd.setBounds(31, 92, 45, 18);
		workPane.add(labelPwd);
		edtPwd.setBounds(90, 89, 166, 24);
		workPane.add(edtPwd);
		labelPwd2.setBounds(8, 126, 86, 18);
		workPane.add(labelPwd2);
		edtPwd2.setBounds(90, 123, 166, 24);
		workPane.add(edtPwd2);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label.setBounds(8, 157, 86, 18);
		workPane.add(label);
		this.setSize(300, 276);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
		
		labelUserType.setBounds(16, 57, 60, 18);
		
		workPane.add(labelUserType);
		
		textField = new JTextField();
		textField.setBounds(90, 54, 166, 24);
		workPane.add(textField);
		textField.setColumns(10);
		admin_radioButton.setBounds(90, 153, 79, 27);
		
		workPane.add(admin_radioButton);
		user_radioButton.setBounds(190, 153, 66, 27);
		
		workPane.add(user_radioButton);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(admin_radioButton);
		buttonGroup.add(user_radioButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		java.util.Date date = new java.util.Date();
		String string = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		string = sdf.format(date);
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			String userid=this.edtUserId.getText();
			String pwd1=new String(this.edtPwd.getPassword());
			String pwd2=new String(this.edtPwd2.getPassword());
			String name = new String(this.textField.getText());
			try {
				int type = 0;
				if(admin_radioButton.isSelected())
					type = 1;
				else if(user_radioButton.isSelected())
					type = 2;
				switch (type) {
				case 1:Bean_admin_infor admin_user= util.userManger.reg(userid,name, pwd1, pwd2);break;
				case 2:Bean_customer_infor customer_user = util.customerManger.reg(userid, name, 1, pwd1, pwd2, null, null, null, string, 0, null);break;
				default:
					break;
				}
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
			
		
	}
}
