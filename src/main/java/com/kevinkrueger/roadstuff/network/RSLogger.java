package com.kevinkrueger.roadstuff.network;

import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private static LoggerProtocol protocol;
    private static long startTime; // Start Execution Time
    private static int errorCount = 0, warningCount = 0, infoCount = 0; // Analysis
    private final static String version = "1.4.2";

    /**
     * Described the Type of the Log
     **/
    enum LoggerType
    {
        INFO,
        ERROR,
        WARN,
        DEBUG,
        DONE,
        ANALYSES
    };

    /**
     *  Initialize the RSLogger Class
     *  @param logger The Main-Instance from the log4j Logger
     *  @param DeveloperMode Describes whether the development mode releases additional features when switched on
     */
    public RSLogger(Logger logger, boolean DeveloperMode)
    {
        startTime = System.currentTimeMillis();
        setDeveloperMode(DeveloperMode);
        LOGGER = logger;
        protocol = new LoggerProtocol();
        protocol.AddProtocolLine(LoggerType.DEBUG, getTimestamp(),this.getClass(), "RSLogger Initialized");
    }

    /**
     * Show a info message in the Console
     * @param msg Show this Message in Console
     */
    public void log(Class<?> thisClass, String msg)
    {
        infoCount++;
        protocol.AddProtocolLine(LoggerType.INFO, getTimestamp(),thisClass, msg);
        if(isDeveloperMode())
          LOGGER.info(msg);
    }

    /**
     *  May only be used for try & catch or other queries where errors can be spit!
     *  => Development mode is not considered!
     *  @param thisClass Describes the class where the action is performed
     *  @param msg this Message in Console
     *  @param exception Spits out information in connection with the logger about the error
     */
    public void error(Class<?> thisClass, String msg, Exception exception)
    {
        errorCount++;

        String line = String.valueOf(exception.getStackTrace()[0].getLineNumber());
        String file = exception.getStackTrace()[0].getFileName();
        String ExceptionMessage = (msg == null ? "" : msg + " ") + "Exception in File: " + file + " in Line: " + line;

        protocol.AddProtocolLine(LoggerType.ERROR, getTimestamp(),thisClass, ExceptionMessage);
        LOGGER.error(ExceptionMessage , exception);
    }

    /**
     *  Show a warning message in the Console
     *  @param thisClass Describes the class where the action is performed
     *  @param msg this Message in Console
     */
    public void warning(Class<?> thisClass, String msg)
    {
        warningCount++;
        protocol.AddProtocolLine(LoggerType.WARN, getTimestamp(),thisClass, msg);
        if(isDeveloperMode())
            LOGGER.warn(msg);
    }

    /**
     *  Displays a completed operation as a message
     *  @param thisClass Describes the class where the action is performed
     *  @param msg this Message in Console
     */
    public void done(Class<?> thisClass, String msg)
    {
        infoCount++;
        protocol.AddProtocolLine(LoggerType.DONE, getTimestamp(),thisClass, msg);
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

    private static Timestamp getTimestamp()
    {
        return new Timestamp(new Date().getTime());
    }

    /**
     *
     * @param thisClass Describes the class where the action is performed
     * @return
     */
    public String LoggerAnalysis(Class<?> thisClass)
    {
        if(isDeveloperMode())
        {
            long endTime = System.currentTimeMillis();

            long elapsedTime =  endTime - startTime;
            long seconds = elapsedTime / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;

            String AnalysisMessage = String.format("Time: %02d:%02d:%02d", hours, minutes, seconds )+ ", Errors: " + errorCount + ", Warnings: " + warningCount+", Infos: " + infoCount;
            protocol.AddProtocolLine(LoggerType.ANALYSES, getTimestamp(),thisClass, AnalysisMessage);
            return AnalysisMessage;
        }
        else
            return "Activate 'DeveloperMode' to get Logger Analysis!";
    }

    /**
     * Saves the protocol in the desired location
     * @param file Describes the path where the file should be saved
     * @throws Exception If the file saving fails
     */
    public void SaveLoggerProtocol(String file) throws Exception {
        if(isDeveloperMode())
        {
            protocol.SaveProtocol(file);
        }else
            LOGGER.warn("Activate 'DeveloperMode' to get Logger Protocol!\";");
    }
}

class LoggerProtocol
{
    private static List<ProtocolLine> protocolLineList;

    public LoggerProtocol()
    {
        protocolLineList = new ArrayList<>();
    }

    /**
     * Adds a line to the protocol
     * @param loggerType Describes which type of log it is
     * @param timestamp Describes the current timestamp at lease time
     * @param thisClass Describes the class where the action is performed
     * @param msg Describes the information that can be seen in the protocol
     */
    public void AddProtocolLine(RSLogger.LoggerType loggerType, Timestamp timestamp,  Class<?> thisClass, String msg)
    {
        protocolLineList.add(
                new ProtocolLine(
                        loggerType,
                        timestamp,
                        thisClass,
                        msg
                )
        );
    }

    /**
     * Saves the protocol in the desired location
     * @param file Describes the path where the file should be saved
     */
    public void SaveProtocol(String file) throws IOException {

        PrintWriter printWriter = new PrintWriter(new FileWriter(file));

        // Start Line
        printWriter.print("======= RSLogger Protocol ======="+"\n");

        // Change Analyze Prosition in file under RSLogger
        ProtocolLine itemPos = protocolLineList.get(protocolLineList.size() - 1);
        protocolLineList.remove(itemPos);
        protocolLineList.add(0, itemPos );

        for (ProtocolLine protocolLine :  protocolLineList)
        {
            printWriter.print(protocolLine.buildLine()+"\n");
        }

        printWriter.close();
    }
}

/**
 * Describes how a line should look in the protocol
 */
class ProtocolLine
{
    private final RSLogger.LoggerType LoggerType;
    private final Timestamp timestamp;
    private final Class<?> thisClass;
    private final String Msg;

    /**
     * Initialize the ProtocolLine
     * @param loggerType Describes which type of log it is
     * @param timestamp Describes the current timestamp at lease time
     * @param thisClass Describes the class where the action is performed
     * @param msg Describes the information that can be seen in the protocol
     */
    public ProtocolLine(RSLogger.LoggerType loggerType, Timestamp timestamp, Class<?> thisClass, String msg)
    {
            this.LoggerType = loggerType;
            this.timestamp = timestamp;
            this.thisClass = thisClass;
            this.Msg = msg;
    }

    /**
     * Combines the individual snippets of information
     * @return Formatted protocol line
     */
    public String buildLine()
    {
        return "["+LoggerType.name()+"]"+
                "["+timestamp+"]"+
                "["+thisClass.getSimpleName()+"]"+
                ": " + Msg;
    }
}