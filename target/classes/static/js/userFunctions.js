

<script>
    $(document).ready(function() {
      
      // Adicionar
      $('#formulario').on('submit', function(event) {
        event.preventDefault();
        
        var nombre = $('#nombre').val();
        var email = $('#email').val();
        var password = $('#password').val();
        
        // Realizar llamada AJAX para adicionar
        $.ajax({
          url: '/api/adicionar',
          method: 'POST',
          data: { nombre: nombre, email: email, password: password },
          success: function(response) {
            // Limpiar formulario después de adicionar
            $('#nombre').val('');
            $('#email').val('');
            $('#password').val('');
          }
        });
      });
      
      // Modificar
      $('#modificar').on('click', function() {
        var nombre = $('#nombre').val();
        var email = $('#email').val();
        var password = $('#password').val();
        
        // Realizar llamada AJAX para modificar
        $.ajax({
          url: '/api/modificar',
          method: 'PUT',
          data: { nombre: nombre, email: email, password: password },
          success: function(response) {
            // Realizar acciones adicionales después de modificar
          }
        });
      });
      
      // Eliminar
      $('#eliminar').on('click', function() {
        var email = $('#email').val();
        
        // Realizar llamada AJAX para eliminar
        $.ajax({
          url: '/api/eliminar',
          method: 'DELETE',
          data: { email: email },
          success: function(response) {
            // Realizar acciones adicionales después de eliminar
          }
        });
      });
      
      // Listar
      $('#listar').on('click', function() {
        // Realizar llamada AJAX para listar
        $.ajax({
          url: '/api/listar',
          method: 'GET',
          success: function(response) {
            // Limpiar la tabla
            $('#tabla-body').empty();
            
            // Recorrer la respuesta y construir las filas de la tabla
            for (var i = 0; i < response.length; i++) {
              var usuario = response[i];
              
              var fila = '<tr>' +
                           '<td>' + usuario.nombre + '</td>' +
                           '<td>' + usuario.email + '</td>' +
                           '<td> Acciones </td>' +
                         '</tr>';
              
              $('#tabla-body').append(fila);
            }
          }
        });
      });
      
    });
  </script>
