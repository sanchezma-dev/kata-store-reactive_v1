package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("interfaz")
public class ProductoInterfazController {

    /** Template */
    final private static String VISTA = "Bienvenido";

    /** Servicio Producto */
    @Autowired
    private ProductoService service;

    @GetMapping("")
    public String inicio(final Model model) {
        model.addAttribute("mostrarTabla", false);
        return VISTA;
    }
    @GetMapping(value = "/marca")
    public String buscarMarca(@RequestParam("marca") final String marca, final Model model) {
        // Clase proporcionada por Thymeleaf
        IReactiveDataDriverContextVariable listado = new ReactiveDataDriverContextVariable(
                service.encontrarMarca(marca), 1);

        model.addAttribute("mostrarTabla", true);
        model.addAttribute("listaProducto", listado);
        return VISTA;
    }

    @GetMapping(value = "/numero")
    public String buscarNumero(@RequestParam("numero") final int numero, final Model model) {
        // Clase proporcionada por Thymeleaf
        IReactiveDataDriverContextVariable listado = new ReactiveDataDriverContextVariable(
                service.encontrarNumero(numero), 1);

        model.addAttribute("mostrarTabla", true);
        model.addAttribute("listaProducto", listado);
        return VISTA;
    }

    @GetMapping(value = "/precioMax")
    public String buscarPrecioMax(@RequestParam("precio") final double precio, final Model model) {
        // Clase proporcionada por Thymeleaf
        IReactiveDataDriverContextVariable listado = new ReactiveDataDriverContextVariable(
                service.encontrarPorPrecioMax(precio), 1);

        model.addAttribute("mostrarTabla", true);
        model.addAttribute("listaProducto", listado);
        return VISTA;
    }
}
