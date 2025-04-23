package jp.osaka.tomohisa.javaee.backing;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named("menu")
@ViewScoped
public class MenuBean implements Serializable {
    private String contentPage = "";

    /** 静的ファイルを表示. */
    public void showContent1() {
        this.contentPage = "static/page1.xhtml";
    }

    /** バッキングBean内でメッセージ作成を表示. */
    public void showContent2() {
        this.contentPage = "static/page1.xhtml";
    }

    /** サービス呼び出しによるメッセージ生成を表示. */
    public void showContent3() {
        this.contentPage = "templates/app.xhtml";
    }
}
