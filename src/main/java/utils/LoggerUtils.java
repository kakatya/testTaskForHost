package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
    private static Logger logger;

    public static void logInfo(String name, String message) {
        logger = LogManager.getLogger(name);
        logger.info(message);
    }

    public static void logFatal(String name, String message) {
        logger = LogManager.getLogger(name);
        logger.fatal(message);
    }

    public static void logError(String name, String message) {
        logger = LogManager.getLogger(name);
        logger.error(message);
    }

}
