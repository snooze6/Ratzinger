$('document').ready(function(){

    $('#verCarrito').click(function(){
        $("#action").val('shoppingCart');
        $("#form").submit();
    });

});