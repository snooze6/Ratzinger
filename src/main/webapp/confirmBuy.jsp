<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
  <html>
    <head>

      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <link rel="stylesheet" href="css/material.min.css">
      <link rel="stylesheet" href="css/myStyle.css">
      <script src="js/material.min.js"></script>
      <script src="js/jquery-2.1.4.js"></script>
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

      <title>Musica para DAA</title>
    </head>
    <body>

      <form action="/index.jsp" method="POST">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">Welcome</h2>
          </div>
          <div class="mdl-card__supporting-text">
          <!--contido tarxeta-->

               <p>Gracias por confiar en nosotros <strong><c:out value="${sessionScope.usuario.getName()}"/></strong>.</p>
              <p>Su compra se ha realizado con éxito, en breves le llegará un correo a <strong><c:out value="${sessionScope.usuario.geteMail()}"/></strong> con los datos de la compra efectuada.</p>

              <input type="hidden" name="action" value="reset">

            <!--fin contido tarxeta-->
          </div>
          <div class="mdl-card__actions mdl-card--border">
              <input type="submit" value="Volver" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
          </div>

        </div>
      </form>
    </body>
</html>
