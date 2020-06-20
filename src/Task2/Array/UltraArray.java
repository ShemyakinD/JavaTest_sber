package Task2.Array;

/**
 * Класс для работы с массивом целочисленных значений. Задание 2.
 */
public class UltraArray {
    private int[] ultraArray;

    //Конструктор
    public UltraArray(int[] ultraArray) {
        this.ultraArray = ultraArray;
    }

    //Добавление элемента в массив по индексу
    public void add(int element, int index){
        int[] newArray = new int[this.ultraArray.length + 1]; //Создадим новый расширенный массив
        boolean inserted = false; //флаг была ли вставка
        for (int i = 0; i < newArray.length; i++){
            if (i == index){ //Если пора добавлять элемент, вставляем и меняем флаг, т.к. была вставка
                newArray[i] = element;
                inserted = true;
            }
            else if (!inserted) newArray[i] = this.ultraArray[i]; //Если вставки не было идём по порядку
            else newArray[i] = this.ultraArray[i-1]; //Если была вставка, нужно учитывать шаг в 1 элемент между значениями массивов
        }
        this.ultraArray = newArray; //обновлняем наш экземпляр
    }

    //Добавление элемента в конец массива
    public void add(int element){
        this.add(element,this.ultraArray.length);
    }

    //Вывод количества элементов в массиве
    public void printSize(){
        System.out.println(this.ultraArray.length);
    }

    //Получение количества элементов в массиве
    public int getSize(){
        return this.ultraArray.length;
    }

    //Удаление элемента по индексу
    public void remove(int index){
        int[] newArray = new int[this.ultraArray.length - 1]; //Делаем уменьшенный массив для текущих данных
        boolean deleted = false; //флаг удаления элемента
        for (int i = 0; i < newArray.length; i++){
            if (i == index || deleted) { //Если пора удалять элемент или уже удалён, то учитываем шаг между элементами массивов
                deleted = true;
                newArray[i] = this.ultraArray[i+1];
            }
            else newArray[i] = this.ultraArray[i]; //иначе просто переносим массив
        }
        this.ultraArray = newArray; //обновляем экземпляр
    }

    //Изменение элемента по индексу
    public void set(int index, int newValue){
        //Если передаём элемент на 1 больше, чем размер массива, то можно его добавить вместо ошибки
        if (index == this.ultraArray.length) add(newValue);
        else {
            for (int i = 0; i < this.ultraArray.length; i++) {
                if (i == index) this.ultraArray[i] = newValue;
            }
        }
    }

    //Вывод массива на экран
    public void print(){
        for (int element : this.ultraArray) {
            System.out.printf("%s ",element);
        }
        System.out.println("\n");
    }

    //Сортировка пузырьком по возрастанию
    public UltraArray sortAsc(){
        int[] newArray = new int[getSize()]; //Чтобы не изменить исходный массив сделаем его копию
        for (int i = 0 ; i< getSize();i++)
            newArray[i] = this.ultraArray[i];
        for(int i = newArray.length-1 ; i > 0 ; i--){ //переносим в правую часть массива значения по возрастанию
            for(int j = 0 ; j < i ; j++){
                if( newArray[j] > newArray[j+1] ){//если текущий элемент больше следующего - двигаем его вправо
                    int tmp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = tmp;
                }
            }
        }
        return new UltraArray(newArray);
    }

    //Сортировка пузырьком по убыванию
    public UltraArray sortDesc(){
        int[] newArray = new int[getSize()]; //Чтобы не изменить исходный массив сделаем его копию
        for (int i = 0 ; i< getSize();i++)
            newArray[i] = this.ultraArray[i];
        for(int i = newArray.length-1 ; i > 0 ; i--){//переносим в правую часть массива значения по убыванию
            for(int j = 0 ; j < i ; j++){
                if( newArray[j] < newArray[j+1] ){//если текущий элемент меньше следующего - двигаем его вправо
                    int tmp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = tmp;
                }
            }
        }
        return new UltraArray(newArray);
    }

    //Вывод максимального значения элемента массива
    public void getMax(){
        int max = Integer.MIN_VALUE;
        for (int i : this.ultraArray){
            if (max < i) max = i;
        }
        System.out.printf("Максимальное значение элемента массива: %s\n",max);
    }

    //Вывод минимального значения элемента массива
    public void getMin(){
        int min = Integer.MAX_VALUE;
        for (int i : this.ultraArray){
            if (min > i) min = i;
        }
        System.out.printf("Минимальное значение элемента массива: %s\n",min);
    }

    //Заполнение массива одинаковым значением element
    public void refillSameShit(int element){
        int[] newArray = new int[getSize()];
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = element;
        }
        this.ultraArray = newArray;
    }

}
