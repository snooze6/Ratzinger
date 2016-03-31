<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>

      <c:import url="./genericHeader.jsp" />
      <script src="./web/js/checkout.js"></script>

      <title>Musica para DAA</title>
    </head>
    <body>

      <form action="./index.jsp" method="POST" id="form" >
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">Datos de Compra</h2>
          </div>

          <!--contido tarxeta-->

          <table class="mdl-data-table mdl-js-data-table">
            <thead>
              <tr>
                <th class="mdl-data-table__cell--non-numeric">CD</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Precio Total</th>
              </tr>
            </thead>
            <tbody>

                    <c:forEach var="producto" items="${sessionScope.cart}">

                        <tr>
                            <td class="text-align-left">${producto.value.getTitle()}</td>
                            <td>${producto.value.getQuantity()}</td>
                            <td>${producto.value.getUnitaryPrice()}&euro;</td>
                            <td><fmt:formatNumber value="${producto.value.getUnitaryPrice() * producto.value.getQuantity()}" type="currency"/></td>
                                <c:set var="total" value="${total + producto.value.getUnitaryPrice() * producto.value.getQuantity()}"></c:set>
                        </tr>

                    </c:forEach>

            </tbody>
            <tfoot>

                <tr>
                  <th class="mdl-data-table__cell--non-numeric">Precio Sin Iva:</th>
                  <th></th>
                  <th></th>
                  <th><fmt:formatNumber value="${total}" type="currency"/></th>

                </tr>
                <tr>
                  <th class="mdl-data-table__cell--non-numeric">IVA(21%):</th>
                  <th></th>
                  <th></th>
                  <th><fmt:formatNumber value="${total * 21 / 100}" type="currency"/></th>

                </tr>
                <tr>
                  <th class="mdl-data-table__cell--non-numeric">Precio Total:</th>
                  <th></th>
                  <th></th>
                  <th><fmt:formatNumber value="${total + total * 21 / 100}" type="currency"/></th>

                </tr>

            </tfoot>
          </table>



               <input type="hidden" name="action" id="action" value="confirmPayment">
            <!--fin contido tarxeta-->

          <div class="mdl-card__actions mdl-card--border">
            <input type="button" value="Volver" id="volver" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            <input type="submit" value="Continuar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
          </div>
          <c:import url="./menu.jsp" />
        </div>
      </form>
    </body>
</html>