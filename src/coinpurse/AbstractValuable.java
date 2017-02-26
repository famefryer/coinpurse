package coinpurse;

/**
 * The super class of each Valuable.
 * 
 * @author Triwith Mutitakul
 *
 */
public abstract class AbstractValuable implements Valuable {
	protected double value;
	protected String currency;

	/**
	 * The constructor.
	 * 
	 * @param value
	 */
	public AbstractValuable(double value) {
		this.value = value;
	}

	/**
	 * The constructor.
	 * 
	 * @param value
	 * @param currency
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * The method is call for return value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * The method is call for return currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * The method that use for compare Valuable.
	 */
	@Override
	public int compareTo(Valuable c) {
		if (this.getCurrency().equals(c.getCurrency())) {
			if (this.value < c.getValue()) {
				return -1;
			}
			if (this.value > c.getValue()) {
				return 1;
			}
			return 0;
		}
		return -1;
	}

	/**
	 * The method that use for check Valuable.return true if it equals.
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		}
		if (arg.getClass() != this.getClass()) {
			return false;
		}
		Valuable other = (Valuable) arg;
		if (this.currency != other.getCurrency() || this.getValue() != other.getValue()) {
			return false;
		}
		return true;
	}

}
