<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="col d-flex flex-column" style="gap:10px">
        <h4>Endereco</h4>

        <div>
            <label for="cep"  class="form-label">Cep</label>
            <input required type="text" value="${cliente.endereco.getCep()}" class="form-control" name="cep" id="cep" placeholder="000000-000">
        </div>

        <div>
            <label for="logradouro"  class="form-label">Logradouro</label>
            <input required type="text" value="${cliente.endereco.getLogradouro()}" class="form-control" name="logradouro" id="logradouro">
        </div>

        <div>
            <label for="complemento"  class="form-label">Complemento</label>
            <input required type="text" value="${cliente.endereco.getComplemento()}" class="form-control" name="complemento" id="complemento" >
        </div>

        <div>
            <label for="bairro"  class="form-label">Bairro</label>
            <input required type="text" value="${cliente.endereco.getBairro()}" class="form-control" name="bairro" id="bairro" >
        </div>

        <div>
            <label for="localidade"  class="form-label">Localidade</label>
            <input required type="text" value="${cliente.endereco.getLocalidade()}" class="form-control" name="localidade" id="localidade">
        </div>

        <div>
            <label for="uf"  class="form-label">UF</label>
            <input required type="text" value="${cliente.endereco.getUf()}" class="form-control" name="uf" id="uf">
        </div>
    </div>
