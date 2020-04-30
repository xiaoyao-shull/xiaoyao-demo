package com.xiaoyao.demo.scope.demo;

import static com.github.phantomthief.scope.Scope.beginScope;
import static com.github.phantomthief.scope.Scope.endScope;
import static com.github.phantomthief.scope.ScopeKey.withInitializer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.github.phantomthief.scope.ScopeKey;
import com.xiaoyao.demo.common.AbstractDemo;
import com.xiaoyao.demo.scope.model.ContextHolder;

/**
 * @author xiaoyao
 */
@ConditionalOnProperty(name = "demos.active", havingValue = "contextHolderScopeDemo")
@Service
public class ContextHolderScopeDemo extends AbstractDemo {

    private static final ScopeKey<ContextHolder> CONTEXT_HOLDER = withInitializer(ContextHolder::new);

    @Override
    protected void demo() throws Exception {
        logger.info("before begin-scope, try-populate-context-holder = {}", tryPopulateContextHolder());
        beginScope();
        logger.info("after begin-scope, try-populate-context-holder = {}", tryPopulateContextHolder());
        populateContextHolder();
        endScope();
    }

    private boolean tryPopulateContextHolder() {
        try {
            populateContextHolder();
            return true;

        } catch (NullPointerException t) {
            return false;
        }
    }

    private void populateContextHolder() {
        CONTEXT_HOLDER.get().getKey2Value().put("some-key", "some-value");
    }
}
