package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fresh_food.util;
import util.BaseException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Frame_changeinfor extends JDialog implements ActionListener{
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	
	private JLabel customer_name_label = new JLabel("姓名:");
	private JLabel customer_email_label = new JLabel("电子邮箱:");
	private JLabel customer_phonenum_label = new JLabel("电话号码:");
	private JLabel customer_city_label = new JLabel("所在城市:");
	private JLabel customer_sex_label = new JLabel("性别:");
	private JComboBox customer_sex_comboBox = new JComboBox();
	private JTextField customer_phonenum_textField = new JTextField();
	private JTextField customer_email_textField = new JTextField();
	private JTextField customer_name_textField = new JTextField();
	private JTextField customer_city_textField = new JTextField();
	public Frame_changeinfor(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		customer_name_label.setBounds(100, 8, 38, 18);
		workPane.add(customer_name_label);
		customer_email_label.setBounds(70, 128, 68, 18);
		workPane.add(customer_email_label);
		customer_phonenum_label.setBounds(70, 88, 68, 18);
		workPane.add(customer_phonenum_label);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		customer_phonenum_textField.setBounds(143, 88, 166, 24);
		workPane.add(customer_phonenum_textField);
		customer_phonenum_textField.setColumns(10);
	
		customer_email_textField.setBounds(143, 128, 166, 24);
		workPane.add(customer_email_textField);
		customer_email_textField.setColumns(10);
		
		customer_name_textField.setBounds(143, 8, 166, 24);
		workPane.add(customer_name_textField);
		customer_name_textField.setColumns(10);
		
		
		customer_city_label.setBounds(70, 168, 68, 18);
		workPane.add(customer_city_label);
		
		customer_city_textField.setBounds(143, 168, 166, 24);
		workPane.add(customer_city_textField);
		customer_city_textField.setColumns(10);
		
		
		customer_sex_label.setBounds(100, 48, 38, 18);
		workPane.add(customer_sex_label);
		
		
		customer_sex_comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "男", "女"}));
		customer_sex_comboBox.setBounds(143, 48, 62, 24);
		workPane.add(customer_sex_comboBox);
		this.setSize(399, 361);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			String name = this.customer_name_textField.getText();
			String sex = (String) this.customer_sex_comboBox.getSelectedItem();
			String phonenum = this.customer_phonenum_textField.getText();
			String email = this.customer_email_textField.getText();
			String city = this.customer_city_textField.getText();
			try {
				util.customerManger.changeInfor(name,sex,phonenum,email,city);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"修改成功", "修改个人信息",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
		}
	}
}
