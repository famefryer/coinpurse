package coinpurse;

public abstract class MoneyFactory {

	private static MoneyFactory factory = null;

	protected MoneyFactory() {}

	public static MoneyFactory getInstance() {
		if (factory == null) {
			factory = new ThaiMoneyFactory();
			return factory;
		}
		return factory;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		double parsedValue;
		try {
			parsedValue = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return createMoney(parsedValue);

	}

	public static void setMoneyFactory(MoneyFactory m) {
		MoneyFactory.factory = m;
	}

}
