$('document').ready(function(){
    alert('suuuuuuuuu');
    $('#volver').click(function(){
        alert('fuego')
        $("#action").val('shoppingCart');
        $("#form").submit();
    });

});