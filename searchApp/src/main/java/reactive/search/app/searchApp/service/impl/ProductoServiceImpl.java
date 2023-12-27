package reactive.search.app.searchApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactive.search.app.searchApp.model.Producto;
import reactive.search.app.searchApp.service.ProductoService;
import reactive.search.app.searchApp.webClient.WebClientShoe;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductoServiceImpl implements ProductoService {

    // URL shoeShop_01
    @Value("${shoe1.address}")
    private String urlShoe_01;

    // URL shoeShop_02
    @Value("${shoe2.address}")
    private String urlShoe_02;

    // Servicio WebClientShoe
    @Autowired
    private WebClientShoe webClientService;

    @Override
    public Flux<Producto> findMarca(final String marca) {
        // Flux de shoe1 y shoe2

        final Flux<Producto> fluxMarca_01 = webClientService.webClientFindMarca(urlShoe_01, "tienda zapatos 01", marca);
        final Flux<Producto> fluxMarca_02 = webClientService.webClientFindMarca(urlShoe_02, "tienda zapatos 02", marca);

        return Flux.merge(fluxMarca_01, fluxMarca_02)
                .delayElements(Duration.ofSeconds(1));
    }

    @Override
    public Flux<Producto> findNumero(final int numero) {
        // Flux de shoe1 y shoe2

        final Flux<Producto> fluxNumero_01 = webClientService.webClientFindNumero(urlShoe_01, "tienda zapatos 01", numero);
        final Flux<Producto> fluxNumero_02 = webClientService.webClientFindNumero(urlShoe_02, "tienda zapatos 02", numero);

        return Flux.merge(fluxNumero_01, fluxNumero_02)
                .delayElements(Duration.ofSeconds(1));
    }


    @Override
    public Flux<Producto> findPrecioMax(final double precio) {
        // Flux de shoe1 y shoe2
        final Flux<Producto> fluxNumero_01 = webClientService.webClientListar(urlShoe_01, "tienda zapatos 01");
        final Flux<Producto> fluxNumero_02 = webClientService.webClientListar(urlShoe_02, "tienda zapatos 02");

        return Flux.merge(fluxNumero_01, fluxNumero_02)
                .filter(p -> p.getPrecioUnitario() >= precio)
                .delayElements(Duration.ofSeconds(1));
    }
}
