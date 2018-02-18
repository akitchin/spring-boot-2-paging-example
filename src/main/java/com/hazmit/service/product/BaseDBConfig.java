package com.hazmit.service.product;

import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;

import lombok.Data;

@Data()
public abstract class BaseDBConfig extends AbstractCassandraConfiguration {
	private String contactPoints;
	private int port;
	private String entityPackage;
	private SchemaAction schemaAction;
	private String keyspaceName;
}