package com.xiaoyao.demo.scope.model;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

/**
 * @author xiaoyao
 */
public class ContextHolder {

    private Map<String, String> key2Value = newHashMap();

    public Map<String, String> getKey2Value() {
        return key2Value;
    }

    public ContextHolder setKey2Value(Map<String, String> key2Value) {
        this.key2Value = key2Value;
        return this;
    }
}
