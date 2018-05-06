package integration;

import model.Receipt;

/**
 * Represents the external printer.
 */
class Printer {
    private boolean receiptPrinted = false;

    Printer(){}

    /**
     * Prints the specified receipt. This dummy implementation prints to
     * <code>System.out</code> instead of a printer.
     *
     * @param receipt is used to create the receipt string.
     */
    void printReceipt(Receipt receipt) {

        System.out.println(receipt.createReceiptString());
        receiptPrinted = true;
    }
}
