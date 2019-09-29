package com.xiaoyao.demo.zookeeper.demo;

import static org.apache.zookeeper.Watcher.Event.KeeperState.SyncConnected;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.xiaoyao.demo.common.AbstractDemo;
import com.xiaoyao.demo.common.util.JsonUtils;

/**
 * @author xiaoyao
 */
@ConditionalOnProperty(name = "demos.active", havingValue = "zookeeper.connectZooKeeperDemo")
@Service
public class ConnectZooKeeperDemo extends AbstractDemo implements Watcher {

    private static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    @Value("${zkServers}")
    private String zkServers;

    @Value("${zkTimeout}")
    private int zkTimeout;

    @Override
    protected void demo() throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(zkServers, zkTimeout, this);
        logger.info("zoo-keeper connecting, state: {}", zooKeeper.getState());
        COUNT_DOWN_LATCH.await();
        logger.info("zoo-keeper connected, state: {}", zooKeeper.getState());
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("incoming watched-event: {}", JsonUtils.writeValue(watchedEvent));
        if (watchedEvent.getState() == SyncConnected) {
            COUNT_DOWN_LATCH.countDown();
        }
    }
}
