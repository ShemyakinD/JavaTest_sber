package Task7.Eratosfen;

public interface Print {

    default void printIntArray(int[] intArray) {
        int rowLength = 20; // Максимальное количество символов с строке
        int rowLengthBuffer = 0;
        int rowAmount = 5; // Максимальное количество строк на странице
        int rowAmountBuffer = 0;
        for (int number : intArray) {
            System.out.print(number + " ");
            rowLengthBuffer += String.valueOf(number).length() + 1;
            if (rowLengthBuffer >= rowLength) {
                // Переход на новую строку
                System.out.println();
                rowLengthBuffer = 0;
                rowAmountBuffer++;
            }
            if (rowAmountBuffer >= rowAmount) {
                System.out.println("--------Новая cтраница--------");
                rowAmountBuffer = 0;
            }
        }
    }
}