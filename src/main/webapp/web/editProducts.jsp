<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

    <c:import url="./genericHeader.jsp" />
    <script src="./web/js/stocks.js"></script>

    <title>Musica para DAA - Editar Producto</title>

</head>
<body>

<form id="form" action="./index.jsp" method="POST">
    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <div class="mdl-card__title" id="cabeceraTarxetaCarrito">
            <h2 class="mdl-card__title-text">Editar Producto ${ requestScope. }</h2>
        </div>

        <div class="mdl-card__actions mdl-card--border">
            <a href="./index.jsp" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                Cancelar
            </a>

            <div class="mdl-card__supporting-text">
                <!--contido tarxeta-->

                <div style="float: left">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="name" name="name" required>
                        <label class="mdl-textfield__label" for="name">Nombre...${param["item"].getTitle()}</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="author" name="author">
                        <label class="mdl-textfield__label" for="author">Autor...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="country" name="country">
                        <label class="mdl-textfield__label" for="country">País...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="price" name="price" required>
                        <label class="mdl-textfield__label" for="price">Precio...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="quantity" name="quantity" pattern=".{2,}" required>
                        <label class="mdl-textfield__label" for="quantity">Cantidad...</label>
                    </div>
                </div>

                <div class="mdl-textfield mdl-js-textfield" style="float: right;">
                    <textarea class="mdl-textfield__input" type="text" rows= "3" id="description" name="description" style="height: 300px"></textarea>
                    <label class="mdl-textfield__label" for="description">Description...</label>
                </div>

                <input type="hidden" name="action" id="action" value="signUpUser">
                <!--fin contido tarxeta-->
            </div>

            <c:choose>
                <c:when test="${total gt 0}">
                    <input type="button" value="GUARDAR" id="eliminar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;color:#F44336;">
                </c:when>
                <c:otherwise>
                    <input type="button" value="GUARDAR" id="eliminar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;" disabled>
                </c:otherwise>
            </c:choose>
        </div>

        <c:import url="./menu.jsp" />

    </div>
</form>
</body>
</html>