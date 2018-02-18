package com.hazmit.service.product;

import java.util.Set;
import java.util.TreeSet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

@Data
public class AttributeResponse {

	private Set<AttributeValueResponse> attributeValue;
	
	private interface StringLists {
		Set<AttributeValue> getParentAttributeValueIds();
		void setParentAttributeValueIds(Set<AttributeValue> arg0);
	}

	public AttributeResponse(Attribute attribute,Set<AttributeValueResponse> attributeValue) {
		this.attribute = attribute;
		this.attributeValue = new TreeSet<AttributeValueResponse>();
		attributeValue.forEach(this.attributeValue::add);
	}
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@Delegate(excludes=StringLists.class)
	private final Attribute attribute;
}
