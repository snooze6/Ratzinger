$('document').ready(function(){

    $('#verCarrito').click(function(){
        $("#action").val('shoppingCart');
        $("#form").submit();
    });

    $(".boton-compra").click(function(){
        $("#product").val(this.id);
        $("#form").submit();
    });
});