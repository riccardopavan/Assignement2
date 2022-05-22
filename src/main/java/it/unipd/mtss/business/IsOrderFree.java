////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

import java.util.List;

public class IsOrderFree {
    public boolean getFreeOrder(List<EItem> itemsOrdered, User user) {
        if (itemsOrdered == null) {
            throw new IllegalArgumentException("Items list can't be null!");
        }
        if (itemsOrdered.isEmpty()) {
            throw new IllegalArgumentException("Items list can't be empty!");
        }
        if (user == null) {
            throw new IllegalArgumentException("User can't be null!");
        }

        EItem last = itemsOrdered.get(itemsOrdered.size() - 1);

        return last.isDuringWinningTime()
                &&
                user.isUnder18() && user.isWinner();
    }
}
