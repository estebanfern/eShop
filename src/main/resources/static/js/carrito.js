let PRODUCTOS = [];

let guarani = Intl.NumberFormat('es-PY', { style: 'currency', currency: 'PYG' });

class Producto {
    constructor(id, nombre, descripcion, precioFormatted, imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioFormatted = precioFormatted;
        this.precio = Producto.formatPrice(this.precioFormatted); //Precio entero
        this.imagen = imagen

    };

    static formatPrice(precioProducto) {
        console.log(precioProducto)
        precioProducto = precioProducto.substring(4, precioProducto.length); //Sin el Gs.
        precioProducto = precioProducto.replaceAll(".", ""); //Sin los puntos
        console.log(precioProducto)
        precioProducto = parseInt(precioProducto); //A entero
        return precioProducto;
    }
}


function addProduct(id){
    let carrito = document.getElementById('carritoBody');
    let success = document.getElementById('alert-success');
    //console.log(carrito.innerHTML)


    if (carrito.innerHTML.includes("cargado productos")) {//Si el carrito esta vacio
        carrito.innerHTML = "";
        carrito.className = "modal-body";
    }

    let nombreProducto = document.getElementById('productoName' + id).innerHTML;
    let descripcionProducto = document.getElementById('productoDesc' + id).innerHTML;
    let precioProducto = document.getElementById('productoPrecio' + id).innerHTML;

    PRODUCTOS.push(new Producto(id, nombreProducto, descripcionProducto, precioProducto, "https://i.pinimg.com/564x/1d/89/53/1d8953b382f9fffca27523a86cff36b9.jpg"));
    console.log(PRODUCTOS);
    calcularTotal();
    calcularCantidad();

    let dom = "<div class=\"row p-2 bg-white border rounded\">" +
                "<div class=\"col-md-3 mt-1\"><img class=\"img-fluid img-responsive rounded product-image\" src=\"https://i.pinimg.com/564x/1d/89/53/1d8953b382f9fffca27523a86cff36b9.jpg\"></div> " +
                "<div class=\"col-md-6 mt-1\">" +
                "<h5>" + nombreProducto + "</h5>" +
                "<p class=\"text-justify text-truncate para mb-0\">"+ descripcionProducto + "<br><br></p>" +
                "</div>" +
                "<div class=\"align-items-center align-content-center col-md-3 border-left mt-1\">"+
                "<div class=\"d-flex flex-row align-items-center\">" +
                "<h6 class=\"sm-1\">" + precioProducto + "</h6>" + 
                "</div>";
    
    carrito.innerHTML = carrito.innerHTML + dom;
    $(".myAlert-bottom").show();
    setTimeout(function(){
      $(".myAlert-bottom").hide(); 
    }, 2000);
    return;
}

function calcularTotal(){
    let precioTotal = document.getElementById('precioTotal');
    let total = 0;
    PRODUCTOS.forEach(producto => {
        total += producto.precio;
    });
    precioTotal.innerHTML = "Total: " + guarani.format(total);
}

function calcularCantidad(){
    let cantidadProductos = document.getElementById('cantidadProductos');
    cantidadProductos.innerHTML = "Cant. Productos: " + PRODUCTOS.length;
}

