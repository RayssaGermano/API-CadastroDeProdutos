package br.com.tech4me.vendams.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.vendams.model.Venda;

@Repository
public interface VendaRepository  extends MongoRepository<Venda, String>{
    
}
