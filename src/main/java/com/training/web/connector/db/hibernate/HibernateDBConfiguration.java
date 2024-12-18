package com.training.web.connector.db.hibernate;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.training.web.connector.db.hibernate")
@Profile("hibernate")
public class HibernateDBConfiguration {
}
