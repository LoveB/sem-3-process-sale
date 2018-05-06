package model;

/**
 * Represents an amount of money
 */
public final class Amount {
    private final int amount;

    /**
     * Creates a new instance, representing the amount 0.
     */
    Amount() {
        this(0);
    }

    /**
     * Creates a new instance, representing the specified amount.
     *
     * @param amount The amount represented by the newly created instance.
     */
    public Amount(int amount) {
        this.amount = amount;
    }

    /**
     * Subtracts the specified <code>Amount</code> from this object and returns
     * an <code>Amount</code> instance with the result. The operation will
     * overflow if the result is smaller than <code>Integer.MIN_VALUE</code>.
     *
     * @param other The <code>Amount</code> to subtract.
     * @return The result of the subtraction.
     */
    Amount minus(Amount other) {
        return new Amount(amount - other.amount);
    }

    /**
     * Adds the specified <code>Amount</code> to this object and returns an
     * <code>Amount</code> instance with the result. The operation will
     * overflow if the result is larger than <code>Integer.MAX_VALUE</code>.
     *
     * @param other The <code>Amount</code> to add.
     * @return The result of the addition.
     */
    Amount plus(Amount other) {
        return new Amount(amount + other.amount);
    }

    /**
     * Multiplies the specified <code>Amount</code> with a given percentage.
     *
     * @param other The <code>Percentage</code> to add.
     * @return The result of the multiplication.
     */
    Amount multPercentage(Percentage other) {
        return new Amount(calcPercentageOfAmount(other));
    }

    Boolean lessThan(Amount other) {

        if (amount < other.amount) {
            return true;
        }
        return false;
    }

    private int calcPercentageOfAmount(Percentage other){
        return amount * other.getPercentage()/100;
    }

    /**
     * Two <code>Amount</code>s are equal if they represent the same amount.
     *
     * @param other The <code>Amount</code> to compare with this amount.
     * @return <code>true</code> if the specified amount is equal to this
     *         amount, <code>false</code> if it is not.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Amount)) {
            return false;
        }
        Amount otherAmount = (Amount) other;
        return amount == otherAmount.amount;
    }

    /**
     * Converts the value of Amount to String.
     *
     * @return the String representation of the Amount.
     */
    @Override
    public String toString() {
        return Integer.toString(amount);
    }
}

