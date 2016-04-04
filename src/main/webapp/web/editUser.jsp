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
                <c:when test="${ requestScope.euser.getDNI()=='new' }">
                    <h2 class="mdl-card__title-text">Nuevo Usuario</h2>
                </c:when>
                <c:otherwise>
                    <h2 class="mdl-card__title-text">Editar Usuario</h2>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="mdl-card__actions mdl-card--border">
            <div class="mdl-card__supporting-text">
                <!--contido tarxeta-->

                <div style="float: left">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="name" name="name" required value="${ requestScope.euser.getFirstName() }">
                        <label class="mdl-textfield__label" for="name">Nombre...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="lastname" name="lastname" value="${ requestScope.euser.getLastName() }">
                        <label class="mdl-textfield__label" for="lastname">Apellidos...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="email" id="email" name="email" value="${ requestScope.euser.geteMail()}" }>
                        <label class="mdl-textfield__label" for="email">Correo electrónico...</label>
                    </div>
                </div>



                <div style="float: right">
                </div>

                <input type="hidden" name="id" value="${ requestScope.euser.getDNI()}">
                <input type="hidden" name="action" id="action" value="admin/products/show">
                <!--fin contido tarxeta-->
            </div>

            <input
                    type="button"
                    value="CANCELAR"
                    id="cancelar"
                    class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                    onclick="$('#action').val('admin/users/show');$('#form').submit();"
            >
            <input type="button"
                   value="GUARDAR"
                   id="guardar"
                   class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                   style="float:right;"
                   onclick="$('#action').val('admin/users/save');$('#form').submit();"
            >
        </div>

        <c:import url="./menu.jsp" />

    </div>
</form>
</body>
</html>