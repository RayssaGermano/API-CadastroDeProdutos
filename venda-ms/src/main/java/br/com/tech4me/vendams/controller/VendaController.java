package br.com.tech4me.vendams.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.vendams.compartilhado.VendaDto;
import br.com.tech4me.vendams.model.Venda;
import br.com.tech4me.vendams.service.VendaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/venda")
    public ResponseEntity<List<Venda>> listarTodos() {
        return ResponseEntity.ok(vendaService.listarTodos());
    }

    @GetMapping("/venda/{Id}")
    public ResponseEntity<Venda> listarId(@PathVariable(value = "Id") String Id) {
        return ResponseEntity.ok(vendaService.listarId(Id));
    }

    @PostMapping("/venda")
    public ResponseEntity<Venda> salvarVenda(@RequestBody VendaDto vendaDto) {
        Venda venda = new Venda();
        BeanUtils.copyProperties(vendaDto, venda);
        return new ResponseEntity<>(vendaService.novaVenda(venda), HttpStatus.CREATED);
    }

}
