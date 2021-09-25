package br.com.tech4me.vendams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tech4me.vendams.model.Venda;
import br.com.tech4me.vendams.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    
    public List<Venda> listarTodos(){
        return vendaRepository.findAll();
    }

    public Venda listarId(@PathVariable(value="Id")String Id){
        return vendaRepository.findById(Id).orElse(null);
    }

    public Venda novaVenda(@RequestBody Venda venda){
        return vendaRepository.save(venda);
    }

    
}
