package se.kth.iv1350.pointofsale.integration;

/**
 * Class that creates all external systems.
 */
public class SystemCreator {
    private InventorySystem inventorySystem = new InventorySystem();
    private AccountingSystem accountingSystem = new AccountingSystem();
    
    /**
     * Get the value of inventorySystem.
     * 
     * @return the value of inventorySystem.
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }
    
    /**
     * Get the value of accountingSystem.
     * 
     * @return the value of AccountingSystem.
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }
}
