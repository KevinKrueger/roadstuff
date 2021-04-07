package com.kevinkrueger.roadstuff.network;

import org.apache.logging.log4j.Logger;

/***********************
* Author: Kevin Krüger
*   Date: 07.04.2021
************************/

/**
 * Logger class for Development
 **/
public class RSLogger implements ILogger
{
    private static boolean DeveloperMode = true;
    private static Logger LOGGER;

    private final static String version = "1.3.2";

    public RSLogger(Logger logger, boolean DeveloperMode)
    {
        setDeveloperMode(DeveloperMode);
        LOGGER = logger;
    }

    /**
     * Extended Method for Development
     * @param msg Show this Message in Console
     * */
    public void log(String msg)
    {
        if(isDeveloperMode())
          LOGGER.info(msg);
    }

    public static boolean isDeveloperMode()
    {
        return DeveloperMode;
    }

    public void setDeveloperMode(boolean DeveloperMode)
    {
        RSLogger.DeveloperMode = DeveloperMode;
    }

    public static String Version(){
        return version;
    }
}