package model;


/**
 * The receipt of a rental
 */
public class Receipt {
    private final Sale sale;

    /**
     * Creates a new instance.
     *
     * @param sale The rental proved by this receipt.
     */
    public Receipt(Sale sale) {
        this.sale = sale;
    }

    /**
     * Creates a well-formatted string with the entire content of the receipt.
     *
     * @return The well-formatted receipt string.
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        String line = "---------------------- ";
        endSection(builder);

        builder.append("Sale time: ");
        appendLine(builder, sale.getSaleTime().toString());
        endSection(builder);

        builder.append("--- ITEMS ---");
        endSection(builder);
        builder.append("\n");
        builder.append(sale.saleItemsToString());
        appendLine(builder, line);

        builder.append("Total Cost: ");
        appendLine(builder, sale.getPayment().getTotalCost().toString());
        builder.append("Total Tax: ");
        appendLine(builder, sale.getTotalTax().toString());
        builder.append("Change: ");
        appendLine(builder, sale.getPayment().getChange().toString());
        endSection(builder);

        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}

