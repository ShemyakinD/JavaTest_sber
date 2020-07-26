package Task10.ReverseMap;

import Task1_3.Vehicle.Main;

import java.util.*;

public class Main8 {
    public static void main(String[] args) {

        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("test1", 4);
        mapa.put("test2", 5);
        mapa.put("test3", 6);
        mapa.put("test4", 5);
        mapa.put("test5", 4);
        mapa.put("test6", 7);
        mapa.put("test7", 8);

        for (Map.Entry entry : reverseMap(mapa).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

    //Метод перестановки ключей и значений в словаре местами
    private static <K,V> Map<V, Collection<K>> reverseMap(Map<K,V> initialMap){
        //Создадим новый словарь
        Map<V, Collection<K>> newMap = new HashMap<>();
        for (K element : initialMap.keySet()) {
            //Проходим по элементам. Значения становятся ключами, а ключи добавляются в лист значений
            V value = initialMap.get(element);
            if (!newMap.containsKey(value))
            {
                newMap.put(value, new ArrayList<>(){{add(element);}});
            }
            else newMap.get(value).add(element);
        }
        return newMap;
    }
}
