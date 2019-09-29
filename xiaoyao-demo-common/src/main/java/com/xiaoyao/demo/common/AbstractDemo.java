package com.xiaoyao.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * @author xiaoyao
 */
public abstract class AbstractDemo implements CommandLineRunner {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected abstract void demo() throws Exception;

    @Override
    public void run(String... args) throws Exception {
        logger.info("---------------------------------- Demo starts -----------------------------");
        demo();
        logger.info("---------------------------------- Demo ends -------------------------------");
    }
}
