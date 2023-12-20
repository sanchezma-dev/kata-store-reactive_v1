package reactive.search.app.searchApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactive.search.app.searchApp.model.Producto;
import reactive.search.app.searchApp.service.ProductoService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("rastreador")
public class ProductoController {

    // Servicio productoServiceImpl
    @Autowired
    private ProductoService service;


    @GetMapping("/buscarMarca")
    public ResponseEntity<Flux<Producto>> rastrearMarca() {
        return new ResponseEntity<>(service.findMarca("Nike"), HttpStatus.OK);
    }


}
