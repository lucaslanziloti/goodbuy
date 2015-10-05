package br.com.caelum.goodbuy.modelo;

import java.io.Serializable;

/**
 *
 * @author lucas
 */
public class Item implements Serializable {

    private static final long serialVersionUID = -5632453279256653144L;

    private Produto produto;

    private Integer quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
