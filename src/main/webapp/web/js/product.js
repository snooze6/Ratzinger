$('document').ready(function(){

    $('#volver').click(function(){
/*        alert('fuego')*/
        //TODO: tal vez sexa millor substituir esto por un script que che devolva a ultima página visitada

        $("#action").val('index');

        $("#form").submit();
    });

    $('#comentar').click(function(){
        var usuario=$('#usuario').val()
        var text = $('.textAreaDescription').val();
       var valoracion=  $( ".valoracion option:selected" ).text();
        console.log("La valoracion es " +valoracion)
        $('#commentDiv').append("<div style='margin-left: 0% ; padding:8px '> " +
            "<strong>"+usuario + "</strong> " +
            "<strong>"+"   Valoración "+ valoracion+"</strong> </div>" + "<p>"+text+"</p> </div>")
        $('.textAreaDescription').val('');



        //TODO: tal vez sexa millor substituir esto por un script que che devolva a ultima página visitada

        var idProduct=$('#product').val()
        var usuario=$('#usuario').val()


        $.post( "index.jsp", { action: "addComment", title: "titulo", content: text, idProducto1: idProduct,  DNI:"12341234M" , idCommentParent:"null" , valoracion: valoracion })
            .done(function( data ) {

            });

/*
        $.post( "index.jsp", { action: "addComment", title: "titulo", content: text, idProducto1: idProduct,  DNI:"12341234M", idCommentParent:"null"  })
            .done(function( data ) {
                alert( "Data Loaded: " + data );
            });
*/


    });


    $('.linkReply').click(function(){
        $( ".commentarReply" ).remove();
        $( ".commentDiv" ).remove();
        var div = -this.id;
        var link=this.id
        $('#'+link).hide()
        console.log( "El valor del producto es " + $('#product').val());

        var textArea= '<div class="commentDiv"> <div class="mdl-textfield mdl-js-textfield comment commentReplyDiv" > ' +
            '<textarea class="mdl-textfield__input textAreaDescriptionReply" type="text" rows="3" id="sample6" ></textarea> ' +
            '<label class="mdl-textfield__label" for="sample6"></label> ' +
            ' </div><input type="button" value="Comentar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect comentarReply">' +
           ' <strong>Valoracion: <select id="valoracionReply" class="valoracionReply"> <option value="1">1</option> <option value="2">2</option> <option value="3">3</option> <option value="4">4</option> <option value="5">5</option> </select></strong></div>'
        row = $('#' + div);
        row.append(textArea)


        $('.comentarReply').click(function(){
            var text = $('.textAreaDescriptionReply').val();
            var idProduct=$('#product').val()
            var usuario=$('#usuario').val()
            var valoracion=  $( ".valoracionReply option:selected" ).text();
            $.post( "index.jsp", { action: "addComment", title: "titulo", content: text, idProducto1: idProduct,  DNI:"12341234M" , idCommentParent:div, valoracion: valoracion })
                .done(function( data ) {
                    $( ".commentarReply" ).remove();
                    $( ".commentDiv" ).remove();
                    $('#'+div).append("<div style='margin-left: 8% ; padding:8px '> " +
                        "<strong>"+usuario+" </strong> <strong>"+"   Valoracion: "+valoracion+" </strong><p>"+text+"</p> </div>")
                    $('.textAreaDescription').val('');
                    $('#'+link).show()

                   //alert( "Data Loaded: " + data );
                });

        });

        return false;
    });





});
