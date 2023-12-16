package reactive.search.app.searchApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {

    private String marca;

    private int numero;

    private double precio;

    private String tienda;
}
