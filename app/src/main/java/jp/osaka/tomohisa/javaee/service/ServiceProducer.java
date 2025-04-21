package jp.osaka.tomohisa.javaee.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jp.osaka.tomohisa.javaee.service.impl.GreetingImpl;

@ApplicationScoped
public class ServiceProducer {
    @Produces
    public Greeting createService() {
        return new GreetingImpl();
    }
}
