package se.kth.iv1350.pointofsale.model;

/**
 * Represents one payment for one sale. The sale is payed with cash.
 */
public class CashPayment {
    private final Amount payment;

    /**
     * Creates a new instance, representing the specified amount.
     * 
     * @param payment The amount of cash that the customer payed. 
     */
    public CashPayment(Amount payment) {
        this.payment = payment;
    }
    
    public Amount toAmount () {
        return payment;
    }
}
