package coinpurse.strategy;

import coinpurse.*;
import java.util.List;

public interface WithdrawStrategy {
	public List<Valuable> withdraw(double amount, List<Valuable> money);

}
