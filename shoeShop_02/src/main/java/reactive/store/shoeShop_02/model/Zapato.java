package reactive.store.shoeShop_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Zapato {

    private int codigo;

    private String marca;

    private int numero;

    private double precioUnitario;

    private int stock;

}
