<%--
  Created by IntelliJ IDEA.
  User: omar-
  Date: 06/08/2021
  Time: 09:29 a. m.
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Iniciar sesión</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="${context}/assets/plugins/bootstrap/css/bootstrap.css">
</head>
<body>
<h1>Iniciar sesión</h1>
<form action="${context}/login" method="POST">
    <label>Correo Electronico:</label>
    <input class="form-control" type="email" name="email"  />
    <br>
    <label>Contraseña:</label>
    <input class="form-control" type="password" name="password" />
    <br>
    <button type="submit" class="btn btn-success">Iniciar sesion</button>
</form>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

