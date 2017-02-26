package coinpurse;

/**
 * The super class that use for create the money.
 * 
 * @author Triwith Mutitakul
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory = null;

	protected MoneyFactory() {
	}

	/**
	 * The method that use for create an Object of MoneyFactory if it won't.
	 * 
	 * @return Object of MoneyFactory
	 */
	public static MoneyFactory getInstance() {
		if (factory == null) {
			factory = new ThaiMoneyFactory();
			return factory;
		}
		return factory;
	}

	/**
	 * The method that use for create money by value.
	 * 
	 * @param value
	 * @return Valuable
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * The method that use for create money by value in String case.but if the
	 * value isn't a string of number It will send an error.
	 * 
	 * @param value
	 * @return Valuable
	 */
	public Valuable createMoney(String value) {
		double parsedValue;
		try {
			parsedValue = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return createMoney(parsedValue);

	}

	/**
	 * The method that use for set the MoneyFactory depending on the
	 * purse.properties.
	 * 
	 * @param m
	 */
	public static void setMoneyFactory(MoneyFactory m) {
		MoneyFactory.factory = m;
	}

}
