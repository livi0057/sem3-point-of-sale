package se.kth.iv1350.pointofsale.model;

import java.util.List;

/**
 * Represents the information of the completed sale.
 */
public class SaleDTO {
    private final List<ItemDTO> itemDescriptions;
    private final Amount totalPrice;
    private Amount totalVat;
    
    /**
     *  Creates a new instance.
     * 
     *  @param itemDescriptions  A list of item descriptions of all items in the completed sale.
     *  @param totalPrice        The total price of all items in the completed sale.
     *  @param totalVat          The total VAT of the completed sale.
     */
    public SaleDTO(List<ItemDTO> itemDescriptions, Amount totalPrice, Amount totalVat) {
        this.itemDescriptions = itemDescriptions;
        this.totalPrice = totalPrice;
        this.totalVat = totalVat;
    }
    
     /**
     * Get the value of itemDescription.
     * 
     * @return the value of itemDescription.
     */
    public List<ItemDTO> getItemDescriptions() {
        return itemDescriptions;
    }
    
    /**
     * Get the value of price.
     * 
     * @return the value of price.
     */
    public Amount getTotalPrice() {
        return totalPrice;
    }
    
    /**
     * Get the value of totalVat.
     * 
     * @return the value of totalVat.
     */
    public Amount getTotalVat() {
        return totalVat;
    }
}
