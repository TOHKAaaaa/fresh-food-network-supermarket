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

import com.mysql.fabric.proto.xmlrpc.DigestAuthentication;

import fresh_food.util;
import model.Bean_admin_infor;
import model.Bean_customer_infor;
import model.Bean_discount_infor;
import model.Bean_order_form_details;
import model.Bean_product_infor;
import model.Bean_product_order_form;
import util.BaseException;
import javax.swing.JButton;
import javax.swing.SwingConstants;

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
	private JMenuItem loadinfor_MenuItem = new JMenuItem("��ʾ������Ϣ");
	private JMenuItem changeinfor_MenuItem = new JMenuItem("�޸ĸ�����Ϣ");
	private JMenuItem changepwd_MenuItem = new JMenuItem("�޸�����");
	private JMenuItem becomeVIP_MenuItem = new JMenuItem("��Ϊ��Ա");
	private JMenuItem renewVIP_MenuItem = new JMenuItem("���ѻ�Ա");
	private JMenuItem havebought_MenuItem = new JMenuItem("�ѹ���Ʒ");
	
	//��Ʒѡ��
	private JMenuItem productinfor_MenuItem = new JMenuItem("��ʾ���ﳵ");
//	private JMenuItem productitembuy_MenuItem = new JMenuItem("��ӵ����ﳵ");
	//����Ա����
//	private JMenuItem deluser_MenuItem = new JMenuItem("ɾ���û�");
	private JMenuItem loadalluser_MenuItem = new JMenuItem("��ʾ�����û�");
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
	private final JButton button = new JButton("\u6DFB\u52A0\u5230\u8D2D\u7269\u8F66");
	
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
		this.user_menu.add(this.loadinfor_MenuItem); this.loadinfor_MenuItem.addActionListener(this);
		this.user_menu.add(this.changeinfor_MenuItem); this.changeinfor_MenuItem.addActionListener(this);
		this.user_menu.add(this.changepwd_MenuItem); this.changepwd_MenuItem.addActionListener(this);
		this.user_menu.add(this.becomeVIP_MenuItem); this.becomeVIP_MenuItem.addActionListener(this);
		this.user_menu.add(this.renewVIP_MenuItem); this.renewVIP_MenuItem.addActionListener(this);
		this.user_menu.add(this.havebought_MenuItem); this.havebought_MenuItem.addActionListener(this);
		//��Ʒѡ��
		this.product_menu.add(this.productinfor_MenuItem); this.productinfor_MenuItem.addActionListener(this);
//		this.product_menu.add(this.productitembuy_MenuItem); this.productitembuy_MenuItem.addActionListener(this);
		//����Ա����
