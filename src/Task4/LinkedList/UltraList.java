package Task4.LinkedList;

public class UltraList {
    private UltraItem item; //узлы списка
    private int size; //размерность

    //Конструктор для пустого списка по умолчанию
    public UltraList() {
        this.item = null;
    }

    //Конструктор для списка из массива целых чисел
    public UltraList(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // пробегаемся по массиву и последовательно засовываем элементы в список
            this.add(arr[i]);
        }
    }

    //Конструктор для копирования списка
    private UltraList(UltraList oldList){
        this.item = oldList.get(0);
        this.size = oldList.size();
    }

    //Рекурсивно идём по элементам в глубь списка, пока не провалимся до нужного индекса. Возвращаем элемент
    private UltraItem getDeeper(UltraItem item, int index) {
        while (index > 0) {
            index--;
            return getDeeper(item.getNextItem(), index);
        }
        return item;
    }

    //Получение индекса максимального элемента списка
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

    //Получение индекса минимального элемента списка
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

    //сортировка списка. По умолчанию флаг 0 - по убыванию. Флаг 1 - по возрастанию
    public UltraList sort(){
        return this.sort(0);
    }

    public UltraList sort(int flag){
        //Делаем копию списка, чтобы не испортить оригинал
        UltraList sacrificeList = new UltraList(this);
        UltraList newList = new UltraList();//Новый отсортированный лист
        for (int i = sacrificeList.size(); i > 0; i--){//Нужно количество итераций равное размеру листу-жертве
            if (flag == 0){
                //По убыванию. Ищем индекс самого большого элемента.
                //Вставляем его в новый лист в начало и удаляем из жертвы
                //Таким образом элементы из жертвы переходят в новый лист в порядке убывания
                int maxIndex = sacrificeList.getMaxIndex();
                newList.add(sacrificeList.get(maxIndex).getValue());
                sacrificeList.remove(maxIndex);
            }
            else {
                //По возрастанию. Ищем индекс самого мелкого элемента.
                //Вставляем его в новый лист в начало и удаляем из жертвы
                int minIndex = sacrificeList.getMinIndex();
                newList.add(sacrificeList.get(minIndex).getValue());
                sacrificeList.remove(minIndex);
            }
        }
        return newList;
    }

    //Получение элемента по индексу. Рекурсивно ковыряемся в глубину списка
    public UltraItem get(int index) {
        return getDeeper(this.item, index);
    }

    //Добавление значения в конец списка
    public void add(int value) {
        if (this.size() == 0) {//список пустой - вставляем первый элемент без ссылок
            this.item = new UltraItem(null, value, null);
            this.size++;
        } else {//есть данные - определяем крайний элемент, вставляем новый и сразу же обновляем ссылки
            UltraItem edgeItem = this.get(size - 1);
            edgeItem.setNextItem(new UltraItem(edgeItem, value, null));
            this.size++;
        }
    }

    //Установка значения элемента по индексу
    public void set(int value, int index) {
        this.get(index).setValue(value);
    }

    //Добавление элемента в список по индексу
    public void add(int value, int index) {
        UltraList newList = new UltraList();//Делаем новый список
        for (int i = 0; i < this.size() + 1; i++) {//Идём по списку оригиналу, но с размерностью +1
            if (i < index)//Если рано вставлять - вставляем значения из списка оригинала по порядку
                newList.add(this.get(i).getValue());
            else if (i == index)//Время вставки нового элемента
                newList.add(value);
            //Последующие элементы из оригинала вставляем с учётом смещения индексов
            else newList.add(this.get(i - 1).getValue());
        }
        this.item = newList.get(0); //Переопределяем список
        this.size++;
    }

    //Удаление элемента по индексу
    public void remove(int index) {
        UltraList newList = new UltraList();//Создаём новый пустой список
        for (int i = 0; i < this.size(); i++) {//Переносим из оригинала все элементы игнорируя указаный индекс
            if (i == index)
                continue;
            else
                newList.add(this.get(i).getValue());
        }
        this.item = newList.get(0);//Обновляем список оригинал
        this.size--;
    }

    //Размерность списка
    public int size() {
        return this.size;
    }

    //Вывод размерности списка на экран
    public void printSize() {
        System.out.println("Размерность списка: " + this.size());
    }

    //Вывод значений элементов списка на экран
    public void print() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.get(i).getValue() + " ");
        }
        System.out.println();
    }
}
