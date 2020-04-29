package se.kth.iv1350.pointofsale.view;

import se.kth.iv1350.pointofsale.controller.Controller;
import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.model.Sale;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller.
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() {
        contr.startNewSale();
        System.out.println("A new sale has been started.");
        
        SaleInfoDTO infoToPresent1 = contr.enterItem(1234, 2);
        System.out.println(infoToPresent1);
        SaleInfoDTO infoToPresent2 = contr.enterItem(1212, 2);
        System.out.println(infoToPresent2);
        SaleInfoDTO infoToPresent3 = contr.enterItem(1234, 1);
        System.out.println(infoToPresent3);
        SaleInfoDTO infoToPresent4 = contr.enterItem(4321, 3);
        System.out.println(infoToPresent4);
        
        Amount totalPrice = contr.endSale();
        System.out.println("\nThe sale is ended.");
        System.out.println("Total price incl. VAT: " + totalPrice);
        System.out.println("\n...PRINTING RECEIPT...");
        
        Amount paidAmount = new Amount (200);
        Amount change = contr.enterPaidAmount(paidAmount);
        System.out.println("Change: " + change.toString());
    }
}
