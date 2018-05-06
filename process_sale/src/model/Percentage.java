package model;

/**
 * Represents a value in percentage.
 */
public class Percentage {
    private final int percentage;

    /**
     * Creates a new instance, representing the specified percentage.
     *
     * @param percentage The percentage represented by the newly created instance.
     */
    public Percentage(int percentage){
        this.percentage = percentage;
    }

    /**
     * Converts the id number to String.
     *
     * @return the String representation of the id number.
     */
    @Override
    public String toString() {
        String percString = Integer.toString(percentage);
        percString = percString + "%";
        return percString;
    }

    /**
     * Get the value of percentage.
     *
     * @return the value of percentage.
     */
    public int getPercentage(){
        return percentage;
    }

}
