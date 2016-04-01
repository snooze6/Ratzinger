/**
 * Created by snooze on 4/1/16.
 */

$('document').ready(function(){

    $("#eliminar").click(function(){
        $("#action").val('stock');

        $("#form").submit();
    });

    $("#add").click(function(){
        $("#action").val('edit');

        $("#form").submit();
    });


});