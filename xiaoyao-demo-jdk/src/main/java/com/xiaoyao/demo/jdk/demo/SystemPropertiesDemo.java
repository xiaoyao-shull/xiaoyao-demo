package com.xiaoyao.demo.jdk.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.xiaoyao.demo.common.AbstractDemo;

/**
 * @author xiaoyao
 */
@ConditionalOnProperty(name = "demos.active", havingValue = "systemPropertiesDemo")
@Service
public class SystemPropertiesDemo extends AbstractDemo {

    @Override
    protected void demo() throws Exception {
        System.getProperties().forEach((key, value) -> logger.info(
                "system-property, key = {}, value = {}", key, value
        ));
    }
}
