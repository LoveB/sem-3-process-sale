package model;

import integration.ItemDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiptTest {
    @Test
    public void createReceiptString() throws Exception {
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

        Receipt receipt = new Receipt(sale);
        String line = "---------------------- ";

        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("Sale time: ");
        builder.append(sale.getSaleTime().toString());
        builder.append("\n");
        builder.append("\n");
        builder.append("--- ITEMS ---");
        builder.append("\n");
        builder.append("\n");
        builder.append(sale.saleItemsToString());
        builder.append(line);
        builder.append("\n");
        builder.append("Total Cost: ");
        builder.append(sale.getPayment().getTotalCost().toString());
        builder.append("\n");
        builder.append("Total Tax: ");
        builder.append(sale.getTotalTax().toString());
        builder.append("\n");
        builder.append("Change: ");
        builder.append(sale.getPayment().getChange().toString());
        builder.append("\n");
        builder.append("\n");

        String expResult = builder.toString();
        String result = receipt.createReceiptString();
        assertEquals(expResult, result);
    }

}