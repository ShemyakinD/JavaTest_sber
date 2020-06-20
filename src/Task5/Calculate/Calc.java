package Task5.Calculate;

import java.util.Scanner;
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

    public static double sqrt(double val1, double val2){
        return 0.0;
    }

    public static double degree(double val1, int val2) {
        if (val2 == 0)
            return 1.0D;
        else {
            while (val2 > 1)
            {
                val1*=val1;
                val2--;
            }
            return val1;
        }

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
