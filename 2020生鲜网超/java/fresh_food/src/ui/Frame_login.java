package ui;

import java.awt.BorderLayout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import fresh_food.util;
import model.Bean_admin_infor;
//import cn.edu.zucc.personplan.PersonPlanUtil;
//import cn.edu.zucc.personplan.model.BeanUser;
import util.BaseException;
import javax.swing.JRadioButton;


public class Frame_login extends JDialog implements ActionListener {
	public static boolean if_admin = false;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnLogin = new JButton("��½");
	private JButton btnCancel = new JButton("�˳�");
	private JButton btnRegister = new JButton("ע��");
	
	private JLabel labelUser = new JLabel("�û���");
	private JLabel labelPwd = new JLabel("���룺");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);

	public Frame_login(Frame frame_main, String s, boolean b) {
		super(frame_main,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnRegister);
		toolBar.add(btnLogin);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		labelUser.setBounds(46, 8, 45, 18);
		workPane.add(labelUser);
		edtUserId.setBounds(95, 5, 166, 24);
		workPane.add(edtUserId);
		labelPwd.setBounds(46, 37, 45, 18);
		workPane.add(labelPwd);
		edtPwd.setBounds(95, 34, 166, 24);
		workPane.add(edtPwd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		JRadioButton radioButton = new JRadioButton("����Ա",true);
		radioButton.setBounds(94, 67, 97, 27);
		workPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("�û�");
		radioButton_1.setBounds(195, 67, 97, 27);
		workPane.add(radioButton_1);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_1);
		
		JLabel label = new JLabel("�û�����:");
		label.setBounds(14, 71, 77, 18);
		workPane.add(label);
		this.setSize(320, 176);
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		this.btnRegister.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			String userid=this.edtUserId.getText();
			String pwd=new String(this.edtPwd.getPassword());
			try {
				Bean_admin_infor.currentLoginadmin= util.userManger.login(userid, pwd);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
			
		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		} else if(e.getSource()==this.btnRegister){
			Frame_register dlg=new Frame_register(this,"��������ע�����",true);
			dlg.setVisible(true);
		}
	}
}
