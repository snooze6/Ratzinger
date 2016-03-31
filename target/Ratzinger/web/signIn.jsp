<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>

      <c:import url="./genericHeader.jsp" />
      <script src="./web/js/signIn.js"></script>

      <title>Musica para DAA</title>
    </head>
    <body>

      <form action="./index.jsp" method="POST" id="form" >
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicio">
            <h2 class="mdl-card__title-text">Datos de Compra</h2>
          </div>
          <div class="mdl-card__supporting-text">
          <!--contido tarxeta-->

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" id="dni" name="dni" pattern="[1-9]{8,8}[A-Z]" required>
                <label class="mdl-textfield__label" for="dni">DNI...</label>
              </div>

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="password" id="password" name="password" required>
                <label class="mdl-textfield__label" for="password">contraseña...</label>
              </div>

               <input type="hidden" name="action" id="action" value="signInUser">
            <!--fin contido tarxeta-->
          </div>
          <div class="mdl-card__actions mdl-card--border">
            <input type="button" value="Volver" id="volver" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            <input type="submit" value="Continuar" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
          </div>
          <c:import url="./menu.jsp" />
        </div>
      </form>
    </body>
</html>