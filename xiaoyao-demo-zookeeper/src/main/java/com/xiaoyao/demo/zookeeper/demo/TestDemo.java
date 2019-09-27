package com.xiaoyao.demo.zookeeper.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.xiaoyao.demo.common.AbstractDemo;

/**
 * @author xiaoyao
 */
@ConditionalOnProperty(name = "demos.active", havingValue = "zookeeper.testDemo")
@Service
public class TestDemo extends AbstractDemo {

    @Override
    protected void demo() {
        logger.info("done");
    }
}
