package se.kth.iv1350.pointofsale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pointofsale.model.Receipt;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import se.kth.iv1350.pointofsale.model.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrinterTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    
    @BeforeEach
    public void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testPrintReceipt() {
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
        
        Receipt receipt = new Receipt(saleTime, completedSale, payment, change);
        Printer instance = new Printer();
        instance.printReceipt(receipt);

        String expResult = "\n-------------------- RECEIPT --------------------"
                + "\nTime of sale: " + saleTime + "\n" + itemDescription + "     x"
                + quantity + "          " + price + "\n\nTotal Price incl. VAT: "
                + totalPrice + "\nTotal VAT: " + totalVat + "\n\nPaid amount: "
                + payment.toAmount() + "\nChange: " + change + "\n-----------------"
                + " END OF RECEIPT -----------------\n";
        String result = outContent.toString();
        assertTrue(result.contains(expResult), "This is a wrong printout");
        assertTrue(result.contains(Integer.toString(saleTime.getHour())), "Wrong sale hour.");
        assertTrue(result.contains(Integer.toString(saleTime.getMinute())), "Wrong sale minute.");
    }
    
}
