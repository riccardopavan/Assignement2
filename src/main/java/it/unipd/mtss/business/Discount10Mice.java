////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;

import java.util.List;
import java.util.stream.Collectors;

class Discount10Mice {
    double getDiscount(List<EItem> items) {
        if (items == null) {
            throw new IllegalArgumentException("La lista non può essere nulla");
        }
        if (items.isEmpty()) {
            throw new IllegalArgumentException("La lista non può essere vouta");
        }

        List<EItem> mice = items.stream()
                .filter(item -> item.getItemType()
                        .toString()
                        .equals("Mouse")
                )
                .collect(Collectors.toList());
        if (mice.size() <= 10) {
            return 0;
        }
        return mice.stream().mapToDouble(EItem::getPrice).min().getAsDouble();
    }
}
