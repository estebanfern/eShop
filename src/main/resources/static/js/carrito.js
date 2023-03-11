let INPUT_NAME = "NumberInput";
let LABEL_TOTAL = "Total";

function setTotal(){
    let precioTotal = document.getElementById('precioTotal');
    let total = calcularTotal();
    precioTotal.innerHTML = `Total: ${total}`;
}

function setCantidad(){
    let cantidadProductos = document.getElementById('cantidadProductos');
    let carritoIcon = document.getElementById('carritoIcon');
    let cantidad = calcularCantidad();

    if (cantidad == 0) {   
        cantidadProductos.innerHTML = "Cant. Productos: 0";
        carritoIcon.innerHTML = "";
        return;
    }

    cantidadProductos.innerHTML = "Cant. Productos: " + cantidad;
    carritoIcon.innerHTML = cantidad;
    return cantidad;
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
                                <input type= "number" class="form-control form-control-sm" id = "${INPUT_NAME + producto.id}" min = "1" max ="${producto.existencia}" value= "${producto.cantidad}" style="width: 70px;">
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-2">
                        <button id="closeButton" class= "close" aria-label= Close alert type=button onclick = deleteProduct(${key}) data-close>
                            <span aria-hidden=true>&times;</span>
                        </button>
                    </div>
                </div>

            </div>
        </div>`;
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
    setTotal();
    setCantidad(); 
}

function inputCantidadProducto(input){
    var inputElement = document.getElementById(INPUT_NAME+input);
    var labelTotal = document.getElementById(LABEL_TOTAL+input);
    let total = changeCantidadProducto(input, inputElement);
    labelTotal.innerHTML =  "<strong>"+"Total: "+ "</strong>"+ total //Actualiza el label total
    setTotal();
    setCantidad();
}

function deleteProduct(id){
    deleteItem(id);
    localStorage.setItem("productosCarrito", JSON.stringify(PRODUCTOS)); //Save productos carrito
    openCarrito();
}