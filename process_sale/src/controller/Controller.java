package controller;

import integration.ExtSystemHandler;
import integration.DbHandler;
import integration.ItemDTO;
import model.CashRegister;
import model.Sale;
import model.SaleInfo;
import model.Amount;
import model.CashPayment;
import model.ItemId;



/**
 * This is the application's only controller class. All calls to the model pass
 * through here.
 */
public class Controller {
    private ExtSystemHandler extSystemHandler;
    private DbHandler dbHandler;
    private CashRegister cashRegister;
    private Sale sale;

    /**
     * Creates a new instance.
     *
     * @param extSystemHandler Used to get all classes that handle external systems.
     * @param dbHandler Used to get all classes that handle the database
     */
    public Controller(ExtSystemHandler extSystemHandler, DbHandler dbHandler){
        this.extSystemHandler = extSystemHandler;
        this.dbHandler = dbHandler;
        this.cashRegister = new CashRegister();
    }

    /**
     * Creates a new instance of Sale
     *
     */
    public void startSale(){
        this.sale = new Sale();
    }

    /**
     * Adds a new item to sale object and updates running total.
     *
     * @param itemId Used to search for item in database and get itemDTO
     * @return saleInfo including item description, item price and running total.
     */
    public SaleInfo addItem(ItemId itemId){
        ItemDTO foundItem = dbHandler.searchItem(itemId);
        SaleInfo saleInfo = sale.addItemToSale(foundItem);
        return saleInfo;
    }

    /**
     * Tells the system that no more items will be added
     *
     * @return Total cost including the calculated tax.
     */
    public Amount stopAddingItems(){
        Amount totalCost = sale.stopAddingItems();
        return totalCost;
    }

    /**
     * Tells the system what amount that been paid by customer.Program creates a CashPayment instance
     * and calculate the change.
     *
     * @param paidAmount Used to create a payment object and to calc change.
     * @return How much change to give back to customer.
     */
    public Amount pay(Amount paidAmount){
        CashPayment payment = new CashPayment(paidAmount, sale);
        Amount change = sale.pay(payment);
        cashRegister.addPayment(payment);
        closeSale();
        return change;
    }

    private void closeSale(){
        dbHandler.closeSale(sale);
        extSystemHandler.closeSale(sale);
    }

    /**
     * Get the value of sale
     *
     * @return the value of sale
     */
    public Sale getSale() {
        return sale;
    }

}
