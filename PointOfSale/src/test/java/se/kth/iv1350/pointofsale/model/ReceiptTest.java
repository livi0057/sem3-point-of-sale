package se.kth.iv1350.pointofsale.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    @Test
    public void testReceiptToString() {
        int itemID = 1234;
        Amount price = new Amount (10);
        int quantity = 1;
        int vatRate = 6;
        String itemDescription = "Pasta";
        ItemDTO scannedItem = new ItemDTO(itemID, price, quantity, vatRate, itemDescription);
        List<ItemDTO> itemsInSale = new ArrayList<>(Arrays.asList(scannedItem));
        Amount totalPrice = new Amount(10.6);
        Amount totalVat = new Amount(0.6);
        SaleDTO completedSale = new SaleDTO(itemsInSale, totalPrice, totalVat);
        Amount paidAmount = new Amount(20);
        CashPayment payment = new CashPayment(paidAmount);
        Amount change = new Amount(9.4);
        LocalTime saleTime = LocalTime.now();
        
        Receipt instance = new Receipt(saleTime, completedSale, payment, change);

        String expResult = "\n-------------------- RECEIPT --------------------"
                + "\nTime of sale: " + saleTime + "\n" + itemDescription + "     x"
                + quantity + "          " + price + "\n\nTotal Price incl. VAT: "
                + totalPrice + "\nTotal VAT: " + totalVat + "\n\nPaid amount: "
                + payment.toAmount() + "\nChange: " + change + "\n-----------------"
                + " END OF RECEIPT -----------------\n";
        String result = instance.receiptToString();
        assertTrue(result.contains(expResult), "This is a wrong printout");
        assertTrue(result.contains(Integer.toString(saleTime.getHour())), "Wrong sale hour.");
        assertTrue(result.contains(Integer.toString(saleTime.getMinute())), "Wrong sale minute.");
    }
    
}
