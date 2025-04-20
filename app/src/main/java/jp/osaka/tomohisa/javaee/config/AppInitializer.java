package jp.osaka.tomohisa.javaee.config;

import java.time.LocalDateTime;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class AppInitializer {
    private String initMessage = "アプリケーションは正常に起動しました。";
    private  LocalDateTime initTime= LocalDateTime.now();

    @PostConstruct
    public void init() {
        System.err.println(initMessage);
    }

    public String getInitMessage() {
        return this.initMessage;
    }

    public LocalDateTime getInitTime() {
        return this.initTime;
    }
}

