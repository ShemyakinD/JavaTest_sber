package Task9.Distinct;

import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("bbbb");
        list.add("cccc");
        list.add("dddd");
        list.add("aaaa");

        List<String> newList = Distinct.removeDuplicates(list);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(3);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(4);

        Queue<Integer> newQueue = Distinct.removeDuplicates(queue);

        System.out.println("Первый лист с дублями:");
        for (String element : list){
            System.out.println(element);
        }
        System.out.println("Лист без дублей:");
        for (String element : newList){
            System.out.println(element);
        }

        System.out.println("Очередь с дублями:");
        for (Integer element : queue){
            System.out.println(element);
        }
        System.out.println("Очередь без дублей:");
        for (Integer element : newQueue){
            System.out.println(element);
        }

    }
}
