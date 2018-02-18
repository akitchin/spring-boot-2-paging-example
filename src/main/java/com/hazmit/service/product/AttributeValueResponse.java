package com.hazmit.service.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

@Data
public class AttributeValueResponse {
	
	private interface StringLists {
	}

	public AttributeValueResponse(AttributeValue attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@Delegate(excludes=StringLists.class)
	private final AttributeValue attributeValue;
}
