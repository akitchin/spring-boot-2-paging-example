package com.hazmit.service.product;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.querybuilder.Ordering;

import lombok.Data;

@Table("attributevalue")
@Data
public class AttributeValue implements Comparable<AttributeValue> {
	/**
	* Surrogate Key
	*/	
	@Id
	@PrimaryKeyColumn(name = "attributevalueid", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
	private UUID attributeValueId;
	/**
	* Value that will be in the json response of v3 API
	*/	
	private String attributeValueName;
	
	@Override
	public int compareTo(AttributeValue aThat) {
	    final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;

	    //this optimization is usually worthwhile, and can
	    //always be added
	    if (this == aThat) return EQUAL;
	    
	    int comparison = this.attributeValueName.compareTo(aThat.attributeValueName);
	    if (comparison != 0) {
	    		return comparison;
	    }
	    int comparison2 = this.attributeValueId.compareTo(aThat.attributeValueId);
	    return comparison2;
	}
}
