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

        <form action="/headset/incluir" method="post" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Características</h4>

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
                    <p>Conexão:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable1">
                        <label class="form-check-label" for="bluetooh_cable1">
                            Bluetooh
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable2">
                        <label class="form-check-label" for="bluetooh_cable2">
                            Cable
                        </label>
                    </div>
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Iluminação:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="iluminacao" id="iluminacao1">
                        <label class="form-check-label" for="iluminacao1">
                            Sim
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="iluminacao" id="iluminacao2">
                        <label class="form-check-label" for="iluminacao2">
                            Não
                        </label>
                    </div>
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Especificações</h4>
                <div>
                    <label for="tipo" class="form-label">Tipo de som</label>
                    <select class="form-select" id="tipo" name="som">
                        <option selected>Selecione uma das opções abaixo</option>
                        <option value="Stereo 7.1">Stereo 7.1</option>
                        <option value="Surround">Surround</option>
                        <option value="Mono">Mono</option>
                    </select>
                </div>

                <div>
                    <label for="frequencia" class="form-label">Frequencia do Som</label>
                    <input type="number" class="form-control" name="frequencia" id="frequencia" placeholder="1000">
                </div>

                <div>
                    <label for="sensibilidade" class="form-label">Sensibilidade</label>
                    <input type="number" class="form-control" name="sensibilidade" id="sensibilidade" placeholder="1000">
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Cancelamento de Ruido:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" value="sim" name="cancelamentoRuido" id="cancelamentoRuido1">
                        <label class="form-check-label" for="cancelamentoRuido1">
                            Sim
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" value="nao" name="cancelamentoRuido" id="cancelamentoRuido2">
                        <label class="form-check-label" for="cancelamentoRuido2">
                            Não
                        </label>
                    </div>
                </div>
            </div>

            <div class="col-md-12 d-flex" style="gap:10px">
                <button class="btn btn-primary" type="submit">Cadastrar Teclado</button>
            </div>
        </form>

    </div>
</main>

<c:import url="/WEB-INF/jsp/components/footer.jsp"/>

</body>

</html>