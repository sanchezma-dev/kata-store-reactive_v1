[Imagen spring reactor]
### Proyecto sencillo del uso de la programación reactiva de spring

Dependencias spring webFlux (Spring Reactive Web) y lombok para facilitar el desarrollo y la información de logs. Además de Thymeleaf para la capa visual.
Importante el uso de stream para evitar ser bloqueante en la lógica de negocio.

Implementación del cliente WebClient que invoca la url del servicio a gestionar.

Lógica de negocio:
  - La lógica es sencilla, dos API Rest (shoeShop_01, shoeShop_02) que exponen los endpoints de crear, listar (varios filtros) y eliminar elementos.
  - Servicio rest (searchApp) encargada de hacer peticiones a ambas (shoeShop_01 y shoeShop_02) que através de `Flux.merge` cruza los datos y filtra. 
    Es realmente el servicio con mayor importancia, ya que manipula los Flux de datos y filtra los buscado.
  - Finalmente, para exponer visualmente el negocio, se llama a la aplicación (InterfaceApp) encargada de la visualización.
    Es una capa sencilla, con botones para realizar las búsqueda y la exposición de la tabla de resultados, en la que se va construyendo a medida que llegan los datos (con retardos).

