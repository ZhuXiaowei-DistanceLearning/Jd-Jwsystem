package com.zxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zxw
 * @date 2019/11/3 17:25
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:config/kaptcha.xml"})
public class JwSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwSystemApplication.class);
    }
}
