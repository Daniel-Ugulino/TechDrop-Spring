<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col d-flex flex-column" style="gap:10px">
    <h4>Endereco</h4>

    <div>
        <label for="cep"  class="form-label">Cep</label>
        <input type="text" value="{}" class="form-control" name="cep" id="cep" placeholder="000000-000">
    </div>

    <div>
        <label for="logradouro"  class="form-label">Logradouro</label>
        <input type="text" class="form-control" name="logradouro" id="logradouro">
    </div>

    <div>
        <label for="complemento"  class="form-label">Complemento</label>
        <input type="text" class="form-control" name="complemento" id="complemento" >
    </div>

    <div>
        <label for="bairro"  class="form-label">Bairro</label>
        <input type="text" class="form-control" name="bairro" id="bairro" >
    </div>

    <div>
        <label for="localidade"  class="form-label">Localidade</label>
        <input type="text" class="form-control" name="localidade" id="localidade">
    </div>

    <div>
        <label for="uf"  class="form-label">UF</label>
        <input type="text" class="form-control" name="uf" id="uf">
    </div>
</div>