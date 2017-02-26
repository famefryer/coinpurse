package coinpurse;

public class MalayMoneyFactory extends MoneyFactory{
	protected MalayMoneyFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable;
		if(value==0.05||value==0.10||value==0.20||value==0.50||value==1||value==2||value==5||value==10||value==20||value==50||value==100){
			if (value < 1) {
				valuable = new Coin(value);
				if(value==0.05||value==0.10||value==0.20||value==0.50){
					valuable.setValue(value*100);
					valuable.setCurrency("Sen");
				}
			} else {
				valuable = new BankNote(value);
			}
			return valuable;
		}
		throw new IllegalArgumentException();
	}
}
