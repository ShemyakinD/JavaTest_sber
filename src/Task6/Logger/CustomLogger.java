package Task6.Logger;

import java.sql.Timestamp;

public class CustomLogger implements LogInterface {

    @Override
    public void logConsole(String message){
        String computerName = System.getenv("COMPUTERNAME");
        String userName = System.getProperty("user.name");
        System.out.printf("%s # %s # %s - %s\n",new Timestamp(System.currentTimeMillis()), computerName, userName, message);
    }
}
