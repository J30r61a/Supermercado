package br.com.tech4me.compras.shared;

import br.com.tech4me.compras.model.Produto;


public class ComprasDto {
    private String nomeCliente;
    private String idProduto;
    private Produto dadosProduto;
    private Double valor;
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getIdPRoduto() {
        return idProduto;
    }
    public void setIdPRoduto(String idPRoduto) {
        this.idProduto = idPRoduto;
    }
    public Produto getDadosProduto() {
        return dadosProduto;
    }
    public void setDadosProduto(Produto dadosProduto) {
        this.dadosProduto = dadosProduto;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
