package br.com.tech4me.vendams.compartilhado;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaDto {

    private String id;
    private LocalDate dataVenda;
    private Produto produtoVendido;
    private int quantidadeVendida;
    
}
