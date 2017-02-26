package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {
	protected ThaiMoneyFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;
		if(value==0.25||value==0.50||value==1||value==2||value==5||value==10||value==20||value==50||value==100||value==500||value==1000){
			if (value < 20) {
				valuable = new Coin(value);
				if(value==0.25||value==0.50){
					valuable.setValue(value*100);
					valuable.setCurrency("Stang");
				}
			} else {
				valuable = new BankNote(value);
			}
			return valuable;
		}
		throw new IllegalArgumentException();
	}

}
