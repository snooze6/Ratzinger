<%@ page import="rc.diego.model.persistence.Connector.MySQLContract" %>
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
                    <c:choose>
                        <c:when test="${ requestScope.euser.getDNI()=='new' }">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                                <input class="mdl-textfield__input" type="text" id="DNI" name="DNI" required pattern="[1-9]{8,8}[A-Z]">
                                <label class="mdl-textfield__label" for="DNI">DNI...</label>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" name="DNI" value="${ requestScope.euser.getDNI()}">
                        </c:otherwise>
                    </c:choose>


                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="name" name="name" required value="${ requestScope.euser.getFirstName() }">
                        <label class="mdl-textfield__label" for="name">Nombre...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="text" id="lastname" name="lastname" value="${ requestScope.euser.getLastName() }">
                        <label class="mdl-textfield__label" for="lastname">Apellidos...</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                        <input class="mdl-textfield__input" type="email" id="email" name="email" required value="${ requestScope.euser.geteMail()}" }>
                        <label class="mdl-textfield__label" for="email">Correo electrónico...</label>
                    </div>
                </div>

                <div style="float: right">
                    <c:choose>
                        <c:when test="${ requestScope.euser.getDNI()=='new' }">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                                <input class="mdl-textfield__input" type="password" id="password" name="password" required>
                                <label class="mdl-textfield__label" for="password">contraseña...</label>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label block">
                                <input class="mdl-textfield__input" type="password" id="password" name="password">
                                <label class="mdl-textfield__label" for="password">contraseña...</label>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <!-- TODO: Meter EL+JSTL -->
                    <select name="tipo">
                        <c:choose>
                            <c:when test="${ requestScope.euser.getDNI()!='new' }">
                                <option value="1">No cambiar</option>
                            </c:when>
                        </c:choose>
                        <%
                            for (int i=2; i< MySQLContract.Tipo.values().length+2; i++){
                                %>
                                 <option value="<%= i %>"><%= MySQLContract.Tipo.values()[i-2] %></option>
                                <%
                            }
                        %>
                    </select>
                    <p></p>
                    <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="active">
                        <c:choose>
                            <c:when test="${requestScope.euser.isActive()}">
                                <input type="checkbox" id="active" name="active" class="mdl-switch__input" checked value="true">
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" id="active" name="active" class="mdl-switch__input" value="false">
                            </c:otherwise>
                        </c:choose>
                        <span class="mdl-switch__label">Active</span>
                    </label>
                    <p></p>
                    <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="vip">
                        <c:choose>
                            <c:when test="${requestScope.euser.isVip()}">
                                <input type="checkbox" id="vip" name="vip" class="mdl-switch__input" checked value="true">
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" id="vip" name="vip" class="mdl-switch__input" value="false">
                            </c:otherwise>
                        </c:choose>
                        <span class="mdl-switch__label">Vip</span>
                    </label>
                    <p></p>
                    <%--<p>${ requestScope.euser.isActive() }</p>--%>
                    <%--<p>${requestScope.euser.isVip()}</p>--%>

                </div>

                <input type="hidden" name="action" id="action" value="admin/users/show">
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