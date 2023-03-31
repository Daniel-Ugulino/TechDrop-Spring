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
        <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
            <div class="feature col">
                <div class="feature-icon d-inline-flex align-items-center justify-content-center fs-2 mb-3" style="width: 2em;height: 2em;background-color: black;opacity: 0.5;">
                    <i class="bi bi-cart" style="color: white"></i>
                </div>
                <h3 class="fs-2">Pedidos</h3>
                <a href="/pedido" class="icon-link">
                    Go to page
                    <i class="bi bi-arrow-right"></i>
                </a>
            </div>
            <div class="feature col">
                <div class="feature-icon d-inline-flex align-items-center justify-content-center fs-2 mb-3" style="width: 2em;height: 2em;background-color: black;opacity: 0.5;">
                    <i class="bi bi-person-circle" style="color: white"></i>
                </div>
                <h3 class="fs-2">Clientes</h3>
                <a href="/cliente" class="icon-link">
                    Go to page
                    <i class="bi bi-arrow-right"></i>
                </a>
            </div>
            <c:if test='${usuario.getPermission().toString() == "ADMINISTRATOR"}'>
                <div class="feature col">
                    <div class="feature-icon d-inline-flex align-items-center justify-content-center  fs-2 mb-3"style="width: 2em;height: 2em;background-color: black;opacity: 0.5;">
                        <i class="bi bi-person-fill" style="color: white"></i>
                    </div>
                    <h3 class="fs-2">Usuarios</h3>
                    <a href="/usuario" class="icon-link">
                        Go to page
                        <i class="bi bi-arrow-right"></i>
                    </a>
                </div>
            </c:if>
        </div>

        <c:if test='${usuario.getPermission().toString() != "SALES"}'>
            <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                <div class="feature col">
                    <div class="feature-icon d-inline-flex align-items-center justify-content-center  fs-2 mb-3"style="width: 2em;height: 2em;background-color: black;opacity: 0.5;">
                        <i class="bi bi-keyboard" style="color: white"></i>
                    </div>
                    <h3 class="fs-2">Teclados</h3>
                    <a href="/teclado" class="icon-link">
                        Go to page
                        <i class="bi bi-arrow-right"></i>
                    </a>
                </div>
                <div class="feature col">
                    <div class="feature-icon d-inline-flex align-items-center justify-content-center fs-2 mb-3"style="width: 2em;height: 2em;background-color: black;opacity: 0.5;">
                        <i class="bi bi-mouse" style="color: white"></i>
                    </div>
                    <h3 class="fs-2">Mouse's</h3>
                    <a href="/mouse" class="icon-link">
                        Go to page
                        <i class="bi bi-arrow-right"></i>
                    </a>
                </div>
                <div class="feature col">
                    <div class="feature-icon d-inline-flex align-items-center justify-content-center fs-2 mb-3"style="width: 2em;height: 2em;background-color: black;opacity: 0.5;">
                        <i class="bi bi-headphones" style="color: white"></i>
                    </div>
                    <h3 class="fs-2">Headset's</h3>
                    <a href="/headset" class="icon-link">
                        Go to page
                        <i class="bi bi-arrow-right"></i>
                    </a>
                </div>
            </div>
        </c:if>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

</html>