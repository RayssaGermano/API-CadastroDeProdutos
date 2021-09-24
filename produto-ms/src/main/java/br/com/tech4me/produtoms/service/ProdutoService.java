package br.com.tech4me.produtoms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tech4me.produtoms.repository.ProdutoRepository;
import java.util.List;
import br.com.tech4me.produtoms.model.Produto;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto listarId(@PathVariable(value="Id")String Id){
        return produtoRepository.findById(Id).orElse(null);
    }

    public Produto novoProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    public void apagarProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }
    
}
