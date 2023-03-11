$(document).ready(function() {
    cargarCardBody();
});
let INPUT = "NumberInputCard";



function cargarCardBody (){
    let listaProductos = document.getElementById("listaProductos");
    listaProductos.innerHTML = "";
    let inputs = [];

    for(var key in PRODUCTOS) {
        var producto = PRODUCTOS[key];
        let dom =  
        `<div class="row bg-black border rounded" style="margin-top:3px; border-color: black;">
            <div class="col-md-3">
                <img class="img-fluid rounded product-image" src=${producto.imagen}>
            </div>
            <div class="col-md-5 mt-1">
                <h5 class="media-title font-weight-semibold">
                <a data-abc=true><strong>${producto.nombre}</strong></a>
                </h5>
                <small class="text-muted">${producto.descripcion}</small>
            </div>

            <div class = "col-md-4" id="CardRight">
                <div class="row justify-content-start">

                    <div class="col-sm-10 align-self-start">
                        <h6><strong>Unitario: </strong> ${producto.precioUnitarioFormatted}</h6>
                        <h6 id= "${LABEL_TOTAL + producto.id}"><strong>Total: </strong>${producto.precioCantidadFormatted}</h6> 
                        <div class="container">
                            <div style="display : flex; flex-direction: row; align-items: baseline;">
                                <label for="cantidadProducto">Cantidad: </label>
                                <input type= "number" class="form-control form-control-sm" id = "${INPUT + producto.id}" min = "1" max ="${producto.existencia}" value= "${producto.cantidad}" style="width: 70px;">
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-2">
                        <button id="closeButton" class= "close" aria-label= Close alert type=button onclick = eliminarProducto(${key}) data-close>
                            <span aria-hidden=true>&times;</span>
                        </button>
                    </div>
                </div>

            </div>
        </div>`;
        listaProductos.innerHTML += dom;
        inputs.push(INPUT + producto.id);
    }
    // inputs.forEach(input => { //Agrega los event listeners a los inputs
    //     document.getElementById(INPUT+input).addEventListener('click', () => { //Agrega el event listener
    //         inputCantidadProducto(input); 
    //     });
    // });
    // inputs.forEach(input => { //Agrega los event listeners a los inputs
    //     document.getElementById(INPUT+input).addEventListener('change', () => { //Agrega el event listener
    //         inputCantidadProducto(input); 
    //     });
    // });
    setCantidadProductos();
    setTotalPrecioProductos();
}

function eventCantidadProducto(input){
    let id = input.substring(INPUT.length);
    let cantidad = document.getElementById(input).value;
    let producto = PRODUCTOS[id];
    producto.cantidad = cantidad;
}

function setCantidadProductos(){
    let cantidadProductos = document.getElementById('productosTotal');
    let carritoIcon = document.getElementById('carritoIcon');
    let cantidad = calcularCantidad();
    console.log()
    console.log("Cantidad: " + cantidad);

    if (cantidad == 0) {   
        cantidadProductos.innerHTML = "0";
        carritoIcon.innerHTML = "";
        return;
    }

    cantidadProductos.innerHTML = cantidad;
    carritoIcon.innerHTML = cantidad;
}

function setTotalPrecioProductos(){
    let precioTotal = document.getElementById('costoTotal');
    let total = calcularTotal();
    precioTotal.innerHTML = total;
}

function eliminarProducto (id){
    deleteItem(id);
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
    cargarCardBody();
}