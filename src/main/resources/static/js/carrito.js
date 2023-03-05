function addProduct(id){
    let carrito = document.getElementById('carritoBody');
    console.log(carrito.innerHTML)


    if (carrito.innerHTML.includes("cargado productos")) {//Si el carrito esta vacio
        carrito.innerHTML = "";
        carrito.className = "modal-body";
    }

    let nombreProducto = document.getElementById('productoName' + id).innerHTML;
    let descripcionProducto = document.getElementById('productoDesc' + id).innerHTML;
    let precioProducto = document.getElementById('productoPrecio' + id).innerHTML;

    let dom = "<div class=\"row p-2 bg-white border rounded\">" +
                "<div class=\"col-md-3 mt-1\"><img class=\"img-fluid img-responsive rounded product-image\" src=\"https://i.pinimg.com/564x/1d/89/53/1d8953b382f9fffca27523a86cff36b9.jpg\"></div> " +
                "<div class=\"col-md-6 mt-1\">" +
                "<h5>" + nombreProducto + "</h5>" +
                "<p class=\"text-justify text-truncate para mb-0\">"+ descripcionProducto + "<br><br></p>" +
                "</div>" +
                "<div class=\"align-items-center align-content-center col-md-3 border-left mt-1\">"+
                "<div class=\"d-flex flex-row align-items-center\">" +
                "<h4 class=\"sm-1\">Gs. " + precioProducto + "</h4>" + 
                "</div>" +
                "<button class=\"btn btn-primary btn-md\" type=\"button\">Detalles</button>"+
                "</div>"+
                "</div>";
    
    carrito.innerHTML = carrito.innerHTML + dom;
    return;
}

