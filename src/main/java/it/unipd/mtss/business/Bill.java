////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;
import java.util.List;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

public interface Bill {
    double getOrderPrice(List<EItem> itemsOrdered, User user);
}
