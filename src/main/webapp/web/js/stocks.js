/**
 * Created by snooze on 4/1/16.
 */

$('document').ready(function(){

    $("#eliminar").click(function(){
        $("#action").val('admin/products/delete');
        $("#item").val('0');
        $("#form").submit();
    });

    $("#add").click(function(){
        $("#action").val('admin/products/edit');
        $("#item").val('0');
        $("#form").submit();
    });

});