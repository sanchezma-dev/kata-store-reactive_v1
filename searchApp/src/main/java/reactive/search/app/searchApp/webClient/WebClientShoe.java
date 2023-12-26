package reactive.search.app.searchApp.webClient;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactive.search.app.searchApp.model.Producto;
import reactor.core.publisher.Flux;

@Component
public class WebClientShoe {

    // Constante buscar por Marca
    private final static String FIND_MARCA = "/findByMarca";

    // Constante buscar por Numero
    private final static String FIND_NUMERO = "/findByNumero";

    // Constante listar zapatos
    private final static String LISTAR_ZAPATOS = "/listar";

    /**
     * Preparación del cliente webClient para acceder a el metodo de encontrar marca
     * @param url dirección del api rest
     * @param tienda tienda
     * @param marca marca del zapato
     * @return flux tipo Producto
     */
    public static Flux<Producto> webClientFindMarca(final String url, final String tienda, final String marca) {
        final WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(FIND_MARCA)
                        .queryParam("marca", marca)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class)
                .map(p -> {
                    p.setTienda(tienda);
                    return p;
                });
    }

    /**
     * Preparación del cliente webClient para acceder a el metodo de encontrar zapato por numero
     * @param url dirección del api rest
     * @param tienda tienda
     * @param numero número de zapato
     * @return flux tipo Producto
     */
    public static Flux<Producto> webClientFindNumero(final String url, final String tienda, final int numero) {
        final WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(FIND_NUMERO)
                        .queryParam("numero", numero)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class)
                .map(p -> {
                    p.setTienda(tienda);
                    return p;
                });
    }

    /**
     * Preparación del cliente webClient para acceder a el metodo de listar zapatos
     * @param url dirección del api rest
     * @param tienda tienda
     * @return flux tipo Producto
     */
    public static Flux<Producto> webClientListar(final String url, final String tienda) {
        final WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri(LISTAR_ZAPATOS)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class)
                .map(p -> {
                    p.setTienda(tienda);
                    return p;
                });
    }

}
