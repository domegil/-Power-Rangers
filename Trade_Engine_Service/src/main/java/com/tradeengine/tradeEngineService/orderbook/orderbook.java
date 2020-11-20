package com.tradeengine.tradeEngineService.orderbook;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class orderbook {

    @GetMapping("/marketdata")
    public Mono<marketDataModel[]> getMarketDataFromExchange() {
        Mono<marketDataModel[]> exchange = null;
        WebClient webclient = WebClient.create("http://localhost:8901");
        exchange = webclient.get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(marketDataModel[].class);
        return exchange;
    }


}
