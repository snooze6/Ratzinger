<!DOCTYPE html>
  <html>
    <head>

      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <link rel="stylesheet" href="./css/material.min.css">
      <link rel="stylesheet" href="./css/myStyle.css">
      <script src="./js/material.min.js"></script>
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

      <title>Musica para DAA - Carrito</title>
    </head>
    <body>

      <form action="/local/prueba" method="POST">
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
                <th>Precio</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="mdl-data-table__cell--non-numeric">Acrylic (Transparent)</td>
                <td>25</td>
                <td>XX.xx€</td>
                  <td>
                  <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" >
                      <input type="checkbox" id="checkbox-1" class="mdl-checkbox__input">
                    </label>
                  </td>
              </tr>
              <tr>
                <td class="mdl-data-table__cell--non-numeric">Plywood (Birch)</td>
                <td>50</td>
                <td>XX.xx€</td>
                  <td>
                  <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" >
                      <input type="checkbox" id="checkbox-1" class="mdl-checkbox__input">
                    </label>
                  </td>
              </tr>
              <tr>
                <td class="mdl-data-table__cell--non-numeric">Laminate (Gold on Blue)</td>
                <td>10</td>
                <td>XX.xx€</td>
                  <td>
                  <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" >
                      <input type="checkbox" id="checkbox-1" class="mdl-checkbox__input">
                    </label>
                  </td>
              </tr>
            </tbody>
            <tfoot>

                <tr>
                  <th class="mdl-data-table__cell--non-numeric">Precio Total</th>
                  <th></th>
                  <th>XX.xx€</th>
                  <th></th>
                </tr>

            </tfoot>
          </table>

            <!--fin contido tarxeta-->
      
          <div class="mdl-card__actions mdl-card--border">
            <a href="index.html" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
              Volver
            </a>
            <input type="submit" value="Comprar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
              <input type="button" value="ELIMINAR" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;color:#F44336;">
          </div>
      
        </div>
      </form>
    </body>
</html>
