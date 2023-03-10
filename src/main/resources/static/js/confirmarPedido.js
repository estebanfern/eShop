$(document).ready(function() {
    console.log("ConfirmarPedido.js loaded")
    cargarProductos();
});


function cargarProductos (){
    let listaProductos = document.getElementById("listaProductos");
    let PRODUCTOS = JSON.parse(localStorage.getItem("productosCarrito"));

    for(var key in PRODUCTOS) {
        var producto = PRODUCTOS[key];
        let dom =  "<div class=\"row bg-black border rounded\" style=\"margin-top:3px; border-color: black;\">" +
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
                    "<input type=\"number\" class=\"form-control form-control-sm\" id=\""+ INPUT_NAME + producto.id+"\" min=\"1\" max = \""+producto.existencia+"\"value=\""+producto.cantidad+"\" style=\"width: 70px;\">" +
                "</div>" +
            "</div>" +
        "</div>"
        listaProductos.innerHTML += dom;
    }
}

