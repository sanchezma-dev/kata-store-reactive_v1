package com.example.demo.service.impl;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class ProductoServiceImpl implements ProductoService {

    /** Url del servicio searchApp */
    @Value("${searchApp.address}")
    private String urlSearchApp;

    @Override
    public Flux<Producto> encontrarMarca(final String marca) {
        final WebClient webClient = WebClient.create(urlSearchApp);
        // FIXME Probar la url así (urlSearchApp +"/" +marca")
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(urlSearchApp)
                        .queryParam("marca", marca)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class);
    }

    @Override
    public Flux<Producto> encontrarNumero(int numero) {
        return null;
    }

    @Override
    public Flux<Producto> buscarPorPrecioMax(double precio) {
        return null;
    }
}
