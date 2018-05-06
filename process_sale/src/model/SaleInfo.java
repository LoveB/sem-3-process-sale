package model;

/**
 * Represents the info that shall be presented to cashier in view after each item has been entered
 */

public class SaleInfo {
    private String itemName;
    private String itemDescription;
    private Amount itemPrice;
    private Amount runningTotal;

    /**
     * Creates an instance.
     *
     * @param itemName        describes the item name.
     * @param itemDescription describes the item description.
     * @param itemPrice       describes the item price.
     * @param runningTotal    describes the value of running total.
     */
    SaleInfo(String itemName, String itemDescription, Amount itemPrice, Amount runningTotal) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.runningTotal = runningTotal;
    }

    /**
     * Get the value of itemName
     *
     * @return the value of itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Get the value of itemDescription
     *
     * @return the value of itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Get the value of runningTotal
     *
     * @return the value of runningTotal
     */
    public Amount getRunningTotal() { return runningTotal; }

    /**
     * Get the value of itemPrice
     *
     * @return the value of itemPrice
     */
    public Amount getItemPrice() {
        return itemPrice;
    }
}
