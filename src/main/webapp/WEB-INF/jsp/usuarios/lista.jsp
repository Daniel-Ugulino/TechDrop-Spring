<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="/css/list.css" rel="stylesheet">
    <meta charset="ISO-8859-1">
    <title>TechDrop</title>
</head>
<body>
<main>
    <form action="/usuario" method="get">
        <h3>Listagem de Usuários</h3>

        <button type="submit">Novo</button>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>E-mail</th>
            <th>CPF</th>
            <th>Setor</th>
            <th>Cargo</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>daniel.ugulino</td>
            <td>123</td>
            <td>daniel.ugulino@aluno.infnet.edu.br</td>
            <td>123456789</td>
            <td>Administrador</td>
            <td>Desenvolvimento</td>
        </tr>
        <tr>
            <td>elberth.moraes</td>
            <td>123</td>
            <td>elberth.moraes@prof.infnet.edu.br</td>
            <td>123456789</td>
            <td>Gerencia</td>
            <td>Gestor</td>
        </tr>
        <tr>
            <td>admin</td>
            <td>123</td>
            <td>admin@gmail.comr</td>
            <td>123456789</td>
            <td>Administrador</td>
            <td>Administrador</td>
        </tr>
        <tr>
            <td>cleiton.jose</td>
            <td>123</td>
            <td>cleiton@gmail.comr</td>
            <td>123456789</td>
            <td>Cliente</td>
            <td>Cliente</td>
        </tr>
        </tbody>
    </table>
</main>
</body>
</html>