package ConsoleApp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class Login {
    public static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static FileHandler fileHandler;
    private static SimpleFormatter simpleFormatter;

    public static void set() throws IOException {
        logger.setLevel(Level.ALL);
        fileHandler = new FileHandler("./files/log/Logging.log");
        simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return LocalDateTime.now(ZoneId.of("Europe/Kiev"))
                        .format(DateTimeFormatter.ofPattern(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                                + " " + record.getLevel() + " " + record.getSourceClassName().
                                substring(record.getSourceClassName().lastIndexOf(".") + 1) + "."
                                + record.getSourceMethodName() + "():" + record.getMessage() + "\n"));
            }
        });
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);
    }


}
