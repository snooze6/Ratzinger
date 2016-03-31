<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
  <html>
    <head>

      <c:import url="./genericHeader.jsp" />

      <title>Musica para DAA</title>
    </head>
    <body>

      <form action="./index.jsp" method="POST">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">Welcome</h2>
          </div>
          <div class="mdl-card__supporting-text">
          <!--contido tarxeta-->

               <p>Gracias por confiar en nosotros <strong><c:out value="${sessionScope.usuario.getFirstName()}"/></strong>.</p>
              <p>Su compra se ha realizado con éxito, en breves le llegará un correo a <strong><c:out value="${sessionScope.usuario.geteMail()}"/></strong> con los datos de la compra efectuada.</p>

              <input type="hidden" name="action" value="reset">

            <!--fin contido tarxeta-->
          </div>
          <div class="mdl-card__actions mdl-card--border">
              <input type="submit" value="Volver" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
          </div>
          <c:import url="./menu.jsp" />
        </div>
      </form>
    </body>
</html>
