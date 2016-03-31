<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>

        <c:import url="./genericHeader.jsp" />
        <script src="./web/js/index.js"></script>

      <title>Musica para DAA</title>
    </head>
    <body>

      <form id="form" action="./index.jsp" method="POST">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">Welcome</h2>
          </div>
          <div class="mdl-card__supporting-text">
          <!--contido tarxeta-->


              <label for="listaCds">CD:</label>
      	      <select  name="listaCds" >
            		<c:forEach var="producto" items="${requestScope.cds}">
            		    <option value="${producto.value.getId()} | ${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}"><c:out value="${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}€" /> </option>
            	    </c:forEach>
      	      </select>

              <label for="cantidad">Cantidad:</label>
              <input type="text" name="cantidad" value="1" pattern="[0-9]*">
              <input type="hidden" name="action" id="action" value="buyItem">

            <!--fin contido tarxeta-->
          </div>
          <div class="mdl-card__actions mdl-card--border">
            <input type="submit" value="Seleccionar Producto" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
            <input type="button" value="Ver Carrito" id="verCarrito" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
          </div>
          <c:import url="./menu.jsp" />

        </div>
      </form>
    </body>
</html>