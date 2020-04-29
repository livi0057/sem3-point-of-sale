package se.kth.iv1350.pointofsale.model;

/**
 * Represents an item in the sale.
 */
public class ItemDTO {
    private final int itemID;
    private final Amount price;
    private final int quantity;
    private final int vatRate;
    private final String itemDescription;
    
    /**
     *  Creates a new instance.
     * 
     *  @param itemID           The scanned item's ID-number.
     *  @param price            The scanned item's price.
     *  @param quantity         The scanned item's quantity.
     *  @param vatRate          The scanned item's vatRate.
     *  @param itemDescription  The scanned item's description.
     */
    public ItemDTO(int itemID, Amount price, int quantity, int vatRate, String itemDescription) {
        this.itemID = itemID;
        this.price = price;
        this.quantity = quantity;
        this.vatRate = vatRate;
        this.itemDescription = itemDescription;
    }
    
    /**
     * Get the value of price.
     * 
     * @return the value of price.
     */
    public Amount getPrice() {
        return price;
    }
    
    /**
     * Get the value of quantity.
     * 
     * @return the value of quantity.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Get the value of vatRate.
     * 
     * @return the value of vatRate.
     */
    public int getVatRate() {
        return vatRate;
    }
    
    /**
     * Get the value of itemDescription.
     * 
     * @return the value of itemDescription.
     */
    public String getItemDescription() {
        return itemDescription;
    }
    
    /**
     * Get the value of itemDescription.
     * 
     * @return the value of itemDescription.
     */
    public int getItemID() {
        return itemID;
    }
    
    /**
     * Set the value of quantity.
     * 
     * @param newQuantity       The new quantity of scanned item.
     * @return the value of newQuantity.
     */
    public int setQuantity(int newQuantity) {
        return newQuantity;
    }
}
