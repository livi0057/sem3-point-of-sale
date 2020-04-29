package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.ItemDTO;
import se.kth.iv1350.pointofsale.model.Amount;
import se.kth.iv1350.pointofsale.model.SaleDTO;

/**
 * Contains all calls to the external accounting system.
 */
public class InventorySystem {
    /**
     * Creates a new instance.
     */
    InventorySystem() {
    }
    
    /**
     * Gets the item information from the external inventory system.
     * 
     * @param itemID
     * @param quantity
     * @return 
     */
    public ItemDTO getItemInfo(int itemID, int quantity) {
        ItemDTO itemInfo = null;
        
        if (itemID == 1234) {
            Amount itemPrice = new Amount(20);
            itemInfo = new ItemDTO(itemID, itemPrice, quantity, 25, "Pasta");
        }
        else if (itemID == 1212) {
            Amount itemPrice = new Amount(30);
            itemInfo = new ItemDTO(itemID, itemPrice, quantity, 12, "Flour");
        }
        else if (itemID == 4321) {
            Amount itemPrice = new Amount(10);
            itemInfo = new ItemDTO(itemID, itemPrice, quantity, 6, "Milk ");
        }
        return itemInfo;
    }
    
    /**
     * Updates the inventory system.
     * 
     * @param saleInfo The sale information used to update the inventory system
     */
    public void updateInventory(SaleDTO saleInfo) {
    }
    
}
