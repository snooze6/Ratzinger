<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>

      <c:import url="./genericHeader.jsp" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
         <script src="js/checkout.js"></script>
        <link rel="stylesheet" href="./web/css/product.css">
      <title>Musica para DAA</title>
    </head>
    <body>

    <c:forEach var="producto" items="${requestScope.cds}">

      <form action="./index.jsp" method="POST" id="form" >
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">
                <c:out value="${producto.value.getTitle()} - ${producto.value.getUnitaryPrice()}€"></c:out>
            </h2>
          </div>

          <!--contido tarxeta-->
            <div class="mdl-card__supporting-text">
                <strong>Descripci&oacute;n: </strong>
                ${producto.value.getDescription()}
            </div>

            <div class="mdl-card__supporting-text">
                <strong>Autor:</strong>
                ${producto.value.getAuthor()}
            </div>

            <div class="mdl-card__supporting-text">
                <strong>Pa&iacute;s</strong>
                ${producto.value.getCountry()}
            </div>


            <%--<option value="${producto.value.getId()} | ${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}"><c:out value="${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}€" /> </option>--%>

            <input type="hidden" name="product" id="product" value="${producto.value.getId()}">
            <input type="hidden" name="quantity" id="quantity" value="1">
            <input type="hidden" name="action" id="action" value="buyItem">
    <!--fin contido tarxeta-->

          <div class="mdl-card__actions mdl-card--border">
            <input type="button" value="Volver" id="volver" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            <input type="submit" value="Comprar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
          </div>
          <c:import url="./menu.jsp" />
        </div>
      </form>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <!-- Floating Multiline Textfield -->
        <form action=".#" method="POST">

            <div class="mdl-textfield mdl-js-textfield comment">

                <div class="mdl-card__supporting-text">
                    <strong>Comentario:</strong>
                </div>

                <textarea class="mdl-textfield__input" type="text" rows= "6" id="sample5" ></textarea>
                <label class="mdl-textfield__label" for="sample5">Text lines...</label>
            </div>
            <input type="button" value="Comentar" id="comentar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">

        </form>
    </div>

    </c:forEach>
    </body>
</html>