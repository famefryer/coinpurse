package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {
	
	
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> list;
		if(amount==0){
			list = new ArrayList<Valuable>();
			return list;
		}
		if(money.size()<=0){
			return null;
		}
		
		if((list = withdraw(amount-money.get(0).getValue(),money.subList(1,money.size())))!=null){
			list.add(money.get(0));
			return list;
		}
		else return withdraw(amount,money.subList(1,money.size()));
	}

	

}
