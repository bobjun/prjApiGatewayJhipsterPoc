package com.sptrans.recon;

import com.sptrans.recon.ReconApp;
import com.sptrans.recon.config.AsyncSyncConfiguration;
import com.sptrans.recon.config.EmbeddedElasticsearch;
import com.sptrans.recon.config.EmbeddedKafka;
import com.sptrans.recon.config.EmbeddedRedis;
import com.sptrans.recon.config.EmbeddedSQL;
import com.sptrans.recon.config.TestSecurityConfiguration;
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
@SpringBootTest(classes = { ReconApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedElasticsearch
@EmbeddedKafka
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
