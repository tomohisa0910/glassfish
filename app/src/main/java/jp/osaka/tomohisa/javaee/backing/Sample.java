package jp.osaka.tomohisa.javaee.backing;

import jakarta.inject.Inject;
import jp.osaka.tomohisa.javaee.service.Greeting;

// @Named("sample")
// @RequestScoped
public class Sample {
    @Inject
    private Greeting greeting;

    private String name;

    private String message;

    public void createMessage() {
        greeting.greeting(name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

}
