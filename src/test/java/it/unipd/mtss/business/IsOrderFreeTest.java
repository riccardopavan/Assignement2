////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IsOrderFreeTest {
        List<EItem> items;
        User user;
        IsOrderFree isOrderFree = new IsOrderFree();

        @BeforeEach
        public void setup() {
            this.items = new ArrayList<>();
            this.items.add(new EItem(EItem.ItemType.Processor, "Ryzen 7", 300d));
            this.items.add(new EItem(EItem.ItemType.Motherboard, "ASUS", 100d));
            this.items.add(new EItem(EItem.ItemType.Mouse, "Logitech MX Master 2S", 60d));
            this.items.add(new EItem(EItem.ItemType.Keyboard, "Logitech MX Keys", 80d));
            this.items.add(new EItem(EItem.ItemType.Keyboard, "Logitech MX Keys2", 90d));

            this.user = new User("Cosimo", 15);
        }

        @Test
        public void testNullList() {
            assertThrows(IllegalArgumentException.class, () -> isOrderFree.getFreeOrder(null, user));
        }

        @Test
        public void testEmptyList() {
            items = Collections.emptyList();
            assertThrows(IllegalArgumentException.class, () -> isOrderFree.getFreeOrder(items, user));
        }

        @Test
        public void testNullUser() {
            assertThrows(IllegalArgumentException.class, () -> isOrderFree.getFreeOrder(items, null));
        }

        @Test
        public void testIsOrderFree() {
            items.get(items.size()-1).setTime(LocalTime.of(18, 45, 0));
            assertTrue(isOrderFree.getFreeOrder(items, user));
        }

        @Test
        public void testIsOrderFreeOver18() {
            user = new User("Cosimo", 19);
            items.get(items.size()-1).setTime(LocalTime.of(18, 45, 0));
            assertFalse(isOrderFree.getFreeOrder(items, user));
        }

        @Test
        public void testIsOrderFreeBadName() {
            user = new User("Fiona", 15);
            items.get(items.size()-1).setTime(LocalTime.of(18, 45, 0));
            assertFalse(isOrderFree.getFreeOrder(items, user));
        }

        @Test
        public void testIsOrderFreeNotOnTime() {
            user = new User("Cosimo", 15);
            items.get(items.size()-1).setTime(LocalTime.of(17, 45, 0));
            assertFalse(isOrderFree.getFreeOrder(items, user));
        }
    }