package com.github.fabriciolfj.multipledb.infrastructure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.github.fabriciolfj.multipledb.domain.repository.product",
        entityManagerFactoryRef = "productEntityManager",
        transactionManagerRef = "productTransactionManager"
)
public class PersistenceProductConfiguration {

    @Bean(name = "prodDataSource")
    @ConfigurationProperties(prefix = "prod.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "productEntityManager")
    public LocalContainerEntityManagerFactoryBean productEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("prodDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.github.fabriciolfj.multipledb.domain.entity.product")
                .persistenceUnit("product")
                .build();
    }

    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager prodTransactionManager(@Qualifier("productEntityManager") EntityManagerFactory productEntityManager) {
        return new JpaTransactionManager(productEntityManager);
    }
}
