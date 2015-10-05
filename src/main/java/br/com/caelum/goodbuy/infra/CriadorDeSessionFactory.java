package br.com.caelum.goodbuy.infra;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author lucas
 */
@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements ComponentFactory<SessionFactory> {

    private SessionFactory factory;

    @Override
    public SessionFactory getInstance() {
        return factory;
    }

    @PostConstruct
    public void abre() {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();

        factory = configuration.buildSessionFactory();
        System.out.println("Abrindo a FACTORY");
    }

    @PreDestroy
    public void fecha() {
        this.factory.close();
        System.out.println("Fechando a FACTORY");
    }
}
