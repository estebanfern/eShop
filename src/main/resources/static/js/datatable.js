$(document).ready(() => {
    $("#productos").DataTable(
        
        {   
            "columnDefs": [
                { "width": "15%", "targets": 1 }
              ],
            "responsive": true,
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
            }
        }
    );
})
