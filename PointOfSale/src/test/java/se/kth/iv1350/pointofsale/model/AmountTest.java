package se.kth.iv1350.pointofsale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AmountTest {
    private Amount amountNoArg;
    private Amount amountWithFive;
    
    @BeforeEach
    public void setUp() {
        amountNoArg = new Amount();
        amountWithFive = new Amount(5);
    }
    
    @AfterEach
    public void tearDown() {
        amountNoArg = null;
        amountWithFive = null;
    }

    @Test
    public void testNotEqualsNull() {
        Object other = null;
        boolean expResult = false;
        boolean result = amountNoArg.equals(other);
        assertEquals(expResult, result, "Amount instance equal to null.");
    }
    
    @Test
    public void testNotEqualsJavaLangObject() {
        Object other = new Object();
        boolean expResult = false;
        boolean result = amountNoArg.equals(other);
        assertEquals(expResult, result, "Amount instance equal to java.lang.Object instance.");
    }
    
    @Test
    public void testNotEqualsUsingNoArg() {
        boolean expResult = false;
        boolean result = amountNoArg.equals(amountWithFive);
        assertEquals(expResult, result, "Amount instance with different states are equal.");
    }
    
    @Test
    public void testNotEqual() {
        double otherNumber = 3;
        Amount other = new Amount(otherNumber);
        boolean expResult = false;
        boolean result = amountWithFive.equals(other);
        assertEquals(expResult, result, "Amount instance with different states are equal.");
    }
    
    @Test
    public void testEqual() {
        double otherNumber = 5.0;
        Amount other = new Amount(otherNumber);
        boolean expResult = true;
        boolean result = amountWithFive.equals(other);
        assertEquals(expResult, result, "Amount instance with same states are not equal.");
    }
    
   @Test
    public void testAdd() {
        double amountOperand1 = 10;
        double amountOperand2 = 2;
        Amount operand1 = new Amount(amountOperand1);
        Amount operand2 = new Amount(amountOperand2);
        Amount expResult = new Amount(amountOperand1 + amountOperand2);
        Amount result = operand1.add(operand2);
        assertEquals(expResult, result, "Wrong addition result.");
    }
    
    @Test
    public void testAddNegResult() {
        double amountOperand1 = 2;
        double amountOperand2 = -10;
        Amount operand1 = new Amount(amountOperand1);
        Amount operand2 = new Amount(amountOperand2);
        Amount expResult = new Amount(amountOperand1 + amountOperand2);
        Amount result = operand1.add(operand2);
        assertEquals(expResult, result, "Wrong addition result.");
    }
    
    @Test
    public void testAddZeroResultNegOperand() {
        double amountOperand1 = -2;
        double amountOperand2 = 2;
        Amount operand1 = new Amount(amountOperand1);
        Amount operand2 = new Amount(amountOperand2);
        Amount expResult = new Amount(amountOperand1 + amountOperand2);
        Amount result = operand1.add(operand2);
        assertEquals(expResult, result, "Wrong addition result.");
    }

    
    @Test
    public void testSubtract() {
        double amountOperand1 = 10;
        double amountOperand2 = 2;
        Amount operand1 = new Amount(amountOperand1);
        Amount operand2 = new Amount(amountOperand2);
        Amount expResult = new Amount(amountOperand1 - amountOperand2);
        Amount result = operand1.subtract(operand2);
        assertEquals(expResult, result, "Wrong subtraction result.");
    }
    
    @Test
    public void testSubtractNegResult() {
        double amountOperand1 = 2;
        double amountOperand2 = 10;
        Amount operand1 = new Amount(amountOperand1);
        Amount operand2 = new Amount(amountOperand2);
        Amount expResult = new Amount(amountOperand1 - amountOperand2);
        Amount result = operand1.subtract(operand2);
        assertEquals(expResult, result, "Wrong subtraction result.");
    }
    
    @Test
    public void testSubtractZeroResultNegOperand() {
        double amountOperand1 = -2;
        double amountOperand2 = -2;
        Amount operand1 = new Amount(amountOperand1);
        Amount operand2 = new Amount(amountOperand2);
        Amount expResult = new Amount(amountOperand1 - amountOperand2);
        Amount result = operand1.subtract(operand2);
        assertEquals(expResult, result, "Wrong subtraction result.");
    }

    @Test
    public void testMultiply() {
        double amountOperand1 = 10;
        int amountOperand2 = 2;
        Amount operand1 = new Amount(amountOperand1);
        Amount expResult = new Amount(amountOperand1 * amountOperand2);
        Amount result = operand1.multiply(amountOperand2);
        assertEquals(expResult, result, "Wrong multiplication result.");
    }
    
    @Test
    public void testMultiplyNegResult() {
        double amountOperand1 = 10;
        int amountOperand2 = -2;
        Amount operand1 = new Amount(amountOperand1);
        Amount expResult = new Amount(amountOperand1 * amountOperand2);
        Amount result = operand1.multiply(amountOperand2);
        assertEquals(expResult, result, "Wrong multiplication result.");
    }
    
    @Test
    public void testMultiplyZeroResultZeroOperand() {
        double amountOperand1 = 10;
        int amountOperand2 = 0;
        Amount operand1 = new Amount(amountOperand1);
        Amount expResult = new Amount(amountOperand1 * amountOperand2);
        Amount result = operand1.multiply(amountOperand2);
        assertEquals(expResult, result, "Wrong multiplication result.");
    }

    @Test
    public void testDivide() {
        double amountOperand1 = 10;
        int amountOperand2 = 2;
        Amount operand1 = new Amount(amountOperand1);
        Amount expResult = new Amount(amountOperand1 / amountOperand2);
        Amount result = operand1.divide(amountOperand2);
        assertEquals(expResult, result, "Wrong division result.");
    }
    
    @Test
    public void testDivideNegResult() {
        double amountOperand1 = 10;
        int amountOperand2 = -2;
        Amount operand1 = new Amount(amountOperand1);
        Amount expResult = new Amount(amountOperand1 / amountOperand2);
        Amount result = operand1.divide(amountOperand2);
        assertEquals(expResult, result, "Wrong division result.");
    }
    
    @Test
    public void testDivideZeroNumerator() {
        double amountOperand1 = 0;
        int amountOperand2 = 2;
        Amount operand1 = new Amount(amountOperand1);
        Amount expResult = new Amount(amountOperand1 / amountOperand2);
        Amount result = operand1.divide(amountOperand2);
        assertEquals(expResult, result, "Wrong division result.");
    }

    @Test
    public void testToStringPosAmount() {
        double number = 10;
        Amount amount = new Amount(number);
        String expResult = Double.toString(number);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString.");
    }
    
     @Test
    public void testToStringNegAmount() {
        double number = -10;
        Amount amount = new Amount(number);
        String expResult = Double.toString(number);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString.");
    }
    
     @Test
    public void testToStringZeroAmount() {
        double number = 0;
        Amount amount = new Amount(number);
        String expResult = Double.toString(number);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString.");
    }
    
}
