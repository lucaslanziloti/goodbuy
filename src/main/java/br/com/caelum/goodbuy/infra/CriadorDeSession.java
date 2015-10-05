package br.com.caelum.goodbuy.infra;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author lucas
 */
@Component
public class CriadorDeSession implements ComponentFactory<Session> {

    private final SessionFactory factory;
    private Session session;

    public CriadorDeSession(SessionFactory factory) {
        this.factory = factory;
    }

    @PostConstruct
    public void abre() {
        this.session = factory.openSession();
        System.out.println("Abrindo a SESSION");
    }

    @Override
    public Session getInstance() {
        return this.session;
    }

    @PreDestroy
    public void fecha() {
        this.session.close();
        System.out.println("Fechando a SESSION");
    }
}
