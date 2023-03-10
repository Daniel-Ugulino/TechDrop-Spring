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

    main>div {
        height: 80vh !important
    }

    @media screen and ( max-width: 535px) {
        main>div {
            height: auto !important;
        }
    }
</style>

<body>

<c:import url="/WEB-INF/jsp/components/navbar.jsp"/>

<main class="pt-3 pb-3">
    <div class="container-fluid d-flex flex-column justify-content-center ps-5 pe-5">

        <div class="row">
            <h2>Cadastro de Usuarios</h2>
        </div>

        <form action="/usuario/incluir" method="post" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>CaracterÝsticas</h4>

                <div>
                    <label for="nome" class="form-label">Nome</label>
                    <input type="text" name="username" id="nome" class="form-control" placeholder="Nome">
                </div>

                <div>
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" name="password" id="senha" class="form-control">
                </div>

                <div>
                    <label for="email" class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
                </div>

                <div>
                    <label for="cpf" class="form-label">Cpf</label>
                    <input type="text" name="cpf" class="form-control" id="cpf" placeholder="000.000.000-00">
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Setor:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" name="setor" type="radio" value="Gerencia" id="setor_opt1">
                        <label class="form-check-label" for="setor_opt1">
                            Gerencia
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" name="setor" type="radio" value="Cliente" id="setor_opt2">
                        <label class="form-check-label" for="setor_opt2">
                            Vendas
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" name="setor" type="radio" value="Administrador" id="setor_opt3">
                        <label class="form-check-label" for="setor_opt3">
                            Administrador
                        </label>
                    </div>
                </div>


                <div class="d-flex" style="gap:15px">
                    <p>Cargo:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" name="cargo" type="radio" value="Gestor" id="cargo_opt1">
                        <label class="form-check-label" for="cargo_opt1">
                            Gestor
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" name="cargo" type="radio" value="Cliente" id="cargo_opt2">
                        <label class="form-check-label" for="cargo_opt2">
                            Vendendor
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" name="cargo" type="radio" value="Desenvolvimento" id="cargo_opt3">
                        <label class="form-check-label" for="cargo_opt3">
                            Desenvolvimento
                        </label>
                    </div>
                </div>


            </div>

            <div class="col-md-12 d-flex" style="gap:10px">
                <button class="btn btn-primary" type="submit">Cadastrar</button>
            </div>
        </form>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

</html>