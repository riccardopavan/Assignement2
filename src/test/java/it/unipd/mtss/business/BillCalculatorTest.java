////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BillCalculatorTest {
    List<EItem> items;
    User user;
    BillCalculator calculator;

    @BeforeEach
    public void setup() {
        this.items = new ArrayList<>();
        this.items.add(new EItem(EItem.ItemType.Processor, "Ryzen 7", 300d));
        this.items.add(new EItem(EItem.ItemType.Motherboard, "ASUS", 100d));
        this.items.add(new EItem(EItem.ItemType.Mouse, "Logitech MX Master 2S", 60d));
        this.items.add(new EItem(EItem.ItemType.Keyboard, "Logitech MX Keys", 80d));
        this.items.add(new EItem(EItem.ItemType.Keyboard, "Logitech MX Keys2", 90d));

        this.user = new User("Rinaldo", 50);

        this.calculator = new BillCalculator();
    }

    @Test
    public void testSimpleGetOrderPrice() {
        assertEquals(630d, this.calculator.getOrderPrice(items, user));
    }

    @Test
    public void testEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> this.calculator.getOrderPrice(new ArrayList<>(), user));
    }

    @Test
    public void testListIsNull() {
        assertThrows(IllegalArgumentException.class, () -> this.calculator.getOrderPrice(null, user));
    }

    @Test
    public void testUserIsNull() {
        assertThrows(IllegalArgumentException.class, () -> this.calculator.getOrderPrice(items, null));
    }

    @Test
    public void test5ProcessorsDiscount() {
        this.items.add(new EItem(EItem.ItemType.Processor, "Processore1", 310d));
        this.items.add(new EItem(EItem.ItemType.Processor, "Processore2", 320d));
        this.items.add(new EItem(EItem.ItemType.Processor, "Processore3", 330d));
        this.items.add(new EItem(EItem.ItemType.Processor, "Processore4", 340d));
        this.items.add(new EItem(EItem.ItemType.Processor, "Processore5", 350d));

        assertEquals(630d + 1650d - 150d, this.calculator.getOrderPrice(items, user));
    }

    @Test
    public void test10MiceDiscount() {
        for (int i = 1; i <= 11; ++i) {
            this.items.add(new EItem(EItem.ItemType.Mouse, "Mouse " + i, i * 10));
        }

        assertEquals(630d + 650d, this.calculator.getOrderPrice(items, user));
    }

    @Test
    public void testMiceKeyboardsGift() {
        this.items.add(new EItem(EItem.ItemType.Mouse, "Mouse1", 70d));
        assertEquals(640d, this.calculator.getOrderPrice(items, user));
    }
}