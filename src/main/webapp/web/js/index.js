$('document').ready(function(){

    $('#verCarrito').click(function(){
        $("#action").val('shoppingCart');
        $("#form").submit();
    });

    $("button").click(function(){
        $("product").val(this.id)
        $("#form").submit();
    });
});