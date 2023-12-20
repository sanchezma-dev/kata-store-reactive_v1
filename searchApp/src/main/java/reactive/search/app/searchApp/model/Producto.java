package reactive.search.app.searchApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {

    // TODO: Los atributos deben ser los mismos que Zapato para mantener la correspondencia
    private String marca;

    private int numero;

    private double precioUnitario;

    private String tienda;
}
