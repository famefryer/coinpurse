package coinpurse;
//TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * a coin with a monetary value and currency
 * @author Triwith Mutitakul
 */
//TODO declare that Coin implements Comparable<Coin>
public class Coin implements Comparable<Coin>{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
   
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
    	this.value=value;
    	this.currency=this.DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	this.value=value;
    	this.currency=currency;
 
    }
    
//TODO Write a getValue() method and javadoc.
    public double getValue( ) {
    	return this.value;
    } 
//TODO Write a getCurrency() method and javadoc.
    
    public String getCurrency() { 
    	return currency;
    }
    @Override
//TODO Write an equals(Object) method.
    public boolean equals(Object arg) {
    	if(arg==null){
    		return false; 
    	}
    	if(arg.getClass()!=this.getClass()){
    		return false;
    	}
    	Coin other = (Coin) arg;
    	if(this.currency!=other.currency || this.value!=other.value){
    		return false;
    	}
    	return true;
    }
    
//TODO Write a compareTo method and implement Comparable.
    @Override
	public int compareTo(Coin c) {
		if(this.value<c.value){
			return 1;
		}
		if(this.value>c.value){
			return -1;
		}
		return 0;
	}
    @Override
//TODO write a toString() method. See labsheet for what to return.
    public String toString() { 
    	return this.value+"-"+this.currency; 
    }
    
//TODO Write good Javadoc comments on all methods.
    
}
//TODO remove the TODO comments after you complete them! Including this one!
