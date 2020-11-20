package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExchangeConnectivityController {

//    String url1 = "https://exchange.matraining.com";
//    String url2 = "https://exchange2.matraining.com";
    @GetMapping("/md")
    public Mono<MarketDataModel[]> getMarketData(){
        Mono<MarketDataModel[]> exchange = null;
        WebClient webclient = WebClient.create("https://exchange.matraining.com");
         exchange = webclient.get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(MarketDataModel[].class);


        return exchange;
    }
    @GetMapping("/md2")
    public Mono<MarketDataModel[]> getMarketData2(){
        Mono<MarketDataModel[]> exchange = null;
        WebClient webclient = WebClient.create("https://exchange2.matraining.com");
        exchange = webclient.get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(MarketDataModel[]

                        .class);


        return exchange;
    }
    
}
