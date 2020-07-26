package Task9.Distinct;

import java.util.*;

public class Distinct {
    //В коллекцию входят множества, словари, очереди и листы
    //Помним, что в множествах и словарях дубликаты исключаются, поэтому обрабатываем только оставшиеся 2

    //Удаление дубликатов в листе
    public static <T> List<T> removeDuplicates(List<T> collection) {
        return addUnique(collection, new ArrayList<>());
    }

    //Удаление дубликатов в очереди
    public static <T> Queue<T> removeDuplicates(Queue<T> collection) {
        return addUnique(collection, new ArrayDeque<>());
    }

    //Универсальный метод вставки только уникальных значений в произвольную коллекцию
    //Говорим, что тип C - это подтип интерфейса коллекции, с типами данных T
    private static  <C extends Collection<T>, T> C addUnique(Collection<T> oldCollection, C newCollection){
        //копируем уникальные значения в новую коллекцию и возвращаем её
        for (T element : oldCollection){
            if (!newCollection.contains(element)){
                newCollection.add(element);
            }
        }
        return newCollection;
    }

}
