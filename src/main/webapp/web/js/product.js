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
        console.log(text);
        $('#commentDiv').append("<div style='margin-left: 0% ; padding:8px '> " +
            "<strong>"+usuario +"</strong> <p>"+text+"</p> </div>")
        $('.textAreaDescription').val('');

        //TODO: tal vez sexa millor substituir esto por un script que che devolva a ultima página visitada

        var idProduct=$('#product').val()
        var usuario=$('#usuario').val()


        $.post( "index.jsp", { action: "addComment", title: "titulo", content: text, idProducto1: idProduct,  DNI:"12341234M" , idCommentParent:"null" })
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
            ' </div><input type="button" value="Comentar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect comentarReply"></div>'
        row = $('#' + div);
        row.append(textArea)


        $('.comentarReply').click(function(){
            var text = $('.textAreaDescriptionReply').val();
            var idProduct=$('#product').val()
            var usuario=$('#usuario').val()
            $.post( "index.jsp", { action: "addComment", title: "titulo", content: text, idProducto1: idProduct,  DNI:"12341234M" , idCommentParent:div })
                .done(function( data ) {
                    $( ".commentarReply" ).remove();
                    $( ".commentDiv" ).remove();
                    $('#'+div).append("<div style='margin-left: 8% ; padding:8px '> " +
                        "<strong>"+usuario+" </strong> <p>"+text+"</p> </div>")
                    $('.textAreaDescription').val('');
                    $('#'+link).show()

                   //alert( "Data Loaded: " + data );
                });

        });

        return false;
    });





});
