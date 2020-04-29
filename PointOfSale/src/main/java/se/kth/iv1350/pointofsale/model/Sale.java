package se.kth.iv1350.pointofsale.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pointofsale.integration.Printer;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private Receipt receipt;
    private List<ItemDTO> itemsInSale = new ArrayList<>();
    
    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale() {
        saleTime = LocalTime.now();
    }
    
    /**
     * Registers a new item to the current sale.
     * 
     * @param itemToAdd the item to be added to the current sale.
     */
    public void registerItem(ItemDTO itemToAdd) {
        itemsInSale.add(itemToAdd);
    }
    
    /**
     * Searches in the current sale for the scanned item.
     * 
     * @param currentItemID The itemID of the scanned item.
     * @return If the item is already in the current sale return 
     * <code>ItemDTO</code> of the scanned item, if the item is not in the current
     * sale return null.
     */
    public ItemDTO findItem(int currentItemID) {
        for (ItemDTO scannedItems : itemsInSale) {
            if (scannedItems.getItemID() == currentItemID) {
                ItemDTO alreadyScannedItem = new ItemDTO(scannedItems.getItemID(), scannedItems.getPrice(), 
                        scannedItems.getQuantity(), scannedItems.getVatRate(), scannedItems.getItemDescription());
                return alreadyScannedItem;
            }
        }
        return null;
    }
    
    /**
     * Updates the scanned items quantity.
     * 
     * @param itemToUpdate  The items whos quantity should be updated.
     * @param quantity      The items quantity before the update.
     */
    public void updateQuantity(ItemDTO itemToUpdate, int quantity) {
        for (ItemDTO scannedItems : itemsInSale) {
            int pos = 0;
            if (scannedItems.getItemID() == itemToUpdate.getItemID()) {
                int newQuantity = itemToUpdate.getQuantity() + quantity;
                itemsInSale.set(pos, new ItemDTO(scannedItems.getItemID(), scannedItems.getPrice(), 
                        newQuantity, scannedItems.getVatRate(), scannedItems.getItemDescription()));
                return;
            }
            pos++;
        }
    }
    
    /**
     * Get the sale's total price including VAT.
     * 
     * @return the sale's total price including VAT.
     */
    public Amount getTotalInclVat() {
        Amount totalInclVat = new Amount();
        Amount itemPrice = new Amount();
        Amount itemVatPrice = new Amount();
        
        for (ItemDTO item : itemsInSale) {
            itemPrice = item.getPrice().multiply(item.getQuantity());
            itemVatPrice = (itemPrice.multiply(item.getVatRate()).divide(100));

            totalInclVat = totalInclVat.add(itemPrice.add(itemVatPrice));
        }
        return totalInclVat;
    }
    
    /**
     * Get the sales total VAT.
     * 
     * @return the sales total VAT.
     */
    public Amount getVatForEntireSale() {
        Amount vatForEntireSale = new Amount();
        Amount itemPrice = new Amount();
        Amount itemVatPrice = new Amount();
        
        for (ItemDTO item : itemsInSale) {
            itemPrice = item.getPrice().multiply(item.getQuantity());
            itemVatPrice = (itemPrice.multiply(item.getVatRate()).divide(100));

            vatForEntireSale = vatForEntireSale.add(itemVatPrice);
        }
        return vatForEntireSale;
    }
    
    /**
     * The sale is completed by receiving a payment.
     * 
     * @param payment The payment received from customer.
     * @return The change to give to customer.
     */
    public Amount completeSale(CashPayment payment) {
        Amount total = getTotalInclVat();
        Amount change = payment.toAmount().subtract(total);

        return change;
    }
    
    /**
     * Get the information of the completed sale.
     * 
     * @return The information of the completed sale.
     */
    public SaleDTO getSaleInfo () {
        Amount totalInclVat = getTotalInclVat();
        Amount totalVat = getVatForEntireSale();
        
        SaleDTO saleInfo = new SaleDTO (itemsInSale, totalInclVat, totalVat);
        
        return saleInfo;
    }
    
    /**
     * Prints a receipt for the current sale on the specified printer.
     * 
     * @param printer   The printer where the receipt is printed.
     * @param payment   The payment given by customer.
     * @param change    The change given to customer.
     */
    public void printReceipt(Printer printer, CashPayment payment, Amount change){
        SaleDTO saleInfo = getSaleInfo();
        Receipt receipt = new Receipt (saleTime, saleInfo, payment, change);
        printer.printReceipt(receipt);
    }
}
