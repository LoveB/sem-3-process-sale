package model;

import integration.ItemDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashPaymentTest {
    @Test
    public void calculateChange() throws Exception {

        Sale sale = new Sale();
        int paid = 500;
        int priceInt = 200;
        Amount paidAmount = new Amount(paid);
        ItemId itemId = new ItemId(100004);
        Amount price = new Amount(priceInt);
        Percentage percent = new Percentage(25);
        String itemName = "Jacket";
        String itemDesc = "Jacket description";
        ItemDTO itemInstance = new ItemDTO(itemId, price, percent, itemName, itemDesc, "Red", "L");
        CashPayment payment = new CashPayment(paidAmount, sale);

        sale.addItemToSale(itemInstance);
        sale.stopAddingItems();
        Amount change = payment.calculateChange();

        Amount expChange = new Amount(300);
        Amount resultChange = change;
        assertEquals(expChange, resultChange);

        // Too small payment

        Sale saleSmall = new Sale();
        paid = 100;
        Amount paidAmountSmall = new Amount(paid);
        CashPayment paymentSmall = new CashPayment(paidAmountSmall, saleSmall);

        saleSmall.addItemToSale(itemInstance);
        saleSmall.stopAddingItems();
        Amount changeSmall = paymentSmall.calculateChange();

        Amount expChangeSmall = new Amount(0);
        Amount resultChangeSmall = changeSmall;
        assertEquals(expChangeSmall, resultChangeSmall);
    }

}