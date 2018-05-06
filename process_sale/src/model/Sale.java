package model;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import integration.ItemDTO;


/**
 * Represents one particular sale transaction, where one or more particular items are
 * sold to one particular customer.
 */
public class Sale {
    private List<SaleItem> saleItems = new ArrayList<>();
    private Amount runningTotal = new Amount(0);
    private LocalDateTime saleTime;
    private CashPayment payment;
    private Amount totalTax;
    private Boolean fullyPaid = false;


    /**
     * Creates a new instance.
     *
     */
    public Sale() {
        this.saleTime = LocalDateTime.now();
    }

    /**
     * adds an item to the specific sale
     *
     * @param itemToAdd specifies what item that is added and is used to add correct details to the
     *                list of items and to update runningTotal.
     * @return a SaleInfo object that contains item name, item description, price and running total.
     */
    public SaleInfo addItemToSale(ItemDTO itemToAdd){
        updateRunningTotal(itemToAdd);
        createNewSaleItem(itemToAdd);
        SaleInfo saleInfo = createSaleInfo(itemToAdd);
        return saleInfo;
    }

    private void createNewSaleItem(ItemDTO foundItem){
        saleItems.add(new SaleItem( foundItem.getItemId(), foundItem.getItemPrice(), foundItem.getItemTax(), foundItem.getItemName()));
    }

    private SaleInfo createSaleInfo(ItemDTO foundItem){
        return new SaleInfo(foundItem.getItemName(), foundItem.getItemDescription(), foundItem.getItemPrice(), runningTotal);
    }

    private void updateRunningTotal(ItemDTO addedItem){
        runningTotal = runningTotal.plus(addedItem.getItemPrice());
    }

    /**
     * adds a payment to the specific sale
     *
     * @param payment specifies what payment that is added to the sale. Payment is also used to calculate change.
     * @return amount of change to give back.
     */
    public Amount pay(CashPayment payment){
        this.payment = payment;
        Amount change = payment.calculateChange();
        if(payment.paymentTooSmall()){
            System.out.println("Payment is too small");
            return new Amount(0);
        }
        fullyPaid = true;
        return change;
    }

    /**
     * Tells the system that no more items will be added.
     *
     * @return the amount of the running total.
     */
    public Amount stopAddingItems(){
        this.calculateTotalTax();
        return runningTotal;
    }

    private void calculateTotalTax(){
        Amount tax = new Amount();
        for (SaleItem item : saleItems){
            tax = taxBalancePlusThisTax(item, tax);
        }
        this.totalTax = tax;
    }

    private Amount taxBalancePlusThisTax(SaleItem item, Amount tax){
        return tax.plus(item.itemPrice.multPercentage(item.itemTax));
    }

    /**
     * Creates Receipt from the specific sale.
     *
     * @return the receipt.
     */
    public Receipt createReceipt(){
        return new Receipt(this);
    }

    private static class SaleItem {
        private ItemId itemId;
        private Amount itemPrice;
        private Percentage itemTax;
        private String itemName;

        SaleItem(ItemId itemId, Amount itemPrice, Percentage itemTax, String itemName) {
            this.itemId = itemId;
            this.itemPrice = itemPrice;
            this.itemTax = itemTax;
            this.itemName = itemName;
        }
    }

    /**
     * Creates a string representation of the SaleItem.
     *
     * @return the String.
     */
    String saleItemsToString(){
        StringBuilder builder = new StringBuilder();
        for (SaleItem item : saleItems){
            builder.append("Item: ");
            appendLine(builder, item.itemName);
            builder.append("Id: ");
            appendLine(builder, item.itemId.toString());
            builder.append("Price: ");
            appendLine(builder, item.itemPrice.toString());
            builder.append("Tax: ");
            appendLine(builder, item.itemTax.toString());
            endSection(builder);
        }
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }

    /**
     * Get the value of runningTotal
     *
     * @return the value of runningTotal
     */
    Amount getRunningTotal(){
    return runningTotal;
    }

    /**
     * Get the value of saleTime
     *
     * @return the value of saleTime
     */
    LocalDateTime getSaleTime(){
        return saleTime;
    }

    /**
     * Get the value of payment
     *
     * @return the value of payment
     */
    CashPayment getPayment() {
        return payment;
    }

    /**
     * Get the value of totalTax
     *
     * @return the value of totalTax
     */
    public Amount getTotalTax() {
        return totalTax;
    }

    public Boolean getFullyPaid() {
        return fullyPaid;
    }
}


