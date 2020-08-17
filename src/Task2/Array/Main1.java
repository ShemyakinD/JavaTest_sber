package Task2.Array;

public class Main1 {

    public static void main(String[] args) {
        //Вобъём случайный массив целых чисел
        int[] testArray = new int[]{4,6,7,213,634,8,56,34,2,3,25,75,4,64,7,7,9,0,-91,-2,421,-2};
        //Создадим экземпляр нашего рукотворного класса и выведем его
        UltraArray ultraArray = new UltraArray(testArray);
        ultraArray.print();

        System.out.println("--------------add");
        //Добавим новое значение -5 в массив с индексом 2
        ultraArray.add(-5,2);
        //Добавим новое значение 99999 в конец массива
        ultraArray.add(99999);
        ultraArray.print();//Проверяем

        System.out.println("--------------add out of bound");
        //Попробуем добавить элемент, а в индекс передадим позицию за пределами массива большую на 1
        ultraArray.add(5555,ultraArray.getSize());
        ultraArray.print();//Проверяем, должно встать справа в массиве, если бы передали ещё больше, должен быть OutOfBound

        System.out.println("--------------remove");
        //Удаляем добавленую ранее -5 с индексом 2
        try {
            ultraArray.remove(2);
        }
        catch (ArrayCustomException ace){
            System.out.println(ace.getMessage());
        }

        ultraArray.print();//Проверяем

        System.out.println("--------------set");
        //Поменяем текущий элемент с индексом 2 на -11111
        ultraArray.set(2,-11111);
        //Сразу попробуем поменять элемент, который находится на 1 за пределами массива (т.е. не существующий)
        ultraArray.set(ultraArray.getSize(),55555);
        ultraArray.print();//Проверяем, он должен добавиться, аналогично add

        System.out.println("--------------sortDesc");
        //Сортируем по убыванию и выводим сортирнутую версию и оригинал
        ultraArray.sortDesc().print();
        ultraArray.print();

        System.out.println("--------------sortAsc");
        //Сортируем по возрастанию и выводим сортирнутую версию и оригинал
        ultraArray.sortAsc().print();
        ultraArray.print();

        System.out.println("--------------getMax");
        ultraArray.getMax();//Получим максимум массива
        System.out.println("--------------getMin");
        ultraArray.getMin();//Получим минимум массива

        System.out.println("--------------fill same value");
        ultraArray.refillSameShit(0);//Перезапишем массив одним значением
        ultraArray.print();
    }
}
