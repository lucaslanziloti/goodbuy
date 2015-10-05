package br.com.caelum.goodbuy.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lucas
 */
@Component
@SessionScoped
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1937771959797224670L;

    private List<Item> itens = new ArrayList<Item>();

    private Double total = 0.0;

    public void adiciona(Item item) {
        itens.add(item);
        total += item.getProduto().getPreco() * item.getQuantidade();
    }

    public void remove(int indiceItem) {
        Item removido = itens.remove(indiceItem);
        total -= removido.getProduto().getPreco() * removido.getQuantidade();
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTotalDeItens() {
        return itens.size();
    }
}
