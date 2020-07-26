package Task8.LettersDictionatry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main6 {
    public static void main(String[] args) {
        lettersFrequency("bam bum test text BLA BLA");
    }

    //Метод вывода частотного словаря латинских букв
    public static void lettersFrequency(String text){
        //Забиваем словарь латинских букв
        Map<Character, Integer> letterDict = new HashMap<>();
        for(Character letter : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            letterDict.put(letter, 0);
        }

        //извлекаем из входной строки только буквы и преобразуем в массив символов
        for (Character letter : text.replaceAll("[^a-zA-Z]+","").toLowerCase().toCharArray()){
            //проходим по символьно и добавляем их в словарь
            letterDict.put(letter, letterDict.get(letter) + 1);
        }
        //создаём словарь под отсортированные по частоте символы
        Map<Character,Integer> sortedLetters = new LinkedHashMap<>();

        //проходимся по словарю букв и переносим в порядке убывания их в словарь sortedLetters
        for (int i = letterDict.size(); i > 0; i--){
            int maxFreq = 0;
            Character currentLetter ='a';
            for (Character letter : letterDict.keySet()) {
                if (maxFreq <= letterDict.get(letter)){
                    currentLetter = letter;
                    maxFreq = letterDict.get(letter);
                }
            }
            sortedLetters.put(currentLetter,maxFreq);
            letterDict.remove(currentLetter);
        }

        //выводим на экран
        for (Character letter : sortedLetters.keySet()) {
            System.out.printf("%s - %d\n", letter, sortedLetters.get(letter));
        }
    }
}
