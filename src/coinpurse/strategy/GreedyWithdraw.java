package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.*;

public class GreedyWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> temp = new ArrayList<>();
		for (Valuable valuable : money) {
			if (valuable.getValue() <= amount) {
				amount = amount - valuable.getValue();
				temp.add(valuable);
			}
		}
		if (amount != 0) {
			return null;
		}
		for (Valuable valuable : temp) {
			money.remove(valuable);
		}
		
		return temp;
	}

}
