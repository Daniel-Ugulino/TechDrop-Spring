<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="/css/login.css" rel="stylesheet">
    <title>TechDrop</title>
</head>
<body>
    <main>
        <img src="/imgs/logo.png">
        <h1>Login</h1>
        <form action="/login" method="post">
            <label>E-mail:</label>
            <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="daniel.ugulino@al.infnet.edu.br">
            <label>Senha:</label>
            <input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha" value="daniel.ugulino@al.infnet.edu.br">
            <button type="submit" class="btn btn-default">Acessar</button>
        </form>
    </main>
</body>
</html>