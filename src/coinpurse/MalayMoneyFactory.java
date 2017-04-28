package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	/**
	 * The constructor that create for set to protected.
	 */
	protected MalayMoneyFactory() {

	}

	/**
	 * The method that use for create money.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50 || value == 1 || value == 2 || value == 5
				|| value == 10 || value == 20 || value == 50 || value == 100) {
			if (value < 1) {
				valuable = new Coin(value);
				if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) {
					valuable.setValueCoin(value * 100);
					valuable.setCurrency("Sen");
				}
			} else {
				valuable = new BankNote(value);
				valuable.setCurrency("Ringgit");
			}
			return valuable;
		}
		throw new IllegalArgumentException();
	}
}
