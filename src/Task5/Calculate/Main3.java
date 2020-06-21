package Task5.Calculate;

public class Main3 {
    public static void main(String[] args) {

        System.out.println("Мучение парсера калькулятора:");

        Calc.calculate("((2.5 - 1) / 0.5) + (5 * (4 * (2+3)))");
        System.out.printf("Посчитала система: %f\n", ((2.5 - 1) / 0.5) + (5 * (4 * (2+3))));

        Calc.calculate("10 * ((1 + 6.9 * (9 + 1))/2.5)");
        System.out.printf("Посчитала система: %f\n", 10 * ((1 + 6.9 * (9 + 1))/2.5));

        Calc.calculate("5.1+6.6/2*3.1-1*0+6*3+4.5/0.5");
        System.out.printf("Посчитала система: %f\n", 5.1+6.6/2*3.1-1*0+6*3+4.5/0.5);

        Calc.calculate("9/3.5 - 3*4.5*7 + 2*5");
        System.out.printf("Посчитала система: %f\n", 9/3.5 - 3*4.5*7 + 2*5);

        Calc.calculate("-5*3 + 3*-7 + 2.2");
        System.out.printf("Посчитала система: %f\n", -5*3 + 3*-7 + 2.2);

        System.out.println("Ручной вызов калькулятора:");
        System.out.println(Calc.minus(-0.5,0.8));
        System.out.println(Calc.multiply(0.5,0.8));
        System.out.println(Calc.divide(0.5,0.8));
        System.out.println(Calc.divide(5,8));
        System.out.println(Calc.degree(5.1,0));
        System.out.println(Calc.sqrt(5.1));
    }
}
