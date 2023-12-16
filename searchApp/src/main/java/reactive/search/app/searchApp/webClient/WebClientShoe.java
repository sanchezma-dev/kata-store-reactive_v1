package reactive.search.app.searchApp.webClient;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactive.search.app.searchApp.model.Producto;
import reactor.core.publisher.Flux;

public class WebClientShoe {

    //FIXME Añadir javadoc
    public static Flux<Producto> webClientFindMarca(final String url, final String tienda) {
        final WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri("/findByMarca")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class)
                .map(p -> {
                    p.setTienda(tienda);
                    return p;
                });
    }

    //FIXME Añadir javadoc
    public static Flux<Producto> webClientFindNumero(final String url, final String tienda) {
        final WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri("/findByNumero")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class)
                .map(p -> {
                    p.setTienda(tienda);
                    return p;
                });
    }

    //FIXME Añadir javadoc
    public static Flux<Producto> webClientFindZapato(final String url, final String tienda) {
        final WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri("/listar")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class)
                .map(p -> {
                    p.setTienda(tienda);
                    return p;
                });
    }

}
