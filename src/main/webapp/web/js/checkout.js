$('document').ready(function(){
    
    $('#volver').click(function(){
        
        $("#action").val('shoppingCart');
        $("#form").submit();
    });

});