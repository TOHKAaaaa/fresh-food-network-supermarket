package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fresh_food.util;
import model.Bean_discount_infor;
import model.Bean_product_infor;
import util.BaseException;

public class Frame_main extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); 
	private Frame_login dlgLogin=null;
	//�˵�����
	private JMenu user_menu = new JMenu("��������");
	private JMenu product_menu = new JMenu("��Ʒѡ��");
	private JMenu admin_menu = new JMenu("����Ա���� ");

	//�˵��¹��ܶ���
	//��������
	private JMenuItem changepwd_MenuItem = new JMenuItem("�޸�����");
	private JMenuItem changeinfor_MenuItem = new JMenuItem("�޸ĸ�����Ϣ");
	private JMenuItem becomeVIP_MenuItem = new JMenuItem("��Ϊ��Ա");
	//��Ʒѡ��
	private JMenuItem productinfor_MenuItem = new JMenuItem("��ʾ������Ʒ");
	private JMenuItem productbuy_MenuItem = new JMenuItem("������Ʒ");
	//����Ա����
	private JMenuItem deluser_MenuItem = new JMenuItem("ɾ���û�");
	private JMenuItem consumeuser_MenuItem = new JMenuItem("�û��������");
	private JMenuItem addproduct_MenuItem = new JMenuItem("�����Ʒ");
	private JMenuItem buyproduct_MenuItem = new JMenuItem("�ɹ���Ʒ");
	private JMenuItem delproduct_MenuItem = new JMenuItem("ɾ����Ʒ");
	private JMenuItem adddiscount_MenuItem = new JMenuItem("����Ż�ȯ");
	private JMenuItem deldiscount_MenuItem = new JMenuItem("ɾ���Ż�ȯ");
	
	private Object Producttitle[] = Bean_product_infor.tableTitles;
	private Object ProductData[][];
	DefaultTableModel ProductModel=new DefaultTableModel();
	private JTable dataProduct=new JTable(ProductModel);
	
	private Object Discounttitle[] = Bean_discount_infor.tableTitles;
	private Object DiscountData[][];
	DefaultTableModel DiscountModel=new DefaultTableModel();
	private JTable dataDisount=new JTable(DiscountModel);
	
	List<Bean_product_infor> allProduct = null;
	List<Bean_discount_infor> allDiscount = null;
	
	private void reloadProductTable(){//���ǲ������ݣ���Ҫ��ʵ�����滻
		try {
			allProduct=util.userProductManger.loadallProduct();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		ProductData =  new Object[allProduct.size()][Bean_product_infor.tableTitles.length];
		for(int i=0;i<allProduct.size();i++){
			for(int j=0;j<Bean_product_infor.tableTitles.length;j++)
				ProductData[i][j]=allProduct.get(i).getCell(j);
		}
		ProductModel.setDataVector(ProductData,Producttitle);
		this.dataProduct.validate();
		this.dataProduct.repaint();
	}
	
	private void reloadDiscountTable(){//���ǲ������ݣ���Ҫ��ʵ�����滻
		try {
			allProduct=util.userProductManger.loadallProduct();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		ProductData =  new Object[allProduct.size()][Bean_product_infor.tableTitles.length];
		for(int i=0;i<allProduct.size();i++){
			for(int j=0;j<Bean_product_infor.tableTitles.length;j++)
				ProductData[i][j]=allProduct.get(i).getCell(j);
		}
		ProductModel.setDataVector(ProductData,Producttitle);
		this.dataProduct.validate();
		this.dataProduct.repaint();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_main frame = new Frame_main();
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
	public Frame_main() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("��������������");
		dlgLogin=new Frame_login(this,"��½",true);
		dlgLogin.setVisible(true);
		
		//�˵�
		//��������
		this.user_menu.add(this.changeinfor_MenuItem); this.changeinfor_MenuItem.addActionListener(this);
		this.user_menu.add(this.changepwd_MenuItem); this.changepwd_MenuItem.addActionListener(this);
		this.user_menu.add(this.becomeVIP_MenuItem); this.becomeVIP_MenuItem.addActionListener(this);
		//��Ʒѡ��
		this.product_menu.add(this.productinfor_MenuItem); this.productinfor_MenuItem.addActionListener(this);
		this.product_menu.add(this.productbuy_MenuItem); this.productbuy_MenuItem.addActionListener(this);
		//����Ա����
		this.admin_menu.add(this.deluser_MenuItem); this.deluser_MenuItem.addActionListener(this);
		this.admin_menu.add(this.consumeuser_MenuItem); this.consumeuser_MenuItem.addActionListener(this);
		this.admin_menu.add(this.addproduct_MenuItem); this.addproduct_MenuItem.addActionListener(this);
		this.admin_menu.add(this.buyproduct_MenuItem); this.buyproduct_MenuItem.addActionListener(this);
		this.admin_menu.add(this.delproduct_MenuItem); this.delproduct_MenuItem.addActionListener(this);
		this.admin_menu.add(this.adddiscount_MenuItem); this.adddiscount_MenuItem.addActionListener(this);
		this.admin_menu.add(this.deldiscount_MenuItem); this.deldiscount_MenuItem.addActionListener(this);
		
		menubar.add(user_menu);
		menubar.add(product_menu);
		menubar.add(admin_menu);
		this.setJMenuBar(menubar);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
