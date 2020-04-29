package se.kth.iv1350.pointofsale.model;

import java.time.LocalTime;
import java.util.List;

/**
 * The receipt of a sale. A receipt proves payment.
 */
public class Receipt {
    private LocalTime saleTime;
    private SaleDTO saleInfo;
    private CashPayment payment;
    private Amount change;
    
    /**
     * Creates a new instance.
     * 
     * @param saleTime      The time of the sale.
     * @param saleInfo      The sale information that is shown on the receipt.
     * @param payment    The amount paid by customer.
     * @param change        The change to give to customer.
     */
    public Receipt (LocalTime saleTime, SaleDTO saleInfo, CashPayment payment, Amount change) {
        this.saleTime = saleTime;
        this.saleInfo = saleInfo;
        this.payment = payment;
        this.change = change;
    }
    
    /**
     * Creates a string with the entire content of the receipt.
     * 
     * @return the receipt string.
     */
    public String receiptToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(dashedLine(20));
        sb.append(" RECEIPT ");
        sb.append(dashedLine(20));
        sb.append("\nTime of sale: ");
        sb.append(saleTime);
        
        List<ItemDTO> itemsInSale = saleInfo.getItemDescriptions();
        for (ItemDTO item : itemsInSale) {
            sb.append("\n");
            sb.append(item.getItemDescription());
            sb.append(insertSpace(5));
            sb.append("x");
            sb.append(item.getQuantity());
            sb.append(insertSpace(10));
            sb.append(item.getPrice());
        }
        
        sb.append("\n\nTotal Price incl. VAT: ");
        sb.append(saleInfo.getTotalPrice());
        sb.append("\nTotal VAT: ");
        sb.append(saleInfo.getTotalVat());
        
        
        sb.append("\n\nPaid amount: ");
        sb.append(payment.toAmount());
        sb.append("\nChange: ");
        sb.append(change);
        
        sb.append("\n");
        sb.append(dashedLine(17));
        sb.append(" END OF RECEIPT ");
        sb.append(dashedLine(17));
        sb.append("\n");
       
        return sb.toString();
    }
    
    private String dashedLine(int number) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < number; i++)
            sb.append('-');
        return sb.toString();
    }
    
    private String insertSpace(int space) {
        StringBuilder sb = new StringBuilder(space);
        for (int i = 0; i < space; i++)
            sb.append(' ');
        return sb.toString();
    }
}
