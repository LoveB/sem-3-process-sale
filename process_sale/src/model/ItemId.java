package model;

/**
 * Represents the id number that is unique fore each item.
 *
 */
public final class ItemId {
    private final int itemId;

    /**
     * Creates an instance.
     *
     */
    public ItemId(int number){
        this.itemId = number;
    }

    /**
     * Converts the id number to String.
     *
     * @return the String representation of the id number.
     */
    @Override
    public String toString() {
        return Integer.toString(itemId);
    }

    /**
     * Get the value of itemId
     *
     * @return the value of itemId
     */
    public int getItemId() {
        return itemId;
    }
}
