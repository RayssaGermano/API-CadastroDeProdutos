package br.com.tech4me.produtoms.compartilhado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private String id;
    private String codigo;
    private String nome;
    private double valor;
    private int quantidadeemEstoque;
    
}
