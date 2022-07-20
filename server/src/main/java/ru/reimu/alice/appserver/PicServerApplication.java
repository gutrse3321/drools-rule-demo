package ru.reimu.alice.appserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-14 17:08
 */
@SpringBootApplication(scanBasePackages = {"ru.reimu.alice"})
@MapperScan("ru.reimu.alice.persist.mapper")
@EnableAspectJAutoProxy
public class PicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicServerApplication.class, args);
        System.out.println("\n" +
                "          _      _____ _____ ______ \n" +
                "    /\\   | |    |_   _/ ____|  ____|\n" +
                "   /  \\  | |      | || |    | |__   \n" +
                "  / /\\ \\ | |      | || |    |  __|  \n" +
                " / ____ \\| |____ _| || |____| |____ \n" +
                "/_/    \\_\\______|_____\\_____|______|");
        System.out.println("\u23F0\u23F0 The Tiny Version 1.0 \u23F0\u23F0");
        System.out.println("\n" +
                " __      __  __  ___ \n" +
                "|__) /\\ |__)|__)| |  \n" +
                "| \\ /--\\|__)|__)| |  ");
    }
}
