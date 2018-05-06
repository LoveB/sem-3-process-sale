package controller;

import integration.DbHandler;
import integration.ExtSystemHandler;
import model.Amount;
import model.ItemId;
import model.SaleInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {
    @Test
    public void addItem() throws Exception {
        ExtSystemHandler extSystemHandler = new ExtSystemHandler();
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(extSystemHandler, dbHandler);

        ItemId itemId = new ItemId(100004);
        int priceInt = 200;
        Amount price = new Amount(priceInt);
        String itemName = "Skirt";
        String itemDesc = "Description for skirt";

        controller.startSale();
        SaleInfo info = controller.addItem(itemId);

        Amount expResultPrice = price;
        Amount resultPrice = info.getItemPrice();
        assertEquals(expResultPrice, resultPrice);

        String expResultName = itemName;
        String resultName = info.getItemName();
        assertEquals(expResultName, resultName);

        String expResultDesc = itemDesc;
        String resultDesc = info.getItemDescription();
        assertEquals(expResultDesc, resultDesc);

        Amount expResultRunnningTotal = price;
        Amount resultRunningTotal = info.getRunningTotal();
        assertEquals(expResultRunnningTotal, resultRunningTotal);

    }

    @Test
    public void stopAddingItems() throws Exception {
        ExtSystemHandler extSystemHandler = new ExtSystemHandler();
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(extSystemHandler, dbHandler);

        ItemId itemId = new ItemId(100004);
        int priceInt = 200;
        Amount price = new Amount(priceInt);

        controller.startSale();
        controller.addItem(itemId);

        Amount expResult = price;
        Amount result = controller.stopAddingItems();
        assertEquals(expResult, result);
    }

    @Test
    public void pay() throws Exception {
        ExtSystemHandler extSystemHandler = new ExtSystemHandler();
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(extSystemHandler, dbHandler);

        ItemId itemId = new ItemId(100004);
        int priceInt = 200;
        int paidAmountInt = 1500;
        Amount price = new Amount(priceInt);
        Amount paidAmount = new Amount(paidAmountInt);


        controller.startSale();
        controller.addItem(itemId);
        controller.stopAddingItems();
        Amount change = controller.pay(paidAmount);

        Amount expResult = new Amount(paidAmountInt - priceInt);
        Amount result = change;
        assertEquals(expResult, result);

    }

}