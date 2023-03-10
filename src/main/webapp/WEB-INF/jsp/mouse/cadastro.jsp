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
            <h2>Cadastro de Teclados</h2>
        </div>

        <form action="/mouse/incluir" method="post" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>CaracterÝsticas</h4>

                <div>
                    <label for="marca"  class="form-label">Marca</label>
                    <input type="text" class="form-control" name="marca" id="marca" placeholder="name@example.com">
                </div>

                <div>
                    <label for="modelo"  class="form-label">Modelo</label>
                    <input type="text" class="form-control" name="modelo" id="modelo" placeholder="name@example.com">
                </div>

                <div>
                    <label for="quantidade" class="form-label">Quantidade</label>
                    <input type="text" class="form-control" name="quantidade" id="quantidade" placeholder="name@example.com">
                </div>

                <div>
                    <label for="valor" class="form-label">Valor</label>
                    <input type="text" class="form-control" name="valor" id="valor" placeholder="name@example.com">
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>ConexŃo:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable">
                        <label class="form-check-label" for="bluetooh_cable">
                            Bluetooh
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable">
                        <label class="form-check-label" for="bluetooh_cable">
                            Cable
                        </label>
                    </div>
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>IluminašŃo:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="iluminacao" id="iluminacao">
                        <label class="form-check-label" for="iluminacao">
                            Sim
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="iluminacao" id="iluminacao">
                        <label class="form-check-label" for="iluminacao">
                            NŃo
                        </label>
                    </div>
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Especificaš§es</h4>
                <div>
                    <label for="dpi" class="form-label">Maximo de dpi</label>
                    <input type="number" class="form-control" name="dpi" id="dpi" placeholder="1200">
                </div>

                <div>
                    <label for="dpi" class="form-label">Quantidade de Bot§es</label>
                    <input type="number" class="form-control" name="qtd_botoes" id="qtd_botoes" placeholder="5">
                </div>

                <div>
                    <label for="dpi" class="form-label">Peso em gramas</label>
                    <input type="number" class="form-control" name="peso" id="peso" placeholder="1200">
                </div>
            </div>

            <div class="col-md-12 d-flex" style="gap:10px">
                <button class="btn btn-primary" type="submit">Cadastrar Mouse</button>
            </div>
        </form>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

</html>