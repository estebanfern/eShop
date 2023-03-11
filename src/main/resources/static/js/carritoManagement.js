$(document).ready(function(){
    getProductos();
    calcularCantidad();
});

let PRODUCTOS = {};


let guarani = Intl.NumberFormat('es-PY', { style: 'currency', currency: 'PYG' });

class Producto {
    constructor(id, nombre, descripcion, precioUnitarioFormatted, imagen, cantidad, existencia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitarioFormatted = precioUnitarioFormatted;
        this.precioCantidadFormatted = precioUnitarioFormatted;
        this.cantidad = cantidad;
        this.existencia = existencia;
        this.precio = Producto.formatPrice(this.precioCantidadFormatted); //Precio entero
        this.imagen = imagen

    };

    static formatPrice(precioProducto) {
        // console.log(precioProducto)
        precioProducto = precioProducto.substring(4, precioProducto.length); //Sin el Gs.
        precioProducto = precioProducto.replaceAll(".", ""); //Sin los puntos
        // console.log(precioProducto)
        precioProducto = parseInt(precioProducto); //A entero
        // console.log("Precio*Cantidad:"+(precioProducto * this.cantidad))
        return precioProducto;
    }

}


function addProduct(id){
    //console.log(carrito.innerHTML)
    
    
    
    let nombreProducto = document.getElementById('productoName' + id).innerHTML;
    let descripcionProducto = document.getElementById('productoDesc' + id).innerHTML;
    let precioProducto = document.getElementById('productoPrecio' + id).innerHTML;
    let imageProducto = document.getElementById('productoImage' + id).src;
    let existenciaProducto = document.getElementById('productoExistencia' + id).innerHTML;

    if (id in PRODUCTOS) { //Si el producto ya esta en el carrito
        $("#warningAlert").show();
        setTimeout(function(){
            $("#warningAlert").hide(); 
        }, 2000);
        return;
    }
    
    
    PRODUCTOS[id] = (new Producto(id, nombreProducto, descripcionProducto, precioProducto, imageProducto, 1, existenciaProducto));
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
    
    $("#succesAlert").show();
    setTimeout(function(){
        $("#succesAlert").hide(); 
    }, 2000);
    calcularCantidad();
    return;
}

function getProductos(){
    console.log("getProductos() carrito");
    let localJson = localStorage.getItem("productosCarrito");
    PRODUCTOS = JSON.parse(localJson);
}

function calcularTotal(){
    let total = 0;
    for(var key in PRODUCTOS) {
        var producto = PRODUCTOS[key];
        total = total + producto.precio;
    };
    return guarani.format(total);
}

function changeCantidadProducto(input, inputElement){
    let producto = PRODUCTOS[input]; //Obtiene el producto
    producto.cantidad = inputElement.value; //Actualiza la cantidad
    producto.precio = Producto.formatPrice(producto.precioUnitarioFormatted) * producto.cantidad; //Actualiza el precio
    producto.precioCantidadFormatted = guarani.format(producto.precio); //Actualiza el precio formateado
    PRODUCTOS[input] = producto; //Actualiza el producto
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
    return producto.precioCantidadFormatted;
}

function calcularCantidad(){
    let carritoIcon = document.getElementById('carritoIcon');
    let cantidad = 0;
    for(var key in PRODUCTOS) {
        var producto = PRODUCTOS[key];
        cantidad = cantidad + parseInt(producto.cantidad);
    };

    if (cantidad == 0) {   
        carritoIcon.innerHTML = "";
        return 0;
    }

    carritoIcon.innerHTML = cantidad;
    return cantidad;
}

function deleteItem(id){
    delete PRODUCTOS[id];
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
}