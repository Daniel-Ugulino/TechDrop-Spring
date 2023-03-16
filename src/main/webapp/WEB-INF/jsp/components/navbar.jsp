<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid d-flex justify-content-center">

            <a class="navbar-brand" href="#"><img src="/imgs/logo.png" class="logo" alt=""></a>

            <c:if test="${not empty usuario}">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Vendas
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Listar</a></li>
                                <li><a class="dropdown-item" href="#">Cadastrar</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Produtos
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/headset">Headsets</a></li>
                                <li><a class="dropdown-item" href="/mouse">Mouse's</a></li>
                                <li><a class="dropdown-item" href="/teclado">Teclados</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Clientes
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/cliente">Listar</a></li>
                                <li><a class="dropdown-item" href="/cliente/cadastro">Cadastrar</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Usuarios
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/usuario">Listar</a></li>
                                <li><a class="dropdown-item" href="/usuario/cadastro">Cadastrar</a></li>
                            </ul>
                        </li>
                    </ul>

                    <div class="nav-link d-flex align-items-center" style="gap:5px; font-size: 1.3rem;">
                            ${usuario.getUsername()}
                        <a href="/logout" role="button">
                            <i class="bi bi-box-arrow-right" style="font-size: 2rem; color: cornflowerblue;"></i>
                        </a>
                    </div>
                </div>
            </c:if>
        </div>
    </nav>
</header>