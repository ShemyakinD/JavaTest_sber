package Task4.LinkedList;

public class UltraItem {
    //Элемент списка
    private UltraItem previousItem;//Ссылка на предыдущий элемент
    private int value;//значение
    private UltraItem nextItem;//ссылка на следующий элемент

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
