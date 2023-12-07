package reactive.store.shoeShop_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactive.store.shoeShop_01.model.Zapato;
import reactive.store.shoeShop_01.service.ZapatosService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("shoeShop01")
public class ZapatosController {

    // Servicio ZapatosService
    @Autowired
    private ZapatosService service;

    // Listar zapatos
    @GetMapping("/listar")
    public ResponseEntity<Flux<Zapato>> listar() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    // Buscar por codigo
    @GetMapping("/findByCodigo")
    public ResponseEntity<Mono<Zapato>> findByCodigo (@PathVariable("codigo") final int codigo) {
        return new ResponseEntity<Mono<Zapato>>(service.filtrarPorCodigo(codigo), HttpStatus.OK);
    }

    // Buscar por numero
    @GetMapping("/findByNumero")
    public ResponseEntity<Flux<Zapato>> findByNumero (@RequestParam("numero") final int numero) {
        return new ResponseEntity<Flux<Zapato>>(service.filtrarPorNumero(numero), HttpStatus.OK);
    }

    // Buscar por marca
    @GetMapping("/findByMarca")
    public ResponseEntity<Flux<Zapato>> findByMarca (@RequestParam("marca") final String marca) {
        return new ResponseEntity<Flux<Zapato>>(service.filtrarPorMarca(marca), HttpStatus.OK);
    }

    // Alta de zapato
    @PostMapping(value = "/altaZapato", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Void>> altaZapato (@RequestBody final Zapato zapato) {
        return new ResponseEntity<Mono<Void>>(service.altaZapato(zapato), HttpStatus.OK);
    }

    // Eliminar zapato
    @DeleteMapping("/eliminarZapato")
    // La salida es diferente, retorna un Mono de ResponseEntity
    public Mono<ResponseEntity<Zapato>> eliminarZapato(@RequestParam("codigo") final int codigo){
        return service.eliminarZapato(codigo)
                //flatMap para transformar Mono<Zapato> en Mono<ResponseEntity<Zapato>>
                .flatMap(e -> Mono.just(new ResponseEntity<>(e, HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
