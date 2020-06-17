package Task4;

public class UltraList {
    private UltraItem[] item;
    private int size;


    public UltraList() {
        this.item = new UltraItem[0];
    }

    public UltraList(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            this.add(arr[i]);
        }
    }

    public void add(int value, int index){
        UltraItem[] newArray = new UltraItem[this.size + 1]; //Создадим новый расширенный массив
        boolean inserted = false; //флаг была ли вставка
        for (int i = 0; i < newArray.length; i++){
            if (i == index){ //Если пора добавлять элемент, вставляем и меняем флаг, т.к. была вставка
                if (newArray.length == 1){
                    newArray[i] = new UltraItem(value, 1,-1);
                }
                else {
                    newArray[i] = new UltraItem(value,newArray[i-1].getNextItem()+1,newArray[i-1].getPreviousItem()+1);
                    inserted = true;
                }
            }
            else if (!inserted) newArray[i] = this.item[i]; //Если вставки не было идём по порядку
            else newArray[i] = this.item[i-1]; //Если была вставка, нужно учитывать шаг в 1 элемент между значениями массивов
        }
        this.size++;
        this.item = newArray; //обновлняем наш экземпляр
    }

    public void add(int element){
        this.add(element,this.size);
    }

/*    public void setItem(UltraItem item) {
        this.item = item;
    }*/

    public int getSize() {
        return size;
    }
}
