package br.com.tech4me.supermercado.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import br.com.tech4me.supermercado.model.Produto;
import br.com.tech4me.supermercado.repository.ProdutoRepository;
import br.com.tech4me.supermercado.shared.ProdutoCompletoDto;
import br.com.tech4me.supermercado.shared.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public List<ProdutoCompletoDto> obterTodos() {
        List<Produto> produto = repositorio.findAll();

        return produto.stream()
        .map(p -> new ModelMapper().map(p, ProdutoCompletoDto.class))
        .collect(Collectors.toList());
}
@Override
public Optional<ProdutoDto> obterPorId(String id) {
  Optional<Produto> produto  = repositorio.findById(id);

  if (produto.isPresent()) {
    return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
  }
  return Optional.empty();
}

@Override
public void excluirPorId(String id) {
  repositorio.deleteById(id);
}

@Override
public ProdutoCompletoDto cadastrar(ProdutoCompletoDto dto) {
  Produto produto = new ModelMapper().map(dto, Produto.class);
  repositorio.save(produto);
  return new ModelMapper().map(produto, ProdutoCompletoDto.class);  
}

@Override
public Optional<ProdutoCompletoDto> atualizarPorId(String id, ProdutoCompletoDto dto) { 
  Optional<Produto> retorno = repositorio.findById(id);

  if (retorno.isPresent()) {
    Produto produto = new ModelMapper().map(dto, Produto.class);
    produto.setId(id);
    repositorio.save(produto);
    return Optional.of(new ModelMapper().map(produto, ProdutoCompletoDto.class));
  } else {
    return Optional.empty();
  }
}


}
