package integration;


import java.util.ArrayList;
import java.util.List;
import model.Sale;

/**
 * Class representing the external Accounting System.
 */
class AccountingSystem {
    private List<Sale> sales = new ArrayList<>();

    /**
     * Creates a new instance.
     *
     */
    AccountingSystem(){ }

    /**
     * Update the system with new sale
     *
     * @param sale updates sale.
     */
    void updateWithNewSale(Sale sale) {
        sales.add(sale);
    }

    List<Sale> getSales() {
        return sales;
    }
}
