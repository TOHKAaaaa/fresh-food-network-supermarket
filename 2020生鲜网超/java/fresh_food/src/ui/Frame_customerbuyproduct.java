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
import model.Bean_product_order_form;
import util.BaseException;

public class Frame_customerbuyproduct extends JDialog implements ActionListener{

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel product_num_label = new JLabel("购买数量:");
	private JTextField product_num_textField = new JTextField();
	private Bean_product_order_form p;
	public Frame_customerbuyproduct(Bean_product_order_form order_form) {
		this.p = order_form;
		setTitle("添加到购物车");
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		product_num_label.setBounds(70, 28, 68, 18);
		workPane.add(product_num_label);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
	
		product_num_textField.setBounds(143, 28, 166, 24);
		workPane.add(product_num_textField);
		product_num_textField.setColumns(10);
		this.setSize(399, 168);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			p.setProduct_num(Integer.valueOf(this.product_num_textField.getText()));
			try {
				System.out.println(p.getProduct_id());
				util.customerProductManger.buyproduct(p);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"添加到购物车成功", "购买商品",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
		}
	}

}
