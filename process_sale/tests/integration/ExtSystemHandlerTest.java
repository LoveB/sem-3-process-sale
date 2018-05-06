package integration;

import model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExtSystemHandlerTest {
    @Test
    public void closeSale() throws Exception {
        ExtSystemHandler extSystemHandler = new ExtSystemHandler();
        Sale sale = new Sale();
        ItemId itemId = new ItemId(100004);
        int priceInt = 200;
        int percInt = 25;
        int paidAmountInt = 1500;

        Amount price = new Amount(priceInt);
        Percentage tax = new Percentage(percInt);
        String itemName = "Jacket";
        String itemDesc = "Jacket description";
        ItemDTO itemInstance = new ItemDTO(itemId, price, tax, itemName, itemDesc, "Red", "L");

        sale.addItemToSale(itemInstance);
        sale.stopAddingItems();

        Amount paidAmount = new Amount(paidAmountInt);
        CashPayment payment = new CashPayment(paidAmount, sale);

        sale.pay(payment);
        extSystemHandler.closeSale(sale);


        Boolean expResult = true;
        Boolean result = sale.getFullyPaid();
        assertEquals(expResult, result);
    }

}