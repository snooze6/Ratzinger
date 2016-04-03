<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

    <c:import url="./genericHeader.jsp" />
    <script src="./web/js/stocks.js"></script>

    <title>Musica para DAA - Stock</title>

</head>
<body>

<form id="form" action="./index.jsp" method="POST">
    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <div class="mdl-card__title" id="cabeceraTarxetaCarrito">
            <h2 class="mdl-card__title-text">Stocks</h2>
        </div>

        <div class="mdl-card__actions mdl-card--border">
            <input type="button" id="add" value="AÑADIR" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
        </div>

        <table class="mdl-data-table mdl-js-data-table">
            <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">CD</th>
                    <th>Cantidad</th>
                    <th>Cantidad Restante</th>
                    <th>Precio Unitario</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

            <c:forEach var="producto" items="${requestScope.cds}">
                <tr>
                    <td class="text-align-left">${producto.value.getTitle()}</td>
                    <td>${producto.value.getQuantity()}</td>
                    <td>${producto.value.getQuantity()}&euro;</td>
                    <td>${producto.value.getUnitaryPrice()}&euro;</td>
                    <td>
                        <input
                                type="button"
                                value="EDITAR"
                                class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                                style="float:right;"
                                onclick="
                                        $('#action').val('admin/edit');
                                        $('#item').val(${producto.value.getId()});
                                        $('#form').submit();
                                        "
                        >
                    </td>
                    <td>
                        <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" >
                            <input type="checkbox" id="checkbox-${producto.value.getId()}" name="checkbox-${producto.value.getId()}" class="mdl-checkbox__input">
                        </label>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>

        <input type="hidden" name="action" id="action" value="checkout">
        <input type="hidden" name="item" id="item" value="0">
        <!--fin contido tarxeta-->

        <div class="mdl-card__actions mdl-card--border">
            <a href="./index.jsp" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                Volver
            </a>
            <%--<c:choose>--%>
                <%--<c:when test="${total gt 0}">--%>
                    <%--<input type="button" value="ELIMINAR" id="eliminar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;color:#F44336;">--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<input type="button" value="ELIMINAR" id="eliminar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;" disabled>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        </div>

        <c:import url="./menu.jsp" />

    </div>
</form>
</body>
</html>