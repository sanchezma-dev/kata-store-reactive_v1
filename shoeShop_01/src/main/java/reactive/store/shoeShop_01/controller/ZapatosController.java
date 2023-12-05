package reactive.store.shoeShop_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactive.store.shoeShop_01.model.Zapato;
import reactive.store.shoeShop_01.service.ZapatosService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("shoeShop01")
public class ZapatosController {

    // Servicio ZapatosService
    @Autowired
    private ZapatosService service;

    @GetMapping("/listar")
    public ResponseEntity<Flux<Zapato>> listar() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }




}
