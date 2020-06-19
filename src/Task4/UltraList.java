package Task4;

public class UltraList {
    private UltraItem item;
    private int size;


    public UltraList() {
        this.item = null;
    }

    public UltraList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.add(arr[i], i);
        }
    }

    private UltraList(UltraList oldList){
        this.item = oldList.get(0);
        this.size = oldList.size();
    }

    private UltraItem getNext(UltraItem item, int index) {
        while (index > 0) {
            index--;
            return getNext(item.getNextItem(), index);
        }
        return item;
    }

    private int getMaxIndex(){
        int maxValue = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < this.size(); i++) {
            if (maxValue < this.get(i).getValue()){
                maxValue = this.get(i).getValue();
                index=i;
            }
        }
        return index;
    }

    private int getMinIndex(){
        int maxValue = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < this.size(); i++) {
            if (maxValue > this.get(i).getValue()){
                maxValue = this.get(i).getValue();
                index=i;
            }
        }
        return index;
    }

    public UltraList sort(){
        return this.sort(0);
    }

    public UltraList sort(int flag){
        UltraList sacrificeList = new UltraList(this);
        UltraList newList = new UltraList();
        for (int i = sacrificeList.size(); i > 0; i--){
            if (flag == 0){
                int maxIndex = sacrificeList.getMaxIndex();
                newList.add(sacrificeList.get(maxIndex).getValue());
                sacrificeList.remove(maxIndex);
            }
            else {
                int minIndex = sacrificeList.getMinIndex();
                newList.add(sacrificeList.get(minIndex).getValue());
                sacrificeList.remove(minIndex);
            }
        }
        return newList;
    }

    public UltraItem get(int index) {
        return getNext(this.item, index);
    }

    public void add(int value) {
        if (this.size() == 0) {
            this.item = new UltraItem(null, value, null);
            this.size++;
        } else {
            UltraItem edgeItem = this.get(size - 1);
            edgeItem.setNextItem(new UltraItem(edgeItem, value, null));
            this.size++;
        }
    }

    public void set(int value, int index) {
        this.get(index).setValue(value);
    }

    public void add(int value, int index) {
        UltraList newList = new UltraList();
        for (int i = 0; i < this.size() + 1; i++) {
            if (i < index)
                newList.add(this.get(i).getValue());
            else if (i == index)
                newList.add(value);
            else newList.add(this.get(i - 1).getValue());
        }
        this.item = newList.get(0);
        this.size++;
    }

    public void remove(int index) {
        UltraList newList = new UltraList();
        for (int i = 0; i < this.size(); i++) {
            if (i == index)
                continue;
            else
                newList.add(this.get(i).getValue());
        }
        this.item = newList.get(0);
        this.size--;
    }

    public int size() {
        return this.size;
    }

    public void printSize() {
        System.out.println("Размерность списка: " + this.size());
    }

    public void print() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.get(i).getValue() + " ");
        }
        System.out.println();
    }
}
