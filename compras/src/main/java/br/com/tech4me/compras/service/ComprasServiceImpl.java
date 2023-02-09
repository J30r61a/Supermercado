package br.com.tech4me.compras.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.compras.httpClient.SupermercadoClient;
import br.com.tech4me.compras.model.Compras;
import br.com.tech4me.compras.repository.ComprasRepository;
import br.com.tech4me.compras.shared.ComprasCompletoDto;
import br.com.tech4me.compras.shared.ComprasDto;
import org.modelmapper.ModelMapper;

@Service
public class ComprasServiceImpl implements ComprasService {
    
    @Autowired
    private ComprasRepository repository;

    @Autowired
    private SupermercadoClient supermercadoClient;

    @Override
    public List<ComprasCompletoDto> obterCompras() {
        List<Compras> compras = repository.findAll();
        List<ComprasCompletoDto> dto = compras.stream().map(p -> new ModelMapper().map(p, ComprasCompletoDto.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public Optional<ComprasDto> obterComprasPorId(String id) {
        
        Optional<Compras> compras = repository.findById(id);
        if(compras.isPresent()){
            ComprasDto ComprasComProduto = new ModelMapper().map(compras, ComprasDto.class);
            ComprasComProduto.setDadosProduto(supermercadoClient.obterProduto(ComprasComProduto.getIdPRoduto()));
            return Optional.of(ComprasComProduto);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void excluirCompra(String id) {
        repository.deleteById(id);
    }

    @Override
    public ComprasCompletoDto CadastrarCompras(ComprasCompletoDto dto) {
        Compras compras = new ModelMapper().map(dto, Compras.class);

        repository.save(compras);
        return new ModelMapper().map(compras,ComprasCompletoDto.class);
    }

    @Override
    public Optional<ComprasDto> atualizarComprasPorId(String id, ComprasDto dto) {
        Optional<Compras> retorno = repository.findById(id);

        if(retorno.isPresent()){
            Compras comprasRetorno = new ModelMapper().map(dto, Compras.class);
            comprasRetorno.setId(id);
            repository.save(comprasRetorno);
            return Optional.of(new ModelMapper().map(comprasRetorno, ComprasDto.class));
        }else{
            return Optional.empty();
        }
    }   
}
