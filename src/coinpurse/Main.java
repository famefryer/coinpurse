package coinpurse;

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
		Purse p = new Purse(12);
		ConsoleDialog c = new ConsoleDialog(p);
		c.run();

	}
}
