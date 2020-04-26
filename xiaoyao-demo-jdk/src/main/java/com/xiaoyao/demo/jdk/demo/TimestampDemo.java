package com.xiaoyao.demo.jdk.demo;

import static java.lang.System.currentTimeMillis;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.xiaoyao.demo.common.AbstractDemo;

/**
 * @author xiaoyao
 */
@ConditionalOnProperty(name = "demos.active", havingValue = "timestampDemo")
@Service
public class TimestampDemo extends AbstractDemo {

    @Override
    protected void demo() throws Exception {
        // 时间戳：距离格林威治时间 1970-01-01 00:00:00 秒的毫秒数
        long currentTimeMillis = currentTimeMillis();
        logger.info("current-time-millis = {}", currentTimeMillis());

        // 时间戳与当前时区无关
        long cctCurrentTimeMillis = getZonedCurrentTimeMillis("CCT");
        logger.info(
                "(CCT) zoned-current-time-millis = {}, delta = {}",
                cctCurrentTimeMillis,
                cctCurrentTimeMillis - currentTimeMillis // 可能有微小偏差

        );

        long pstCurrentTimeMillis = getZonedCurrentTimeMillis("PST");
        logger.info(
                "(PST) zoned-current-time-millis = {}, delta = {}",
                pstCurrentTimeMillis,
                pstCurrentTimeMillis - currentTimeMillis // 可能有微小偏差
        );
    }

    private long getZonedCurrentTimeMillis(String timeZone) {
        ZoneId zoneId = TimeZone.getTimeZone(timeZone).toZoneId();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        return zonedDateTime.toInstant().toEpochMilli();
    }
}
