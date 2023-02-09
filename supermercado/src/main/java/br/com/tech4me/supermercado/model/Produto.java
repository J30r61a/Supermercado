package br.com.tech4me.supermercado.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Produto {
    @Id
    private String id;
    private String nome;
    private String peso;
    private List<String> produFiscal;
    private Double valor;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public List<String> getProduFiscal() {
        return produFiscal;
    }
    public void setProduFiscal(List<String> produFiscal) {
        this.produFiscal = produFiscal;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
