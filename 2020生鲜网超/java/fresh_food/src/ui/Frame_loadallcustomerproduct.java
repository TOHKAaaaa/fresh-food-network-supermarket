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

public class Frame_loadallcustomerproduct extends JDialog implements ActionListener{

	private JPanel toolBar = new JPanel();
	private Button btnDelete = new Button("ɾ����Ʒ");
	private Object OrderTitle[]=Bean_product_order_form.tableTitles;
	private Object OrderData[][];
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable CustomerTable=new JTable(tablmod);
	private void reloadOrderTable(){
		try {
			List<Bean_product_infor> allOrder=(new ExampleCustomerProductManger()).loadall();
			OrderData =new Object[allOrder.size()][Bean_customer_infor.tableTitles.length];
			for(int i=0;i<allOrder.size();i++){
				for(int j=0;j<Bean_customer_infor.tableTitles.length;j++)
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
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//��ȡ��������
		this.reloadOrderTable();
		this.getContentPane().add(new JScrollPane(this.CustomerTable), BorderLayout.CENTER);
		
		// ��Ļ������ʾ
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

//		this.btnAdd.addActionListener(this);
//		this.btnResetPwd.addActionListener(this);
		this.btnDelete.addActionListener(this);
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
//			FrmUserManager_AddUser dlg=new FrmUserManager_AddUser(this,"����˺�",true);
//			dlg.setVisible(true);
//			if(dlg.getUser()!=null){//ˢ�±��
//				this.reloadUserTable();
//			}
//		}
//		else if(e.getSource()==this.btnResetPwd){
//			int i=this.userTable.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null,  "��ѡ���˺�","��ʾ",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			if(JOptionPane.showConfirmDialog(this,"ȷ������������","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
//				String userid=this.tblData[i][0].toString();
//				try {
//					(new SystemUserManager()).resetUserPwd(userid);
//					JOptionPane.showMessageDialog(null,  "�����������","��ʾ",JOptionPane.INFORMATION_MESSAGE);
//				} catch (BaseException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
//				}
//				
//			}
//		}
		if(e.getSource()==this.btnDelete){
			int i=this.CustomerTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ����Ʒ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ����Ʒ��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				String customer_id=this.OrderData[i][2].toString();
//				Bean_customer_infor customer = new Bean_customer_infor();
//				customer.setCustomer_id(userid);
				try {
//					(new ExampleUserManger()).deletecustomer(customer);
//					this.reloadUserTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}

}
