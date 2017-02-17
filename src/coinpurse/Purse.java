package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Triwith Mutitakul
 */
public class Purse {
	/** Collection of objects in the purse. */
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private double balance = 0;
	public List<Valuable> money = new ArrayList<Valuable>();

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		// TODO initialize the attributes of purse

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (capacity <= money.size()) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param valuable
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (valuable.getValue() == 0) {
			return false;
		}
		if (!isFull()) {
			money.add(valuable);
			balance += money.get(money.size() - 1).getValue();
			Collections.sort(this.money, new Comparator<Valuable>() {
				@Override
				public int compare(Valuable arg0, Valuable arg1) {
					if (arg0.getValue() < arg1.getValue()) {
						return 1;
					}
					if (arg0.getValue() > arg1.getValue()) {
						return -1;
					}
					return 0;
				}
			});
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */

	public Valuable[] withdraw(double amount) {
		// TODO don't allow to withdraw amount < 0
		double amount2 = amount;
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
		Valuable[] myPurse = new Valuable[temp.size()];
		temp.toArray(myPurse);
		this.balance = this.balance - amount2;
		return myPurse;

	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return money.size() + " coins with value " + this.balance;
	}

}
