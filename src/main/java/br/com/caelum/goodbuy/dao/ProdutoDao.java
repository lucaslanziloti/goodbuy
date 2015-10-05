package br.com.caelum.goodbuy.dao;

import br.com.caelum.goodbuy.modelo.Produto;
import java.util.List;
import org.hibernate.Session;
import br.com.caelum.vraptor.ioc.Component;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * @author lucas
 */
@Component
public class ProdutoDao {

    private final Session session;

    public ProdutoDao(Session session) {
        this.session = session;
    }

    public void salva(Produto produto) {
        Transaction tx = session.beginTransaction();
        session.save(produto);
        tx.commit();
    }

    public List<Produto> listaTudo() {
        return this.session.createCriteria(Produto.class).list();
    }

    public Produto carrega(Long id) {
        return (Produto) this.session.get(Produto.class, id);
    }

    public void atualiza(Produto produto) {
        Transaction tx = session.beginTransaction();
        this.session.update(produto);
        tx.commit();
    }

    public void remove(Produto produto) {
        Transaction tx = session.beginTransaction();
        this.session.delete(produto);
        tx.commit();
    }

    public List<Produto> busca(String nome) {
        Criterion restricaoPorNome = Restrictions.ilike("nome", nome, MatchMode.ANYWHERE);

        return session.createCriteria(Produto.class)
                .add(restricaoPorNome).list();
    }

    public void recarrega(Produto produto) {
        session.refresh(produto);
    }
}
