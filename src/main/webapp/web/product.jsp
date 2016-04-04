<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

    <c:import url="./genericHeader.jsp"/>

    <script src="./web/js/product.js"></script>


            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
             <script src="js/checkout.js"></script>
            <link rel="stylesheet" href="./web/css/product.css">

    <title>Musica para DAA</title>
</head>
<body>

<c:forEach var="producto" items="${requestScope.cds}">

    <form action="./index.jsp" method="POST" id="form">
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

            <input type="hidden" name="product" id="product" value="${producto.value.getId()}">
            <input type="hidden" name="quantity" id="quantity" value="1">
            <input type="hidden" name="action" id="action" value="buyItem">
            <input type="hidden" name="action" id="usuario" value="${ sessionScope.usuario.getFirstName()} ${ sessionScope.usuario.getLastName()} ">


            <!--fin contido tarxeta-->

            <div class="mdl-card__actions mdl-card--border">
                <input type="button" value="Volver" id="volver"
                       class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                <input type="submit" value="Comprar"
                       class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float:right;">
            </div>
            <c:import url="./menu.jsp"/>
        </div>
    </form>




    <div class="demo-card-wide mdl-card mdl-shadow--2dp" id="commentDiv">
        <!-- Floating Multiline Textfield -->
        <h2>Comentarios:</h2>
        <c:forEach var="comentario" items="${requestScope.comments}">
            <div style="margin-left: ${comentario.getDeep()*8}% ; padding:8px " id="${comentario.getIdComment()}">
                <strong>${comentario.getTitle()} </strong>
                <strong>   Valoracion: ${comentario.getValoracion()}</strong>
                <p>${comentario.getContent()}  </p>
                <c:choose>
                    <c:when test="${fn:length(sessionScope.usuario.getFirstName()) gt 0}">
                        <a href="#" id="-${comentario.getIdComment()}"  class="linkReply" title="${comentario.getIdComment()}">Reply </a>
                    </c:when>
                </c:choose>
            </div>
            </hr>
        </c:forEach>
    </div>


    <c:choose>
        <c:when test="${fn:length(sessionScope.usuario.getFirstName()) gt 0}">
            <div class="demo-card-wide mdl-card mdl-shadow--2dp divComment" id="divComment">
                <!-- Floating Multiline Textfield -->
                <form action=".#" method="POST">
                    <div class="mdl-card__supporting-text" >
                        <strong>Comentario:</strong>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield comment" >
                        <textarea class="mdl-textfield__input textAreaDescription" type="text" rows="6" id="sample5" ></textarea>
                        <label class="mdl-textfield__label" for="sample5">Escriba su comentario</label>
                    </div>
                    <input type="button" value="Comentar" id="comentar"
                           class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect comentar">
                    <strong>Valoracion: <select id="valoracion" class="valoracion">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select></strong>
                </form>
            </div>
        </c:when>
    </c:choose>



</c:forEach>
</body>
</html>


<c:choose>
    <c:when test="${fn:length(sessionScope.usuario.getFirstName()) gt 0}">
        <li class="mdl-menu__item" id="linkPerfil" >Perf&iacute;l</li>
    </c:when>
</c:choose>