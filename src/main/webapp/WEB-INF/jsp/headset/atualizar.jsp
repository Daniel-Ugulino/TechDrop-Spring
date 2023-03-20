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
        <c:if test="${not empty headset}">

        <div class="row">
            <h2>Atualizar Headset: ${headset.getMarca()} ${headset.getModelo()}</h2>
        </div>

        <form action="/headset/atualizar/${headset.getId()}" method="post" enctype="multipart/form-data" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Características</h4>

                <div>
                    <label for="marca"  class="form-label">Marca</label>
                    <input type="text" class="form-control" name="marca" value="${headset.getMarca()}" id="marca" placeholder="name@example.com">
                </div>

                <div>
                    <label for="modelo"  class="form-label">Modelo</label>
                    <input type="text" class="form-control" name="modelo" value="${headset.getModelo()}" id="modelo" placeholder="name@example.com">
                </div>

                <div>
                    <label for="quantidade" class="form-label">Quantidade</label>
                    <input type="text" class="form-control" name="quantidade" value="${headset.getQuantidade()}" id="quantidade" placeholder="name@example.com">
                </div>

                <div>
                    <label for="valor" class="form-label">Valor</label>
                    <input type="text" class="form-control" name="valor" value="${headset.getValor()}" id="valor" placeholder="name@example.com">
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Conexão:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input ${headset.getBluetooh_cable().equals("bluetooh") ? 'checked="checked"' : ''} class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable" value="bluetooh">
                        <label class="form-check-label" for="bluetooh_cable">
                            Bluetooh
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input ${headset.getBluetooh_cable().equals("cable") ? 'checked="checked"' : ''} class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable" value="cable">
                        <label class="form-check-label" for="bluetooh_cable">
                            Cable
                        </label>
                    </div>
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Iluminação:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input ${headset.getIluminacao() ? 'checked="checked"' : ''} class="form-check-input" type="radio" name="iluminacao" id="iluminacao" value="true">
                        <label class="form-check-label" for="iluminacao">
                            Sim
                        </label>
                    </div>

                    <div ${headset.getIluminacao() == false ? 'checked="checked"' : ''} class="form-check d-flex" style="gap:10px">
                        <input class="form-check-input" type="radio" name="iluminacao" id="iluminacao" value="false">
                        <label class="form-check-label" for="iluminacao">
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
                        <option ${headset.getSom().equals("stereo 7.1") ? 'selected' : ''}  value="stereo 7.1">Stereo 7.1</option>
                        <option ${headset.getSom().equals("surround") ? 'selected' : ''}value="surround">Surround</option>
                        <option ${headset.getSom().equals("surround") ? 'selected' : ''} value="mono">Mono</option>
                    </select>
                </div>

                <div>
                    <label for="frequencia" class="form-label">Frequencia do Som</label>
                    <input type="number" value="${headset.getFrequencia()}"  class="form-control" name="frequencia" id="frequencia" placeholder="1000">
                </div>

                <div>
                    <label for="sensibilidade" class="form-label">Sensibilidade</label>
                    <input type="number" value="${headset.getSensibilidade()}" class="form-control" name="sensibilidade" id="sensibilidade" placeholder="1000">
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Cancelamento de Ruido:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input ${headset.getCancelamentoRuido() ? 'checked="checked"' : ''}  class="form-check-input" type="radio" value="true" name="cancelamentoRuido" id="cancelamentoRuido1">
                        <label class="form-check-label" for="cancelamentoRuido1">
                            Sim
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input ${headset.getCancelamentoRuido() == false ? 'checked="checked"' : ''} class="form-check-input" type="radio" value="false" name="cancelamentoRuido" id="cancelamentoRuido2">
                        <label class="form-check-label" for="cancelamentoRuido2">
                            Não
                        </label>
                    </div>
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Imagem do Produto:</h4>

                <div class="card" style="max-width: 200px;max-height: 200px;">
                    <img src="${headset.getImgUrl()}" class="card-img-top" alt="..." id="preview_img">
                </div>

                <div class="input-group mb-3">
                    <input type="file" class="form-control" id="file" name="file">
                </div>

            </div>

            <div class="col-md-12 d-flex" style="gap:10px">
                <button class="btn btn-primary" type="submit">Atualizar Headset</button>
            </div>


        </form>
        </c:if>
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
</script>

</html>