package com.pubSubTry.pubSubdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;


public class ReportService {

    List<String> storeReport = new ArrayList<>();
    Jedis msg = new Jedis("localhost");

    public void subscriberFun() {
        msg.subscribe(new JedisPubSub() {
                          @Override
                          public void onMessage(String channel, String message) {

                              storeReport.add(message);
                              for (String a : storeReport) {
                                  System.out.println(a);
                              }
                              //System.out.println(message);

                          }
                      }, "client"
        );
    }

    public String sendAllReport() {
        return "";
    }
}
