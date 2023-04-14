<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
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
            <h2>Cadastro de Clientes</h2>
        </div>

        <form action="/cliente/incluir" method="post" enctype="multipart/form-data" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Dados do Cliente:</h4>
                <div>
                    <label for="nome"  class="form-label">Nome</label>
                    <input required type="text" class="form-control" name="nome" id="nome" placeholder="Nome">
                </div>

                <div>
                    <label for="sobrenome"  class="form-label">Sobrenome</label>
                    <input required type="text" class="form-control" name="sobrenome" id="sobrenome" placeholder="Sobrenome">
                </div>

                <div>
                    <label for="email" class="form-label">Email</label>
                    <input required type="email" class="form-control" name="email" id="email" placeholder="name@example.com">
                </div>

                <div>
                    <label for="cpf" class="form-label">Cpf</label>
                    <input required type="text" class="form-control" name="cpf" id="cpf" placeholder="000.000.000-00">
                </div>

                <div>
                    <label for="nascimento"  class="form-label">Nascimento</label>
                    <input required type="text" class="form-control" name="nascimento" id="nascimento" placeholder="02/02/2002">
                </div>

                <div>
                    <label for="telefone" class="form-label">Telefone</label>
                    <input required type="text" class="form-control" name="telefone" id="telefone" placeholder="(21) 00000 0000">
                </div>
            </div>

            <c:import url="/WEB-INF/jsp/endereco/cadastro.jsp"/>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Imagem do Cliente:</h4>

                <div class="card" style="max-width: 200px;max-height: 200px;">
                    <img src="https://techdrop-bucket.s3.amazonaws.com/default.png" class="card-img-top" alt="..." id="preview_img" style="max-height: 100%;">
                </div>

                <div class="input-group mb-3">
                    <input type="file" class="form-control" id="file" name="file">
                </div>
            </div>


            <div class="col-md-12 d-flex" style="gap:10px">
                <button class="btn btn-primary" type="submit">Cadastrar Cliente</button>
            </div>
        </form>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

<script>
    imgInp = document.querySelector("#file")
    preview = document.querySelector("#preview_img")

    imgInp.onchange = evt => {
        const [file] = imgInp.files
        if (file) {
            preview.src = URL.createObjectURL(file)
        }
    }


    $( "#cep" ).keyup(function() {
        if($("#cep").val().length >= 8){
            $.get( "/getCep/"+$("#cep").val(), function( data ) {
                console.log(data)
                $("#logradouro").empty()
                $("#logradouro").val(data.logradouro)

                $("#complemento").empty()
                $("#complemento").val(data.complemento)

                $("#bairro").empty()
                $("#bairro").val(data.bairro)

                $("#localidade").empty()
                $("#localidade").val(data.localidade)

                $("#uf").empty()
                $("#uf").val(data.uf)

            });
        }
    });
</script>

</html>