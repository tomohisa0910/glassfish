package jp.osaka.tomohisa.javaee.service.impl;

import org.apache.commons.lang3.StringUtils;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jp.osaka.tomohisa.javaee.annotation.GreetingType;
import jp.osaka.tomohisa.javaee.service.Greeting;

@Named
@RequestScoped
@GreetingType
public class GreetingImpl implements Greeting {

    @Override
    public String greeting(String target) {
        StringBuilder message = new StringBuilder("Hello, ");
        if (StringUtils.isBlank(target)) {
            message.append("World !!");
        } else {
            message.append(target)
                .append(" !!");
        }
        return message.toString();
    }

}
