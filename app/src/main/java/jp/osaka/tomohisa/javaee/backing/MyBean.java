package jp.osaka.tomohisa.javaee.backing;

import java.time.LocalDateTime;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
class MyBean {

    private String initMessage = "アプリケーションは正常に起動しました。";
    private  LocalDateTime initTime= LocalDateTime.now();

    public String getInitMessage() {
        return this.initMessage;
    }

    public LocalDateTime getInitTime() {
        return this.initTime;
    }
}

