////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;

import java.util.List;
import java.util.stream.Collectors;

public class Discount5Processors {

    public double getDiscount(List<EItem> itemsOrdered) {
        if (itemsOrdered == null) {
            throw new IllegalArgumentException("La lista non può essere nulla");
        }

        if (itemsOrdered.isEmpty()) {
            throw new IllegalArgumentException("La lista non può essere vuota");
        }

        List<EItem> processors = itemsOrdered.stream()
                .filter(item -> item.getItemType()
                        .toString()
                        .equals("Processor")
                )
                .collect(Collectors.toList());

        if (processors.size() <= 5) {
            return 0;
        }

        return processors.stream()
                .mapToDouble(EItem::getPrice)
                .min()
                .getAsDouble()*0.5;
    }
}
