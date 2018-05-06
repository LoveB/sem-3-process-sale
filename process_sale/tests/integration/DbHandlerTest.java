package integration;

import controller.Controller;
import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DbHandlerTest {


    @Test
    public void searchItem() throws Exception {
        DbHandler dbHandler = new DbHandler();
        int id = 100002;
        String itemName = "Jeans";
        String itemDesc = "Description for jeans";
        String colour = "blue";
        String size = "L";
        Amount price = new Amount(700);
        int taxInt = 25;
        ItemId jeansId = new ItemId(id);

        ItemDTO resultItem = dbHandler.searchItem(jeansId);

        int expId = id;
        int resultId = resultItem.getItemId().getItemId();
        assertEquals(expId, resultId);


        String expName = itemName;
        String resultName = resultItem.getItemName();
        assertEquals(expName, resultName);


        String expDesc = itemDesc;
        String resultDesc = resultItem.getItemDescription();
        assertEquals(expDesc, resultDesc);


        String expColour = colour;
        String resultColour = resultItem.getColour();
        assertEquals(expColour, resultColour);


        String expSize = size;
        String resultSize = resultItem.getSize();
        assertEquals(expSize, resultSize);


        Amount expPrice = price;
        Amount resultPrice = resultItem.getItemPrice();
        assertEquals(expPrice, resultPrice);


        int expTax = taxInt;
        int resultTax = resultItem.getItemTax().getPercentage();
        assertEquals(expTax, resultTax);



    }

    @Test
    public void closeSale() throws Exception {
        DbHandler dbHandler = new DbHandler();
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
        dbHandler.closeSale(sale);


        Boolean expResult = true;
        Boolean result = sale.getFullyPaid();
        assertEquals(expResult, result);

    }

}