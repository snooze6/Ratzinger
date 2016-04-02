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
        <div class="mdl-card__title" id="cabeceraTarxetaCarrito">
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
                        <input class="mdl-textfield__input" type="text" id="price" name="price" required value="${ requestScope.cd.getUnitaryPrice() }">
                        <label class="mdl-textfield__label" for="price">Precio...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="quantity" name="quantity" required value="${ requestScope.cd.getQuantity() }">
                        <label class="mdl-textfield__label" for="quantity">Cantidad...</label>
                    </div>
                </div>

                <div class="mdl-textfield mdl-js-textfield" style="float: right;">
                    <textarea class="mdl-textfield__input" type="text" rows= "3" id="description" name="description" style="height: 300px" value="${ requestScope.cd.getDescription() }"></textarea>
                    <label class="mdl-textfield__label" for="description">Description...</label>
                </div>

                <input type="hidden" name="action" id="action" value="admin/stock">
                <!--fin contido tarxeta-->
            </div>

            <input
                    type="button"
                    value="CANCELAR"
                    id="cancelar"
                    class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                    onclick="$('#action').val('admin/stock');$('#form').submit();"
            >
            <input type="button"
                   value="GUARDAR"
                   id="guardar"
                   class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                   style="float:right;"
                   onclick="$('#action').val('admin/save');$('#form').submit();"
            >
        </div>

        <c:import url="./menu.jsp" />

    </div>
</form>
</body>
</html>