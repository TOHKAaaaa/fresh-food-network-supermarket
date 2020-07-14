package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import example.ExampleCustomerProductManger;
import example.ExampleUserManger;
import model.Bean_customer_infor;
import model.Bean_product_infor;
import model.Bean_product_order_form;
import util.BaseException;
import javax.swing.JLabel;

public class Frame_loadallcustomerproduct extends JDialog implements ActionListener{

	private JPanel toolBar = new JPanel();
	private Button btnDelete = new Button("删除商品");
	private Button btnPaid = new Button("结算商品");
	private Object OrderTitle[]=Bean_product_order_form.tableTitles;
	private Object OrderData[][];
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable CustomerTable=new JTable(tablmod);
	private void reloadOrderTable(){
		try {
			List<Bean_product_order_form> allOrder=(new ExampleCustomerProductManger()).loadall();
			OrderData =new Object[allOrder.size()][Bean_product_order_form.tableTitles.length];
			for(int i=0;i<allOrder.size();i++){
				for(int j=0;j<Bean_product_order_form.tableTitles.length;j++)
					OrderData[i][j]=allOrder.get(i).getCell(j);
			}
			tablmod.setDataVector(OrderData,OrderTitle);
			this.CustomerTable.validate();
			this.CustomerTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Frame_loadallcustomerproduct(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
//		toolBar.add(btnAdd);
//		toolBar.add(btnResetPwd);
		toolBar.add(this.btnDelete);
		toolBar.add(this.btnPaid);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		this.reloadOrderTable();
		this.getContentPane().add(new JScrollPane(this.CustomerTable), BorderLayout.CENTER);
		
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

//		this.btnAdd.addActionListener(this);
//		this.btnResetPwd.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnPaid.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()==this.btnAdd){
//			FrmUserManager_AddUser dlg=new FrmUserManager_AddUser(this,"添加账号",true);
//			dlg.setVisible(true);
//			if(dlg.getUser()!=null){//刷新表格
//				this.reloadUserTable();
//			}
//		}
//		else if(e.getSource()==this.btnResetPwd){
//			int i=this.userTable.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null,  "请选择账号","提示",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			if(JOptionPane.showConfirmDialog(this,"确定重置密码吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
//				String userid=this.tblData[i][0].toString();
//				try {
//					(new SystemUserManager()).resetUserPwd(userid);
//					JOptionPane.showMessageDialog(null,  "密码重置完成","提示",JOptionPane.INFORMATION_MESSAGE);
//				} catch (BaseException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
//				}
//				
//			}
//		}
//		tableTitles={"订单编号","生鲜编号","商品编号","商品名称","数量","单价","最终价"};
		if(e.getSource()==this.btnDelete){
			int i=this.CustomerTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择商品","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"确定删除商品吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				String orderid=this.OrderData[i][0].toString();
				String fresh_food_id = this.OrderData[i][1].toString();
				String product_id = this.OrderData[i][2].toString();
				int num = Integer.valueOf(this.OrderData[i][4].toString());
				float price = Float.valueOf(this.OrderData[i][5].toString());
				float finally_price = Float.valueOf(this.OrderData[i][6].toString());
				Bean_product_order_form customer = new Bean_product_order_form();
				customer.setOrder_form_id(orderid);
				customer.setFresh_food_id(fresh_food_id);
				customer.setProduct_id(product_id);
				customer.setProduct_num(num);
				customer.setOriginal_price(price);
				customer.setFinally_price(finally_price);
				try {
					(new ExampleCustomerProductManger()).delproduct(customer);
					this.reloadOrderTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		else if(e.getSource()==this.btnPaid) {
			int i=this.CustomerTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择商品","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"确定结算商品吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				String orderid=this.OrderData[i][0].toString();
				String fresh_food_id = this.OrderData[i][1].toString();
				String product_id = this.OrderData[i][2].toString();
				int num = Integer.valueOf(this.OrderData[i][4].toString());
				float price = Float.valueOf(this.OrderData[i][5].toString());
				float finally_price = Float.valueOf(this.OrderData[i][6].toString());
				Bean_product_order_form customer = new Bean_product_order_form();
				customer.setOrder_form_id(orderid);
				customer.setFresh_food_id(fresh_food_id);
				customer.setProduct_id(product_id);
				customer.setProduct_num(num);
				customer.setOriginal_price(price);
				customer.setFinally_price(finally_price);
				try {
					float result = 0;
					result = (new ExampleCustomerProductManger()).paidOrder_form(customer);
					JOptionPane.showConfirmDialog(this, "本次结算共花费"+result+"元,欢迎下次光临！","确认",JOptionPane.PLAIN_MESSAGE);
					this.reloadOrderTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}

}
