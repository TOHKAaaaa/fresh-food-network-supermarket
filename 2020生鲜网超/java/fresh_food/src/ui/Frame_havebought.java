package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import example.ExampleCustomerManger;
import example.ExampleUserManger;
import model.Bean_product_order_form;
import util.BaseException;

public class Frame_havebought extends JDialog {

	private String CustomerTitle[]={"客户编号","订单编号","生鲜编号","商品编号","商品名称","数量","结算单价"};
	private Object CustomerData[][];
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable CustomerTable=new JTable(tablmod);
	private void reloadUserTable(){
		try {
			List<Bean_product_order_form> allCustomer=(new ExampleCustomerManger()).list();
			CustomerData =new Object[allCustomer.size()][CustomerTitle.length];
			for(int i=0;i<allCustomer.size();i++){
				for(int j=0;j<CustomerTitle.length;j++)
					CustomerData[i][j]=allCustomer.get(i).getconCell(j);
			}
			tablmod.setDataVector(CustomerData,CustomerTitle);
			this.CustomerTable.validate();
			this.CustomerTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Frame_havebought(Frame f, String s, boolean b) {
		super(f, s, b);
//		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
//		toolBar.add(btnAdd);
//		toolBar.add(btnResetPwd);
//		toolBar.add(this.btnDelete);
//		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		this.reloadUserTable();
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
//		this.btnDelete.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}

}
