package com.hazmit.service.product;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table("attribute")
@Data
public class Attribute implements Comparable<Attribute> {
	/**
	 * Surrogate Key
	 */
	@Id
	@PrimaryKeyColumn(name = "attributeid", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
	private UUID attributeId;
	/**
	 * must be unique, key used in database and site code
	 */
	private String attributeCode;
	/**
	 * How it's displayed in Internal Portal
	 */
	private String displayName;

	@Override
	public int compareTo(Attribute aThat) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		// this optimization is usually worthwhile, and can
		// always be added
		if (this == aThat)
			return EQUAL;

		int comparison = this.displayName.compareTo(aThat.displayName);
		if (comparison != 0) {
			return comparison;
		}
		int comparison2 = this.attributeCode.compareTo(aThat.attributeCode);
		if (comparison2 != 0) {
			return comparison2;
		}
		int comparison3 = this.attributeId.compareTo(aThat.attributeId);
		return comparison3;
	}
}
