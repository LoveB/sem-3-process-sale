package integration;

import model.Sale;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InventorySystemTest {
    @Test
    public void updateWithNewSale() throws Exception {
        InventorySystem inventorySystem = new InventorySystem();
        Boolean result = false;
        Sale sale = new Sale();

        inventorySystem.updateWithNewSale(sale);
        List<Sale> sales =  inventorySystem.getSales();

        if(sales != null){
            result = true;
        }

        Boolean expResult = true;
        assertEquals(expResult, result);
    }

}