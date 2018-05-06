package view;

import controller.Controller;
import model.Amount;
import model.SaleInfo;
import model.ItemId;
import model.Sale;


/**
 * Represents the view
 */
public class View {
    private Controller controller;

    /**
     * Creates a new instance.
     *
     * @param controller The controller that is used for all operations.
     */
    public View(Controller controller) {

        this.controller = controller;
    }

    /**
     * Simulates a user input that generates calls to all system operations.
     */
    public void sampleExecution() {
        controller.startSale();

        ItemId itemOne = new ItemId(100004);
        ItemId itemTwo = new ItemId(100005);

        String dottedLine = "- - - - - - - - - - - - - - - - - - - - ";

        System.out.println(dottedLine);
        SaleInfo saleInfoSweater =  controller.addItem(itemOne);
        printSaleInfo(saleInfoSweater);

        System.out.println();

        System.out.println(dottedLine);
        SaleInfo saleInfoJeans =  controller.addItem(itemTwo);
        printSaleInfo(saleInfoJeans);

        System.out.println();

        System.out.println(dottedLine);
        Amount totalCost = controller.stopAddingItems();
        System.out.println("Total Cost with tax included: " + totalCost);

        Sale sale = controller.getSale();
        Amount totalTax = sale.getTotalTax();
        System.out.println("Total Tax: " + totalTax);

        System.out.println();

        System.out.println(dottedLine);
        Amount paidAmount = new Amount(1500);
        System.out.println("Paid Amount: " + paidAmount);

        System.out.println();
        System.out.println();

        System.out.println("--------------- Receipt follows --------------");

        Amount change =  controller.pay(paidAmount);

        System.out.println("--------------- End of receipt ----------------");

        System.out.println();

        System.out.println("Change: " + change);

        System.out.println();
        System.out.println(dottedLine);
    }


    private void printSaleInfo(SaleInfo saleInfo){
        System.out.println("Item Name: " + saleInfo.getItemName());
        System.out.println("Item Description: " + saleInfo.getItemDescription());
        System.out.println("Item Price: " + saleInfo.getItemPrice());
        System.out.println("Running Total: " + saleInfo.getRunningTotal());
    }

}
