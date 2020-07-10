package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Frame_admin extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_admin frame = new Frame_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JMenu user_menu = new JMenu("个人中心");
		panel.add(user_menu);
		
		JRadioButtonMenuItem changepwd_radioButtonMenuItem = new JRadioButtonMenuItem("修改密码");
		user_menu.add(changepwd_radioButtonMenuItem);
		
		JMenu product_menu = new JMenu("商品选项");
		panel.add(product_menu);
		
		JRadioButtonMenuItem productinfor_radioButtonMenuItem = new JRadioButtonMenuItem("显示所有商品");
		product_menu.add(productinfor_radioButtonMenuItem);
		
		JRadioButtonMenuItem productbuy_radioButtonMenuItem = new JRadioButtonMenuItem("购买商品");
		product_menu.add(productbuy_radioButtonMenuItem);
		
		JMenu admin_menu = new JMenu("管理员操作 ");
		panel.add(admin_menu);
		
		JMenu usermanger_menu = new JMenu("用户管理");
		admin_menu.add(usermanger_menu);
		
		JRadioButtonMenuItem deluser_radioButtonMenuItem = new JRadioButtonMenuItem("删除用户");
		usermanger_menu.add(deluser_radioButtonMenuItem);
		
		JRadioButtonMenuItem consumeuser_radioButtonMenuItem = new JRadioButtonMenuItem("\u7528\u6237\u6D88\u8D39\u60C5\u51B5");
		usermanger_menu.add(consumeuser_radioButtonMenuItem);
		
		JMenu productmanger_menu = new JMenu("商品管理");
		admin_menu.add(productmanger_menu);
		
		JRadioButtonMenuItem addproduct_radioButtonMenuItem_1 = new JRadioButtonMenuItem("\u6DFB\u52A0\u5546\u54C1");
		productmanger_menu.add(addproduct_radioButtonMenuItem_1);
		
		JRadioButtonMenuItem buyproduct_radioButtonMenuItem_2 = new JRadioButtonMenuItem("\u91C7\u8D2D\u5546\u54C1");
		productmanger_menu.add(buyproduct_radioButtonMenuItem_2);
		
		JRadioButtonMenuItem delproduct_radioButtonMenuItem_3 = new JRadioButtonMenuItem("\u5220\u9664\u5546\u54C1");
		productmanger_menu.add(delproduct_radioButtonMenuItem_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollBar product_scrollBar = new JScrollBar();
		product_scrollBar.setForeground(Color.DARK_GRAY);
		product_scrollBar.setBounds(0, 27, 298, 402);
		panel_1.add(product_scrollBar);
		
		JScrollBar discount_scrollBar = new JScrollBar();
		discount_scrollBar.setForeground(Color.WHITE);
		discount_scrollBar.setBackground(Color.ORANGE);
		discount_scrollBar.setBounds(298, 27, 298, 402);
		panel_1.add(discount_scrollBar);
		
		JScrollPane product_scrollPane = new JScrollPane();
		product_scrollPane.setBounds(0, 0, 298, 27);
		panel_1.add(product_scrollPane);
		
		JScrollPane discount_scrollPane = new JScrollPane();
		discount_scrollPane.setBounds(298, 0, 298, 27);
		panel_1.add(discount_scrollPane);
		
		JButton buy_button = new JButton("\u8D2D\u4E70");
		buy_button.setBounds(638, 128, 113, 27);
		panel_1.add(buy_button);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
