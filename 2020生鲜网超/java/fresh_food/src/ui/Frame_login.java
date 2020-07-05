package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Checkbox;

public class Frame_login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Frame_login dialog = new Frame_login();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
	public Frame_login() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 432, 216);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u7528\u6237\u540D");
			label.setBounds(87, 58, 45, 18);
			label.setVerticalAlignment(SwingConstants.TOP);
			contentPanel.add(label);
		}
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setBounds(87, 120, 72, 18);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(153, 55, 150, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(153, 117, 150, 24);
			contentPanel.add(passwordField);
		}
		
		JRadioButton radioButton = new JRadioButton("\u7BA1\u7406\u5458");
		radioButton.setBounds(157, 168, 83, 27);
		contentPanel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u7528\u6237");
		radioButton_1.setBounds(249, 168, 83, 27);
		contentPanel.add(radioButton_1);
		
		JLabel label_1 = new JLabel("\u767B\u5F55\u8EAB\u4EFD");
		label_1.setBounds(87, 172, 72, 18);
		contentPanel.add(label_1);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 216, 432, 37);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton button = new JButton("\u6CE8\u518C");
				button.setBounds(229, 5, 63, 27);
				buttonPane.add(button);
			}
			{
				JButton okButton = new JButton("\u767B\u5F55");
				okButton.setBounds(296, 5, 63, 27);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u9000\u51FA");
				cancelButton.setBounds(364, 5, 63, 27);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
		}
	}
}
