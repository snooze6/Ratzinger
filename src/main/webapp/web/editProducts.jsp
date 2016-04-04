<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

    <c:import url="./genericHeader.jsp" />

    <title>Musica para DAA - Editar Producto</title>

</head>
<body>

<form id="form" action="./index.jsp" method="POST">
    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <div class="mdl-card__title" id="cabeceraTarxetaSettings">
            <c:choose>
                <c:when test="${ requestScope.cd.getId()==0 }">
                    <h2 class="mdl-card__title-text">Nuevo Producto</h2>
                </c:when>
                <c:otherwise>
                    <h2 class="mdl-card__title-text">Editar Producto</h2>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="mdl-card__actions mdl-card--border">
            <div class="mdl-card__supporting-text">
                <!--contido tarxeta-->

                <div style="float: left">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="name" name="name" required value="${ requestScope.cd.getTitle() }">
                        <label class="mdl-textfield__label" for="name">Nombre...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="author" name="author" value="${ requestScope.cd.getAuthor()}" }>
                        <label class="mdl-textfield__label" for="author">Autor...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="country" name="country" value="${ requestScope.cd.getCountry() }">
                        <label class="mdl-textfield__label" for="country">País...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="number" id="price" name="price" required value="${ requestScope.cd.getUnitaryPrice() }">
                        <label class="mdl-textfield__label" for="price">Precio...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" id="quantity" name="quantity" required type="number" step="1" value="${ requestScope.cd.getQuantity() }">
                        <label class="mdl-textfield__label" for="quantity">Cantidad...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield">
                        <textarea class="mdl-textfield__input" type="text" rows= "5" id="description" name="description" style="height: 150px">${ requestScope.cd.getDescription() }</textarea>
                        <label class="mdl-textfield__label" for="description">Descripcion...</label>
                    </div>
                </div>



                <div style="float: right">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="imagen" name="imagen" value="${requestScope.cd.getImage()}">
                        <label class="mdl-textfield__label" for="imagen">Imagen</label>
                    </div>
                    <p><img src="${requestScope.cd.getImage()}" id="productimg" style="width:300px"></p>
                </div>

                <input type="hidden" name="id" value="${ requestScope.cd.getId()}">
                <input type="hidden" name="action" id="action" value="admin/products/show">
                <!--fin contido tarxeta-->
            </div>

            <script>
                var valid=true;

                function urlExists(url, callback){
                    $.ajax({
                        type: 'HEAD',
                        url: url,
                        success: function(){
                            callback(true, url);
                        },
                        error: function() {
                            callback(false, url);
                        }
                    });
                }

                function doit(sucess, imagesrc){
                    if (sucess){
                        if (!(/(jpg|jpeg|gif|png)$/i.test(imagesrc))) {
                            //alert("the file is not an image");
                            imagesrc = './web/images/notfound.png';
                            $('#imagen').val('Not an image');
                        } else {

                        }
                    } else {
                        //alert("There's nothing");
                        imagesrc = './web/images/notfound.png';
                        $('#imagen').val('Invalid link');
                    }
                    $('#productimg').attr('src', imagesrc);
                }

                $('document').ready(function(){
                    $('#imagen').focusout(function(){
                        var imagesrc = $('#imagen').val();
                        urlExists(imagesrc, doit);
                    });
                });
            </script>

            <input
                    type="button"
                    value="CANCELAR"
                    id="cancelar"
                    class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                    onclick="$('#action').val('admin/products/show');$('#form').submit();"
            >
            <input type="button"
                   value="GUARDAR"
                   id="guardar"
                   class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                   style="float:right;"
                   onclick="$('#action').val('admin/products/save');$('#form').submit();"
            >
        </div>

        <c:import url="./menu.jsp" />

    </div>
</form>
</body>
</html>