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
	//菜单定义
	private JMenu user_menu = new JMenu("个人中心");
	private JMenu product_menu = new JMenu("商品选项");
	private JMenu admin_menu = new JMenu("管理员操作 ");

	//菜单下功能定义
	//个人中心
	private JMenuItem loadinfor_MenuItem = new JMenuItem("显示个人信息");
	private JMenuItem changeinfor_MenuItem = new JMenuItem("修改个人信息");
	private JMenuItem changepwd_MenuItem = new JMenuItem("修改密码");
	private JMenuItem becomeVIP_MenuItem = new JMenuItem("成为会员");
	private JMenuItem renewVIP_MenuItem = new JMenuItem("续费会员");
	private JMenuItem havebought_MenuItem = new JMenuItem("已购商品");
	
	//商品选项
	private JMenuItem productinfor_MenuItem = new JMenuItem("显示购物车");
//	private JMenuItem productitembuy_MenuItem = new JMenuItem("添加到购物车");
	//管理员操作
//	private JMenuItem deluser_MenuItem = new JMenuItem("删除用户");
	private JMenuItem loadalluser_MenuItem = new JMenuItem("显示所有用户");
	private JMenuItem consumeuser_MenuItem = new JMenuItem("用户消费情况");
	private JMenuItem addproduct_MenuItem = new JMenuItem("添加商品");
	private JMenuItem buyproduct_MenuItem = new JMenuItem("采购商品");
	private JMenuItem delproduct_MenuItem = new JMenuItem("删除商品");
	private JMenuItem adddiscount_MenuItem = new JMenuItem("添加优惠券");
	private JMenuItem deldiscount_MenuItem = new JMenuItem("删除优惠券");
	
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
	
	private void reloadProductTable(){//这是测试数据，需要用实际数替换
		try {
			allProduct=util.userProductManger.loadallProduct();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
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
		this.setTitle("生鲜网超主界面");
		dlgLogin=new Frame_login(this,"登陆",true);
		dlgLogin.setVisible(true);
		
		//菜单
		//个人中心
		this.user_menu.add(this.loadinfor_MenuItem); this.loadinfor_MenuItem.addActionListener(this);
		this.user_menu.add(this.changeinfor_MenuItem); this.changeinfor_MenuItem.addActionListener(this);
		this.user_menu.add(this.changepwd_MenuItem); this.changepwd_MenuItem.addActionListener(this);
		this.user_menu.add(this.becomeVIP_MenuItem); this.becomeVIP_MenuItem.addActionListener(this);
		this.user_menu.add(this.renewVIP_MenuItem); this.renewVIP_MenuItem.addActionListener(this);
		this.user_menu.add(this.havebought_MenuItem); this.havebought_MenuItem.addActionListener(this);
		//商品选项
		this.product_menu.add(this.productinfor_MenuItem); this.productinfor_MenuItem.addActionListener(this);
//		this.product_menu.add(this.productitembuy_MenuItem); this.productitembuy_MenuItem.addActionListener(this);
		//管理员操作
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
		 
		//状态栏
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label;
			if(Bean_customer_infor.currentLogincustomer!=null)
		    	label=new JLabel("欢迎"+Bean_customer_infor.currentLogincustomer.getCustomer_name()+"光临生鲜网超!");//修改成   您好！+登陆用户名
			else
				label=new JLabel("欢迎"+Bean_admin_infor.currentLoginadmin.getAdmin_name()+"光临生鲜网超!");
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
			Frame_changepwd dlg = new Frame_changepwd(this, "密码修改", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.addproduct_MenuItem) {
			Frame_addproduct dlg = new Frame_addproduct(this,"添加商品",true);
			dlg.setVisible(true);
			Frame_main.this.reloadProductTable();
		}
		else if(e.getSource()==this.delproduct_MenuItem) {
			Frame_delproduct dlg = new Frame_delproduct(this, "删除商品", true);
			dlg.setVisible(true);
			Frame_main.this.reloadProductTable();
		}
		else if(e.getSource()==this.buyproduct_MenuItem) {
			Frame_buyproduct dlg = new Frame_buyproduct(this, "采购商品", true);
			dlg.setVisible(true);
			Frame_main.this.reloadProductTable();
		}
//		else if(e.getSource()==this.deluser_MenuItem) {
//			Frame_delcustomer dlg = new Frame_delcustomer(this, "删除用户", true);
//			dlg.setVisible(true);
//		}
		else if(e.getSource()==this.loadalluser_MenuItem) {
			Frame_loadallcustomer dlg = new Frame_loadallcustomer(this,"显示用户",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.changeinfor_MenuItem) {
			Frame_changeinfor dlg = new Frame_changeinfor(this, "修改信息", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.loadinfor_MenuItem) {
			Frame_loadinfor dlg = new Frame_loadinfor(this,"个人信息",true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.becomeVIP_MenuItem) {
			Frame_becomeVIP dlg = new Frame_becomeVIP(this, "成为会员", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.renewVIP_MenuItem) {
			Frame_renewVIP dlg = new Frame_renewVIP(this, "续费会员", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.adddiscount_MenuItem) {
			Frame_adddiscount dlg = new Frame_adddiscount(this, "添加优惠券", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.deldiscount_MenuItem) {
			Frame_deldiscount dlg = new Frame_deldiscount(this, "删除优惠券", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.productinfor_MenuItem) {
			Frame_loadallcustomerproduct dlg = new Frame_loadallcustomerproduct(this, "显示购物车", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.consumeuser_MenuItem) {
			Frame_consumeuser dlg = new Frame_consumeuser(this, "用户消费情况", true);
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.button) {
//			 tableTitles={"生鲜编号","生鲜类别","商品编号","商品名称","数量","价格","会员价","商品描述"};product
//			 tableTitles={"可用优惠券id","启用日期","到期日期","减免价格","可用价格"}discount
			int i = this.dataProduct.getSelectedRow();
			int j = this.dataDisount.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择商品","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"确定购买该商品吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)	{
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
