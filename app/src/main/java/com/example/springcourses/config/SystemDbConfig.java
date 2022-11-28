package com.example.springcourses.config;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Profile("!test")
@EnableTransactionManagement // not required
@EnableJpaRepositories(
        transactionManagerRef = "systemTransactionManager",
        entityManagerFactoryRef = "systemEntityManagerFactory",
        basePackages = {"com.example.system.repository"})
@Configuration
public class SystemDbConfig {

    @Bean("systemDataSource")
    @LiquibaseDataSource
    @ConfigurationProperties("spring.system-datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .type(ManagedHikariDataSource.class)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean systemEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                             @Qualifier("systemDataSource") DataSource dataSource,
                                                                             ConfigurableListableBeanFactory beanFactory) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = builder.dataSource(dataSource)
                .packages("com.example.system.entity")
                .persistenceUnit("systemPersistenceUnit")
                .build();
        entityManagerFactoryBean.getJpaPropertyMap().put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(beanFactory));
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager systemTransactionManager(@Qualifier("systemEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

