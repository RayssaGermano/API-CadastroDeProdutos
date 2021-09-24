package br.com.tech4me.produtoms.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.produtoms.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>{

    
}
