<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>

      <c:import url="./genericHeader.jsp" />
      <script src="js/checkout.js"></script>

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

            <div style="position: relative;height: 100%;clear: both;">
          <!--contido tarxeta-->
                <div class="left">
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

                    <div class="mdl-card__supporting-text">
                        <strong>Disponibles:</strong>
                            ${producto.value.getQuantity()}
                    </div>
                </div>
                <%--<option value="${producto.value.getId()} | ${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}"><c:out value="${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}€" /> </option>--%>
                <div class="right" style="width:300px;margin:8px;">
                    <p><img src="${producto.value.getImage()}" id="productimg" style="width:300px"></p>
                </div>

            </div>

            <input type="hidden" name="product" id="product" value="${user.value.getId()}">
            <input type="hidden" name="quantity" id="quantity" value="1">
            <input type="hidden" name="action" id="action" value="buyItem">
    <!--fin contido tarxeta-->

          <div class="mdl-card__actions mdl-card--border">
              <a href="./index.jsp" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                  Volver
              </a>
            <input type="submit" value="Comprar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
          </div>
          <c:import url="./menu.jsp" />
        </div>
      </form>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <!-- Floating Multiline Textfield -->
        <form action=".#" method="POST">
            <div class="mdl-card__supporting-text">
                <strong>Comentario:</strong>
            </div>
            <div class="mdl-textfield mdl-js-textfield comment">
                <textarea class="mdl-textfield__input" type="text" rows= "6" id="sample5" ></textarea>
                <label class="mdl-textfield__label" for="sample5">Escriba su comentario</label>
            </div>
            <input type="button" value="Comentar" id="comentar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
        </form>
    </div>



    </c:forEach>
    </body>
</html>