package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author your name
 */
public class Main {

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("factory");
		try {
			MoneyFactory m = (MoneyFactory) Class.forName(factoryclass).newInstance();
			MoneyFactory.setMoneyFactory(m);
		} catch (Exception e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		} 
		Purse p = new Purse(12);
		ConsoleDialog c = new ConsoleDialog(p);
		c.run();
	}
}
