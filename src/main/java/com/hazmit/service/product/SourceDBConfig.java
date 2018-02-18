package com.hazmit.service.product;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.hazmit.service.product.repository", cassandraTemplateRef = "sourceDBTemplate") // 2
@ConfigurationProperties("hazmit.product.service.db.source")
public class SourceDBConfig extends BaseDBConfig {

	public SourceDBConfig() {
		this.setEntityPackage("com.hazmit.service.product");
	}

	@Override
	@Bean("pagingSession")
	public CassandraSessionFactoryBean session() {
		return super.session();
	}

	@Bean("pagingDBTemplate")
	public CassandraAdminOperations cassandraTemplate(@Qualifier("pagingSession") CassandraSessionFactoryBean session)
			throws Exception {
		return new CassandraAdminTemplate(session.getObject(), cassandraConverter());
	}

}
