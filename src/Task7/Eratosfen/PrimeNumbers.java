package Task7.Eratosfen;

public class PrimeNumbers implements EratosfenMethod, Print {

    public void primeEratosfen(int endNumber){
        if (endNumber < 2){
            System.out.println("Невозможно создать массив");
        }
        else {
            boolean[] maskArray = getMaskScreen(endNumber);
            printIntArray(getPrimeEratosfen(maskArray));
        }
    }
}
