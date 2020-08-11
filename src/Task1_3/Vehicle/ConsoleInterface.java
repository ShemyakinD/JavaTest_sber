package Task1_3.Vehicle;

import Task6.Logger.CustomLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleInterface {

    private static final String workDirectory = "C:/Task1/GSM/";

    public static void enterVehicles(String username) {
        List<String> vehicles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите автомобили в формате <C[тип авто]_[номер]-[пробег]-[параметр]>. Команда для выхода end.");
        boolean isEnd = true;
        while (isEnd) {
            String command = scanner.nextLine();
            CustomLogger.logFileGSM(String.format("Пользователь %s ввёл автомобиль %s", username,command));
            if (command.equalsIgnoreCase("end"))
                isEnd = false;
            else vehicles.add(command);
        }

        if (vehicles.size() > 0){
            String vehicleFilename = getVehiclesFile(username);
            for (String vehicle : vehicles){
                printToFile(vehicleFilename,vehicle+"\n");
            }
            CalculationCost.getCost(vehicles.toArray(new String[0]),getCalculationFile(username));

            System.out.println("Введите параметры сортировки, если необходимо." + "\n" +
                    "Команда: sort [Тип транспорта] [Тип сортировки]" + "\n\t" +
                    "Тип транспорта:" + "\n" +
                    "100- Легковой авто" + "\n" +
                    "200- Грузовой авто" + "\n" +
                    "300-Пассажирский транспорт" + "\n" +
                    "400- Тяжёлая техника" + "\n\t" +
                    "Тип сортировки:" + "\n" +
                    "0- сортировка по Пробегу авто" + "\n" +
                    "1- сортировка по Параметру");
            String command = scanner.nextLine();
            if (command.matches("sort \\d+ \\d")){
                CustomLogger.logFileGSM(String.format("Пользователь %s выполнил сортировку %s", username,command));
                int vehicleType = Integer.parseInt(command.substring(command.indexOf(" ")+1, command.indexOf(" ")+4));
                int sortType = Integer.parseInt(command.substring(command.lastIndexOf(" ")+1));
                CalculationCost.sortVehicles(vehicles.toArray(new String[0]),vehicleType, sortType);
            }
        }
    }

    public static void printListFiles(String username){
        Map<Integer,File> listFiles = new LinkedHashMap<>();
        int counter = 0;
        File[] files = getListFiles(username);
        if (files != null){
            for (File file : files) {
                if (file.isFile() && file.getName().contains(".tsk")) {
                    counter = ++counter;
                    listFiles.put(counter, file);
                    System.out.println(counter + " : " + file.getName());
                }
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Если нужно открыть файл, введите номер: ");
            String command = scanner.nextLine();
            if (command.matches("\\d+") && listFiles.containsKey(Integer.parseInt(command)))
            {
                CustomLogger.logFileGSM(String.format("Пользователь %s открыл на просмотр файл %s", username,listFiles.get(Integer.parseInt(command)).getPath()));
                System.out.println("\nСодержимое файла:");
                printFile(listFiles.get(Integer.parseInt(command)));
            }
        }
        else System.out.println("Файлы/каталог отсутсвуют");
    }

    private static void printFile(File file){
        try(Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }

    private static String getVehiclesFile(String username){
        String fileName = workDirectory + username + "/vehicles_" + new SimpleDateFormat("ddMMyyyy").format(new Date());
        if (existsFiles(username))
            fileName = fileName + "_" + getNextFileNumber(username, fileName);
        else fileName = fileName + "_1";
        return fileName;
    }

    private static String getCalculationFile(String username){
        String fileName = workDirectory + username + "/calc_" + new SimpleDateFormat("ddMMyyyy").format(new Date());
        if (existsFiles(username))
            fileName = fileName + "_" + getNextFileNumber(username, fileName);
        else fileName = fileName + "_1";
        return fileName;
    }

    private static boolean existsFiles(String username){
        File[] listOfFiles = getListFiles(username);
        if (listOfFiles != null){
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().contains(".tsk")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static File[] getListFiles(String username){
        File folder = new File(workDirectory+username);
        return folder.listFiles();
    }

    private static String getNextFileNumber(String username, String filename){
        File folder = new File(workDirectory+username);
        File[] listOfFiles = folder.listFiles();
        Integer maxNumber = 1;
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains(".tsk")) {
                int currentNumber = Integer.parseInt(file.getName().substring(file.getName().lastIndexOf("_") + 1, file.getName().indexOf(".")));
                if (maxNumber <= currentNumber)
                maxNumber = currentNumber;
            }
        }
        maxNumber = (filename.contains("vehicles")) ? ++maxNumber : maxNumber;
        return maxNumber.toString();
    }

    public static void printToFile(String fileName, String data){
        File file = new File(fileName + ".tsk");
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        try (FileOutputStream out = new FileOutputStream(file, true)) {
                out.write(data.getBytes());
            }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
