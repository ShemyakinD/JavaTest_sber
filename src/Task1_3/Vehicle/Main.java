package Task1_3.Vehicle;

import Task6.Logger.CustomLogger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isEnd = true;
        System.out.println("Идентифицируйте себя: ");
        String currentUser = scanner.nextLine();
        CustomLogger.logFileGSM("Авторизовался пользователь: " + currentUser);
        while (isEnd){
            System.out.println("Введите команду (start|history|exit): ");
            String command = scanner.nextLine();
            CustomLogger.logFileGSM(String.format("Введена команда %s пользователем %s", command, currentUser));
            if (command.equalsIgnoreCase("start"))
                ConsoleInterface.enterVehicles(currentUser);
            if (command.equalsIgnoreCase("history"))
                ConsoleInterface.printListFiles(currentUser);
            if (command.equalsIgnoreCase("exit"))
                isEnd = false;
        }
        CustomLogger.logFileGSM(String.format("Пользователь %s завершил сеанс", currentUser));
        //String[] cars = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
    }
}
