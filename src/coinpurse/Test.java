package coinpurse;
public class Test {
	public static void main(String[] args) {
		Purse p = new Purse(3);
		System.out.println(p.getBalance());
		System.out.println(p.count());
		System.out.println(p.isFull());
		p.insert(new Coin(10));
		p.insert(new Coin(10));
		p.insert(new Coin(0));
		p.insert(new Coin(1));
		System.out.println(p.count());
		System.out.println(p.isFull());
		//System.out.println(p.withdraw(12));
		System.out.println(p.withdraw(11));

		
	
	}
	

}
