package integration;

import model.Amount;
import model.ItemId;
import model.Percentage;

/**
 * Contains information about one particular item.
 */
public final class ItemDTO {
    private final ItemId itemId;
    private final String itemName;
    private final String itemDescription;
    private final String colour;
    private final String size;
    private final Amount itemPrice;
    private final Percentage itemTax;

    /**
     * Creates a new instance representing a particular item.
     *
     * @param itemId  The items id number.
     * @param itemPrice  The price paid to rent the item.
     * @param itemTax   The tax rate of the item in percentage.
     * @param itemName     The name of the item.
     * @param itemDescription The item description.
     * @param colour  The color of the item.
     * @param size  The size of the item.
     */
    public ItemDTO(ItemId itemId, Amount itemPrice, Percentage itemTax, String itemName, String itemDescription, String colour, String size) {
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemTax = itemTax;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.colour = colour;
        this.size = size;

    }

    /**
     * Converts the ItemDTO to a String.
     *
     * @return the String representation of ItemDTO
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("itemId: " + itemId + ", ");
        builder.append("Price: " + itemPrice + ", ");
        builder.append("Tax: " + itemTax + ", ");
        builder.append("Name: " + itemName + ", ");
        builder.append("Description: " + itemDescription + ", ");
        builder.append("colour: " + colour + ", ");
        builder.append("size: " + size);
        return builder.toString();
    }

    /**
     * Get the value of itemId
     *
     * @return the value of itemId
     */
    public ItemId getItemId() {
        return itemId;
    }

    /**
     * Get the value of itemPrice
     *
     * @return the value of itemPrice
     */
    public Amount getItemPrice() {
        return itemPrice;
    }

    /**
     * Get the value of itemTax
     *
     * @return the value of itemTax
     */
    public Percentage getItemTax(){
        return itemTax;
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
     * Get the value of colour
     *
     * @return the value of colour
     */
    String getColour() {
        return colour;
    }

    /**
     * Get the value of size
     *
     * @return the value of size
     */
    String getSize() {
        return size;
    }
}
