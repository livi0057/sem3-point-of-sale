package se.kth.iv1350.pointofsale.model;

/**
 * Represents the information that will be displayed to the cashier.
 */
public class SaleInfoDTO {
    private final String itemDescription;
    private final Amount itemPrice;
    private final Amount runningTotal;
    private final int quantity;
    
    /**
     * Creates a new instance.
     * 
     * @param itemDescription   The scanned items description.
     * @param itemPrice         The scanned items price.
     * @param runningTotal      The sales running total.
     * @param quantity          The scanned items quantity.
     */
    public SaleInfoDTO(String itemDescription, Amount itemPrice, Amount runningTotal, int quantity) {
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.runningTotal = runningTotal;
        this.quantity = quantity;
    }
    
     /**
     * Get the value of itemDescription.
     * @return the value of itemDescription.
     */
    public String getItemDescription() {
        return itemDescription;
    }
    
    /**
     * Get the value of price.
     * @return the value of price.
     */
    public Amount getItemPrice() {
        return itemPrice;
    }
    
    /**
     * Get the value of runningTotal.
     * @return the value of runningTotal.
     */
    public Amount getRunningTotal() {
        return runningTotal;
    }
    
    /**
     * Get the value of quantity.
     * @return the value of quantity.
     */
    public int getQuantity() {
        return quantity;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAn item has been added to the current sale.");
        sb.append("\nItem description: ");
        sb.append(itemDescription);
        sb.append("\nItem price: ");
        sb.append(itemPrice);
        sb.append(" x ");
        sb.append(quantity);
        sb.append("\nRunning total incl. VAT: ");
        sb.append(runningTotal);
       
        return sb.toString();
    }
}
