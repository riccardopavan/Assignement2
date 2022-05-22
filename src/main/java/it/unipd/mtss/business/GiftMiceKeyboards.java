////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GiftMiceKeyboards {
    public double getGift(List<EItem> itemsOrdered) {

        if (itemsOrdered == null) {
            throw new IllegalArgumentException("Items list can't be null!");
        }
        if (itemsOrdered.size() == 0) {
            throw new IllegalArgumentException("Items list can't be empty!");
        }

        List<EItem> mice = itemsOrdered.stream()
                .filter(item -> item.getItemType()
                        .toString()
                        .equals("Mouse")
                )
                .collect(Collectors.toList());
        List<EItem> keyboards = itemsOrdered.stream()
                .filter(item -> item.getItemType()
                        .toString()
                        .equals("Keyboard")
                )
                .collect(Collectors.toList());
        if (mice.size() != keyboards.size()) {
            return 0d;
        }

        List<EItem> miceAndKeyboards = Stream
                .concat(mice.stream(), keyboards.stream())
                .collect(Collectors.toList());

        return miceAndKeyboards.stream()
                .mapToDouble(EItem::getPrice)
                .min()
                .getAsDouble();
    }
}
