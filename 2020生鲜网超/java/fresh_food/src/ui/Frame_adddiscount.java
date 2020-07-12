package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import example.ExampleDiscountManger;
import fresh_food.util;
import model.Bean_discount_infor;
import model.Bean_product_infor;
import util.BaseException;

public class Frame_adddiscount extends JDialog implements ActionListener{

	public Bean_product_infor plan=null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel discount_id_label = new JLabel("\u4F18\u60E0\u5238id\uFF1A");
	private JLabel discount_StartDate = new JLabel("\u5F00\u59CB\u65E5\u671F\uFF1A");
	private JLabel discoun_EndDate = new JLabel("\u7ED3\u675F\u65E5\u671F\uFF1A");
	
	private JTextField edtStartDate = new JTextField(20);
	private JTextField edtFinishDate = new JTextField(20);
	private JTextField discount_id_Name = new JTextField(20);
	private final JLabel product_id_label = new JLabel("\u4EA7\u54C1\u7C7B\u522B:");
	private final JLabel freshfood_id_label = new JLabel("\u751F\u9C9C\u7C7B\u522B:");
	private final JTextField product_id_textField = new JTextField();
	private final JTextField freshfood_id_textField = new JTextField();
	private final JLabel lblNewLabel = new JLabel("\u53EF\u7528\u4EF7\u683C:");
	private final JLabel lblNewLabel_1 = new JLabel("\u51CF\u514D\u4EF7\u683C:");
	private final JTextField apply_price_textField = new JTextField();
	private final JTextField discount_price_textField = new JTextField();
	public Frame_adddiscount(JFrame f, String s, boolean b) {
		super(f, s, b);
		discount_price_textField.setBounds(153, 187, 166, 24);
		discount_price_textField.setColumns(10);
		apply_price_textField.setBounds(153, 156, 166, 24);
		apply_price_textField.setColumns(10);
		freshfood_id_textField.setBounds(153, 125, 166, 24);
		freshfood_id_textField.setColumns(10);
		product_id_textField.setBounds(153, 94, 166, 24);
		product_id_textField.setColumns(10);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		discount_id_label.setBounds(58, 8, 81, 18);
		workPane.add(discount_id_label);
		discount_id_Name.setBounds(153, 5, 166, 24);
		workPane.add(discount_id_Name);
		discount_StartDate.setBounds(58, 37, 75, 18);
		workPane.add(discount_StartDate);
		edtStartDate.setBounds(153, 34, 166, 24);
		workPane.add(edtStartDate);
		discoun_EndDate.setBounds(58, 66, 75, 18);
		workPane.add(discoun_EndDate);
		edtFinishDate.setBounds(153, 63, 166, 24);
		workPane.add(edtFinishDate);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		product_id_label.setBounds(58, 97, 72, 18);
		
		workPane.add(product_id_label);
		freshfood_id_label.setBounds(58, 128, 72, 18);
		
		workPane.add(freshfood_id_label);
		
		workPane.add(product_id_textField);
		
		workPane.add(freshfood_id_textField);
		lblNewLabel.setBounds(58, 159, 72, 18);
		
		workPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(61, 190, 72, 18);
		
		workPane.add(lblNewLabel_1);
		
		workPane.add(apply_price_textField);
		
		workPane.add(discount_price_textField);
		this.setSize(380, 297);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			Bean_discount_infor discount_infor = new Bean_discount_infor();
			discount_infor.setDiscount_id(this.discount_id_Name.getText());
			discount_infor.setStart_date(Timestamp.valueOf(this.edtStartDate.getText()));
			discount_infor.setEnd_date(Timestamp.valueOf(this.discoun_EndDate.getText()));
			discount_infor.setProduct_id(this.product_id_textField.getText());
			discount_infor.setFresh_food_id(this.freshfood_id_textField.getText());
			discount_infor.setDiscount_price(Float.valueOf(this.discount_price_textField.getText()));
			discount_infor.setApply_price(Float.valueOf(this.apply_price_textField.getText()));
			try {
				util.discountManger.addDiscount(discount_infor);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		
		}
	}

}
