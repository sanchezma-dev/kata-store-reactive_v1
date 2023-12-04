package reactive.store.shoeShop_01.service;

import reactive.store.shoeShop_01.model.Zapato;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ZapatosService {

     public Flux<Zapato> listarTodos();

     public Flux<Zapato> filtrarPorNumero(final int numero);

     public Flux<Zapato> filtrarPorMarca(final String marca);

     public Mono<Void> altaZapato (final Zapato zapato);

     public Mono<Zapato> eliminarZapato (final int codigo);

     public Mono<Zapato> actualizarPrecio(final int cod, final double precio);




}
