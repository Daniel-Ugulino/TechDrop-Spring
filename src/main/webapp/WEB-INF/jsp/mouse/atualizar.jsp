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
        <c:if test="${not empty mouse}">

        <div class="row">
            <h2>Atualizar Mouse: ${mouse.getMarca()} ${mouse.getModelo()}</h2>
        </div>

        <form action="/mouse/atualizar/${mouse.getId()}" method="post" enctype="multipart/form-data" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Caracter�sticas</h4>

                <div>
                    <label for="marca"  class="form-label">Marca</label>
                    <input required type="text" class="form-control" name="marca" value="${mouse.getMarca()}" id="marca" placeholder="name@example.com">
                </div>

                <div>
                    <label for="modelo"  class="form-label">Modelo</label>
                    <input required type="text" class="form-control" name="modelo" value="${mouse.getModelo()}" id="modelo" placeholder="name@example.com">
                </div>

                <div>
                    <label for="quantidade" class="form-label">Quantidade</label>
                    <input required type="text" class="form-control" name="quantidade" value="${mouse.getQuantidade()}" id="quantidade" placeholder="name@example.com">
                </div>

                <div>
                    <label for="valor" class="form-label">Valor</label>
                    <input required type="text" class="form-control" name="valor" value="${mouse.getValor()}" id="valor" placeholder="name@example.com">
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Conex�o:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input required ${mouse.getBluetooh_cable().equals("bluetooh") ? 'checked="checked"' : ''} class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable" value="bluetooh">
                        <label class="form-check-label" for="bluetooh_cable">
                            Bluetooh
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input required ${mouse.getBluetooh_cable().equals("cable") ? 'checked="checked"' : ''} class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable" value="cable">
                        <label class="form-check-label" for="bluetooh_cable">
                            Cable
                        </label>
                    </div>
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Ilumina��o:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input required ${mouse.getIluminacao() ? 'checked="checked"' : ''} class="form-check-input" type="radio" name="iluminacao" id="iluminacao" value="true">
                        <label class="form-check-label" for="iluminacao">
                            Sim
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input required ${mouse.getIluminacao() == false ? 'checked="checked"' : ''} class="form-check-input" type="radio" name="iluminacao" id="iluminacao" value="false">
                        <label class="form-check-label" for="iluminacao">
                            N�o
                        </label>
                    </div>
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Especifica��es</h4>
                <div>
                    <label for="dpi" class="form-label">Maximo de dpi</label>
                    <input required type="number" value="${mouse.getDpi()}" class="form-control" name="dpi" id="dpi" placeholder="1200">
                </div>

                <div>
                    <label for="dpi" class="form-label">Quantidade de Bot�es</label>
                    <input required type="number" value="${mouse.getQtd_botoes()}" class="form-control" name="qtd_botoes" id="qtd_botoes" placeholder="5">
                </div>

                <div>
                    <label for="dpi" class="form-label">Peso em gramas</label>
                    <input required type="number" value="${mouse.getPeso()}" class="form-control" name="peso" id="peso" placeholder="1200">
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Imagem do Produto:</h4>

                <div class="card" style="max-width: 200px;max-height: 200px;">
                    <img src="${mouse.getImgUrl()}" class="card-img-top" alt="..." id="preview_img" style="max-height: 100%;">
                </div>

                <div class="input-group mb-3">
                    <input type="file" class="form-control" id="file" name="file">
                </div>

            </div>

            <div class="col-md-12 d-flex" style="gap:10px">
                <button class="btn btn-primary" type="submit">Atualizar Mouse</button>
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