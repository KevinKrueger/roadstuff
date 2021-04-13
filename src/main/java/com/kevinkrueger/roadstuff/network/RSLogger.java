package com.kevinkrueger.roadstuff.network;

import org.apache.logging.log4j.Logger;

import javax.management.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private final static String version = "1.4.5";

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
        protocol.AddDeviceProtocolLine(this.getClass(), Device.getDeviceMemory()); //First CPU and Memory usage Snapshot
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
        protocol.AddDeviceProtocolLine(this.getClass(), Device.getDeviceMemory());
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
        protocol.AddDeviceProtocolLine(this.getClass(), Device.getDeviceMemory());
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
        protocol.AddDeviceProtocolLine(this.getClass(),Device.getDeviceMemory());
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
        protocol.AddDeviceProtocolLine(this.getClass(), Device.getDeviceMemory());
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

    public static Timestamp getTimestamp()
    {
        return new Timestamp(new Date().getTime());
    }

    /**
     * Build a String that has the Logger Analysis data
     * @param thisClass Describes the class where the action is performed
     * @return Logger Analysis data(String)
     */
    public String LoggerAnalysis(Class<?> thisClass)
    {
        if(isDeveloperMode())
        {
            protocol.AddDeviceProtocolLine(this.getClass(), Device.getDeviceMemory());

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
    public void SaveLoggerProtocol(String file,Class<?> thisClass) throws Exception {
        if(isDeveloperMode())
        {
            protocol.SaveProtocol(protocol, file, thisClass);
        }else
            LOGGER.warn("Activate 'DeveloperMode' to get Logger Protocol!\";");
    }
}

/**
 * With the LoggerProtocol, you can create an Protocol from the Logger
 */
class LoggerProtocol
{
    private static List<LoggerProtocolLine> loggerProtocolLineList;
    private final List<DeviceLoggerProtocolLine> deviceLoggerProtocolLineList;

    public LoggerProtocol()
    {
        loggerProtocolLineList = new ArrayList<>();
        deviceLoggerProtocolLineList = new ArrayList<>();
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
        loggerProtocolLineList.add(
                new LoggerProtocolLine(
                        loggerType,
                        timestamp,
                        thisClass,
                        msg
                )
        );
    }

    /**
     * Adds the actual CPU & Memory usage to the List
     * @param thisClass Describes the class where the action is performed
     * @param deviceInfo
     */
    public void AddDeviceProtocolLine(Class<?> thisClass, DeviceInfo deviceInfo)
    {
        deviceLoggerProtocolLineList.add(new DeviceLoggerProtocolLine(thisClass, deviceInfo));
    }

    public LoggerProtocolLine ConvertToLoggerProtocolLine(IConvertLoggerProtocolLine cLPL)
    {
        return new LoggerProtocolLine(cLPL.getLoggerType(), cLPL.getTimeStamp(), cLPL.thisClass(), cLPL.getMsg());
    }

    /**
     * Saves the protocol in the desired location
     * @param file Describes the path where the file should be saved
     */
    public void SaveProtocol(LoggerProtocol protocol, String file, Class<?> thisClass) throws IOException {

        PrintWriter printWriter = new PrintWriter(new FileWriter(file));

        // Start Line
        printWriter.print("======= RSLogger Protocol from "+ RSLogger.getTimestamp().toLocalDateTime().toLocalDate()+" ======="+"\n");

        // Change Analyze Prosition in file under RSLogger
        MoveObjectToListIndex(loggerProtocolLineList, 0); // LoggerAnalysis
        CalculateAveragedMemoryACPU(protocol, thisClass, deviceLoggerProtocolLineList);
        MoveObjectToListIndex(loggerProtocolLineList, 1); // DeviceAnalysis

        // Write in File
        for (LoggerProtocolLine protocolLine : loggerProtocolLineList)
        {
            printWriter.print(protocolLine.buildLine()+"\n");
        }

        printWriter.close();
    }

    private static void CalculateAveragedMemoryACPU(LoggerProtocol protocol, Class<?> thisClass, List<DeviceLoggerProtocolLine> deviceLoggerProtocolLineList)
    {
        int listSize = deviceLoggerProtocolLineList.size();
        DeviceInfo average_memory_device = new DeviceInfo();

        for(DeviceLoggerProtocolLine deviceLine : deviceLoggerProtocolLineList)
        {
            average_memory_device.cpuLoad += deviceLine.deviceInfo.cpuLoad;
            average_memory_device.allocatedMemory += deviceLine.deviceInfo.allocatedMemory;
            average_memory_device.freeMemory += deviceLine.deviceInfo.freeMemory;
            average_memory_device.totalFreeMemory += deviceLine.deviceInfo.totalFreeMemory;
        }

        // Calculate Average
        average_memory_device.cpuLoad = average_memory_device.cpuLoad / listSize;
        average_memory_device.allocatedMemory = average_memory_device.allocatedMemory / listSize;
        average_memory_device.freeMemory = average_memory_device.freeMemory / listSize;
        average_memory_device.freeMemory = average_memory_device.freeMemory / listSize;

        DeviceLoggerProtocolLine deviceLine = new DeviceLoggerProtocolLine(thisClass, average_memory_device);
        loggerProtocolLineList.add(protocol.ConvertToLoggerProtocolLine(deviceLine));
    }

    private static void MoveObjectToListIndex(List<LoggerProtocolLine> list, int index)
    {
        LoggerProtocolLine item = list.get(list.size() - 1);
        list.remove(item);
        list.add(index, item);
    }
}

/**
 * Describes how a line should look in the protocol
 */
class LoggerProtocolLine
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
    public LoggerProtocolLine(RSLogger.LoggerType loggerType, Timestamp timestamp, Class<?> thisClass, String msg)
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

/**
 * Describes how a line should look in the protocol
 */
class DeviceLoggerProtocolLine implements IConvertLoggerProtocolLine
{
    public final RSLogger.LoggerType LoggerType = RSLogger.LoggerType.ANALYSES;
    public final Timestamp timestamp;
    public final Class<?> thisClass;
    public final DeviceInfo deviceInfo;

    /**
     * Initialize the ProtocolLine
     * @param thisClass Describes the class where the action is performed
     */
    public DeviceLoggerProtocolLine(Class<?> thisClass, DeviceInfo deviceInfo)
    {
        this.deviceInfo = deviceInfo;
        this.timestamp = RSLogger.getTimestamp();
        this.thisClass = thisClass;
    }

    @Override
    public RSLogger.LoggerType getLoggerType()
    {
        return LoggerType;
    }

    @Override
    public Timestamp getTimeStamp()
    {
        return timestamp;
    }

    @Override
    public Class<?> thisClass()
    {
        return thisClass;
    }

    @Override
    public String getMsg()
    {
        return getAverageCpuAMemoryUsage(deviceInfo);
    }

    public String getAverageCpuAMemoryUsage(DeviceInfo deviceInfo)
    {
        final String unit = "MB";
        final int precision = 1;

        return  "Ø Alloc. Mem.: " + roundDouble(deviceInfo.allocatedMemory, precision) + unit +
                ", Ø Free Mem.: " + roundDouble(deviceInfo.freeMemory,precision ) + unit +
                ", Ø Total Free Mem.: " + roundDouble(deviceInfo.totalFreeMemory, precision) + unit +
                ", Ø CPU Load: " + roundDouble(deviceInfo.cpuLoad,precision) +"%";
    }

    private static double roundDouble(double d, int places)
    {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
class DeviceInfo
{
    public double cpuLoad;
    public double maxMemory;
    public double allocatedMemory;
    public double freeMemory;
    public double totalFreeMemory;
}

class Device
{
    public static double getProcessCpuLoad() throws ReflectionException, InstanceNotFoundException, MalformedObjectNameException
    {
        MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
        ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });

        if (list.isEmpty())     return Double.NaN;

        Attribute att = (Attribute)list.get(0);
        Double value  = (Double)att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0)      return Double.NaN;
        // returns a percentage value with 1 decimal point precision
        return ((int)(value * 1000) / 10.0);
    }

    public static DeviceInfo getDeviceMemory()
    {
        final double toMB = Math.pow(10, -6);
        final Runtime runtime = Runtime.getRuntime();

        DeviceInfo deviceMemory= new DeviceInfo();
        deviceMemory.maxMemory = runtime.maxMemory() * toMB; // MB
        deviceMemory.allocatedMemory = runtime.totalMemory() * toMB;// MB
        deviceMemory.freeMemory = runtime.freeMemory() * toMB;// MB
        deviceMemory.totalFreeMemory = (deviceMemory.freeMemory + (deviceMemory.maxMemory - deviceMemory.allocatedMemory));
        try {
            deviceMemory.cpuLoad = getProcessCpuLoad();
        }catch (Exception ignored){}

        return deviceMemory;
    }
}