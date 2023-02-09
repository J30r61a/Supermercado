package br.com.tech4me.supermercado.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.supermercado.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

    Object find = null;

    void deleteById(String id);

    Produto save(Produto produto);

    Optional<Produto> findById(String id);
    
}
