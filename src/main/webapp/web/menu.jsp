<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mdl-card__menu">

    <script src="./web/js/menu.js"></script>

    <button type="button" id="demo-menu-lower-right" class="mdl-button mdl-js-button mdl-button--icon">
        <i class="material-icons" style="color:#FAFAFA">
            more_vert
        </i>
    </button>

    <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="demo-menu-lower-right">

        <!-- TODO: Esconder menus de admin (Están así por debug) -->
      <c:choose>
          <c:when test="${fn:length(sessionScope.usuario.getFirstName()) gt 0}">
            <li class="mdl-menu__item" id="linkPerfil" >Perf&iacute;l</li>
            <li class="mdl-menu__item" id="linkCerrarSesion" >Cerrar Sesi&oacute;n</li>
              <c:choose>
                  <c:when test="${sessionScope.usuario.isAdmin()}">
                      <li class="mdl-menu__item" id="linkStock" >Administrar Stock</li>
                      <li class="mdl-menu__item"
                          id="linkUsers"
                          onclick="$('#action').val('admin/users/show');$('#form').submit();">
                          Administrar Usuarios
                      </li>
                  </c:when>
              </c:choose>
          </c:when>
          <c:otherwise>
              <li class="mdl-menu__item" id="linkIniciarSesion" >Iniciar Sesi&oacute;n</li>
              <li class="mdl-menu__item" id="linkRegistrarse" >Registrarse</li>
          </c:otherwise>
      </c:choose>

        <%--<li class="mdl-menu__item" id="linkStock" >Administrar Stock</li>--%>
        <%--<li class="mdl-menu__item"--%>
            <%--id="linkUsers"--%>
            <%--onclick="$('#action').val('admin/users/show');$('#form').submit();">--%>
            <%--Administrar Usuarios--%>
        <%--</li>--%>

    </ul>

</div>