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
import model.Bean_customer_infor;
import util.BaseException;

public class Frame_delcustomer extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	
	private JLabel customer_id_label = new JLabel("顾客编号:");
	private JTextField customer_id_textField = new JTextField();
	public Frame_delcustomer(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		customer_id_label.setBounds(66, 31, 68, 18);
		workPane.add(customer_id_label);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		customer_id_textField.setBounds(143, 28, 166, 24);
		workPane.add(customer_id_textField);
		customer_id_textField.setColumns(10);
		this.setSize(399, 163);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			Bean_customer_infor customer = new Bean_customer_infor();
			customer.setCustomer_id(this.customer_id_textField.getText());
			try {
				util.userManger.deletecustomer(customer);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"删除成功", "删除用户",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
		}
	}

}
