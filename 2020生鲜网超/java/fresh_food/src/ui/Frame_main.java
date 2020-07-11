package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fresh_food.util;
import model.Bean_admin_infor;
import model.Bean_customer_infor;
import model.Bean_discount_infor;
import model.Bean_product_infor;
import util.BaseException;

public class Frame_main extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); 
	private Frame_login dlgLogin=null;
	private JPanel statusBar = new JPanel();
	//�˵�����
	private JMenu user_menu = new JMenu("��������");
	private JMenu product_menu = new JMenu("��Ʒѡ��");
	private JMenu admin_menu = new JMenu("����Ա���� ");

	//�˵��¹��ܶ���
	//��������
	private JMenuItem changepwd_MenuItem = new JMenuItem("�޸�����");
	private JMenuItem changeinfor_MenuItem = new JMenuItem("�޸ĸ�����Ϣ");
	private JMenuItem becomeVIP_MenuItem = new JMenuItem("��Ϊ��Ա");
	private JMenuItem havebought_MenuItem = new JMenuItem("�ѹ���Ʒ");
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
	
	private Bean_product_infor curProduct = null;
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
	
	private void reloadDiscountTable(int planIdx){
		if(planIdx<0) return;
		curProduct=allProduct.get(planIdx);
		try {
			allDiscount=util.discountManger.loadallDiscount_infor(curProduct);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		DiscountData =new Object[allDiscount.size()][Bean_discount_infor.tableTitles.length];
		for(int i=0;i<allDiscount.size();i++){
			for(int j=0;j<Bean_discount_infor.tableTitles.length;j++)
				DiscountData[i][j]=allDiscount.get(i).getCell(j);
		}
		
		DiscountModel.setDataVector(DiscountData,Discounttitle);
		this.dataDisount.validate();
		this.dataDisount.repaint();
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frame_main frame = new Frame_main();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		this.user_menu.add(this.havebought_MenuItem); this.havebought_MenuItem.addActionListener(this);
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
		
		this.getContentPane().add(new JScrollPane(this.dataProduct), BorderLayout.WEST);
		
		this.dataProduct.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frame_main.this.dataProduct.getSelectedRow();
				if(i<0) {
					return;
				}
				Frame_main.this.reloadDiscountTable(i);
			}
	    	
	    });
		 this.getContentPane().add(new JScrollPane(this.dataDisount), BorderLayout.CENTER);
		    
		 this.reloadProductTable();
		//״̬��
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label=new JLabel("����!");//�޸ĳ�   ���ã�+��½�û���
		    statusBar.add(label);
		    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
		    this.addWindowListener(new WindowAdapter(){   
		    	public void windowClosing(WindowEvent e){ 
		    		System.exit(0);
	             }
	        });
		    this.setVisible(true);
		    
		    if(Bean_customer_infor.currentLogincustomer==null)
				admin_menu.setVisible(true);
			if(Bean_admin_infor.currentLoginadmin==null) 
				admin_menu.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.changepwd_MenuItem) {
			Frame_changepwd dlg = new Frame_changepwd(this, "�����޸�", true);
			dlg.setVisible(true);
		}
		
	}

}
