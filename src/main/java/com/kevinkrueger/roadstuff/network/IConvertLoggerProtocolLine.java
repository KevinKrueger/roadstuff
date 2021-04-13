package com.kevinkrueger.roadstuff.network;

import java.sql.Timestamp;

/**
 *  This is for new Protocol Line Types (For Converting Later into ProtocolLine)
 */
public interface IConvertLoggerProtocolLine
{
    RSLogger.LoggerType getLoggerType();
    Timestamp getTimeStamp();
    Class<?> thisClass();
    String getMsg();
}
