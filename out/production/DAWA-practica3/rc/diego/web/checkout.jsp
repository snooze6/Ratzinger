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
            <h2 class="mdl-card__title-text">Datos de Compra</h2>
          </div>
          <div class="mdl-card__supporting-text">
          <!--contido tarxeta-->

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" id="nombre" pattern="text">
                <label class="mdl-textfield__label" for="nombre">Text...</label>
              </div>
              <br/>

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="email" id="email" pattern="email">
                <label class="mdl-textfield__label" for="email">e-mail...</label>
              </div>

               <input type="hidden" name="action" value="confirmPayment">
            <!--fin contido tarxeta-->
          </div>
          <div class="mdl-card__actions mdl-card--border">
            <a href="index.html" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
              Volver
            </a>
            <input type="submit" value="Continuar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
          </div>

        </div>
      </form>
    </body>
</html