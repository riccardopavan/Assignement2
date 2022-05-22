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

    private final ItemType itemType;
    private final String name;
    private final double price;
    private LocalTime time;

    public EItem(ItemType itemType, String name, double price)
            throws IllegalArgumentException {
        if (itemType == null) {
            throw new IllegalArgumentException("Il tipo non può essere nullo");
        }
        if (name == null) {
            throw new IllegalArgumentException("Il nome non può essere nullo");
        }
        if (price < 0) {
            throw new IllegalArgumentException
                    ("Il prezzo non può essere negativo");
        }
        if (name.equals("")) {
            throw new IllegalArgumentException("Il nome non può essere vuoto");
        }

        this.itemType = itemType;
        this.name = name;
        this.price = price;
        this.time = LocalTime.now();
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public double getPrice() {
        return price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) throws IllegalArgumentException {
        if (time == null) {
            throw new IllegalArgumentException("L'orario non può essere nullo");
        }

        this.time = time;
    }
}
