<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="./genericHeader.jsp" %>
    <script src="./web/js/index.js"></script>

    <title>Musica para DAA</title>
</head>
<body>

<form id="form" action="./index.jsp" method="POST">
    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">Welcome</h2>
        </div>

        <style>
            .demo-card-square.mdl-card {
                width: 320px;
                height: 320px;
            }
            .demo-card-square > .mdl-card__title {
                color: #fff;
                background-size: 100%;
                background: url('https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQiIxa3WlAYrEOQCPgGYVefzFrRs8CCGVxRa7PX6z4JweBOAkmX') no-repeat;
            }
        </style>

        <c:forEach var="producto" items="${requestScope.cds}">
            <div class="demo-card-square mdl-card mdl-shadow--2dp">
                <div class="mdl-card__title mdl-card--expand">
                    <h2 class="mdl-card__title-text">Update</h2>
                </div>
                <div class="mdl-card__supporting-text">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    Aenan convallis.
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        View Updates
                    </a>
                </div>
            </div>
        </c:forEach>

        <!-- Square card -->

        <div class="mdl-card__actions mdl-card--border">
            <input type="submit" value="Seleccionar Producto" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
            <input type="button" value="Ver Carrito" id="verCarrito" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
        </div>
        <c:import url="./menu.jsp" />

    </div>
</form>
</body>
</html>