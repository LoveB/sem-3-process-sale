package model;


/**
 * Represents a payment made in cash.
 */
public class CashPayment {
    private Amount paidAmount;
    private Amount totalCost;
    private Amount change;

    /**
     * Creates a new instance of Cash Payment
     *
     */
    public CashPayment(Amount paidAmount, Sale sale){
        this.paidAmount = paidAmount;
        this.totalCost = sale.getRunningTotal();
    }

    /**
     * Calculates the change that the customer should get back.
     *
     * @return the value of the change.
     */
    Amount calculateChange(){
        this.change = paidAmount.minus(totalCost);
        Amount zero = new Amount(0);
        if (change.lessThan(zero)){
            this.change = zero;
            return zero;
        }
        return change;
    }
    /**
     * Calculates if payment is too small
     *
     * @return true if payment is less than the total cost.
     */
    boolean paymentTooSmall(){
        return paidAmount.lessThan(totalCost);
    }

    /**
     * Get the value of totalCost
     *
     * @return the value of totalCost
     */
    Amount getTotalCost(){
        return totalCost;
    }

    /**
     * Get the value of change
     *
     * @return the value of change
     */
    Amount getChange() {
        return change;
    }

    /**
     * Get the value of paidAmount
     *
     * @return the value of paidAmount
     */
    Amount getPaidAmount() {
        return paidAmount;
    }
}
