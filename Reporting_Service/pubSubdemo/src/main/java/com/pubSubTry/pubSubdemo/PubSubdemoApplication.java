package com.pubSubTry.pubSubdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PubSubdemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(PubSubdemoApplication.class, args);
		ReportService reportServiceController = new ReportService();
		reportServiceController.subscriberFun();
		ReportPublisher.sendReportMsg("order",reportServiceController.sendAllReport());
	}
}
