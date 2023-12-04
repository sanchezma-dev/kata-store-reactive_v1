package reactive.store.shoeShop_01.utils;

import reactive.store.shoeShop_01.model.Zapato;

import java.util.ArrayList;
import java.util.List;

public class ZapatosUtils {

    /**
     * Método encargado de proporcionar los datos de la tienda
     * @return lista de zapatos existentes
     */
    public static List<Zapato> generarDatosZapatos () {
        return List.of(
            new Zapato(1, "Nike", 42, 120, 2),
            new Zapato(2, "Nike", 40, 110.5, 1),
            new Zapato(3, "Puma", 41, 68.20, 12),
            new Zapato(4, "Adidas", 42, 100.5, 10),
            new Zapato(5, "Convert", 42, 189, 2),
            new Zapato(6, "Mizuno", 46, 160, 8)
        );
    }
}
