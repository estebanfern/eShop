$(document).ready(() => {
    $("#productos").DataTable(
        
        {   
            "columnDefs": [
                { "width": "15%", "targets": 1 },
                {
                    targets: 3,
                    render: function ( data, type, row ) {
                        return data.length > 40 ?
                            data.substr( 0, 40 ) +'…' :
                            data;
                    }
                }
              ],
            "responsive": true,
            "language": {
                "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
            }
        }
    );
})
