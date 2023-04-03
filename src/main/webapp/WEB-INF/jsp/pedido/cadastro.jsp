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

<main class="pt-3 pb-3">
    <div class="container-fluid d-flex flex-column justify-content-center ps-5 pe-5">

        <div class="row">
            <h2>Realizar Pedido</h2>
        </div>

        <form action="/pedido/incluir" method="post" enctype="multipart/form-data" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Características</h4>

                <div>
                    <label for="marca"  class="form-label">Descrição da Venda</label>
                    <input required type="text" class="form-control" name="descricao" id="marca" placeholder="name@example.com">
                </div>

                <div>
                    <label for="date"  class="form-label">Data da Venda</label>
                    <input required type="text" class="form-control" name="date" id="date" placeholder="name@example.com">
                </div>

                <div class="d-flex" style="gap: 20px">
                    <div>
                        <label for="pagamento" class="form-label">Forma de pagamento</label>
                        <input required type="text" class="form-control" name="pagamento" id="pagamento" placeholder="name@example.com">
                    </div>
                    <div>
                        <label for="valor" class="form-label">Valor Total</label>
                        <input required type="text" disabled class="form-control" id="valor" placeholder="name@example.com">
                    </div>

                </div>

                <div>
                    <label for="cliente" class="form-label">Cliente</label>
                    <select required class="form-select" id="cliente" name="cliente.id">
                        <option selected disabled>Selecione um cliente</option>
                        <c:forEach var="obj" items="${cliente}">
                            <option value="${obj.id}">${obj.nome}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Produtos</h4>

                <div style="display: flex; gap: 10px">
                    <label class="form-label">Adicionar Produto:</label>
                    <button class="btn btn-primary" type="button" id="add">Adicionar produto</button>
                </div>

                <div id="produto_container" style="display: flex;flex-direction: column;gap: 10px;max-height: 300px;overflow: auto">
                    <div class="d-flex" style="gap: 20px">
                        <select onchange="get_product(this)" class="form-select tipo">
                            <option selected disabled>Selecione a categoria do Produto</option>
                            <option value="teclado">Teclado</option>
                            <option value="mouse">Mouse</option>
                            <option value="headset">Headset</option>
                        </select>
                        <select class="form-select" name="produtos[]" onchange="calcular_valor(this)">
                            <option  selected disabled>Selecione o produto</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="col-md-12 d-flex" style="gap:10px">
                <button class="btn btn-primary" type="submit">Realizar Pedido</button>
            </div>
        </form>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

<script>
    var price = 0
    var full_price = 0

    $("#add").click(function (){
        let div =  $('<div class="d-flex" style="gap: 20px">')

        let select_type = $('<select onchange="get_product(this)" class="form-select tipo">' +
            '<option  selected disabled>Selecione a categoria do Produto</option>' +
            '<option value="teclado">Teclado</option>' +
            '<option value="mouse">Mouse</option>' +
            '<option value="headset">Headset</option>'+
            '</select>')

        let select_product = $('<select onchange="calcular_valor(this)" class="form-select" name="produtos[]">' +
            '<option  selected disabled>Selecione o produto</option>' +
            '</select>')

        div.append(select_type,select_product)
        $("#produto_container").append(div)
    })

    function get_product(select){
        full_price -= price
        let field = $(select).next()
        field.empty()
        field.append("<option selected disabled>Selecione o produto</option>")
        $.get( "/getProdutos/"+$(select).val(), function( data ) {
            data.map(item => {
                field.append("<option data-price="+item.valor+" value="+item.id+">"+item.marca + " " + item.modelo+"</option>")
            })
        });
    }

    function calcular_valor(select){
        price = parseFloat((select).find(":selected").attr("data-price"))
        full_price += parseFloat(price)
        $("#valor").val(full_price)
    }


</script>

</html>