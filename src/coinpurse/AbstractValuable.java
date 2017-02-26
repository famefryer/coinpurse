package coinpurse;

public abstract class AbstractValuable implements Valuable {
	protected double value;
	protected String currency;

	public AbstractValuable(double value) {
		this.value = value;
	}

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return this.value;
	};

	public String getCurrency() {
		return this.currency;
	};

	@Override
	public int compareTo(Valuable c) {
		if(this.getCurrency().equals(c.getCurrency())){
			if (this.value < c.getValue()) {
				return -1;
			}
			if (this.value > c.getValue()) {
				return 1;
			}
			return 0;
		}
		return -1;
	}
	
    @Override
	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		}
		if (arg.getClass() != this.getClass()) {
			return false;
		}
		Valuable other = (Valuable) arg;
		if (this.currency != other.getCurrency() || this.getValue() != other.getValue()) {
			return false;
		}
		return true;
	}

}
