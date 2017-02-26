package coinpurse;

/**
 * The class that use for create Thai money.
 * 
 * @author Triwith Mutitakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/**
	 * The constructor that create for set to protected.
	 */
	protected ThaiMoneyFactory() {
	}

	/**
	 * The method that use for create money.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;
		if (value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10 || value == 20
				|| value == 50 || value == 100 || value == 500 || value == 1000) {
			if (value < 20) {
				valuable = new Coin(value);
				if (value == 0.25 || value == 0.50) {
					valuable.setValueCoin(value * 100);
					valuable.setCurrency("Stang");
				}
			} else {
				valuable = new BankNote(value);
				valuable.setCurrency("Baht");
			}
			return valuable;
		}
		throw new IllegalArgumentException();
	}

}
