package com.xiaoyao.demo.jdk.demo;

import static java.time.Instant.ofEpochMilli;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.xiaoyao.demo.common.AbstractDemo;

/**
 * @author xiaoyao
 */
@ConditionalOnProperty(name = "demos.active", havingValue = "dateTimeFormatterDemo")
@Service
public class DateTimeFormatterDemo extends AbstractDemo {

    private static final DateTimeFormatter FORMATTER = ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void demo() throws Exception {
        long timestamp = System.currentTimeMillis();
        logger.info("timestamp = {}", timestamp);
        logger.info("formatted = {}", ofInstant(ofEpochMilli(timestamp), systemDefault())
                .format(FORMATTER));
    }
}
