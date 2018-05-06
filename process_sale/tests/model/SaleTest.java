package model;

import integration.ItemDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleTest {

    @Test
    public void addItemToSale() throws Exception {
        Sale sale = new Sale();
        ItemId itemId = new ItemId(100004);
        Amount price = new Amount(200);
        Percentage percent = new Percentage(25);
        String itemName = "Jacket";
        String itemDesc = "Jacket description";
        ItemDTO itemInstance = new ItemDTO(itemId, price, percent, itemName, itemDesc, "Red", "L");

        SaleInfo saleInfoGenerated = sale.addItemToSale(itemInstance);
        Amount runningTotal = sale.getRunningTotal();
        SaleInfo saleInfoInstance = new SaleInfo(itemName, itemDesc, price, runningTotal);

        Amount expPrice = saleInfoInstance.getItemPrice();
        Amount resultPrice = saleInfoGenerated.getItemPrice();
        assertEquals(expPrice, resultPrice);

        String expName = saleInfoInstance.getItemName();
        String resultName = saleInfoGenerated.getItemName();
        assertEquals(expName, resultName);

        String expDescription = saleInfoInstance.getItemDescription();
        String resultDescription = saleInfoGenerated.getItemDescription();
        assertEquals(expDescription, resultDescription);

        Amount expRunningTotal = saleInfoInstance.getRunningTotal();
        Amount resultRunningTotal = saleInfoGenerated.getRunningTotal();
        assertEquals(expRunningTotal, resultRunningTotal);


    }

    @Test
    public void stopAddingItems() throws Exception {
        Sale sale = new Sale();
        ItemId itemId = new ItemId(100004);
        int priceInt = 200;
        int percInt = 25;

        Amount price = new Amount(priceInt);
        Percentage tax = new Percentage(percInt);
        String itemName = "Jacket";
        String itemDesc = "Jacket description";
        ItemDTO itemInstance = new ItemDTO(itemId, price, tax, itemName, itemDesc, "Red", "L");

        SaleInfo saleInfoGenerated = sale.addItemToSale(itemInstance);
        sale.stopAddingItems();

        Amount expRunningTotal = price;
        Amount resultRunningTotal = saleInfoGenerated.getRunningTotal();
        assertEquals(expRunningTotal, resultRunningTotal);

        Amount expTax = new Amount((priceInt * percInt/100));
        Amount resultTax = sale.getTotalTax();
        assertEquals(expTax, resultTax);

    }

    @Test
    public void pay() throws Exception {
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
        Amount paidAmount = new Amount(paidAmountInt);
        CashPayment payment = new CashPayment(paidAmount, sale);

        sale.addItemToSale(itemInstance);
        sale.stopAddingItems();
        Amount change = sale.pay(payment);

        Amount expChange = new Amount(paidAmountInt - priceInt);
        Amount resultChange = payment.calculateChange();
        assertEquals(expChange, resultChange);

        Amount expChangeReturn = new Amount(paidAmountInt - priceInt);
        Amount resultChangeReturn = change;
        assertEquals(expChangeReturn, resultChangeReturn);

        Boolean expFullyPaid = true;
        Boolean resultFullyPaid = sale.getFullyPaid();
        assertEquals(expFullyPaid, resultFullyPaid);

        // Payment too small

        Sale saleSmallPayment = new Sale();
        int paidAmountIntSmall = 100;
        Amount paidAmountSmall = new Amount(paidAmountIntSmall);
        CashPayment paymentSmall = new CashPayment(paidAmountSmall, saleSmallPayment);

        saleSmallPayment.addItemToSale(itemInstance);
        saleSmallPayment.stopAddingItems();
        Amount changeSmall = saleSmallPayment.pay(paymentSmall);

        Amount expChangeSmall = new Amount(0);
        Amount resultChangeSmall = paymentSmall.getChange();
        assertEquals(expChangeSmall, resultChangeSmall);

        Amount expChangeSmallReturn = new Amount(0);
        Amount resultChangeSmallReturn = changeSmall;
        assertEquals(expChangeSmallReturn, resultChangeSmallReturn);

    }

}