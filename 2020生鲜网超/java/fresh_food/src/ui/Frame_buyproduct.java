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

public class Frame_buyproduct extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	
	private JLabel freshfood_id_label = new JLabel("生鲜类别编号:");
	private JLabel product_num_label = new JLabel("购买数量:");
	private JLabel product_id_label = new JLabel("商品编号:");
	private JTextField product_id_textField = new JTextField();
	private JTextField product_num_textField = new JTextField();
	private JTextField freshfood_id_textField = new JTextField();
	public Frame_buyproduct(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		freshfood_id_label.setBounds(40, 8, 98, 18);
		workPane.add(freshfood_id_label);
		product_num_label.setBounds(70, 88, 68, 18);
		workPane.add(product_num_label);
		product_id_label.setBounds(70, 48, 68, 18);
		workPane.add(product_id_label);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		product_id_textField.setBounds(143, 48, 166, 24);
		workPane.add(product_id_textField);
		product_id_textField.setColumns(10);
	
		product_num_textField.setBounds(143, 88, 166, 24);
		workPane.add(product_num_textField);
		product_num_textField.setColumns(10);
		
		freshfood_id_textField.setBounds(143, 8, 166, 24);
		workPane.add(freshfood_id_textField);
		freshfood_id_textField.setColumns(10);
		this.setSize(399, 209);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			int product_id = Integer.valueOf(this.product_id_textField.getText());
			int fresh_food_id = Integer.valueOf(this.freshfood_id_textField.getText());
			int sum = Integer.valueOf(this.product_num_textField.getText());
			try {
				util.userProductManger.buyProduct(product_id, fresh_food_id, sum);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"采购成功", "采购商品",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
		}
	}
}
