package br.com.tech4me.supermercado.shared;

import java.util.List;

public class ProdutoDto {
    private String id;
    private String nome;
    private List<String> produFiscal;
    private String peso;
    
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
    public List<String> getProduFiscal() {
        return produFiscal;
    }
    public void setProduFiscal(List<String> produFiscal) {
        this.produFiscal = produFiscal;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }

}
