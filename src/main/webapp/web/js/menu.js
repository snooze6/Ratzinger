$('document').ready(function(){

    $('#linkRegistrarse').click(function(){
        $("#action").val('signUp');

        $("#form").submit();
    });

    $('#linkIniciarSesion').click(function(){
            $("#action").val('signIn');

            $("#form").submit();
    });

    $('#linkPerfil').click(function(){
        alert("Pendiente de implementar");
    });

    $('#linkCerrarSesion').click(function(){
        $("#action").val('reset');

        $("#form").submit();
    });

    $('#linkStock').click(function(){
        $("#action").val('admin/stock');
        $("#form").submit();
    });

}); 