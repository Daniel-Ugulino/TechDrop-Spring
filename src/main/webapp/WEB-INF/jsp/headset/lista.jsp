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
            <h2>Listagem de Headsets</h2>
            <h5>Quantidade de headset's cadastrados: ${headset.size()}</h5>

            <a href="/headset/cadastro">Adicionar Item</a>
        </div>

        <c:if test="${not empty headset}">
            <div class="row">
                <div class="table-responsive">
                    <table class="table table-hover table-striped-columns mt-3">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Marca</th>
                            <th scope="col">Modelo</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Conexao</th>
                            <th scope="col">Iluminacao</th>
                            <th scope="col">Tipo de som</th>
                            <th scope="col">Frequencia</th>
                            <th scope="col">Sensibilidade</th>
                            <th scope="col">Cancelamento de Ruido</th>
                            <th scope="col">Imagem do Produto</th>
                            <th scope="col">Op��es</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        <c:forEach var="obj" items="${headset}">
                            <tr>
                                <td>${obj.id}</td>
                                <td>${obj.marca}</td>
                                <td>${obj.modelo}</td>
                                <td>${obj.quantidade}</td>
                                <td>${obj.valor}</td>
                                <td>${obj.bluetooh_cable}</td>
                                <td>${obj.iluminacao}</td>
                                <td>${obj.som}</td>
                                <td>${obj.frequencia}</td>
                                <td>${obj.sensibilidade}</td>
                                <td>${obj.cancelamentoRuido}</td>
                                <td><a href="${obj.imgUrl}" target="_blank">imagem</a></td>
                                <td>
                                    <a href="/headset/${obj.id}/excluir">excluir</a>
                                    <a href="/headset/${obj.id}">atualizar</a>
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