package reactive.store.shoeShop_02.service;

import reactive.store.shoeShop_02.model.Zapato;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ZapatosService {

    /**
     * Obtiene un flujo de todos los zapatos disponibles.
     *
     * @return Un flujo de objetos Zapato.
     */
    public Flux<Zapato> listarTodos();

    /**
     * Filtra y devuelve un Mono de zapato por su código.
     *
     * @param codigo El código del zapato a filtrar.
     * @return Un mono que puede contener un objeto Zapato o estar vacío.
     */
    public Mono<Zapato> filtrarPorCodigo(final int codigo);

    /**
     * Filtra y devuelve un flujo de zapatos por su número.
     *
     * @param numero El número de zapato a filtrar.
     * @return Un flujo de objetos Zapato que coinciden con el número proporcionado.
     */
    public Flux<Zapato> filtrarPorNumero(final int numero);

    /**
     * Filtra y devuelve un flujo de zapatos por su marca.
     *
     * @param marca La marca de zapato a filtrar.
     * @return Un flujo de objetos Zapato que coinciden con la marca proporcionada.
     */
    public Flux<Zapato> filtrarPorMarca(final String marca);

    /**
     * Registra un nuevo zapato.
     *
     * @param zapato El objeto Zapato a dar de alta.
     * @return Un mono void
     */
    public Mono<Void> altaZapato(final Zapato zapato);

    /**
     * Elimina un zapato por su código.
     *
     * @param codigo El código del zapato a eliminar.
     * @return Un mono que puede contener el objeto Zapato eliminado o estar vacío.
     */
    public Mono<Zapato> eliminarZapato(final int codigo);

    /**
     * Actualiza el precio de un zapato por su código.
     *
     * @param cod    El código del zapato a actualizar.
     * @param precio El nuevo precio del zapato.
     * @return Un mono que puede contener el objeto Zapato actualizado o estar vacío.
     */
    public Mono<Zapato> actualizarPrecio(final int cod, final double precio);

}
