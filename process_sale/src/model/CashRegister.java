package model;

/**
 * Represents a cash register. There shall be one instance of this class for
 * each register.
 */
public class CashRegister {
    private Amount balance = new Amount();

    /**
     * Adds a payment to the balance of the Cash Register.
     *
     * @param payment is used to get the total cost.
     */
    public void addPayment(CashPayment payment) {
        balance = balance.plus(payment.getTotalCost());
    }

    Amount getBalance() {
        return balance;
    }
}
