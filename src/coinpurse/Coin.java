package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Triwith Mutitakul
 */
public class Coin extends AbstractValuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	private double valueCoin;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		super(value);
		this.currency = "Baht";
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

	/**
	 * a method that use for set the currency.
	 * 
	 * @param currency
	 */
	@Override
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * a method that use for set the value in coin term.
	 * 
	 * @param value
	 */

	public void setValueCoin(double value) {
		this.valueCoin = value;
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
	 * show the value and currency of this coin.
	 * 
	 * @return the String that contain the value and currency of coin.
	 */
	@Override
	public String toString() {
		return this.value + "-" + this.currency + " coin";
	}

}
