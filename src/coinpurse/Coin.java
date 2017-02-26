package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Triwith Mutitakul
 */
public class Coin extends AbstractValuable {
	public static final String DEFAULT_CURRENCY = "Baht";

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		super(value);
		this.currency="Baht";
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * a method that use for called the value of coin.
	 * 
	 * @return value of coin.
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	
	@Override
	public void setCurrency(String currency){
		this.currency=currency;
	}
	
	@Override
	public void setValue(double value){
		this.value=value;
	}

	/**
	 * a method that use for called the currency of coin.
	 * 
	 * @return currency of coin.
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * this method use for check between two coin by the same value and same
	 * currency.
	 * 
	 * @param arg
	 *            is the other object that you want to check.
	 * @return true if it's equal.
	 */
	// @Override
	// public boolean equals(Object arg) {
	// if (arg == null) {
	// return false;
	// }
	// if (arg.getClass() != this.getClass()) {
	// return false;
	// }
	// Coin other = (Coin) arg;
	// if (this.currency != other.currency || this.value != other.value) {
	// return false;
	// }
	// return true;
	// }

	/**
	 * this method use for compare the coin.
	 * 
	 * @param c
	 *            is the object Coin that you want to compared.
	 * @return if it's has value more than c return -1,if its less than c return
	 *         1,if its equals return 0
	 */
	// @Override
	// public int compareTo(Coin c) {
	// if (this.value < c.value) {
	// return 1;
	// }
	// if (this.value > c.value) {
	// return -1;
	// }
	// return 0;
	// }

	/**
	 * show the value and currency of this coin.
	 * 
	 * @return the String that contain the value and currency of coin.
	 */
	@Override
	public String toString() {
		return this.value + "-" + this.currency+" coin";
	}

}
