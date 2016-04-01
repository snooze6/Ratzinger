<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>

        <c:import url="./genericHeader.jsp" />

      <title>Musica para DAA</title>
    </head>
    <body>

      <form id="form" action="./index.jsp" method="POST">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
          <div class="mdl-card__title" id="cabeceraTarxetaInicioError">
            <h2 class="mdl-card__title-text">Se ha producido un error</h2>
          </div>
          <div class="mdl-card__supporting-text">
          <!--contido tarxeta-->

                <p>
                    <c:out value="${requestScope.error}"/>
                </p>

              <input type="hidden" name="action" id="action" value="index">

            <!--fin contido tarxeta-->
          </div>
          <div class="mdl-card__actions mdl-card--border">
            <input type="submit" value="OK" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
          </div>

          <c:import url="./menu.jsp" />

        </div>
      </form>
    </body>
</html>