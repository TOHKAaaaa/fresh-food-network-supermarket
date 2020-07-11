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
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import fresh_food.util;
import model.Bean_admin_infor;
import model.Bean_customer_infor;
import util.BaseException;
import javax.swing.JTextField;

public class Frame_addproduct extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	
	private JLabel freshfood_id_label = new JLabel("生鲜类别编号:");
	private JLabel freshfood_name_label = new JLabel("生鲜类别名称:");
	private JLabel product_id_label = new JLabel("商品编号:");
	private JLabel product_name_label = new JLabel("商品名称:");
	private final JLabel product_price_label = new JLabel("商品价格:");
	private final JLabel product_VIPirce_label = new JLabel("会员价格:");
	private JTextField product_id_textField = new JTextField();
	private JTextField freshfood_name_textField = new JTextField();
	private JTextField freshfood_id_textField = new JTextField();
	private final JTextField product_name_textField = new JTextField();
	private final JTextField product_price_textField = new JTextField();
	private final JTextField product_VIPrice_textField = new JTextField();
	private final JLabel product_describe_label = new JLabel("商品描述:");
	private final JTextField product_describe_textField = new JTextField();
	public Frame_addproduct(Frame f, String s, boolean b) {
		super(f, s, b);
		product_describe_textField.setBounds(143, 248, 166, 24);
		product_describe_textField.setColumns(10);
		product_VIPrice_textField.setBounds(143, 208, 166, 24);
		product_VIPrice_textField.setColumns(10);
		product_price_textField.setBounds(143, 168, 166, 24);
		product_price_textField.setColumns(10);
		product_name_textField.setBounds(143, 128, 166, 24);
		product_name_textField.setColumns(10);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		freshfood_id_label.setBounds(40, 8, 98, 18);
		workPane.add(freshfood_id_label);
		freshfood_name_label.setBounds(40, 48, 98, 18);
		workPane.add(freshfood_name_label);
		product_id_label.setBounds(70, 88, 68, 18);
		workPane.add(product_id_label);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		product_id_textField.setBounds(143, 88, 166, 24);
		workPane.add(product_id_textField);
		product_id_textField.setColumns(10);
	
		freshfood_name_textField.setBounds(143, 48, 166, 24);
		workPane.add(freshfood_name_textField);
		freshfood_name_textField.setColumns(10);
		
		freshfood_id_textField.setBounds(143, 8, 166, 24);
		workPane.add(freshfood_id_textField);
		freshfood_id_textField.setColumns(10);
		
		
		product_name_label.setBounds(70, 128, 68, 18);
		workPane.add(product_name_label);
		
		workPane.add(product_name_textField);
		product_price_label.setBounds(70, 168, 68, 18);
		
		workPane.add(product_price_label);
		product_VIPirce_label.setBounds(70, 208, 68, 18);
		
		workPane.add(product_VIPirce_label);
		
		workPane.add(product_price_textField);
		
		workPane.add(product_VIPrice_textField);
		product_describe_label.setBounds(70, 248, 72, 18);
		
		workPane.add(product_describe_label);
		
		workPane.add(product_describe_textField);
		this.setSize(399, 392);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			int product_id = Integer.valueOf(this.product_id_textField.getText());
			String product_name = this.product_name_textField.getText();
			float price = Float.valueOf(this.product_price_textField.getText());
			float VIP_price = Float.valueOf(this.product_VIPrice_textField.getText());
			int fresh_food_id = Integer.valueOf(this.freshfood_id_textField.getText());
			String fresh_food_name = this.freshfood_name_textField.getText();
			String product_describe = this.product_describe_textField.getText();
			try {
				util.userProductManger.addProduct(product_id, product_name, price, VIP_price, fresh_food_id, fresh_food_name,product_describe);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"添加成功", "添加商品",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
		}
	}
}
