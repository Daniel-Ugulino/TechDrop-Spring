<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="/css/cadastro.css" rel="stylesheet">
    <title>TechDrop</title>
</head>
<body>
<main>
    <form action="/usuario/incluir" method="post" class="form">
        <h1>Cadastro de Usuário</h1>

        <div class="row">
            <label>Nome:</label>
            <input type="text" name="username" value="Elberth Moraes" class="form-control">
        </div>

        <div class="row">
            <label>Senha:</label>
            <input type="password" name="password" value="123" class="form-control">
        </div>

        <div class="row">
            <label>E-mail:</label>
            <input type="email" name="email" value="elberth@gmail.com" class="form-control">
        </div>

        <div class="row">
            <label>CPF:</label>
            <input type="text" name="cpf" value="44" class="form-control">
        </div>

        <div class="row-options">
            <label>Setor:</label>
            <select name="setor">
                <option value="1">Gerencia</option>
                <option value="2">Cliente</option>
                <option value="3" selected>Administrador</option>
            </select>
        </div>

        <div class="row-options">
            <label>Cargo:</label>
            <input type="radio" name="cargo" value="G" > Gestor
            <input type="radio" name="cargo" value="C" > Cliente
            <input type="radio" name="cargo" value="A" checked> Desenvolvimento
        </div>

        <button type="submit">Cadastrar</button>
    </form>
</main>
</body>
</html>