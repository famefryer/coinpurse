package coinpurse;

import java.util.Comparator;

/**
 * The interface class that use for make easy way to call the type of money.
 * 
 * @author Triwith Mutitakul
 *
 */
public interface Valuable extends Comparable<Valuable> {
	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the value of this object
	 */
	public double getValue();

	/**
	 * Get the monetary currency of this object, in its own currency.
	 * 
	 * @return the currency of this object
	 */
	public String getCurrency();

	public void setCurrency(String currency);

	public void setValueCoin(double d);

}
