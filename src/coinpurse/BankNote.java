package coinpurse;

/**
 * a banknote with a monetary value and currency.
 * 
 * @author Triwith Mutitakul
 *
 */
public class BankNote extends AbstractValuable {
	private static long nextSerialNumber = 1000000;
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 */
	public BankNote(double value) {
		super(value);
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
		super(value, currency);
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	/**
	 * /** a method that use for set the currency.
	 * 
	 * @param currency
	 */
	@Override
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * a method that use for set the value.
	 * 
	 * @param value
	 */
	@Override
	public void setValueCoin(double value) {
		this.value = value;
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
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}

}
