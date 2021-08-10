<%--
  Created by IntelliJ IDEA.
  User: omar-
  Date: 06/08/2021
  Time: 08:33 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Listado de Videojuegos</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body onload="findGames();">
<div id="content">
    <br>
    <button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#create"><i class="fas fa-plus"></i> Agregar Videojuego</button>
    <br>
    <table class="table">
        <thead class="table-dark">
        <th>No.</th>
        <th>Nombre del videojuego</th>
        <th>Imagen del juego</th>
        <th>Fecha de estreno</th>
        <th>Categoria</th>
        <th>Estado</th>
        </thead>
        <tbody id="res">

        </tbody>

    </table>
</div>

<div class="modal fade" id="create" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar Videojuego</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <label>Nombre del videojuego:</label>
                <input class="form-control" type="text" name="name" id="name"  />
                <br>
                <label>Imagen:</label>
                <input class="form-control" type="file" name="image"  id="image"/>
                <br>
                <label>Fecha de Estreno:</label>
                <input class="form-control" type="date" name="date" id="date" />
                <br>
                <label>Categoria:</label>
                <select class="form-select" name="type" id="category">
                    <option selected>Seleccione una categoria...</option>
                    <option value="1">Aventura</option>
                    <option value="2">Acción</option>
                    <option value="3">Deportes</option>
                </select>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                <button type="button" class="btn btn-success" onclick="createGame();"> Agregar</button>
            </div>
        </div>
    </div>
</div>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${context}/assets/dist/js/main.js"></script>
</body>
</html>
