package br.com.tech4me.compras.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.compras.shared.ComprasCompletoDto;
import br.com.tech4me.compras.shared.ComprasDto;

public interface ComprasService {
    
    List<ComprasCompletoDto> obterCompras();
    
    Optional<ComprasDto> obterComprasPorId(String id);
    void excluirCompra(String id);
    ComprasCompletoDto CadastrarCompras(ComprasCompletoDto compras);
    Optional<ComprasDto> atualizarComprasPorId(String id, ComprasDto dto);

}
