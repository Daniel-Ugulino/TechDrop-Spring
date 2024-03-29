package br.edu.infnet.TechStore.model.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class mouseDto extends produtoDto {
    @NotNull
    private Integer dpi;
    @NotNull
    private Integer qtd_botoes;
    @NotNull
    private Integer peso;

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    public Integer getQtd_botoes() {
        return qtd_botoes;
    }

    public void setQtd_botoes(Integer qtd_botoes) {
        this.qtd_botoes = qtd_botoes;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
