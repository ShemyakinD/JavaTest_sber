package Task4;

public class UltraItem {
    private int value;
    private int nextItem = 0;
    private int previousItem = -1;

    public UltraItem(int value, int nextItem, int previousItem) {
        this.value = value;
        this.nextItem = nextItem;
        this.previousItem = previousItem;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNextItem() {
        return nextItem;
    }

    public void setNextItem(int nextItem) {
        this.nextItem = nextItem;
    }

    public int getPreviousItem() {
        return previousItem;
    }

    public void setPreviousItem(int previousItem) {
        this.previousItem = previousItem;
    }
}
