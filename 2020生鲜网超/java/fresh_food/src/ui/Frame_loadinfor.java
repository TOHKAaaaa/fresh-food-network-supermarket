package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bean_customer_infor;

import javax.swing.JLabel;

public class Frame_loadinfor extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JLabel customer_name_label = new JLabel("\u59D3\u540D:");
	private JLabel customer_sex_label = new JLabel("\u6027\u522B:");
	private JLabel customer_phonenum_label = new JLabel("\u7535\u8BDD\u53F7\u7801:");
	private JLabel customer_email_label = new JLabel("\u7535\u5B50\u90AE\u7BB1:");
	private JLabel customer_city_label = new JLabel("\u6240\u5728\u57CE\u5E02:");
	private JLabel customer_regtime_label = new JLabel("\u6CE8\u518C\u65F6\u95F4:");
	private JLabel customer_isvip_label = new JLabel("\u662F\u5426\u4E3AVIP:");
	private JLabel customer_vipddl_lavbel = new JLabel("VIP\u622A\u6B62\u65F6\u95F4:");
	private JLabel name_label = new JLabel("");
	private JLabel sex_label = new JLabel("");
	private JLabel phonenum_label = new JLabel("");
	private JLabel email_label = new JLabel("");
	private JLabel city_label = new JLabel("");
	private JLabel regtime_label = new JLabel("");
	private JLabel isvip_label = new JLabel("");
	private JLabel vipddl_label = new JLabel("");
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Frame_loadinfor dialog = new Frame_loadinfor();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param b 
	 * @param s 
	 * @param f 
	 */
	public Frame_loadinfor(Frame_main f, String s, boolean b) {
		super(f,s,b);
		setBounds(100, 100, 450, 418);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		customer_name_label.setBounds(100, 8, 38, 18);
		contentPanel.add(customer_name_label);
		
		
		customer_sex_label.setBounds(100, 48, 38, 18);
		contentPanel.add(customer_sex_label);
		
		
		customer_phonenum_label.setBounds(70, 88, 68, 18);
		contentPanel.add(customer_phonenum_label);
		
		
		customer_email_label.setBounds(70, 128, 68, 18);
		contentPanel.add(customer_email_label);
		
		
		customer_city_label.setBounds(70, 168, 68, 18);
		contentPanel.add(customer_city_label);
		
		
		customer_regtime_label.setBounds(70, 208, 68, 18);
		contentPanel.add(customer_regtime_label);
		
		
		customer_isvip_label.setBounds(61, 248, 77, 18);
		contentPanel.add(customer_isvip_label);
		
		
		customer_vipddl_lavbel.setBounds(46, 288, 92, 18);
		contentPanel.add(customer_vipddl_lavbel);
		
		
		name_label.setBounds(143, 8, 166, 18);
		contentPanel.add(name_label);
		
		
		sex_label.setBounds(143, 48, 166, 18);
		contentPanel.add(sex_label);
		
		
		phonenum_label.setBounds(143, 88, 166, 18);
		contentPanel.add(phonenum_label);
		
		
		email_label.setBounds(143, 128, 166, 18);
		contentPanel.add(email_label);
		
		
		city_label.setBounds(143, 168, 166, 18);
		contentPanel.add(city_label);
		
		
		regtime_label.setBounds(143, 208, 166, 18);
		contentPanel.add(regtime_label);
		
		
		isvip_label.setBounds(143, 248, 168, 18);
		contentPanel.add(isvip_label);
		
		
		vipddl_label.setBounds(143, 288, 166, 18);
		contentPanel.add(vipddl_label);
		//姓名，性别，电话号码，电子邮箱，所在城市，注册时间，是否为VIP，VIP截止时间
		Bean_customer_infor result = Bean_customer_infor.currentLogincustomer;
		name_label.setText(result.getCustomer_name());
		sex_label.setText(result.getCustomer_sex());
		phonenum_label.setText(result.getCustomer_phonenum());
		email_label.setText(result.getCustomer_email());
		city_label.setText(result.getCustomer_city());
		regtime_label.setText(String.valueOf(result.getCustomer_registration_date()));
		isvip_label.setText(result.isCustomer_VIPwhether());
		vipddl_label.setText(String.valueOf(result.getCustomer_VIPddl()));
	}

}
