package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Frame_main extends JFrame{
	private Frame_login lFrame_login = null;
	
	public Frame_main(){
		lFrame_login = new Frame_login(this, "ÉúÏÊÍø³¬µÇÂ¼½çÃæ", true);
		lFrame_login.setVisible(true);
	}
	
	

}
