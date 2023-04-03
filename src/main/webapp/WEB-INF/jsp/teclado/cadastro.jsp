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
            <h2>Cadastro de Teclados</h2>
        </div>

        <form action="/teclado/incluir" method="post" enctype="multipart/form-data" class="row d-flex justify-content-center pt-3" style="gap:20px">
            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Características</h4>

                <div>
                    <label for="marca"  class="form-label">Marca</label>
                    <input required type="text" class="form-control" name="marca" id="marca" placeholder="name@example.com"required>
                </div>

                <div>
                    <label for="modelo"  class="form-label">Modelo</label>
                    <input required type="text" class="form-control" name="modelo" id="modelo" placeholder="name@example.com" required>
                </div>

                <div>
                    <label for="quantidade" class="form-label">Quantidade</label>
                    <input required type="text" class="form-control" name="quantidade" id="quantidade" placeholder="name@example.com"required>
                </div>

                <div>
                    <label for="valor" class="form-label">Valor</label>
                    <input required type="text" class="form-control" name="valor" id="valor" placeholder="name@example.com">
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Conexão:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input value="bluetooh" class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable1"required>
                        <label class="form-check-label" for="bluetooh_cable1">
                            Bluetooh
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input required value="cable" class="form-check-input" type="radio" name="bluetooh_cable" id="bluetooh_cable2"required>
                        <label class="form-check-label" for="bluetooh_cable2">
                            Cable
                        </label>
                    </div>
                </div>

                <div class="d-flex" style="gap:15px">
                    <p>Iluminação:</p>
                    <div class="form-check d-flex" style="gap:10px">
                        <input required value="true" class="form-check-input" type="radio" name="iluminacao" id="iluminacao1" required>
                        <label class="form-check-label" for="iluminacao1">
                            Sim
                        </label>
                    </div>

                    <div class="form-check d-flex" style="gap:10px">
                        <input required value="false" class="form-check-input" type="radio" name="iluminacao" id="iluminacao2" required>
                        <label class="form-check-label" for="iluminacao2">
                            Não
                        </label>
                    </div>
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Especificações</h4>
                <div>
                    <label for="tipo" class="form-label">Tipo de Teclado</label>
                    <select required class="form-select" id="tipo" name="tipo" required>
                        <option selected value="" disabled>Selecione uma das opções abaixo</option>
                        <option value="MEMBRANA">Membrana</option>
                        <option value="MECANICO">Mecanico</option>
                        <option value="OPTICO">Optico</option>
                    </select>
                </div>

                <div>
                    <label for="switch_type" class="form-label">Tipo de Switch</label>
                    <select required class="form-select" id="switch_type" name="switch_type" required>
                        <option selected value="" disabled>Selecione uma das opções abaixo</option>
                        <option value="NENHUM">Nenhum</option>
                        <option value="BLUE">Blue</option>
                        <option value="RED">Red</option>
                        <option value="BROWN">Brown</option>
                        <option value="BLACK">Black</option>
                    </select>
                </div>

                <div>
                    <label for="ghosting" class="form-label">Ghosting</label>
                    <select required class="form-select" id="ghosting" name="ghosting">
                        <option selected value="" disabled>Selecione uma das opções abaixo</option>
                        <option value="NENHUM">Nenhum</option>
                        <option value="METADE">50%</option>
                        <option value="FULL">100%</option>
                    </select>
                </div>
            </div>

            <div class="col d-flex flex-column" style="gap:10px">
                <h4>Imagem do Produto:</h4>

                    <div class="card" style="max-width: 200px;max-height: 200px;">
                    <img src="https://techdrop-bucket.s3.amazonaws.com/default.png" class="card-img-top" alt="..." id="preview_img" style="max-height: 100%;">
                </div>

                <div class="input-group mb-3">
                    <input type="file" class="form-control" id="file" name="file">
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