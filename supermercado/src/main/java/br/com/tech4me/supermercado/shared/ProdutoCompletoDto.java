package br.com.tech4me.supermercado.shared;

import java.util.List;

import org.springframework.boot.convert.DataSizeUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoCompletoDto {
    private String id;
    @NotEmpty(message= "O nome do produto deve ser informado")
    @NotBlank(message= "Tem que informar os caracteres")
    private String nome;
    private List<String> produFiscal;
    @Size(min=3, max=4, message="Escolha o peso do produto: 250g, 500g ou 1kg")
    private String tamanho;
    @Positive(message="valor deve ser digitado:")
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
