package Task6.Logger;

import java.io.File;

public interface LogInterface {
    void logConsole(String message);
    void logFile(String message, File file);
}
