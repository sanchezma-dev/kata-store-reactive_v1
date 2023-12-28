package com.example.demo.controller;

import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

@Controller
public class ProductoInterfazController {

    /** Template */
    final private static String VISTA = "Bienvenido";

    /** Servicio Producto */
    @Autowired
    private ProductoService service;

    @GetMapping("/marca")
    public String buscarMarca(@RequestParam("marca") final String marca, final Model model) {
        IReactiveDataDriverContextVariable listado = new ReactiveDataDriverContextVariable(
                service.encontrarMarca(marca), 1);

        model.addAttribute("listaProducto", listado);
        return VISTA;
    }
}
