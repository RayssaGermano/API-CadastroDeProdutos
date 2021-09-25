package br.com.tech4me.vendams.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tech4me.vendams.compartilhado.Produto;

@FeignClient(name= "produto-ms", fallback = ProdutoFeignClientFallBack.class)
public interface ProdutoFeignClient {

    @GetMapping(path = "/api/produto")
    List<Produto> obterProdutos();

    @PutMapping(path = "/api/produto")
    Produto atualizarProduto(@RequestBody Produto produto);

}

@Component
class ProdutoFeignClientFallBack implements ProdutoFeignClient {

    @Override
    public List<Produto> obterProdutos() {
        return new ArrayList<>();
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produto;
    }

}