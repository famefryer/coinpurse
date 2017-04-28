package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Triwith Mutitakul
 */
public class Purse extends Observable{
	/** Collection of objects in the purse. */
	/**
	 * Capacity is maximum number of money that the purse can hold. Capacity is
	 * set when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private double balance = 0;
	public List<Valuable> money = new ArrayList<Valuable>();
	private WithdrawStrategy strategy;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of money you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		strategy = new RecursiveWithdraw();
		// TODO initialize the attributes of purse

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of Valuable object in the purse.
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
	 * Insert a money into the purse. The money is only inserted if the purse
	 * has space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param valuable
	 *            is a Valuable object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (valuable.getValue() == 0) {
			return false;
		}
		if (!isFull()) {
			money.add(valuable);
			balance += money.get(money.size() - 1).getValue();
			setChanged();
			notifyObservers();
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
	 * Withdraw the requested amount of money. Return an array of Valuable.
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */

	public Valuable[] withdraw(double amount) {
		List<Valuable> list = strategy.withdraw(amount, money);
		if(list!=null){
			Valuable[] val = new Valuable[list.size()];
			list.toArray(val);
			if(val!=null){
				this.balance = this.balance - amount;
			}
			for (Valuable valuable : val) {
				money.remove(valuable);
			}
			setChanged();
			notifyObservers();
			return val;
		}
		else return null;
	}
	
	public void setWithdrawStrategy(WithdrawStrategy wstrategy){
		
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return money.size() + " Valuable object with value " + this.balance;
	}

}
