package com.kevinkrueger.roadstuff.network;

import com.kevinkrueger.roadstuff.RoadStuff;


/*
* Use: Development
* */
public interface ILogger
{
    static RSLogger LOGGER = new RSLogger(RoadStuff.LOGGER, RSLogger.isDeveloperMode());
}
