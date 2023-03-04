<h1 style="text-align: center;">eShop</h1>

<p align="center">
    <img src="https://img.shields.io/static/v1?label=dev&message=Mijhael Samaniego&color=red&style=for-the-badge&logo=Moo&logoColor=red&link=https://github.com/seb5433//left?">
    <img src="https://img.shields.io/static/v1?label=dev&message=Sebastian Alvarez&color=informational&style=for-the-badge&logo=Bitwarden&logoColor=informational&link=https://github.com/seb5433//left?">
    <img src="https://img.shields.io/static/v1?label=dev&message=Esteban Fernandez&color=red&style=for-the-badge&logo=AdGuard&logoColor=red&link=https://github.com/seb5433//left?">
    <img src="https://img.shields.io/static/v1?label=Actual version&message=V0&color=green&style=for-the-badge&logo=Astro&logoColor=green">
</p>

<h5 align="center" style="margin: 0 auto 0 auto;">Sistema de eShop con Springboot</h5>

## ⚡ Features 
- 👥 Administración de Usuarios.
- 👥 Administración de Clientes.
- 📦 Administración de Inventario.
- 📦 Administración de Pedidos.
- 📍  Administración de entregas.
- 📊 Visualización de Reportes.
- ⚡ User Friendly.
> ----

## Flujo de creación de pedido
1. Vendedor o Admin agregan productos al Carrito.
    - Se puede agregar desde la tabla productos o desde el detalle del producto.
1. Vendedor entra a la vista Carrito.
    - En la vista carrito se pueden editar los productos, eliminarlos o agregar nuevos.
    - Se puede ver el total del carrito y la cantidad de productos.
1. Vendedor carga los datos de entrega y cliente.
1. Vendedor da click en cargar pedido dentro de vista carrito.
    - Se verifica que el carrito tenga productos.
    - Se verifica que existan la cantidad de productos en el inventario.
    - Si se cumple se crea el pedido y se actualiza el inventario.
3. El vendedor pedidos puede ver sus pedidos completados, pendientes,  rechazados.


## 📝 TODO LIST

- [ ] Mejorar la tabla de productos
    - [ ] Agregar al final la opción para:
        - [ ] Eliminar.
        - [ ] Editar
        - [ ] Ver producto(detalles del producto).
        - [ ] Agregar al carrito.
    - [x] Buscador
    - [ ] Filtrar
    - [ ] ordenar
    - [x] paginar

- [ ] Form Detalles del producto (Este form será utilizado para ver, editar y cargar un nuevo producto)
    - [ ] Nombre del producto
    - [ ] Descripción
    - [ ] Precio
    - [ ] Imagen
    - [ ] Cantidad de existencia
    
- [ ] Vista Carrito
    - [ ] Agregar productos al carrito.
    - [ ] Eliminar productos del carrito.
    - [ ] Ver productos del carrito.
    - [ ] Ver total del carrito.
    - [ ] Ver total de productos del carrito.
    - [ ] Cargar el carrito a un pedido.

- [ ] Vista Detalle Pedidos
    - [ ] Ver los detalles del pedido.
        - [ ] Ver el estado del pedido.
        - [ ] Ver el total del pedido.
        - [ ] Ver la cantidad de productos del pedido.
        - [ ] Ver los productos del pedido.
        - [ ] Ver el cliente del pedido.
        - [ ] Ver la fecha de creación del pedido.
    - [ ] Editar datos de entrega del pedido.
    - [ ] Editar datos del pedido. (SOLO ADMIN)
    - [ ] Eliminar pedido. (SOLO ADMIN)


- [ ] Agregar limitaciones
    - [ ] Los vendedores no pueden ver los pedidos de los demás vendedores.
    - [ ] No se puede hacer un POST con uno de los campos del FORM sin completar.
