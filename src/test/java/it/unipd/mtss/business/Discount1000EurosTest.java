////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Discount1000EurosTest {
    private final Discount1000Euros discount = new Discount1000Euros();

    @Test
    public void testGetDiscount() {
        assertEquals(110, this.discount.getDiscount(1100));
    }

    @Test
    public void testLessThanOr1000Euoros() {
        assertEquals(0, this.discount.getDiscount(1000));
    }

    @Test
    public void testNegativeTotal() {
        assertThrows(IllegalArgumentException.class, () -> this.discount.getDiscount(-2));
    }
}
