package reactive.store.shoeShop_02.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactive.store.shoeShop_02.model.Zapato;
import reactive.store.shoeShop_02.service.ZapatosService;
import reactive.store.shoeShop_02.utils.ZapatosUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Slf4j //Lo proporciona la libreria de lombok
@Service
public class ZapatosServiceImpl implements ZapatosService {

    // Datos de la zapateria
    private final List<Zapato> zapatosBD = ZapatosUtils.generarDatosZapatos();

    @Override
    public Flux<Zapato> listarTodos() {
        log.info("Entrando en el ZapatosServiceImpl.listarTodos del API shoeShop_02");
        return Flux.fromIterable(zapatosBD) //devuelve el flux de zapatos
                .delayElements(Duration.ofMillis(1000)); // Retrasa la llamada a cada elemento por los milisegundos dados
    }

    @Override
    public Mono<Zapato> filtrarPorCodigo(int codigo) {
        log.info("Entrando en el ZapatosServiceImpl.filtrarPorCodigo del API shoeShop_02");
        return listarTodos() // (Flux) Recupera todos y filtra por código
                .filter(e -> e.getCodigo() == codigo)
                .next();// (Mono) Toma el primer elemento del Flux
    }

    @Override
    public Flux<Zapato> filtrarPorNumero(int numero) {
        log.info("Entrando en el ZapatosServiceImpl.filtrarPorNumero del API shoeShop_02");
        return listarTodos() // Llamada al método listarTodos de esta clase
                .filter(e -> e.getNumero() == numero); //solo devuelve los que coincidan con el numero dado
    }

    @Override
    public Flux<Zapato> filtrarPorMarca(String marca) {
        log.info("Entrando en el ZapatosServiceImpl.filtrarPorMarca del API shoeShop_02");
        return listarTodos() // Llamada al método listarTodos de esta clase
                .filter(e -> marca.equals(e.getMarca())); //solo devuelve los zapatos de la marca dada
    }

    @Override
    public Mono<Void> altaZapato(Zapato zapato) {
        log.info("Entrando en el ZapatosServiceImpl.altaZapato del API shoeShop_02");
        // Validacion que el codigo no exista
        if (noExiste(zapato.getCodigo())) {
            // Guardado datos
            return Mono.fromSupplier(() -> {
                zapatosBD.add(zapato);
                return zapato;
            }).then(); // Devuelve el Mono guardado
        } else {
            return Mono.empty().then(); // Devuelve un Mono vacio
        }
    }

    @Override
    public Mono<Zapato> eliminarZapato(int codigo) {
        log.info("Entrando en el ZapatosServiceImpl.eliminarZapato del API shoeShop_02");
        return Mono.defer( () -> { //Mono.defer(() -> {...}) esto permite diferir las operaciones
            Zapato zapatoEliminado = zapatosBD.stream() //Zapato existente con ese codigo
                    .filter(e -> e.getCodigo() == codigo)
                    .findFirst() //devuelve el primero
                    .orElse(null); //null en caso que no encuentre

            if (zapatoEliminado != null) {
                zapatosBD.remove(zapatoEliminado);
                return Mono.just(zapatoEliminado); //Suscripcion al Mono y devuelve el zapatoEliminado en Mono
            } else {
                return Mono.empty(); //Return Mono vacio
            }
        });
    }

    @Override
    public Mono<Zapato> actualizarPrecio(int cod, double precio) {
        log.info("Entrando en el ZapatosServiceImpl.actualizarPrecio del API shoeShop_02");
        return filtrarPorCodigo(cod)
                .map (e -> {
                    e.setPrecioUnitario(precio);
                    return e;
                });
    }

    // Metodos privados

    /**
     * Devuelve verdadero no hay ningun zapato con ese codigo, falso en caso contrario
     * @param codigo
     * @return true o false
     */
    private boolean noExiste(final int codigo) {
        return zapatosBD.stream().noneMatch(e -> e.getCodigo() == codigo);
    }
}
