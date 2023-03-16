<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>TechDrop</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/navbar.css" rel="stylesheet">
    <c:import url="/WEB-INF/jsp/components/dependencies.jsp"/>
</head>

<style>
    body {
        min-height: 100vh;
        display: flex;
        flex-direction: column;
    }
</style>

<body>
    <c:import url="/WEB-INF/jsp/components/navbar.jsp"/>

    <main>
        <div class="container-fluid d-flex justify-content-center flex-column ps-5 pe-5 " style="height: 80vh !important;">
            <div class="row">
                <h2>Listagem de Usuarios</h2>
                <a href="/usuario/cadastro">Adicionar Item</a>
            </div>

            <c:if test="${not empty usuarios}">
            <div class="row">
                <div class="table-responsive">
                    <table class="table table-hover table-striped-columns mt-3">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Username</th>
                            <th scope="col">E-mail</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Setor</th>
                            <th scope="col">Cargo</th>
                            <th scope="col">Clientes</th>
                            <th scope="col">Opções</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach var="obj" items="${usuarios}">
                                <tr>
                                    <td>${obj.id}</td>
                                    <td>${obj.username}</td>
                                    <td>${obj.email}</td>
                                    <td>${obj.cpf}</td>
                                    <td>${obj.setor}</td>
                                    <td>${obj.cargo}</td>
                                    <td>${obj.clientes.size()}</td>
                                    <td>
                                        <a href="/usuario/${obj.id}/excluir">excluir</a>
                                        <a href="/usuario/${obj.id}">atualizar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row">
                <div class="col d-flex justify-content-center mt-4 ">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="/usuario">1</a></li>
                            <li class="page-item"><a class="page-link" href="/usuario/page/1">2</a></li>
                            <li class="page-item"><a class="page-link" href="/usuario/page/2">3</a></li>
                            <li class="page-item"><a class="page-link" href="/usuario/page/3">4</a></li>
                            <li class="page-item"><a class="page-link" href="/usuario/page/4">5</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            </c:if>

        </div>
    </main>

    <c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

</html>