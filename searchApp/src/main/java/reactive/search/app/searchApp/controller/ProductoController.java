package reactive.search.app.searchApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Flux<Producto>> rastrearMarca(@RequestParam("marca") final String marca) {
        return new ResponseEntity<>(service.findMarca(marca), HttpStatus.OK);
    }

    @GetMapping("/buscarNumero")
    public ResponseEntity<Flux<Producto>> rastrearNumero(@RequestParam("numero") final int numero) {
        return new ResponseEntity<>(service.findNumero(numero), HttpStatus.OK);
    }

    @GetMapping("/buscarPorPrecio")
    public ResponseEntity<Flux<Producto>> rastrearPrecio(@RequestParam("precio") final double precio) {
        return new ResponseEntity<>(service.findPrecioMax(precio), HttpStatus.OK);
    }
}
