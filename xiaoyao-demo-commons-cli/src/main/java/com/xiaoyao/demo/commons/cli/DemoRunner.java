package com.xiaoyao.demo.commons.cli;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author xiaoyao
 */
@SpringBootApplication
public class DemoRunner {

    public static void main(String... args) {
        new SpringApplicationBuilder(DemoRunner.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
