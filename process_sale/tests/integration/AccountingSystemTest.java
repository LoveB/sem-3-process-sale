package integration;

import org.junit.Test;
import model.Sale;

import java.util.List;

import static org.junit.Assert.*;

public class AccountingSystemTest {
    @Test
    public void updateWithNewSale() throws Exception {
        AccountingSystem accountingSystem = new AccountingSystem();
        Boolean result = false;
        Sale sale = new Sale();

        accountingSystem.updateWithNewSale(sale);
        List<Sale> sales =  accountingSystem.getSales();

        if(sales != null){
            result = true;
        }

        Boolean expResult = true;
        assertEquals(expResult, result);
    }

}