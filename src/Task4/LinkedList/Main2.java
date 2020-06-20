package Task4.LinkedList;

public class Main2 {
    public static void main(String[] args) {
        //Зададим целочисленный массив
        int[] arr = new int[]{1,45,75,32,1,7,8,5};
        //Создадим 2 списка, один из массива, другой пустой
        UltraList ultraList = new UltraList(arr);
        UltraList ultraList2 = new UltraList();

        //Заполним пустой список значениями и выведем оба на экран с размерностями
        ultraList2.add(2);
        ultraList2.add(6);
        System.out.println("--------------Список 1 ultraList");
        ultraList.print();
        ultraList.printSize();
        System.out.println("--------------Список 2 ultraList2");
        ultraList2.print();
        ultraList2.printSize();

        //Добавим значение по индексу и выведем на экран
        ultraList.add(9999,3);
        System.out.println("--------------Список 1 ultraList добавление элемента");
        ultraList.print();

        //Изменим добавленный элемент и выведем на экран
        ultraList.set(-777777,3);
        System.out.println("--------------Список 1 ultraList изменение элемента");
        ultraList.print();
        ultraList.printSize();

        //Удалим первый элемент списка и выведем
        ultraList.remove(0);
        System.out.println("--------------Список 1 ultraList удаление элемента");
        ultraList.print();
        ultraList.printSize();

        //Отсортируем список во убыванию и возрастанию и выведем + выведем оригинал
        System.out.println("--------------Список 1 ultraList по Убыванию");
        ultraList.sort().print();
        System.out.println("--------------Список 1 ultraList по Возрастанию");
        ultraList.sort(1).print();
        System.out.println("--------------Список 1 ultraList Оригинал");
        ultraList.print();
    }
}
