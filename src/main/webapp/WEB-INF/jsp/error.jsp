<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
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
            <h2>Ocorreu um erro</h2>
        </div>

        <div class="row">
            <h2>${exception}</h2>
        </div>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

</html>