////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

import java.util.List;

public class BillCalculator {
    public double getOrderPrice(List<EItem> itemsOrdered, User user) {
        if (itemsOrdered == null) {
            throw new IllegalArgumentException("Items list can't be null!");
        }
        if (itemsOrdered.isEmpty()) {
            throw new IllegalArgumentException("Items list can't be empty!");
        }
        if (user == null) {
            throw new IllegalArgumentException("User can't be null!");
        }

        double partialTotal = itemsOrdered.stream()
                .mapToDouble(EItem::getPrice)
                .sum();

        Discount5Processors discount5Processors = new Discount5Processors();
        partialTotal -= discount5Processors.getDiscount(itemsOrdered);

        return partialTotal;
    }
}