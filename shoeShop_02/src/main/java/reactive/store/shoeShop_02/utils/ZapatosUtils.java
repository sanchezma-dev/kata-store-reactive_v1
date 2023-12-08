package reactive.store.shoeShop_02.utils;

import reactive.store.shoeShop_02.model.Zapato;

import java.util.List;

public class ZapatosUtils {

    /**
     * Método encargado de proporcionar los datos de la tienda
     * @return lista de zapatos existentes
     */
    public static List<Zapato> generarDatosZapatos () {
        return List.of(
                new Zapato(1, "Hoka One One", 44, 156, 4),
                new Zapato(2, "Adidas", 40, 140.5, 4),
                new Zapato(3, "Puma", 41, 79.99, 2),
                new Zapato(4, "Asics", 45, 135.5, 2),
                new Zapato(5, "Adidas", 42, 189, 2),
                new Zapato(6, "Asics", 40, 100, 1),
                new Zapato(7, "Nike", 41, 268, 2),
                new Zapato(8, "Adidas", 39, 130.5, 1),
                new Zapato(9, "Convert", 40, 79, 2),
                new Zapato(10, "Joma", 40, 66, 2)
        );
    }
}
