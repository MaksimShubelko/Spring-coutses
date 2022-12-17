package com.example.springcourses.config;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Optional;

@Profile("!test")
@EnableJpaAuditing
@EnableTransactionManagement // not required
@EnableJpaRepositories(
        transactionManagerRef = "transactionManager",
        entityManagerFactoryRef = "entityManagerFactory",
        basePackages = {"com.example.springcourses.repository"})
@Configuration
public class MainDbConfig {

    @Primary
    @Bean("mainDataSource")
    @LiquibaseDataSource
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {

        return DataSourceBuilder.create()
                .type(ManagedHikariDataSource.class)
                .build();
    }


    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("mainDataSource") DataSource dataSource,
                                                                       ConfigurableListableBeanFactory beanFactory) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = builder.dataSource(dataSource)
                .packages("com.example.springcourses.entity")
                .persistenceUnit("mainPersistenceUnit")
                .build();

        entityManagerFactoryBean.getJpaPropertyMap().put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(beanFactory));
        return entityManagerFactoryBean;
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return Optional.ofNullable(authentication != null ? authentication.getName() : "UNDEFINED");
        };
    }
}
