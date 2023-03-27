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
    <div class="container-fluid d-flex justify-content-center flex-column ps-5 pe-5">
        <div class="row">
            <h2>Listagem de Pedidos</h2>
            <h5>Quantidade de pedidos realizados: ${pedido.size()}</h5>
            <a href="/pedido/cadastro">Adicionar Item</a>
        </div>

        <c:if test="${not empty pedido}">
            <div class="row">
                <div class="table-responsive">
                    <table class="table table-hover table-striped-columns mt-3">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Descricao</th>
                            <th scope="col">Data</th>
                            <th scope="col">Quantidade de Produtos</th>
                            <th scope="col">Forma de Pagamento</th>
                            <th scope="col">Valor Total</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Usuario</th>
                            <th scope="col">Opções</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        <c:forEach var="obj" items="${pedido}">
                            <tr>
                                    <td>${obj.id}</td>
                                    <td>${obj.descricao}</td>
                                    <td>${obj.date}</td>
                                    <td>${obj.produtos.size()}</td>
                                    <td>${obj.pagamento}</td>
                                    <td>${obj.valor_total}</td>
                                    <td>${obj.cliente.getNome()}</td>
                                    <td>${obj.usuario.getUsername()}</td>
                                <td>
                                    <a href="/pedido/${obj.id}/excluir">excluir</a>
                                    <a href="/pedido/${obj.id}">atualizar</a>
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