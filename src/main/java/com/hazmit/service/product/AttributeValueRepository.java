package com.hazmit.service.product;

import java.util.UUID;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueRepository extends TypedIdCassandraRepository<AttributeValue,UUID> {

}
