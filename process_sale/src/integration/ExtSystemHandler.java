package integration;

import model.Sale;

/**
 * This class is handling all external systems
 */
public class ExtSystemHandler {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private Printer printer;

    /**
     * Creates a new instance. Also creates the Accounting system and the Inventory System.
     *
     */
    public ExtSystemHandler(){
        this.accountingSystem = new AccountingSystem();
        this.inventorySystem = new InventorySystem();
        this.printer = new Printer();
    }

    /**
     * Tells all the external systems that sale is now closed.
     *
     * @param sale Used to transfer to external systems
     */
    public void closeSale(Sale sale){
      if (sale.getFullyPaid()) {
            accountingSystem.updateWithNewSale(sale);
            inventorySystem.updateWithNewSale(sale);
            printer.printReceipt(sale.createReceipt());
      }
    }
}
