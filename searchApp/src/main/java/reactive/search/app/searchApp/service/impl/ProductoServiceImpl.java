package reactive.search.app.searchApp.service.impl;

import reactive.search.app.searchApp.model.Producto;
import reactive.search.app.searchApp.service.ProductoService;
import reactor.core.publisher.Flux;

public class ProductoServiceImpl implements ProductoService {

    @Override
    public Flux<Producto> findMarca(String marca) {
        return null;
    }

    @Override
    public Flux<Producto> findNumero(int numero) {
        return null;
    }

    @Override
    public Flux<Producto> findPrecioMax(double precio) {
        return null;
    }
}
