package integration;

import model.Sale;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the external Inventory System.
 */
class InventorySystem {
    private List<Sale> sales = new ArrayList<>();

    /**
     * Creates a new instance.
     *
     */
    InventorySystem(){
    }

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
