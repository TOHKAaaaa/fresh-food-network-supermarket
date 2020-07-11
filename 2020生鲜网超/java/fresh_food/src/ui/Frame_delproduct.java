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

import org.dom4j.swing.BranchTreeNode;

import fresh_food.util;
import model.Bean_product_infor;
import util.BaseException;

public class Frame_delproduct extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	
	private JLabel freshfood_id_label = new JLabel("生鲜类别编号:");
	private JLabel product_id_label = new JLabel("商品编号:");
	private JTextField product_id_textField = new JTextField();
	private JTextField freshfood_id_textField = new JTextField();
	public Frame_delproduct(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		freshfood_id_label.setBounds(40, 18, 98, 18);
		workPane.add(freshfood_id_label);
		product_id_label.setBounds(70, 58, 68, 18);
		workPane.add(product_id_label);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		product_id_textField.setBounds(143, 58, 166, 24);
		workPane.add(product_id_textField);
		product_id_textField.setColumns(10);
		
		freshfood_id_textField.setBounds(143, 18, 166, 24);
		workPane.add(freshfood_id_textField);
		freshfood_id_textField.setColumns(10);
		this.setSize(399, 191);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			Bean_product_infor p = new Bean_product_infor();
			int product_id = Integer.valueOf(this.product_id_textField.getText());
			int fresh_food_id = Integer.valueOf(this.freshfood_id_textField.getText());
			p.setFresh_food_id(fresh_food_id);
			p.setProduct_id(product_id);
			try {
				util.userProductManger.deleteProduct(p);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"删除成功", "删除商品",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
		}
	}
}
