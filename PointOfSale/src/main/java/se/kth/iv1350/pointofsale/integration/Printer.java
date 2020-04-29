package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.Receipt;

/**
 * The interface to the printer. Used to print recepies created by program.
 */
public class Printer {
    
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.receiptToString());
    }
}
