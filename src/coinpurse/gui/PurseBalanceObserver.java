package coinpurse.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import coinpurse.Purse;

public class PurseBalanceObserver implements Observer{
	private JFrame frame;
	private JTextArea message;
	
	public PurseBalanceObserver() {
		initComponents();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	private void initComponents(){
		frame = new JFrame("Purse Balance");
		message = new JTextArea("0 BAHT");
		message.setEditable(false);
		message.setFont(new Font("Arial", 1, 100));
		frame.add(message);
		frame.setSize(600, 200);
	}

	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof Purse){
			Purse purse = (Purse) subject;
			message.setForeground(Color.BLACK);
			message.setText(purse.getBalance()+" BAHT");
			if(purse.isFull()){
				message.setForeground(Color.RED);
			}
		}
	}
	

}
