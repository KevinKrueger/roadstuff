package com.kevinkrueger.roadstuff.network;

import java.sql.Timestamp;

/**
 *
 */
public interface IConvertLoggerProtocolLine
{
    RSLogger.LoggerType getLoggerType();
    Timestamp getTimeStamp();
    Class<?> thisClass();
    String getMsg();
}
