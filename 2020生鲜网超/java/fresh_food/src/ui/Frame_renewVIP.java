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

public class Frame_renewVIP extends JDialog implements ActionListener{

	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	
	private JLabel customer_id_label = new JLabel("请输入续费会员月数:");
	private JTextField customer_id_textField = new JTextField();
	private final JLabel lblNewLabel = new JLabel("个月");
	public Frame_renewVIP(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.setLayout(null);
		customer_id_label.setBounds(14, 31, 143, 18);
		workPane.add(customer_id_label);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		
		customer_id_textField.setBounds(160, 28, 48, 24);
		workPane.add(customer_id_textField);
		customer_id_textField.setColumns(10);
		lblNewLabel.setBounds(210, 31, 37, 18);
		
		workPane.add(lblNewLabel);
		this.setSize(399, 163);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			int time = Integer.valueOf(this.customer_id_textField.getText());
			try {
				util.customerManger.renewVIP(time);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"续费成功", "成为会员",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
		}
	}

}
