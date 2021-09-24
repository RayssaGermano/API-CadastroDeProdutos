package br.com.tech4me.produtoms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.tech4me.produtoms.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.com.tech4me.produtoms.model.Produto;
import br.com.tech4me.produtoms.compartilhado.ProdutoDto;
import org.springframework.beans.BeanUtils;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/produto/{Id}")
    public ResponseEntity<Produto> listarId(@PathVariable(value = "Id") String Id) {
        return ResponseEntity.ok(produtoService.listarId(Id));
    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDto produtoDto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return new ResponseEntity<>(produtoService.novoProduto(produto), HttpStatus.CREATED);
    }

    @PutMapping("/produto")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody ProdutoDto produtoDto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return new ResponseEntity<>(produtoService.novoProduto(produto), HttpStatus.OK);
    }

    @DeleteMapping("/produto")
    public ResponseEntity<Void> apagarProduto(@RequestBody Produto produto) {
        produtoService.apagarProduto(produto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}