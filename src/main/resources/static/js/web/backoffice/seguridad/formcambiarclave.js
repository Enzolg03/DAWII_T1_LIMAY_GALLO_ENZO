$(document).on("click", "#btncambiarclave", function(){
 const password = $('#password').val();
        const repeatPassword = $('#repeatPassword').val();

        if (password !== repeatPassword) {
            alert('Las contraseñas no coinciden');
            return;
        }

        const passwordMap = {
            password: password
        };

        $.ajax({
            url: '/seguridad/cambiarclave',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(passwordMap),
            success: function(response) {
                alert(response.mensaje);
            }
        });
    });