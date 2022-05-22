////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.EItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GiftMiceKeyboardsTest {
    GiftMiceKeyboards gift;
    public List<EItem> itemsList;

    @BeforeEach
    public void setup() {
        gift = new GiftMiceKeyboards();
        itemsList = new ArrayList<>();

        this.itemsList.add(new EItem(EItem.ItemType.Mouse, "Mouse1", 80.00));
        this.itemsList.add(new EItem(EItem.ItemType.Mouse, "Mouse2", 90.00));
        this.itemsList.add(new EItem(EItem.ItemType.Keyboard, "Keyboard1", 100.00));
        this.itemsList.add(new EItem(EItem.ItemType.Keyboard, "Keyboard2", 110.00));
    }

    @Test
    public void testgetGift() {
        assertEquals(80, this.gift.getGift(itemsList));
    }

    @Test
    public void testListNull() {
        assertThrows(IllegalArgumentException.class, () -> this.gift.getGift(null));
    }

    @Test
    public void testListIsEmpty() {
        itemsList = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () -> this.gift.getGift(itemsList));
    }

    @Test
    public void testNotEnoughItems() {
        this.itemsList.remove(0);
        assertEquals(0, this.gift.getGift(itemsList));
    }
}
