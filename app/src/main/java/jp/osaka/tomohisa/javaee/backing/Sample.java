package jp.osaka.tomohisa.javaee.backing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jp.osaka.tomohisa.javaee.annotation.GreetingType;
import jp.osaka.tomohisa.javaee.service.Greeting;
import lombok.Data;

@Data
@Named("sample")
@RequestScoped
public class Sample {
    /** ロガー. */
    private static Logger logger = LoggerFactory.getLogger(Sample.class);

    /** サービス. */
    private Greeting greeting;

    /** 名前. */
    private String name;

    /** メッセージ. */
    private String message;

    /** デフォルトコンストラクタ. */
    public Sample() {
    }

    /** コンストラクタ. */
    @Inject
    public Sample(@GreetingType Greeting greeting) {
        logger.info("コンストラクタ");
        this.greeting = greeting;
        if (this.greeting == null) {
            logger.info("this.greeting is NULL");
        } else {
            logger.info("this.greeting :" + this.greeting.toString());
        }
    }

    public void createMessage() {
        this.message = greeting.greeting(name);
        logger.info("this.greeting.getMessage() :" + this.getMessage());
    }

}
