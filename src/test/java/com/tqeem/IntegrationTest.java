package com.tqeem;

import com.tqeem.TQeemMServiceApp;
import com.tqeem.config.AsyncSyncConfiguration;
import com.tqeem.config.EmbeddedElasticsearch;
import com.tqeem.config.EmbeddedKafka;
import com.tqeem.config.EmbeddedRedis;
import com.tqeem.config.EmbeddedSQL;
import com.tqeem.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { TQeemMServiceApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedElasticsearch
@EmbeddedKafka
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
