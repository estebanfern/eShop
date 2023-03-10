$(document).ready(function(){
    console.log("Carrito.js loaded")
    getProductos();
    calcularCantidad();
});

let PRODUCTOS = {};
let INPUT_NAME = "NumberInput";
let LABEL_TOTAL = "Total";

let guarani = Intl.NumberFormat('es-PY', { style: 'currency', currency: 'PYG' });

class Producto {
    constructor(id, nombre, descripcion, precioUnitarioFormatted, imagen, cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitarioFormatted = precioUnitarioFormatted;
        this.precioCantidadFormatted = precioUnitarioFormatted;
        this.cantidad = cantidad;
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

    if (id in PRODUCTOS) { //Si el producto ya esta en el carrito
        $("#warningAlert").show();
        setTimeout(function(){
            $("#warningAlert").hide(); 
        }, 2000);
        return;
    }
    
    
    PRODUCTOS[id] = (new Producto(id, nombreProducto, descripcionProducto, precioProducto, imageProducto, 1));
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
    
    $("#succesAlert").show();
    setTimeout(function(){
        $("#succesAlert").hide(); 
    }, 2000);
    calcularCantidad();
    return;
}

function getProductos(){
    let localJson = localStorage.getItem("productosCarrito");
    PRODUCTOS = JSON.parse(localJson);
}

function calcularTotal(){
    let precioTotal = document.getElementById('precioTotal');
    let total = 0;
    for(var key in PRODUCTOS) {
        var producto = PRODUCTOS[key];
        total = total + producto.precio;
    };
    precioTotal.innerHTML = "Total: " + guarani.format(total);
}

function calcularCantidad(){
    let cantidadProductos = document.getElementById('cantidadProductos');
    let carritoIcon = document.getElementById('carritoIcon');
    let cantidad = 0;
    for(var key in PRODUCTOS) {
        var producto = PRODUCTOS[key];
        cantidad = cantidad + parseInt(producto.cantidad);
    };

    if (cantidad == 0) {   
        cantidadProductos.innerHTML = "Cant. Productos: 0";
        carritoIcon.innerHTML = "";
        return;
    }

    cantidadProductos.innerHTML = "Cant. Productos: " + cantidad;
    carritoIcon.innerHTML = cantidad;

}

function openCarrito (){
    let carrito = document.getElementById('carritoBody');
    let localJson = localStorage.getItem("productosCarrito");
    let inputs = [];
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
    
    for(var key in PRODUCTOS) {
        var producto = PRODUCTOS[key];
      
        // do something with "key" and "value" variables
        let dom = 
        "<div class=\"row bg-black border rounded\" style=\"margin-top:3px; border-color: black;\">" +
            "<div class=\"col-md-3\">"+
                "<img class=\"img-fluid rounded product-image\" src=\""+ producto.imagen + "\">" +
            "</div> " +
                "<div class=\"col-md-5 mt-1\">" +
                    "<h5 class=\"media-title font-weight-semibold\">"+
                    "<a data-abc=\"true\"><strong>"+producto.nombre+"</strong></a>"+
                    "</h5>"+
                    "<small class=\"text-muted\">"+producto.descripcion+"</small>"+
                    // "<p class=\"text-justify text-truncate para mb-0\">"+ producto.descripcion + "<br><br></p>" +
                "</div>" +
                "<div id=\"CardRight\">" +
                    "<div style=\"display : flex; flex-direction: row; align-items: baseline; gap: 10px;\">" + 
                        "<h6>"+ "<strong>"+"Unitario: "+ "</strong>"+ producto.precioUnitarioFormatted+ "</h6>" + 
                        "<button id=\"closeButton\"class=\"close\" aria-label=\"Close alert\" type=\"button\" onclick=\"deleteProduct("+ key +")\" data-close>" +
                            "<span aria-hidden=\"true\">&times;</span>" +
                        "</button>" +
                    "</div>" +
                    "<h6 id=\""+ LABEL_TOTAL + producto.id+"\">"+ "<strong>"+"Total: "+ "</strong>"+ producto.precioCantidadFormatted+ "</h6>" + 
                    "<div style=\"display : flex; flex-direction: row; align-items: baseline\">" + 
                        "<label for=\"cantidadProducto\">Cantidad: </label>"+
                        "<input type=\"number\" class=\"form-control form-control-sm\" id=\""+ INPUT_NAME + producto.id+"\" min=\"1\" value=\""+producto.cantidad+"\" style=\"width: 70px;\">" +
                    "</div>" +
                "</div>" +
        "</div>"
        carrito.innerHTML = carrito.innerHTML + dom;
        inputs.push(producto.id);
    };
    inputs.forEach(input => { //Agrega los event listeners a los inputs
        document.getElementById(INPUT_NAME+input).addEventListener('click', () => { //Agrega el event listener
            inputCantidadProducto(input); 
        });
    });
    inputs.forEach(input => { //Agrega los event listeners a los inputs
        document.getElementById(INPUT_NAME+input).addEventListener('change', () => { //Agrega el event listener
            inputCantidadProducto(input); 
        });
    });
    calcularTotal();
    calcularCantidad(); 
}

function inputCantidadProducto(input){
    var inputElement = document.getElementById(INPUT_NAME+input);
    var labelTotal = document.getElementById(LABEL_TOTAL+input);
    
    let producto = PRODUCTOS[input]; //Obtiene el producto
    producto.cantidad = inputElement.value; //Actualiza la cantidad
    producto.precio = Producto.formatPrice(producto.precioUnitarioFormatted) * producto.cantidad; //Actualiza el precio
    producto.precioCantidadFormatted = guarani.format(producto.precio); //Actualiza el precio formateado
    labelTotal.innerHTML =  "<strong>"+"Total: "+ "</strong>"+ producto.precioCantidadFormatted //Actualiza el label total
    calcularTotal();
    calcularCantidad();

    PRODUCTOS[input] = producto; //Actualiza el producto
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito

}

function deleteProduct(id){
    console.log("Se a eliminado" + id);
    delete PRODUCTOS[id];
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
    openCarrito();
}