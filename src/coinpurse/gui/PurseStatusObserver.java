package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import coinpurse.Purse;

public class PurseStatusObserver implements Observer {
	private JFrame frame;
	private JTextArea message;
	private JProgressBar bar;

	public PurseStatusObserver() {
		initComponents();
		frame.setLocation(800, 170);
		frame.setVisible(true);
	}
	
	private void initComponents(){
		bar = new JProgressBar();
		bar.setMaximum(10);
		bar.setValue(10);
		frame = new JFrame("Purse Status");
		message = new JTextArea("EMPTY");
		message.setEditable(false);
		message.setFont(new Font("Arial", 1, 80));
		frame.add(message, BorderLayout.NORTH);
		frame.add(bar,BorderLayout.SOUTH);
		frame.setSize(700, 200);
	}

	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof Purse){
			Purse purse = (Purse) subject;
			message.setForeground(Color.BLACK);
			bar.setValue(purse.count());
			bar.setMaximum(purse.getCapacity());
			if(purse.isFull()){
				message.setText("FULL");
				message.setForeground(Color.RED);
			}
			else if(purse.count()==0){
				message.setText("EMPTY");
			}
			else message.setText(bar.getString());
		}

	}

}
