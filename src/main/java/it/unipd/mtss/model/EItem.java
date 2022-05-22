////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import java.time.LocalTime;

public class EItem {
    public enum ItemType {
        Processor,
        Motherboard,
        Mouse,
        Keyboard
    }

    public EItem(ItemType itemType, String name, double price) {
    }

    public String getName() {
        return null;
    }

    public ItemType getItemType() {
        return null;
    }

    public double getPrice() {
        return 0d;
    }

    public LocalTime getTime() {
        return null;
    }

    public void setTime(LocalTime time) throws IllegalArgumentException {
    }
}
