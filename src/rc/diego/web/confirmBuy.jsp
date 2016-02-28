<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
  <html>
    <head>

      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <link rel="stylesheet" href="./web/css/material.min.css">
      <link rel="stylesheet" href="./web/css/myStyle.css">
      <script src="./web/js/material.min.js"></script>
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

      <title>Musica para DAA</title>
    </head>
    <body>

      <form action="/practica3_diego_reirizcores/index.jsp" method="POST">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">Welcome</h2>
          </div>
          <div class="mdl-card__supporting-text">
          <!--contido tarxeta-->

              Su compra se ha realizado con éxcito, en breves le llegará un correo a <strong>usuario@correo.com</strong> con los datos de la compra efectuada.
              


              <input type="hidden" name="action" value="index">

            <!--fin contido tarxeta-->
          </div>
          <div class="mdl-card__actions mdl-card--border">
              <input type="submit" value="Volver" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
          </div>

        </div>
      </form>
    </body>
</html>
