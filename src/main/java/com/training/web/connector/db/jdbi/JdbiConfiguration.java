package com.training.web.connector.db.jdbi;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

//@Configuration
//@Profile("jdbi")
public class JdbiConfiguration {
   /* private final Logger logger = LoggerFactory.getLogger(JdbiConfiguration.class);

    @Bean
    @Profile("jdbi")
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);
        Jdbi jdbi = Jdbi.create(proxy);

        // Register all available plugins
        logger.info("[I27] Installing plugins... ({} found)", jdbiPlugins.size());
        jdbiPlugins.forEach(jdbi::installPlugin);

        // Register all available rowMappers
        logger.info("[I31] Installing rowMappers... ({} found)", rowMappers.size());
        rowMappers.forEach(jdbi::registerRowMapper);
        return jdbi;
    }*/
}