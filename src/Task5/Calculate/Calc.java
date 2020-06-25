package Task5.Calculate;

import Task6.Logger.CustomLogger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc implements IntegerCalculation, LongCalculation, DoubleCalculation, FloatCalculation {

    private static CustomLogger logger = new CustomLogger();

    public static void calculate(String expression){
        logger.logConsole("Передано выражение: " + expression);
        int braketsCheck = 0;
        //Валидируем выражение на количество скобок
        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '('){
                braketsCheck++;
            }
            if (expression.charAt(i) == ')'){
                braketsCheck--;
            }
        }
        if (braketsCheck != 0){ //Плохо ошибаться с количеством скобок
            logger.logConsole("Что-то со скобками беда!");
            return;
        }
        else { //если ты молодец, то начинаем вычислять все скобки начиная изнути выражения
            while (expression.contains("(") || expression.contains(")")){
                String nestedExpression = expression.substring(expression.lastIndexOf("(")+1,expression.indexOf(")",expression.lastIndexOf("(")));
                logger.logConsole("Вычисляем значение в скобках: (" + nestedExpression+")");
                expression = expression.replace("("+nestedExpression+")", calculateExpression(nestedExpression));
            }
            System.out.println(calculateExpression(expression));
        }
    }

    //Какулируем простое выражение без скобок
    public static String calculateExpression(String expression){
        expression = expression.replaceAll("\\s","");//для регулярок почистим пробелы
        while (expression.contains("*") || expression.contains("/")){ //сначала обратабываем частные и произведения
            Matcher multOrDiv = Pattern.compile("(\\D?\\d+\\.*\\d*)[\\*/](\\D?\\d+\\.*\\d*)").matcher(expression);
            //Проверяем в выражении наличие произведений и частных с учётом знака чисел
            if (multOrDiv.find()){ //В зависимости от того, что нашли - умножаем или делим. Результат подставляем в выражение
                logger.logConsole("Выражение: " + multOrDiv.group(0));
                if (multOrDiv.group(0).contains("*")){
                    String res = multiplyStr(Double.parseDouble(multOrDiv.group(1)),Double.parseDouble(multOrDiv.group(2)));
                    expression = expression.replace(multOrDiv.group(0), res.contains("-") ? res : "+"+res);
                }
                else {
                    String res = divideStr(Double.parseDouble(multOrDiv.group(1)),Double.parseDouble(multOrDiv.group(2)));
                    expression = expression.replace(multOrDiv.group(0), res.contains("-") ? res : "+"+res);
                }
            }
        }
        //Вычисляем суммы и разности в выражении. Также с учётом знака. Если остаётся одно число - выходим из цикла
        while ((expression.contains("+") || expression.contains("-")) && !Pattern.compile("^\\D?\\d+\\.*\\d*$").matcher(expression).find()){
            Matcher plusOrMinus = Pattern.compile("(\\D?\\d+\\.*\\d*)(\\D?\\d+\\.*\\d*)").matcher(expression);
            if (plusOrMinus.find()){//Аналогично произведениям и частным, идём по порядку и вычисляем. Результат подставляем
                logger.logConsole("Выражение: " + plusOrMinus.group(0));
                if (plusOrMinus.group(0).contains("+")){
                    String res = plusStr(Double.parseDouble(plusOrMinus.group(1)),Double.parseDouble(plusOrMinus.group(2)));
                    expression = expression.replace(plusOrMinus.group(0),res.contains("-") ? res : "+"+res);
                }
                else {
                    String res = minusStr(Double.parseDouble(plusOrMinus.group(1)),Double.parseDouble(plusOrMinus.group(2)));
                    expression = expression.replace(plusOrMinus.group(0),res.contains("-") ? res : "+"+res);
                }
            }
        }
        //Выводим число. Если оно положительное - опускаем знак.
//        System.out.println(expression.contains("-") ? expression : expression.replace("+",""));
        logger.logConsole("Результат вычислениея: " + expression);
        return expression.contains("-") ? expression : expression.replace("+","");
    }

    //Вычисление произведения для парсера
    private static String multiplyStr(double val1, double val2){
        return String.valueOf(val1 * val2);
    }

    //Вычисление частного для парсера
    private static String divideStr(double val1, double val2){
        return String.valueOf(val1 / val2);
    }

    //Вычисление суммы для парсера
    private static String plusStr(double val1, double val2){
        return String.valueOf(val1 + val2);
    }

    //Вычисление разности для парсера
    private static String minusStr(double val1, double val2){
        if (val1 < 0.0 || val2 < 0.0)
            return plusStr(val1,val2);
        return String.valueOf(val1 - val2);
    }

}
