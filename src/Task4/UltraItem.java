package Task4;

public class UltraItem {
    private UltraItem previousItem;
    private int value;
    private UltraItem nextItem;

    public UltraItem(UltraItem previousItem, int value, UltraItem nextItem) {
        this.previousItem = previousItem;
        this.value = value;
        this.nextItem = nextItem;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public UltraItem getNextItem() {
        return nextItem;
    }

    public void setNextItem(UltraItem nextItem) { this.nextItem = nextItem; }

}
