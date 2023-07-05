package com.evision.eauf.evision_automation.selenium.Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

    public class LoggerUtil {

        private static Logger logger;

        public static void configureLogger() {
            logger = Logger.getLogger(LoggerUtil.class);
            PropertyConfigurator.configure("D:\\Java\\evision_automation\\src\\main\\resources\\Log4j.properties");

        }

        public static void logInfo(String message) {
            logger.info(message);
        }

        public static void logError(String message, Throwable throwable) {
            logger.info(message, throwable);
        }

    }

