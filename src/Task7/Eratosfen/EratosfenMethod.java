package Task7.Eratosfen;

public interface EratosfenMethod {

    default boolean[] getMaskScreen(int endNumber){
            int size = endNumber + 1;
            boolean[] maskScreenArray = new boolean[size];

            // Заполняем массив true
            for (int i = 0; i < size; i++)
                maskScreenArray[i] = true;
            maskScreenArray[0] = maskScreenArray[1] = false; //Удаляем числа, которые точно не простые 0 и 1
            return maskScreenArray;
        }

    default int[] getPrimeEratosfen(boolean[] mask){
        // Алгоритм Решето Эратосфена
        int primeNumbersCount = mask.length - 2;
        for (int i = 2; i < Math.sqrt(mask.length) + 1; i++) {
                for (int j = 2 * i; j < mask.length; j += i) {
                    if (mask[j]) {
                        mask[j] = false;
                        primeNumbersCount--;
                    }
                }
        }

        int[] primeNumbers = new int[primeNumbersCount];
        // Итоговый массив
        for (int i = 0, j = 0; i < mask.length; i++) {
            if (mask[i])
                primeNumbers[j++] = i;
        }

        return primeNumbers;
    }
}
