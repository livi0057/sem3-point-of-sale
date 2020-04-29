package se.kth.iv1350.pointofsale.model;

/**
 * Represents a cash register.
 */
public class CashRegister {
    private Amount balance = new Amount();
    
    /**
     * Increases the balance in the cash register.
     * 
     * @param payment The <code>Amount</code> to increase balance with.
     */
    public void increaseBalance(CashPayment payment) {
        balance = balance.add(payment.toAmount());
    }
    
    /**
     * Updated the balance in the cash register.
     * 
     * @param change The <code>Amount</code> to decrease balance with.
     */
    public void updateBalance(Amount change) {
        balance = balance.subtract(change);
    }
}
