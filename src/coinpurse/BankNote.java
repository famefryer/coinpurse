package coinpurse;

public class BankNote implements Valuable {
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency = "Baht";
	private long serialNumber;

	public BankNote(double value) {
		this.value = value;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;

	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		// TODO Auto-generated method stub
		return this.currency;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		BankNote other = (BankNote) obj;
		if (this.currency != other.currency || this.value != other.value) {
			return false;
		}
		return true;
	}

	public long getSerial() {
		return this.serialNumber;
	}

	public String toString() {
		return this.value + "-" + this.currency + " note " + this.serialNumber;
	}

}
