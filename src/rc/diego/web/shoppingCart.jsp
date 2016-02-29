<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
  <html>
    <head>

      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <link rel="stylesheet" href="./web/css/material.min.css">
      <link rel="stylesheet" href="./web/css/myStyle.css">
      <script src="./web/js/material.min.js"></script>
      <script src="./web/js/jquery-2.1.4.js"></script>
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

      <title>Musica para DAA - Carrito</title>

    </head>
    <body>

      <form action="/practica3_diego_reirizcores/index.jsp" method="POST">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaCarrito">
            <h2 class="mdl-card__title-text">Carrito</h2>
          </div>

          <!--contido tarxeta-->

          <table class="mdl-data-table mdl-js-data-table">
            <thead>
              <tr>
                <th class="mdl-data-table__cell--non-numeric">CD</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Precio Total</th>
                <th></th>
              </tr>
            </thead>
            <tbody>

      				<c:forEach var="producto" items="${sessionScope.usuario.getShoppingCart()}">

      					<tr>
      						<td>${producto.value.getName()}</td>
      						<td>${producto.value.getQuantity()}</td>
      						<td>${producto.value.getUnitaryPrice()}&euro;</td>
      						<td><fmt:formatNumber value="${producto.value.getUnitaryPrice() * producto.value.getQuantity()}" type="currency"/></td>
                                <c:set var="total" value="${total + producto.value.getUnitaryPrice() * producto.value.getQuantity()}"></c:set>
      						<td>
                                <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" >
                                  <input type="checkbox" id="checkbox-1" class="mdl-checkbox__input">
                                </label>
      						</td>
      					</tr>

      				</c:forEach>

            </tbody>
            <tfoot>

                <tr>
                  <th class="mdl-data-table__cell--non-numeric">Precio Sin Iva:</th>
                  <th></th>
                  <th></th>
                  <th><fmt:formatNumber value="${total}" type="currency"/></th>
                  <th></th>
                </tr>
                <tr>
                  <th class="mdl-data-table__cell--non-numeric">IVA(21%):</th>
                  <th></th>
                  <th></th>
                  <th><fmt:formatNumber value="${total * 21 / 100}" type="currency"/></th>
                  <th></th>
                </tr>
                <tr>
                  <th class="mdl-data-table__cell--non-numeric">Precio Total:</th>
                  <th></th>
                  <th></th>
                  <th><fmt:formatNumber value="${total + total * 21 / 100}" type="currency"/></th>
                  <th></th>
                </tr>

            </tfoot>
          </table>

            <input type="hidden" name="action" value="checkout">
            <!--fin contido tarxeta-->

          <div class="mdl-card__actions mdl-card--border">
            <a href="/practica3_diego_reirizcores/index.jsp" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
              Volver
            </a>
            <input type="submit" value="Comprar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
            <input type="button" value="ELIMINAR" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;color:#F44336;">
          </div>

        </div>
      </form>
    </body>
</html>