package com.hazmit.service.product;

import java.util.UUID;

import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends TypedIdCassandraRepository<Attribute,UUID> {
	Slice<Attribute> findAll(Pageable pageRequest);
}
