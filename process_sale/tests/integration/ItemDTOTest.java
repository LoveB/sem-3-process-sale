package integration;

import org.junit.Test;

import static org.junit.Assert.*;
import model.Amount;
import model.Percentage;
import model.ItemId;

public class ItemDTOTest {
    @Test
    public void toStringTest() throws Exception {
        int id = 100004;
        int price = 500;
        int tax = 25;
        String itemName = "name";
        String itemDescription = "desc";
        String itemColour = "red";
        String itemSize = "M";

        ItemId itemId = new ItemId(id);
        Amount itemPrice = new Amount(price);
        Percentage itemTax = new Percentage(tax);

        ItemDTO item = new ItemDTO(itemId, itemPrice, itemTax, itemName, itemDescription, itemColour, itemSize);

        String expString = "itemId: " + id + ", Price: " + price + ", Tax: " + tax + "%, Name: " + itemName + ", Description: " + itemDescription + ", colour: " + itemColour + ", size: " + itemSize;
        String resultString = item.toString();
        assertEquals(expString, resultString);

    }

}