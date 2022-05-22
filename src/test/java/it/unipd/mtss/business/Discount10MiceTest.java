////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Discount10MiceTest {
    private final Discount10Mice discount = new Discount10Mice();
    private List<EItem> items = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        for (int i = 1; i <= 10; ++i) {
            this.items.add(new EItem(EItem.ItemType.Mouse, "Mouse " + i, i * 10));
        }
    }

    @Test
    public void testGetDiscount() {
        assertEquals(540, this.discount.getDiscount(this.items));
    }

    @Test
    public void testGetDiscountOnNotEnoughItems() {
        this.items.remove(0);
        assertEquals(0, this.discount.getDiscount(this.items));
    }

    @Test
    public void testListIsNull() {
        assertThrows(IllegalArgumentException.class, () -> this.discount.getDiscount(null));
    }

    @Test
    public void testListIsEmpty() {
        this.items = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () -> this.discount.getDiscount(this.items));
    }
}
