package com.pubSubTry.pubSubdemo;

import redis.clients.jedis.Jedis;

import java.util.concurrent.Callable;

public class ReportPublisher {

    public static void sendReportMsg(String channel, String message){
        Jedis msg = new Jedis("localhost");
         msg.publish(channel,message);
    }
}
