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
            <div class="mdl-layout mdl-js-layout mdl-color--grey-100">
                <main class="mdl-layout__content">
                    <div class="mdl-grid">
          <!--contido tarxeta-->





              <c:forEach var="producto" items="${requestScope.cds}">




              <!-- Image card -->
              <style>
                  .demo-card-square > .mdl-card__title {
                      color: #fff;
                      background-size: 100%;
                      background: url('https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQiIxa3WlAYrEOQCPgGYVefzFrRs8CCGVxRa7PX6z4JweBOAkmX') no-repeat;
                  }

                  .mdl-layout__container {
                      position: relative;
                      height: 100%;
                  }

                  .mdl-grid {
                      margin-left: 1.3%;
                  }

                  .item {
                      width: 270px;
                      height: 400px;
                      margin:
                  }

                  .mdl-card__media {
                      margin: 0;
                  }

                  .mdl-card__media > img {
                      max-width: 100%;
                  }

                  .mdl-card__actions {
                      display: flex;
                      box-sizing: border-box;
                      align-items: center;
                  }

                  .mdl-card__actions > .mdl-button--icon {
                      margin-right: 3px;
                      margin-left: 3px;
                  }

                  .titulo_disco{
                      font-size: medium;
                      width:100%;
                  }

                  .ellipsis{
                      text-overflow: ellipsis;
                  }

                  .item{
                      height: 470px;
                  }
              </style>


              <div class="item mdl-card mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-shadow--2dp">
                  <figure class="mdl-card__media">
                      <img src="http://cwallpaper.xyz/wp-content/uploads/halcyon-days-ellie-goulding-album-cover-6.jpg" alt="" />
                  </figure>
                  <div class="mdl-card__title">
                      <h1 class="mdl-card__title-text titulo_disco" >${producto.value.getTitle()} </h1><h1 class="mdl-card__subtitle-text">${producto.value.getUnitaryPrice()}€</h1>
                  </div>
                  <div class="mdl-card__supporting-text ellipsis">
                      <p>${producto.value.getDescription()}</p>
                  </div>
                  <div class="mdl-card__actions mdl-card--border">
                      <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Información</a>
                      <div class="mdl-layout-spacer"></div>
                      <button type="button" class="mdl-button mdl-button--icon mdl-button--colored" id="${producto.value.getId()}"><i class="material-icons">add_shopping_cart</i></button>
                  </div>
              </div>



                      <%--<option value="${producto.value.getId()} | ${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}"><c:out value="${producto.value.getTitle()} | ${producto.value.getAuthor()} | ${producto.value.getCountry()} | ${producto.value.getUnitaryPrice()}€" /> </option>--%>
              </c:forEach>



                    </div>
                </main>
            </div>


            <input type="hidden" name="product" id="product" value="-1">
            <input type="hidden" name="quantity" id="quantity" value="1">
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