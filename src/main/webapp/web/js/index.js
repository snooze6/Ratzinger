$('document').ready(function(){

    $('#verCarrito').click(function(){
        $("#action").val('shoppingCart');
        $("#form").submit();
    });

    $('#searchButton').click(function(){
        $("#action").val('search');
        $("#form").submit();
    });


    $( "#searchFilter" ).keypress(function() {
        if (e.which == 13) {
            console.log("pulsaste algo y tal");
            e.preventDefault();
            $("#action").val('search');
            $("#form").submit();
        }
    });

    $(".boton-compra").click(function(){
        $("#product").val(this.id);
        $("#form").submit();
    });

    $(".boton-info").click(function(){
        $("#action").val('productInfo');
        $("#product").val(this.id.replace("a",""));
        $("#form").submit();
    });
});