package integration;

import model.Sale;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SaleRegistryTest {
    @Test
    public void addSaleToRegistry() throws Exception {
        SaleRegistry saleRegistry = new SaleRegistry();
        Boolean result = false;
        Sale sale = new Sale();

        saleRegistry.addSaleToRegistry(sale);
        List<Sale> sales =  saleRegistry.getSales();

        if(sales != null){
            result = true;
        }

        Boolean expResult = true;
        assertEquals(expResult, result);
    }

}