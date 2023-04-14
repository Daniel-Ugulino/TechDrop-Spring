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

<main class="">
    <div class="container-fluid d-flex justify-content-center flex-column ps-5 pe-5 ">
        <div class="row">
            <c:if test="${not empty msg}">
                <div class="alert alert-success" role="alert">
                        ${msg}
                </div>
            </c:if>
            <h2>Listagem de Clientes</h2>
            <h5>Quantidade de clientes cadastrados: ${cliente.size()}</h5>
            <a href="/cliente/cadastro">Adicionar Item</a>
        </div>

        <c:if test="${not empty cliente}">
            <div class="row">
                <div class="table-responsive">
                    <table class="table table-hover table-striped-columns mt-3">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Sobrenome</th>
                            <th scope="col">Email</th>
                            <th scope="col">Cpf</th>
                            <th scope="col">Nascimento</th>
                            <th scope="col">Status</th>
                            <th scope="col">Cep</th>
                            <th scope="col">Endereco</th>
                            <th scope="col">Telefone</th>
                            <th scope="col">Usuario vinculado</th>
                            <th scope="col">Opções</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        <c:forEach var="obj" items="${cliente}">
                            <tr>
                                <td>${obj.id}</td>
                                <td>${obj.nome}</td>
                                <td>${obj.sobrenome}</td>
                                <td>${obj.email}</td>
                                <td>${obj.cpf}</td>
                                <td>${obj.nascimento}</td>
                                <td>${obj.status}</td>
                                <td>${obj.endereco.uf}</td>
                                <td>${obj.endereco.cep}</td>
                                <td>${obj.telefone}</td>
                                <td>${obj.usuario.getUsername()}</td>
                                <td>
                                    <c:if test='${usuario.getPermission().toString() != "SALES"}'>
                                        <c:if test="${obj.status == true}">
                                            <a href="/cliente/${obj.id}/updateStatus">desativar</a>
                                        </c:if>
                                        <c:if test="${obj.status == false}">
                                            <a href="/cliente/${obj.id}/updateStatus">ativar</a>
                                        </c:if>
                                    </c:if>

                                    <a href="/cliente/${obj.id}">atualizar</a>

                                    <c:if test="${usuario.getPermission().toString() == 'ADMINISTRATOR'}">
                                        <a href="/cliente/${obj.id}/excluir">excluir</a>
                                    </c:if>
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
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">4</a></li>
                            <li class="page-item"><a class="page-link" href="#">5</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
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