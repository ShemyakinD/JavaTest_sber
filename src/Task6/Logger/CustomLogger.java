package Task6.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;

public class CustomLogger implements LogInterface {
    private static String computerName = System.getenv("COMPUTERNAME");
    private static String userName = System.getProperty("user.name");

    @Override
    public void logConsole(String message){
        System.out.printf("%s # %s # %s - %s\n",new Timestamp(System.currentTimeMillis()), computerName, userName, message);
    }

    @Override
    public void logFile(String message, File file) {
        message = String.format("%s # %s # %s - %s\n",new Timestamp(System.currentTimeMillis()), computerName, userName, message);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        try (FileOutputStream out = new FileOutputStream(file, true)) {
            out.write(message.getBytes());
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void logFileGSM(String message){
        CustomLogger logger = new CustomLogger();
        logger.logFile(message,new File("C:/Task1/GSM/logs.txt"));
    }

}
