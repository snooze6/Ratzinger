<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="./genericHeader.jsp" />
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
            <input type="button"
                   id="add"
                   value="AÑADIR"
                   class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                   style="float:right;"
                   onclick="
                           $('#action').val('admin/users/edit');
                           $('#item').val('new');
                           $('#form').submit();
                           "
            >
        </div>

        <table class="mdl-data-table mdl-js-data-table">
            <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">DNI</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Tipo</th>
                    <th>Vip</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

            <c:forEach var="user" items="${requestScope.users}">
                <tr>
                    <td class="text-align-left">${user.getDNI()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.geteMail()}</td>
                    <td>${user.getTipo()}</td>
                    <td>${user.isVip()}</td>
                    <td>
                        <input
                                type="button"
                                value="EDITAR"
                                class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                                style="float:right;"
                                onclick="
                                        $('#action').val('admin/users/edit');
                                        $('#item').val('${user.getDNI()}');
                                        $('#form').submit();
                                        "
                        >
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${user.isActive()}">
                                <button type="button"
                                        class="mdl-button mdl-button--icon mdl-button--colored boton-compra"
                                        onclick="
                                                $('#action').val('admin/users/deactivate');
                                                $('#item').val('${user.getDNI()}');
                                                $('#form').submit();
                                                ">
                                    <i class="material-icons">lock_outline</i>
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button type="button"
                                        class="mdl-button mdl-button--icon mdl-button--colored boton-compra"
                                        onclick="
                                                $('#action').val('admin/users/activate');
                                                $('#item').val('${user.getDNI()}');
                                                $('#form').submit();
                                                ">
                                    <i class="material-icons">lock_open</i>
                                </button>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>

        <input type="hidden" name="action" id="action" value="checkout">
        <input type="hidden" name="item" id="item" value="0">
        <!--fin contido tarxeta-->

        <%--<div class="mdl-card__actions mdl-card--border">--%>
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