package br.com.tech4me.compras.repository;

import br.com.tech4me.compras.model.Compras;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComprasRepository extends MongoRepository<Compras,String>{

    
}
    

