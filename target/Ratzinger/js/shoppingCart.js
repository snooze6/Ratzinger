$('document').ready(function(){

    $("#eliminar").click(function(){
        $("#action").val('eraseItem');

        $("#form").submit();
    });

});