<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>TechDrop</title>
</head>
    <body>
    <div class="container">
        <h2>Login</h2>
        <div class="row">
            <img src="/imgs/logo.png">
            <form action="/login" method="post">

                <div class="form-group">
                    <label>E-mail:</label>
                    <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="daniel.ugulino@al.infnet.edu.br">
                </div>

                <div class="form-group">
                    <label>Senha:</label>
                    <input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha" value="daniel.ugulino@al.infnet.edu.br">
                </div>

                <button type="submit" class="btn btn-default">Acessar</button>
            </form>
        </div>

    </div>
    </body>
</html>