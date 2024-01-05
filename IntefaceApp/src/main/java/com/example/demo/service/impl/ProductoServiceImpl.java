package com.example.demo.service.impl;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ProductoServiceImpl implements ProductoService {

    /** Url del servicio searchApp */
    @Value("${searchApp.address}")
    private String urlSearchApp;

    @Override
    public Flux<Producto> encontrarMarca(final String marca) {
        final WebClient webClient = WebClient.create(urlSearchApp);
        // TODO Podria construir la uri asi (urlSearchApp + "/buscarMarca?marca=" + marca)
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buscarMarca")
                        .queryParam("marca", marca)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class);
    }

    @Override
    public Flux<Producto> encontrarNumero(final int numero) {
        final WebClient webClient = WebClient.create(urlSearchApp);
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buscarNumero")
                        .queryParam("numero", numero)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class);

    }

    @Override
    public Flux<Producto> encontrarPorPrecioMax(final double precio) {
        final WebClient webClient = WebClient.create(urlSearchApp);
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/buscarPorPrecio")
                        .queryParam("precio", precio)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class);
    }
}
