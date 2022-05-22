////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import it.unipd.mtss.model.EItem.ItemType;

import java.util.ArrayList;
import java.util.List;

public class Discount5ProcessorsTest {
    Discount5Processors discount;
    public List<EItem> itemsList;

    @BeforeEach
    public void setup() {
        discount = new Discount5Processors();
        itemsList = new ArrayList<>();

        this.itemsList.add(new EItem(ItemType.Processor, "Processore1", 200.00));
        this.itemsList.add(new EItem(ItemType.Processor, "Processore2", 220.00));
        this.itemsList.add(new EItem(ItemType.Processor, "Processore3", 210.00));
        this.itemsList.add(new EItem(ItemType.Processor, "Processore4", 230.00));
        this.itemsList.add(new EItem(ItemType.Processor, "Processore5", 240.00));
    }

    @Test
    public void testGetDiscount() throws BillException {
        assertEquals(100, discount.getDiscount(itemsList));
    }

    @Test
    public void testListNull() {
        assertThrows(IllegalArgumentException.class, () -> this.discount.getDiscount(null));
    }

    @Test
    public void testNotEnoughItems() {
        this.itemsList.remove(0);
        assertThrows(IllegalArgumentException.class, () -> this.discount.getDiscount(itemsList));
    }

    @Test
    public void testNotEnoughProcessors() {
        this.itemsList.remove(0);
        this.itemsList.add(new EItem(ItemType.Keyboard, "Keyboard1", 50));
        assertThrows(BillException.class, () -> this.discount.getDiscount(itemsList));
    }
}