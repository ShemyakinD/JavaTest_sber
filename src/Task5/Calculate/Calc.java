package Task5.Calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    public static double add(double val1, double val2 ){
        return (val1 + val2);
    }

    public static float add(float val1, float val2 ){
        return (val1 + val2);
    }

    public static int add(int val1, int val2 ){
        return (val1 + val2);
    }

    public static long add(long val1, long val2 ){
        return (val1 + val2);
    }

    public static double minus(double val1, double val2 ){
        return (val1 - val2);
    }

    public static float minus(float val1, float val2 ){
        return (val1 - val2);
    }

    public static int minus(int val1, int val2 ){
        return (val1 - val2);
    }

    public static long minus(long val1, long val2 ){
        return (val1 - val2);
    }

    public static double multiply(double val1, double val2){
        return (val1 * val2);
    }

    public static float multiply(float val1, float val2){
        return (val1 * val2);
    }

    public static int multiply(int val1, int val2){
        return (val1 * val2);
    }

    public static long multiply(long val1, long val2){
        return (val1 * val2);
    }

    public static double divide(double val1, double val2){
        return (val1 / val2);
    }

    public static double divide(float val1, float val2){
        return ((double) val1 / (double) val2);
    }

    public static double divide(int val1, int val2){
        return ((double) val1 / (double) val2);
    }

    public static double divide(long val1, long val2){
        return ((double) val1 /(double)  val2);
    }

    public static double sqrt(double val1){
        return Math.sqrt(val1);
    }

    public static double degree(double val1, int val2) {
        double res = 1;
        if (val2 == 0)
            return 1.0D;
        else {
            while (val2 > 0)
            {
                res = res * val1;
                val2--;
            }
            return res;
        }

    }

    //Какулируем простое выражение без скобок
    public static void calculate(String expression){
        expression = expression.replaceAll("\\s","");//для регулярок почистим пробелы
        while (expression.contains("*") || expression.contains("/")){ //сначала обратабываем частные и произведения
            Matcher multOrDiv = Pattern.compile("(\\D?\\d+\\.*\\d*)[\\*/](\\D?\\d+\\.*\\d*)").matcher(expression);
            //Проверяем в выражении наличие произведений и частных с учётом знака чисел
            if (multOrDiv.find()){ //В зависимости от того, что нашли - умножаем или делим. Результат подставляем в выражение
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
        System.out.println(expression.contains("-") ? expression : expression.replace("+",""));
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
        if (val1 < 0.0 && val2 < 0.0)
            return plusStr(val1,val2);
        return String.valueOf(val1 - val2);
    }

    //(1+5)*3
  /*  public static void calculate(String expression){
        double result = 0.0;

//        String[] vars = input.split("^\\((.*?)\\)");

        Matcher expres = Pattern.compile("(\\(.*\\)(\\(.*\\)(\\(.*\\)(\\(.*\\)))))").matcher(expression);
        expres.find();
        String exp = expression.substring(expression.indexOf("(")+1,expression.indexOf(")"));
        Scanner scanner = new Scanner(exp);
        String input = scanner.next();*/
//        String[] vars = input.split("(\\d+[\\*/]\\d+)");
      /*  String[] vars = input.split("[\\+-]");
        for (String var : vars){
            Matcher m = Pattern.compile("(\\d\\.*\\d*)\\*(\\d\\.*\\d*)").matcher(var);
            Matcher d = Pattern.compile("(\\d\\.*\\d*)/(\\d\\.*\\d*)").matcher(var);
            if (m.find()){
                System.out.println(m.group(1));
                System.out.println(m.group(2));
                String res = multiply(Double.parseDouble(m.group(1)),Double.parseDouble(m.group(2)));
                exp = exp.replace(var,res);
            }
            if (d.find()){
                System.out.println(d.group(1));
                System.out.println(d.group(2));
                String res2 = divide(Double.parseDouble(d.group(1)),Double.parseDouble(d.group(2)));
                exp = exp.replace(var,res2);
            }
        }
        System.out.println(result);
    }*/
}
