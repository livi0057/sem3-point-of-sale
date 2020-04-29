package se.kth.iv1350.pointofsale.model;

/**
 * Represents an amount of money.
 */
public final class Amount {

    private final double amount;
    
    /**
     * Creates a new instance, representing the amount 0.
     */
    public Amount(){
        this(0);
    }
    
    /**
     * Creates a new instance, representing the specified amount.
     * 
     * @param amount The amount represented by the newly created instance. 
     */
    public Amount(double amount) {
        this.amount = amount;
    }
    
    /**
     * Adds the specified <code>Amount</code> to another Amount object, and
     * returns the sum as an <code>Amount</code> instance.
     * 
     * @param other The other <code>Amount</code> to add.
     * @return The result of the addition.
     */
    public Amount add(Amount other) {
        return new Amount(amount + other.amount);
    }
    
    /**
     * Subtracts the specified <code>Amount</code> with another Amount object, and
     * returns the differens as an <code>Amount</code> instance.
     * 
     * @param other The other <code>Amount</code> to subtract.
     * @return The result of the subtraction.
     */
    public Amount subtract(Amount other) {
        return new Amount(amount - other.amount);
    }
    
    /**
     * Multiplies the specified <code>Amount</code> with an integer which is converted
     * to another Amount object. Returns the product as an <code>Amount</code> instance.
     * 
     * @param other The int to convert to another <code>Amount</code> to multiply.
     * @return The result of the multiplication.
     */
    public Amount multiply(int other) {
        return new Amount(amount * new Amount(other).amount);
    }
    
    /**
     * Divides the specified <code>Amount</code> with an integer which is converted
     * to another Amount object. Returns the quotient as an <code>Amount</code> instance.
     * 
     * @param other The int to convert to another <code>Amount</code> to divide.
     * @return The result of the multiplication.
     */
    public Amount divide(int other) {
        return new Amount(amount / new Amount(other).amount);
    }
    
    /**
     * Two <code>Amount</code>s are equal if they represent the same Amount.
     * 
     * @param other The <code>Amount</code> to compare with this amount.
     * @return <code>true</code> if the specified amount is equal to this amount,
     *         <code>false</code> if it is not.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Amount)) {
            return false;
        }
        Amount otherAmount = (Amount) other;
        return amount == otherAmount.amount;
    }
    
    @Override
    public String toString() {
        return Double.toString(amount);
    }
}
