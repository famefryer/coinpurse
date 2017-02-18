package coinpurse;

/**
 * a banknote with a monetary value and currency.
 * 
 * @author Triwith Mutitakul
 *
 */
public class BankNote implements Valuable {
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency = "Baht";
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 */
	public BankNote(double value) {
		this.value = value;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;

	}

	/**
	 * a method that use for called the value of banknote.
	 * 
	 * @return value of banknote.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * a method that use for called the currency of banknote.
	 * 
	 * @return value of banknote.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * this method use for check between two banknote by the same value and same
	 * currency.
	 * 
	 * @param obj
	 *            is the other object that you want to check.
	 * @return true if it's equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		BankNote other = (BankNote) obj;
		if (this.currency != other.currency || this.value != other.value) {
			return false;
		}
		return true;
	}

	/**
	 * a method that use for called the serial number of banknote.
	 * 
	 * @return serial number of banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * show the value and currency of this banknote.
	 * 
	 * @return the String that contain the value and currency of banknote.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " note " + this.serialNumber;
	}

}
