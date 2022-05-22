////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class EItemTest {
    EItem item;
    EItem.ItemType itemType;
    String name;
    double price;

    @BeforeEach
    public void setUp() {
        itemType = EItem.ItemType.Processor;
        name = "AMD Ryzen 5 5600x";
        price = 219.99;

        item = new EItem(itemType, name,  price);
    }

    @Test
    public void testGetItemType() {
        assertEquals(itemType, item.getItemType());
    }

    @Test
    public void testGetName() {
        assertEquals(name, item.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, item.getPrice(), 0.01);
    }

    @Test
    public void testGetTime() {
        LocalTime time = LocalTime.of(16, 0, 0);
        item.setTime(time);

        assertEquals(time, item.getTime());
    }

    @Test
    public void testTypeNull() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> new EItem(null, name, price));
    }

    @Test
    public void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new EItem(itemType, null, price));
    }

    @Test
    public void testPriceNegative() {
        assertThrows(IllegalArgumentException.class, () -> new EItem(itemType, name, -1));

    }

    @Test
    public void testNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new EItem(itemType, "", price));
    }

    @Test
    public void testSetTimeNull() {
        assertThrows(IllegalArgumentException.class, () -> item.setTime(null));
    }

    @Test
    public void testIsDuringWinningTime() {
        item.setTime(LocalTime.of(18, 30, 0));
        assertTrue(item.isDuringWinningTime());
    }

    @Test
    public void testIsNotDuringWinningTime() {
        item.setTime(LocalTime.of(17, 30, 0));
        assertFalse(item.isDuringWinningTime());
    }
}