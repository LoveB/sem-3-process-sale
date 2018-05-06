package integration;

import java.util.ArrayList;
import java.util.List;
import model.Sale;

/**
 * Contains all calls to the data store with performed sales.
 */
class SaleRegistry {
    private List<Sale> sales = new ArrayList<>();

    SaleRegistry() {
    }

    /**
     * Saves the specified sale permanently.
     *
     * @param sale The sale that will be saved.
     */
    void addSaleToRegistry(Sale sale) {
        sales.add(sale);
    }

    List<Sale> getSales() {
        return sales;
    }
}

