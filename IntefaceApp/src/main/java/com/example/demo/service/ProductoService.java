package com.example.demo.service;

import com.example.demo.model.Producto;
import reactor.core.publisher.Flux;

public interface ProductoService {

    /**
     * Método encargado de buscar por la marca de una zapato
     * @param marca marca de zapato
     * @return lista Flux
     */
    public Flux<Producto> encontrarMarca(final String marca);

    /**
     * Encuentra zapatos que coincidan con el número dado
     * @param numero número de pie
     * @return lista Flux
     */
    public Flux<Producto> encontrarNumero(final int numero);

    /**
     * Encuentra los zapatos por debajo o igual al precio dado
     * @param precio precio unitario del zapto
     * @return lista Flux
     */
    public Flux<Producto> buscarPorPrecioMax(final double precio);
}
