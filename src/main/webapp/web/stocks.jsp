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
            <a href="./index.jsp" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                Volver
            </a>
            <input type="button" id="add" value="AÑADIR" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
        </div>

        <table class="mdl-data-table mdl-js-data-table">
            <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">CD</th>
                    <th>Cantidad</th>
                    <th>Precio Unitario</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

            <c:forEach var="user" items="${requestScope.cds}">
                <tr>
                    <td class="text-align-left">${user.value.getTitle()}</td>
                    <td>${user.value.getQuantity()}</td>
                    <td>${user.value.getUnitaryPrice()}&euro;</td>
                    <td>
                        <input
                                type="button"
                                value="EDITAR"
                                class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                                style="float:right;"
                                onclick="
                                        $('#action').val('admin/products/edit');
                                        $('#item').val(${user.value.getId()});
                                        $('#form').submit();
                                        "
                        >
                    </td>
                    <td>
                        <button type="button"
                                class="mdl-button mdl-button--icon mdl-button--colored boton-compra"
                                onclick="
                                        $('#action').val('admin/products/delete');
                                        $('#item').val(${user.value.getId()});
                                        $('#form').submit();
                                        ">
                            <i class="material-icons">delete</i>
                        </button>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>

        <input type="hidden" name="action" id="action" value="checkout">
        <input type="hidden" name="item" id="item" value="0">
        <!--fin contido tarxeta-->

        <%--<div class="mdl-card__actions mdl-card--border">--%>
            <%--<a href="./index.jsp" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">--%>
                <%--Volver--%>
            <%--</a>--%>
            <%--&lt;%&ndash;<c:choose>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<c:when test="${total gt 0}">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<input type="button" value="ELIMINAR" id="eliminar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;color:#F44336;">&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:when>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<c:otherwise>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<input type="button" value="ELIMINAR" id="eliminar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;" disabled>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:otherwise>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</c:choose>&ndash;%&gt;--%>
        <%--</div>--%>

        <c:import url="./menu.jsp" />

    </div>
</form>
</body>
</html>