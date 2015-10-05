package br.com.caelum.goodbuy.testes;

import br.com.caelum.goodbuy.modelo.Produto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author lucas
 */
public class AlteracaoDeProduto {

    public static void main(String[] args) {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        // carrega o produto do banco de dados
        Produto produto = (Produto) session.load(Produto.class, 1L);

        Transaction tx = session.beginTransaction();
        produto.setPreco(42.50);
        session.update(produto);
        tx.commit();
    }
}
