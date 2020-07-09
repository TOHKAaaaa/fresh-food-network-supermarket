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
		
		JMenu admin_menu = new JMenu("��������");
		panel.add(admin_menu);
		
		JRadioButtonMenuItem changepwd_radioButtonMenuItem = new JRadioButtonMenuItem("�޸�����");
		admin_menu.add(changepwd_radioButtonMenuItem);
		
		JMenu product_menu = new JMenu("��Ʒ����");
		panel.add(product_menu);
		
		JRadioButtonMenuItem productinfor_radioButtonMenuItem = new JRadioButtonMenuItem("��Ʒ��Ϣ");
		product_menu.add(productinfor_radioButtonMenuItem);
		
		JRadioButtonMenuItem productbuy_radioButtonMenuItem = new JRadioButtonMenuItem("������Ʒ");
		product_menu.add(productbuy_radioButtonMenuItem);
		
		JRadioButtonMenuItem productchange_radioButtonMenuItem = new JRadioButtonMenuItem("�޸���Ʒ��Ϣ");
		product_menu.add(productchange_radioButtonMenuItem);
		
		JMenu user_menu = new JMenu("�û�����");
		panel.add(user_menu);
		
		JRadioButtonMenuItem userinfor_radioButtonMenuItem = new JRadioButtonMenuItem("�û���Ϣ");
		user_menu.add(userinfor_radioButtonMenuItem);
		
		JRadioButtonMenuItem useradd_radioButtonMenuItem = new JRadioButtonMenuItem("����û�");
		user_menu.add(useradd_radioButtonMenuItem);
		
		JRadioButtonMenuItem userdel_radioButtonMenuItem = new JRadioButtonMenuItem("ɾ���û�");
		user_menu.add(userdel_radioButtonMenuItem);
		
		JMenu discountinfor_menu = new JMenu("�Ż�ȯ��Ϣ");
		panel.add(discountinfor_menu);
		
		JRadioButtonMenuItem discountinfor_radioButtonMenuItem = new JRadioButtonMenuItem("�Ż�ȯ��Ϣ");
		discountinfor_menu.add(discountinfor_radioButtonMenuItem);
		
		JRadioButtonMenuItem discountadd_radioButtonMenuItem = new JRadioButtonMenuItem("����Ż�ȯ");
		discountinfor_menu.add(discountadd_radioButtonMenuItem);
		
		JRadioButtonMenuItem discountdel_radioButtonMenuItem = new JRadioButtonMenuItem("ɾ���Ż�ȯ");
		discountinfor_menu.add(discountdel_radioButtonMenuItem);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollBar product_scrollBar = new JScrollBar();
		product_scrollBar.setForeground(Color.DARK_GRAY);
		product_scrollBar.setBounds(0, 27, 298, 402);
		panel_1.add(product_scrollBar);
		
		JScrollBar user_scrollBar = new JScrollBar();
		user_scrollBar.setForeground(Color.WHITE);
		user_scrollBar.setBackground(Color.ORANGE);
		user_scrollBar.setBounds(298, 0, 244, 429);
		panel_1.add(user_scrollBar);
		
		JScrollPane product_scrollPane = new JScrollPane();
		product_scrollPane.setBounds(0, 0, 298, 27);
		panel_1.add(product_scrollPane);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