//		this.admin_menu.add(this.deluser_MenuItem); this.deluser_MenuItem.addActionListener(this);
		this.admin_menu.add(this.loadalluser_MenuItem); this.loadalluser_MenuItem.addActionListener(this);
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
		
		this.getContentPane().add(new JScrollPane(this.dataProduct), BorderLayout.CENTER);
		
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
		 this.getContentPane().add(new JScrollPane(this.dataDisount), BorderLayout.EAST);
		    
		 this.reloadProductTable();
		 
		 this.dataDisount.addMouseListener(new MouseAdapter (){

				@Override
				public void mouseClicked(MouseEvent e) {
					int i=Frame_main.this.dataDisount.getSelectedRow();
					if(i<0) {
						return;
					}
					
				}
		    	
		    });
		 
		//״̬��
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label;
			if(Bean_customer_infor.currentLogincustomer!=null)
		    	label=new JLabel("��ӭ"+Bean_customer_infor.currentLogincustomer.getCustomer_name()+"������������!");//�޸ĳ�   ���ã�+��½�û���
			else
				label=new JLabel("��ӭ"+Bean_admin_infor.currentLoginadmin.getAdmin_name()+"������������!");
			statusBar.add(label);
		    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
		    button.setHorizontalAlignment(SwingConstants.RIGHT);
		    
		    statusBar.add(button);
		    button.addActionListener(this);
		    
		    this.addWindowListener(new WindowAdapter(){   
		    	public void windowClosing(WindowEvent e){ 
		    		System.exit(0);
	             }
	        });
		    
		    this.setVisible(true);
		    
		    if(Bean_customer_infor.currentLogincustomer==null) {
		    	admin_menu.setVisible(true);
		    	user_menu.setVisible(false);
		    }
			if(Bean_admin_infor.currentLoginadmin==null) { 
				admin_menu.setVisible(false);
				user_menu.setVisible(true);
			}	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.changepwd_MenuItem) {
			Frame_changepwd dlg = new Frame_changepwd(this, "�����޸�", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.addproduct_MenuItem) {
			Frame_addproduct dlg = new Frame_addproduct(this,"�����Ʒ",true);
			dlg.setVisible(true);
			Frame_main.this.reloadProductTable();
		}
		else if(e.getSource()==this.delproduct_MenuItem) {
			Frame_delproduct dlg = new Frame_delproduct(this, "ɾ����Ʒ", true);
			dlg.setVisible(true);
			Frame_main.this.reloadProductTable();
		}
		else if(e.getSource()==this.buyproduct_MenuItem) {
			Frame_buyproduct dlg = new Frame_buyproduct(this, "�ɹ���Ʒ", true);
			dlg.setVisible(true);
			Frame_main.this.reloadProductTable();
		}
//		else if(e.getSource()==this.deluser_MenuItem) {
//			Frame_delcustomer dlg = new Frame_delcustomer(this, "ɾ���û�", true);
//			dlg.setVisible(true);
//		}
		else if(e.getSource()==this.loadalluser_MenuItem) {
			Frame_loadallcustomer dlg = new Frame_loadallcustomer(this,"��ʾ�û�",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.changeinfor_MenuItem) {
			Frame_changeinfor dlg = new Frame_changeinfor(this, "�޸���Ϣ", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.loadinfor_MenuItem) {
			Frame_loadinfor dlg = new Frame_loadinfor(this,"������Ϣ",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.becomeVIP_MenuItem) {
			Frame_becomeVIP dlg = new Frame_becomeVIP(this, "��Ϊ��Ա", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.renewVIP_MenuItem) {
			Frame_renewVIP dlg = new Frame_renewVIP(this, "���ѻ�Ա", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.adddiscount_MenuItem) {
			Frame_adddiscount dlg = new Frame_adddiscount(this, "����Ż�ȯ", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.deldiscount_MenuItem) {
			Frame_deldiscount dlg = new Frame_deldiscount(this, "ɾ���Ż�ȯ", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.productinfor_MenuItem) {
			Frame_loadallcustomerproduct dlg = new Frame_loadallcustomerproduct(this, "��ʾ���ﳵ", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.consumeuser_MenuItem) {
			Frame_consumeuser dlg = new Frame_consumeuser(this, "�û��������", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.button) {
//			 tableTitles={"���ʱ��","�������","��Ʒ���","��Ʒ����","����","�۸�","��Ա��","��Ʒ����"};product
//			 tableTitles={"�����Ż�ȯid","��������","��������","����۸�","���ü۸�"}discount
			int i = this.dataProduct.getSelectedRow();
			int j = this.dataDisount.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ����Ʒ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"ȷ���������Ʒ��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)	{
				Bean_product_order_form order_form = new Bean_product_order_form();
				order_form.setProduct_id(this.ProductData[i][2].toString());
				order_form.setFresh_food_id(this.ProductData[i][0].toString());
				order_form.setProduct_name(this.ProductData[i][3].toString());
				order_form.setOriginal_price(Float.valueOf(this.ProductData[i][5].toString()));
				order_form.setFinally_price(Float.valueOf(this.ProductData[i][6].toString()));
				if(j>=0) 
					order_form.setDiscount_id(this.DiscountData[j][0].toString());
				Frame_customerbuyproduct dlg = new Frame_customerbuyproduct(order_form);
				dlg.setVisible(true);
			}
			Frame_main.this.reloadProductTable();
		}
		else if(e.getSource()==this.havebought_MenuItem) {
			
		}
	}

}
