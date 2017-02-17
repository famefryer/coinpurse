package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> coinlist, String currency) {
		List<Valuable> tempFil = new ArrayList<>();
		for (Valuable valuable : coinlist) {
			if (valuable.getCurrency().equals(currency)) {
				tempFil.add(valuable);
			}
		}
		return tempFil;
		// return a list of coin references copied from coinlist
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param valuable
	 *            is a List of Coin objects we want to sort.
	 *
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		ForCompareCurren comp = new ForCompareCurren();
		Collections.sort(valuable, comp);
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> valuable) {
		Map<String, Double> map = new HashMap<>();
		for (Valuable money : valuable) {
			if (map.containsKey(money.getCurrency())) {
				map.put(money.getCurrency(), map.get(money.getCurrency()) + money.getValue());
			} else
				map.put(money.getCurrency(), money.getValue());
		}
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> valuable = makeInternationalCoins();
		int size = valuable.size();
		System.out.print(" INPUT: ");
		printList(valuable, " ");
		List<Valuable> rupees = filterByCurrency(valuable, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (valuable.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		valuable = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(valuable, " ");
		sortByCurrency(valuable);
		System.out.print("RESULT: ");
		printList(valuable, " ");

		System.out.println("\nSum coins by currency");
		valuable = makeInternationalCoins();
		System.out.print("coins= ");
		printList(valuable, " ");
		sumByCurrency(valuable);
	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}

}

/**
 * the class that use for sort the coin by currency.
 * 
 * @author Triwith Mutitakul
 *
 */
class ForCompareCurren implements Comparator<Valuable> {
	/**
	 * this method that manage how to sort.
	 * 
	 * @param coin1
	 * @param coin2
	 */
	@Override
	public int compare(Valuable coin1, Valuable coin2) {
		return coin1.getCurrency().compareToIgnoreCase(coin2.getCurrency());
	}
}
