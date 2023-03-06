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
    let success = document.getElementById('alert-success');
    //console.log(carrito.innerHTML)
    
    
    
    let nombreProducto = document.getElementById('productoName' + id).innerHTML;
    let descripcionProducto = document.getElementById('productoDesc' + id).innerHTML;
    let precioProducto = document.getElementById('productoPrecio' + id).innerHTML;
    let imageProducto = document.getElementById('productoImage' + id).src;
    console.log(imageProducto)
    PRODUCTOS.push(new Producto(id, nombreProducto, descripcionProducto, precioProducto, imageProducto));
    console.log(PRODUCTOS);
    
    
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
    
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

function openCarrito (){
    let carrito = document.getElementById('carritoBody');
    let localJson = localStorage.getItem("productosCarrito");
    PRODUCTOS = JSON.parse(localJson);

    if (PRODUCTOS == null) {//Si el carrito esta vacio
        carrito.innerHTML = "<div class=\"modal-body text-center\">" +
                            "<p>No se han cargado productos</p>"+
                            "</div>";
        carrito.className = "modal-body text-center";
        return
    }
    else{
        carrito.innerHTML = "";
        carrito.className = "modal-body";
    }
    
    PRODUCTOS.forEach(producto => {
        let dom = 
        "<div class=\"row bg-black border rounded\" style=\"margin-top:3px;\">" +
            "<div class=\"col-md-3\">"+
                "<img class=\"img-fluid rounded product-image\" src=\""+ producto.imagen + "\">" +
            "</div> " +
                "<div class=\"col-md-6 mt-1\">" +
                    "<h5 class=\"media-title font-weight-semibold\">"+
                    "<a data-abc=\"true\"><strong>"+producto.nombre+"</strong></a>"+
                    "</h5>"+
                    "<small class=\"text-muted\">"+producto.descripcion+"</small>"+
                    // "<p class=\"text-justify text-truncate para mb-0\">"+ producto.descripcion + "<br><br></p>" +
                "</div>" +
            "<div class=\"align-items-center align-content-center col-md-3 border-left mt-1\">"+
                "<div class=\"d-flex flex-row align-items-center\">" +
                    "<h6 class=\"mr-1\"><strong>" + producto.precioFormatted + "</strong></h6>" + 
            "</div>"+
        "</div>"
        carrito.innerHTML = carrito.innerHTML + dom;
    });
    calcularTotal();
    calcularCantidad();
    console.log(PRODUCTOS)
}

