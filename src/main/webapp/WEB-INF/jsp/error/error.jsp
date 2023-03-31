<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>TechDrop</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:import url="/WEB-INF/jsp/components/dependencies.jsp"/>
</head>

<body>
<c:import url="/WEB-INF/jsp/components/navbar.jsp"/>

<main>
    <div class="container-fluid d-flex justify-content-center flex-column ps-5 pe-5 ">
        <div class="row">
            <h2>Listagem de Usuarios</h2>
            <h5>Quantidade de usuarios cadastrados: ${usuarios.size()}</h5>
            <a href="/usuario/cadastro">Adicionar Item</a>
        </div>

        <c:if test="${not empty usuarios}">
            <div class="row">

            </div>
        </c:if>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

</html>